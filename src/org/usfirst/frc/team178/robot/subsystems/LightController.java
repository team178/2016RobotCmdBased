package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightController extends Subsystem {
    public static I2C arduino;
    
    public LightController(){
    	arduino = new I2C(I2C.Port.kOnboard, 10);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean saySomething(String message) {
    	return arduino.writeBulk(message.getBytes());
    }
}

