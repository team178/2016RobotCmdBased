package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PhotoelectricSensor extends Subsystem {
    DigitalInput sensor;
    public PhotoelectricSensor() {
    	sensor = new DigitalInput(RobotMap.PhotoelectricSensor);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public boolean getstuff(){
    	return sensor.get();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
