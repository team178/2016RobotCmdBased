package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TapeMeasureScalar extends Subsystem {
    public static Relay Rick;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public TapeMeasureScalar() {
    	Rick = new Relay(RobotMap.scalarMotor, Relay.Direction.kForward);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
    	
    }
    
    public void Up() {
    	Rick.set(Relay.Value.kOn);
    }
    public void Down() {
    	Rick.set(Relay.Value.kOff);
    }
    
    
    
}

