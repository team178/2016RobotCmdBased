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

	VisionValues vision = Robot.vision;
	
	double valueCorrect;
	double distanceCorrect;
	
	private PIDSource angleFixer = new PIDSource() {
		@Override
		public double pidGet() {
			return vision.COG_X-(vision.IMAGE_WIDTH/2.0);
		}

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	private PIDOutput angleCorr = new PIDOutput() {
		@Override
		public void pidWrite(double output) {
			valueCorrect = output;
		}
	};
		
	private PIDController pid = new PIDController(3.1, 0, 0, angleFixer, angleCorr);
	

    public AutoAim() {
    	
    	
    	//System.out.println("Isaac is a door.");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return vision.COG_X-(vision.IMAGE_WIDTH/2.0) < 0.00001;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
