package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *!!!!!! ATTANTION !!!!!! The lift and reverse methods need to be fixed, probably removed. The commands that use them need to be fixed.
 */
public class Intake extends Subsystem {
	CANTalon inOut;//Turns pulleys on intake.
	CANTalon upDown;//Lifts intake up and down.
	
	public Intake(){
		inOut = new CANTalon(18);
		upDown = new CANTalon(19);
	}
	
	public void setInOut(int value)
	{
		inOut.set(value);
	}
	
	public void setUpDown(int value)
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
