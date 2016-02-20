package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Encoders;
import org.usfirst.frc.team178.robot.subsystems.Kicker;

/**
 *
 */


public class Kick extends Command {
	Kicker kicker;
	Encoders encoders;
	
    public Kick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    	kicker = Robot.kicker;
    	requires(Robot.encoders);
    	encoders = Robot.encoders;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoders.reset(3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	kicker.kick(-.3);
    	System.out.println(encoders.getDistance(3));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//double passedTime = timeSinceInitialized();
    	double degrees = encoders.getDistance(3);
    	if (degrees >= 360) {
    		System.out.println("true");
    		return true;
    	}
    	else {
    		System.out.println("false");
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	kicker.kick(0);
    	double lastPosition = encoders.getDistance(3);
    	while(lastPosition > 360) {
    		kicker.kick(.05);
    	}
    	kicker.kick(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("inttttt");
    }
}
