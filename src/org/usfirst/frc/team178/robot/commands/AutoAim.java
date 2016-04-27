package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.VisionValues;
import org.usfirst.frc.team178.robot.subsystems.*;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoAim extends Command {

	// Declaration of variables
	VisionValues vision;
	double valueCorrect;
	VisionPIDInterface visionPIDInput;
	private AutoAimPIDOutput pidOutput;
	private PIDController pid;
	private double pValue,iValue;
	

    public AutoAim() {

    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
	// Initializes all the declared objects
    protected void initialize() {
		VisionValues visionValues = Robot.vision;
		visionPIDInput = new VisionPIDInterface();
		pidOutput = new AutoAimPIDOutput(Robot.drivetrain);
		//Below are the PID values you must edit. They are in the order: P,I,D.
		SmartDashboard.putNumber("P Value", pValue);
		SmartDashboard.putNumber("I Value", iValue);
		pid = new PIDController(5, 0, 1.5, visionPIDInput, pidOutput);
		pid.setAbsoluteTolerance(.05);
		System.out.println("AutoAim initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		pid.enable();
		//pid.setPID(SmartDashboard.getNumber("P Value",0.1), SmartDashboard.getNumber("I Value",(.5)), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
		pid.disable();
		pidOutput.pidAbort();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		pid.disable();
		//pidOutput.pidAbort();
    }
}

class VisionPIDInterface implements PIDSource{

	public VisionPIDInterface() {
		setPIDSourceType(PIDSourceType.kDisplacement);
	}
	
	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		//This method's results must scale from -1 to 1
		//0 = IMAGE_WIDTH/2
		//0 = -1
		//IMAGE_WIDTH = 1
		//System.out.println("This is the scaled deviation"+(((Robot.visionValues.getCOG_X()/Robot.visionValues.getIMAGE_WIDTH())*2)-1));
		return (((Robot.vision.getCOG_X()/Robot.vision.getIMAGE_WIDTH())*2)-1);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		//This method is irrelevant, as the only output possible from this device is displacement from center, not rate.
	}

}

class AutoAimPIDOutput implements PIDOutput{

	private DriveTrain driveTrain;

	AutoAimPIDOutput(DriveTrain driveTrain){
		this.driveTrain = driveTrain;
	}

	@Override
	public void pidWrite(double output) {
		// THIS IS WHERE THE OUTPUT IS GIVEN. YOU MUST call Robot.Drivetrain, and write the correct values to it. -1 is turn left, +1 is turn right.
		driveTrain.drive(-output,-output);
		System.out.println("This is the pidOutput: "+output);
		//Robot.logger.fine("pidOutput is: ("+(-output)+","+(output));
	}

	public void pidAbort(){
		driveTrain.drive(0,0);
	}
}