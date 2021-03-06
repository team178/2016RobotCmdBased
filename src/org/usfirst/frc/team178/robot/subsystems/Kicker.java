package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class Kicker extends Subsystem {
	public static CANTalon motor1;
	public static CANTalon motor2;

	public Kicker() {
		motor1 = new CANTalon(RobotMap.KICKER_ONE);
		motor2 = new CANTalon(RobotMap.KICKER_TWO);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void kick(double num) {
    	motor1.set(num);
    	motor2.set(num);
    }
    
}