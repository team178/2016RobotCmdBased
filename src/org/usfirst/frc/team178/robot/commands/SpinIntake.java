package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinIntake extends Command {
	
	int TS;
	double speed;

    public SpinIntake(int TS, double speed) {
        requires(Robot.intake);
        TS = this.TS;
        speed = this.speed;
        this.setTimeout(0.5);
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
    	if(Robot.oi.isTSPressed(TS)){
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setInOut(0);
		Robot.intake.allStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
