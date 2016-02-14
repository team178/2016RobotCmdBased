package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
	DriveTrain drivetrain;
	OI joystick;
	double yVal,twistVal;
	
	public Drive()
	{
		requires(Robot.drivetrain);
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
		
		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			drivetrain.drive(-twistVal+yVal, -twistVal-yVal);
		}
		else {
			drivetrain.drive(0,0);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drivetrain.drive(0,0);
	}

	protected void interrupted() {
		drivetrain.drive(0,0);

	}
}
