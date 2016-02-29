package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.AntennaScalar;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AScale extends Command {
	AntennaScalar antennascalar;
	
    public AScale() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.antennascalar);
    	antennascalar = Robot.antennascalar;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	antennascalar.Up();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.oi.isTSPressed(8)) 
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
    	antennascalar.Down();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
