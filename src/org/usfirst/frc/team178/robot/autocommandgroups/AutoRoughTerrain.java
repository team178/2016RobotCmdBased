package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.AutoDoNothing;
import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.DropIntake;
import org.usfirst.frc.team178.robot.commands.HoldBall;
import org.usfirst.frc.team178.robot.commands.Kick;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRoughTerrain extends CommandGroup {
    
    public  AutoRoughTerrain() {
    	
    	addSequential(new AutoDrive(0.5), 2.5);
    	addSequential(new AutoAim(), 5);
    	addSequential(new DropIntake());
    	addSequential(new HoldBall());
    	addSequential(new AutoDoNothing(), 0.1);
    	addSequential(new Kick());
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
