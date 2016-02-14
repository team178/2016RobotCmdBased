package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{

	public static TalonSRX left1;
	public static TalonSRX left2;
	public static TalonSRX right1;
	public static TalonSRX right2;

	
	public DriveTrain()  {
		
		left1 = new TalonSRX(0);
		left2 = new TalonSRX(1);
		right1 = new TalonSRX(2);
		right2 = new TalonSRX(3);
	}
	protected void initDefaultCommand() {
		
	}
	
	protected void execute()
	{
		
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}

}
