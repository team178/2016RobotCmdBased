package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Encoders;
import org.usfirst.frc.team178.robot.subsystems.Kicker;
import org.usfirst.frc.team178.robot.subsystems.PhotoelectricSensor;

/**
 *
 */


public class Kick extends Command {
	Kicker kicker;
	Encoders encoders;
	PhotoelectricSensor sensor; 
	
    public Kick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    	requires(Robot.encoders);
    	requires(Robot.sensor);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	kicker = Robot.kicker;
    	encoders = Robot.encoders;
    	encoders.reset(3);
    	sensor = Robot.sensor;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.isBottomLimitSwitchTripped()||!Robot.intake.isTopLimitSwitchTripped())
    	{
    		kicker.kick(-1);
    		System.out.println(encoders.getDistance(3));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//double passedTime = timeSinceInitialized();

    	double revolutions = encoders.getDistance(3);
    	if (revolutions >= 360) {//It may never stop because it only gives you a 4 degree window to return true. 


    		System.out.println("true");
    		return true;
    	}
    	else {
    		System.out.println("false");
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	kicker.kick(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("rick");
    }
}
