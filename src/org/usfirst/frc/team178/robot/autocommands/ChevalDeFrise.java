package org.usfirst.frc.team178.robot.autocommands;

import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.DropIntake;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevalDeFrise extends CommandGroup {
    
    public  ChevalDeFrise() {
    	addSequential(new AutoDrive(0.8),1.5);
    	addSequential(new DropIntake());
    	addSequential(new AutoDrive(1.0),1.5);
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
