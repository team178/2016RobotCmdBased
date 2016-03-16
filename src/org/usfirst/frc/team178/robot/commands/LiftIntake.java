package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class LiftIntake extends Command {
	
	Intake intake;

    public LiftIntake() {
    	requires(Robot.intake);
    	this.setTimeout(0.5);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intake = Robot.intake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setUpDown(-0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (this.isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setUpDown(0);
		Robot.intake.allStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.setUpDown(0);
		Robot.intake.allStop();
    }
}
