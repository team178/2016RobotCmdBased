package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.TapeMeasureScalar;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TMScale extends Command {
	TapeMeasureScalar tapemeasurescalar;
	
    public TMScale() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires (Robot.tapemeasurescalar);
    	//tapemeasurescalar = Robot.tapemeasurescalar;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	tapemeasurescalar.Up();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.oi.isTSPressed(7)) 
    	{
    		return false;
    	}
    	else 
    	{
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	tapemeasurescalar.Down();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
