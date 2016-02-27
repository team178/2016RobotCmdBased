package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class Scalar extends Subsystem {
	public static CANTalon topMotor;
	public static CANTalon bottomMotor;

	public Scalar() {
		topMotor = new CANTalon(20);
		bottomMotor = new CANTalon(21);
		//Check what input values are available for CANTalons, temp numbers in
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveScalar(double num) {
    	topMotor.set(num);
    	bottomMotor.set(num);
    	//You can rename this method if you want
    	//Idk any other names
    }
    
}

