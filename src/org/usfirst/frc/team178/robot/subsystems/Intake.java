package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	CANTalon spin;
	CANTalon rotate;
	
	public Intake(){
		spin = new CANTalon();
		rotate = new CANTalon();
	}
    
	public void lift()
	{
		spin.set(1);
		rotate.set(0.25);
	}
	
	public void stop()
	{
		spin.set(0);
		rotate.set(0);
	}
	
	public void reverse()
	{
		spin.set(-1);
		rotate.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
