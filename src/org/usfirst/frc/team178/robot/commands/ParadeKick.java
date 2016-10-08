package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Kicker;

/**
 *
 */
public class ParadeKick extends Command {
	Kicker kicker;
    public ParadeKick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    	kicker = Robot.kicker;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 /*	kicker.kick(-0.1);
    	double passedTime = timeSinceInitialized();
		if (passedTime >= 1 && passedTime < 2) {
	    	kicker.kick(0.1); 
    	}*/
    	double passedTime = timeSinceInitialized();
    	int x = (int)passedTime;
    	if (x%2 == 0)
    		kicker.kick(.085);
    	else 
    		kicker.kick(-.085);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return false;
}

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
