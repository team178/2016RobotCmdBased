package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
public class JoystickDrive2 extends Command {
	
	//Encoders encoders;
	OI oi;
	DriveTrain drivetrain;
	double yVal,twistVal;
	
	public JoystickDrive2()
	{
		requires(Robot.drivetrain);
		//requires(Robot.encoders);
	}
	
    protected void initialize() {
    	oi = Robot.oi;
    	//encoders = Robot.encoders;
    	drivetrain = Robot.drivetrain;
    }
	
	protected void execute() {
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		//Motors are attached backwards, hence the negatives
		yVal = -1*oi.getY();
		twistVal = -1*oi.getTwist();
		//System.out.println("Y Val: " + yVal);
		//System.out.println("Twist Val: " + twistVal);
		//System.out.println("X Val: " + oi.getX());

		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		//The if condition implements what's called a dead zone. The controllers have some variances to them, 
		//and this makes sure that the robot doesn't do anything we don't want it to.
		//Without this, the motor speed is never upset. 
		//The robot would continue moving at its last speed. This makes it stop.
	/*	while(oi.getAxisValue()<-0.5 || oi.getAxisValue()>0.5){
			new KiddyDrive();
		}*/
		//System.out.println("MY NAME'S NOT RIIIIICK!!!");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	//	drivetrain.drive(0,0);
	}

	protected void interrupted() {

	}
}
