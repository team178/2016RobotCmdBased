package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class Intake extends Subsystem {
	CANTalon inOut;//Turns pulleys on intake.
	CANTalon upDown;//Lifts intake up and down.
	
	public Intake(){
		inOut = new CANTalon(18);
		upDown = new CANTalon(19);
	}
    
	public void lift()
	{
		inOut.set(1);
		upDown.set(0.25);
	}
	
	public void stop()
	{
		inOut.set(0);
		upDown.set(0);
	}
	
	public void reverse()
	{
		inOut.set(-1);
		upDown.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
