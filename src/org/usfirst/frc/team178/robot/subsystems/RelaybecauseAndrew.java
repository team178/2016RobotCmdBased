package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 */
public class RelaybecauseAndrew extends Subsystem {
	Relay icecreamsandwich; 
    public RelaybecauseAndrew (){
    	icecreamsandwich = new Relay (RobotMap.RELAYINPUT); 	
    }
    public void setvalue (boolean isOn){
    	if (isOn){
    		icecreamsandwich.set(Relay.Value.kForward);	
    	}
    	else {
    		icecreamsandwich.set(Relay.Value.kOff);
    	}
    	// Put methods for controlling this subsystem
    }

    
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
