package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
	
	public Drive()
	{
		requires(drivetrain);
		
		
	}
	
	 protected void initialize() {
	 }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	double leftSide = oi.gety()-oi.getx();
	        double rightSide = oi.gety()+oi.getx();
	    	drivetrain.drive(leftSide,rightSide );
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
	
public void initDefaultCommand() {
		
	}
	
}
