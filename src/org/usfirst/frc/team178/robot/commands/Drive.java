package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

<<<<<<< HEAD
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
		
=======
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
>>>>>>> 875da309eb4fd5004542029d2e812888df9f20c2
	}
}
