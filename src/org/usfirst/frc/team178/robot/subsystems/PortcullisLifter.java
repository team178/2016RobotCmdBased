package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class PortcullisLifter extends Subsystem {
    public static Victor lifter;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public PortcullisLifter()	{
    	lifter = new Victor(1000);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

