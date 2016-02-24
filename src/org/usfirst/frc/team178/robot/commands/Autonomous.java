package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
    	
    	
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
    	
    	//Pseudocode Starts Here
    	
    	//Initialize Sendable Chooser to pick obstacle to cross
    	//Start switch case based on SendableChooser
    	//Each switch case will have addSequential(*relevantcommand*) in order to complete the obstacle
    	//After the switches break, enter High Goal shooting mode.
    	//Use Variables created in the VisionVars class to make descisions.
    	
    	
    	
    	
    }
    
    protected void execute() {
    	System.out.println("Just do that");
    }

}
