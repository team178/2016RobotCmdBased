package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class PortcullisLifter extends Subsystem {
    public static CANTalon lifter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public PortcullisLifter()	{
    	lifter = new CANTalon(1000);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

