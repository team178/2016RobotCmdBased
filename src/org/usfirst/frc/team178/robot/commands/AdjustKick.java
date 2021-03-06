package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Kicker;

/**
 *
 */
public class AdjustKick extends Command {
	Kicker kicker;
	
    public AdjustKick() {
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
    	kicker.kick(-0.2);
    	System.out.println("kicker adjust move");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	kicker.kick(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	kicker.kick(0);
    }
}
