package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class AutoDoNothing extends Command {
	
	DriveTrain drivetrain;
	Timer timer;

    public AutoDoNothing() {
        requires(Robot.drivetrain);
        drivetrain = Robot.drivetrain;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(0, 0);
    	System.out.println("Nothing.");
    }    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.drive(0, 0);
    }
}
