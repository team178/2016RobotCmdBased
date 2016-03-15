







package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeathSpin extends Command {

    public DeathSpin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*&System.out.println("We said don't do it.");
    	System.out.println("Now it's doing the same thing as AutoDoNothing");
    	System.out.println("Good job.");
    	System.out.println("You guys thought it'd be funny.");
    	System.out.println("And now you look really stupid in autonomous.");
    	System.out.println("Congrats.");*/
    	System.out.println("rick");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
