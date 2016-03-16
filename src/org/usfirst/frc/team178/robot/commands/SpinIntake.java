package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinIntake extends Command {
	
	double speed;

    public SpinIntake(double speed) {
        requires(Robot.intake);
        speed = this.speed;
        //this.setTimeout(0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setInOut(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setInOut(0);
		Robot.intake.allStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /* So basically we had to do this because we wanted this to go to two buttons
    but you can't do this so basically two buttons will call the same command and it will stop
    from being interrupted after the timeout*/
    
    protected void interrupted() {
    	Robot.intake.setInOut(0);
		Robot.intake.allStop();
    }
}
