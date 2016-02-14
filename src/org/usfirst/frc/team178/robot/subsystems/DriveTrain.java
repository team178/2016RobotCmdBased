package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{

	public static CANTalon left1;
	public static CANTalon left2;
	public static CANTalon right1;
	public static CANTalon right2;
	
	public DriveTrain()  {
		
		left1 = new CANTalon(0);
		left2 = new CANTalon(1);
		right1 = new CANTalon(2);
		right2 = new CANTalon(3);
	}
	protected void initDefaultCommand() {
		
	}
	
	public void drive(double leftnum, double rightnum){
    	left1.set(leftnum);
    	left2.set(leftnum);
    	right1.set(rightnum);
    	right2.set(rightnum);
    }
	

}
