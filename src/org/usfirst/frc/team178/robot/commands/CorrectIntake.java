package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Intake;

/**
 *
 */
public class CorrectIntake extends Command {

	Intake intake;
    public CorrectIntake() {
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intake = Robot.intake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(intake.getIntakeLocation()!=intake.isTopLimitSwitchTripped()&& intake.getIntakeLocation())
    	{
    		Robot.intake.liftIntake();
    	}
    	else if(intake.getIntakeLocation()!=intake.isBottomLimitSwitchTripped()&& !intake.getIntakeLocation())
    	{
    		Robot.intake.dropIntake();
    	}
    	else
    	{
    		Robot.intake.setUpDown(0);
    	}
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
