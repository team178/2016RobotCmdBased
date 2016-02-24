package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.VisionValues;
import org.usfirst.frc.team178.robot.subsystems.*;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

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
	

    public AutoAim() {

    	// System.out.println("Isaac is a door.");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
	// Initializes all the declared objects
    protected void initialize() {
		VisionValues vision = Robot.vision;
		visionPIDInput = new VisionPIDInterface();
		pidOutput = new AutoAimPIDOutput(Robot.drivetrain);
		pid = new PIDController(3.1, 1, 0, visionPIDInput, pidOutput);
		pid.setAbsoluteTolerance(.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		pid.enable();
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
		pidOutput.pidAbort();
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
		// TODO Auto-generated method stub
		driveTrain.drive(-output,output);
	}

	public void pidAbort(){
		driveTrain.drive(0,0);
	}
}