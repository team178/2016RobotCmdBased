package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ultrasonic extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput sensor;
	double coeficent = 0.327/35;
	double yIntercept = 0.087714;
	
	
	public Ultrasonic(){
		sensor = new AnalogInput(RobotMap.ULTRASONICINPUT);
	}
	
	public double getVoltage(){
		
		return ((sensor.getVoltage()));
	}
	
	public double getDistance(){
		return ((this.getVoltage() - yIntercept)/coeficent); 
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

