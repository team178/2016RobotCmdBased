package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class SmartDashboardThing extends Command {
	Intake intake;
	SmartDashboard smartdash;
	PhotoelectricSensor sensor;

    public SmartDashboardThing() {
        requires(Robot.intake);
        requires(Robot.sensor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	smartdash.putNumber("Ultrasonic Distance", 3.0);
    	smartdash.putBoolean("Top LS flipped", intake.isTopLimitSwitchTripped());
    	smartdash.putBoolean("Bottom LS flipped", intake.isBottomLimitSwitchTripped());
    	smartdash.putBoolean("Ball in holding area", sensor.getstuff()); //Add other condition or add method in Kicker or something like that
    	smartdash.putBoolean("Ready to kick", false);
    	

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
