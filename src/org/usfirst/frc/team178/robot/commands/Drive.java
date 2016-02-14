package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;


public class Drive extends CommandBase{
	double yVal,xVal;
	public Drive()
	{
		requires(drivetrain);
		
		
	}
	
	 protected void initialize() {
	 }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	
	    	yVal = -1*oi.gety();
			xVal = -1*oi.getx();

	    	double leftSide = -xVal+yVal;
	        double rightSide =-xVal-yVal;
	    	drivetrain.drive(leftSide,rightSide );
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
			if(Math.abs(yVal)>0.1 || Math.abs(xVal)>0.1){
				return false;
			}
			else {
				return true;
			}
		}

		protected void end() {
			drivetrain.drive(0,0);
		}

		protected void interrupted() {
			drivetrain.drive(0,0);

		}
	
public void initDefaultCommand() {
}

}
/*
public class Drive extends Command{
	DriveTrain drivetrain;
	Joystick joystick;
	double yVal,twistVal;
	
	public Drive()
	{
		requires(Robot.drivetrain);
		requires(Robot.oi.joystick);

		drivetrain = Robot.drivetrain;
		joystick = Robot.oi.joystick; 
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		//TODO clean up this section. The negatives are quite ghetto. It's hard to understand.
		yVal = -1*joystick.getY();
		twistVal = -1*joystick.getTwist();

		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		//TODO Debug and optimize this code. It does things weirdly. It's more logical to turn based on twist.
		//The if condition implements what's called a dead zone. The controllers have some variances to them, 
		//and this makes sure that the robot doesn't do anything we don't want it to.
		//Without this, the motor speed is never upset. 
		//The robot would continue moving at its last speed. This makes it stop.

		drivetrain.drive(-twistVal+yVal, -twistVal-yVal);

	}

	protected boolean isFinished() {
		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			return false;
		}
		else {
			return true;
		}
	}

	protected void end() {
		drivetrain.drive(0,0);
	}

	protected void interrupted() {
		drivetrain.drive(0,0);

	}
}
*/