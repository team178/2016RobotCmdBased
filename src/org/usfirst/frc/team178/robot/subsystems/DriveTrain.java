package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{

	public static Victor left1;
	public static Victor left2;
	public static Victor right1;
	public static Victor right2;
	
	public DriveTrain()  {
		
		left1 = new Victor(RobotMap.MOTOR.TOPleft);
		left2 = new Victor(RobotMap.MOTOR.BOTTOMleft);
		right1 = new Victor(RobotMap.MOTOR.TOPright);
		right2 = new Victor(RobotMap.MOTOR.BOTTOMright);
	}
	

	
	public void drive(double LeftMotors, double RightMotors)
	{
		left1.set(LeftMotors);
		left2.set(LeftMotors);
		right1.set(RightMotors);
		right2.set(RightMotors);
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new JoystickDrive());
	}
}

