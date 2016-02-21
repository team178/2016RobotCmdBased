package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class ToggleIntakeLocation extends Command {
	
	Intake intake;
	int buttonPressed;

    public ToggleIntakeLocation(int value) {
    	requires(Robot.intake);
    	buttonPressed = value;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intake = Robot.intake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(buttonPressed == 1)
    	{
    		intake.setIntakeLocation(true);
    	}
    	else if(buttonPressed == 0)
    	{
    		intake.setIntakeLocation(false);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(buttonPressed == 1 && intake.getIntakeLocation() == true||buttonPressed == 0 && intake.getIntakeLocation() == false)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
