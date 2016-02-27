package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AntennaScalar extends Subsystem {
    public static Relay Elizabeth;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public AntennaScalar() {
    	Elizabeth = new Relay(RobotMap.scalarMotor, Relay.Direction.kForward);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Up() {
    	Elizabeth.set(Relay.Value.kOn);
    }
    public void Down() {
    	Elizabeth.set(Relay.Value.kOff);
    }
}

