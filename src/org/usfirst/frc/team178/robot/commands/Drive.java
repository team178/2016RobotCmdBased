package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

public class Drive {
	
	public Drive()
	{
		requires(Robot.drivetrain);
	}
	
	public void drive(Joystick joystick){
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		//TODO clean up this section. The negatives are quite ghetto. It's hard to understand.
		double yVal,twistVal;
		yVal = -1*joystick.getY();
		twistVal = -1*joystick.getTwist();
				
		// 6wl tank drive has two motors on one gearbox that drive in the same direction.
		//TODO Debug and optimize this code. It does things weirdly. It's more logical to turn based on twist.
		//The if condition implements what's called a dead zone. The controllers have some variances to them, 
		//and this makes sure that the robot doesn't do anything we don't want it to.
		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			left1.set(-twistVal+yVal);
			left2.set(-twistVal+yVal);
			right1.set(-twistVal-yVal);
			right2.set(-twistVal-yVal);
		}
		//Without this, the motor speed is never upset. 
		//The robot would continue moving at its last speed. This makes it stop.
		else{
			left1.set(0);
			left2.set(0);
			right1.set(0);
			right2.set(0);
		}
		
		//SmartDashboard.putNumber("Rotation", );
	}
	
public void initDefaultCommand() {
		
	}
	
}
