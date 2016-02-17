package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Switches extends Subsystem {
    
	DigitalInput digitalinput1;
	DigitalInput digitalinput2;
	DigitalInput digitalinput3;
	DigitalInput digitalinput4;
	
	public Switches(){
		digitalinput1 = new DigitalInput(RobotMap.SwitchPort1);
		digitalinput2 = new DigitalInput(RobotMap.SwitchPort2);
		digitalinput3 = new DigitalInput(RobotMap.SwitchPort3);
		digitalinput4 = new DigitalInput(RobotMap.SwitchPort4);
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public boolean getValue(int inputNum) {
		if (inputNum == 1)
			return digitalinput1.get();
		else if(inputNum == 2)
			return digitalinput2.get();
		else if(inputNum == 3)
			return digitalinput3.get();
		else if (inputNum == 4)
			return digitalinput4.get();
		else{
			return false;
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

