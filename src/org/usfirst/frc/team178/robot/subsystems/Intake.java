package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *!!!!!! ATTENTION !!!!!! The lift and reverse methods need to be fixed, probably removed. The commands that use them need to be fixed.
 */
public class Intake extends Subsystem {
	CANTalon inOut;//Turns pulleys on intake.
	CANTalon upDown;//Lifts intake up and down.
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	public Intake(){
		inOut = new CANTalon(19);
		upDown = new CANTalon(18);
		
		limitSwitchBottom = new DigitalInput(RobotMap.bottomintakelimitswitch);	
		limitSwitchTop = new DigitalInput(RobotMap.topintakelimitswitch);
	}
	
	public boolean isBottomLimitSwitchTripped(){
		//System.out.println("Bottom: " + limitSwitchBottom.get());
		return limitSwitchBottom.get();
	}
	
	public boolean isTopLimitSwitchTripped(){
		//System.out.println("Top: " + limitSwitchTop.get());
		return limitSwitchTop.get();
	}
		
	public void setInOut(double value)
	{
		inOut.set(value);
	}
	
	public void setUpDown(double value)
	{
		upDown.set(value);
	}
	
	
	public void allStop()//Stops all intake motors.
	{
		inOut.set(0);
		upDown.set(0);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
