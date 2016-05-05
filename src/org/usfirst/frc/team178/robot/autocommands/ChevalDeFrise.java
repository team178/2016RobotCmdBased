package org.usfirst.frc.team178.robot.autocommands;

import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.AutoDoNothing;
import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.DropIntake;
import org.usfirst.frc.team178.robot.commands.HoldBall;
import org.usfirst.frc.team178.robot.commands.Kick;
import org.usfirst.frc.team178.robot.commands.LiftIntake;
import org.usfirst.frc.team178.robot.commands.SpinIntakeIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevalDeFrise extends CommandGroup {
    
    public  ChevalDeFrise() {
    	addSequential(new AutoDrive(0.4),1.27);
    	addSequential(new DropIntake());
    	addSequential(new AutoDoNothing(),.1);
    	addSequential(new AutoDrive(0.6),2.0);
    	addSequential(new SpinIntakeIn(), 1);
    	addSequential(new AutoAim());
    	addParallel(new HoldBall());
    	addSequential(new Kick());
    	
    	//addParallel(new LiftIntake());
    	
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
