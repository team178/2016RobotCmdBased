package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TapeMeasureScalar extends Subsystem {
    public static Relay Freddie;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public TapeMeasureScalar() {
    	Freddie = new Relay(RobotMap.scalarMotor, Relay.Direction.kForward);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
    	
    }
    
    public void Up() {
    	Freddie.set(Relay.Value.kOn);
    }
    public void Down() {
    	Freddie.set(Relay.Value.kOff);
    }
    
    
    
}

