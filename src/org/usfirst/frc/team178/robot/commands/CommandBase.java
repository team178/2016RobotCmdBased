package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.Encoders;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandBase extends Command {


	DriveTrain drivetrain;
	Encoders encoders;
	
	public static OI oi;

	
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	encoders = Robot.encoders;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
