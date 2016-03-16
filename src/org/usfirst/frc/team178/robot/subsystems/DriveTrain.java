package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{

	public static CANTalon left1;
	public static CANTalon left2;
	public static CANTalon right1;
	public static CANTalon right2;
	
	public DriveTrain()  {
		
		left1 = new CANTalon(RobotMap.MOTOR.TOPleft);
		left2 = new CANTalon(RobotMap.MOTOR.BOTTOMleft);
		right1 = new CANTalon(RobotMap.MOTOR.TOPright);
		right2 = new CANTalon(RobotMap.MOTOR.BOTTOMright);
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

