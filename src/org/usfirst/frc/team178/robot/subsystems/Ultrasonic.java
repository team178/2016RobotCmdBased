package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ultrasonic extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput sensor;
	double coeficent = 1;
	double yIntercept = 0;
	
	
	public Ultrasonic(){
		sensor = new AnalogInput(0);
	}
	
	public double getVoltage(){
		
		return sensor.getVoltage()*coeficent + yIntercept;
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

