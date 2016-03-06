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
	//Encoders encoders;
	PhotoelectricSensor sensor; 
	
    public Kick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    	kicker = Robot.kicker;
    	//requires(Robot.encoders);
    	requires(Robot.sensor);
    	//encoders = Robot.encoders;
    	//encoders.reset(3);
    	sensor = Robot.sensor;	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//kicker.kick(0);
    	//double lastPosition = encoders.getDistance(3);
    	//while(encoders.getDistance(3) > 0) {
    		//kicker.kick(1);
    		//System.out.println(encoders.getDistance(3));
    		
    	//}
    	//kicker.kick(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		kicker.kick(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime >= 0.5) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	/*double degrees = encoders.getDistance(3)%360.0;
    	if (degrees >= 355) {
    		System.out.println("true");
    		return true;
    	}
    	else {
    		System.out.println("false");
    		return false;
    	}*/
    }

    // Called once after isFinished returns true
    protected void end() {	
    	/*double degrees = encoders.getDistance(3)%360.0;
    	while(degrees >= 170 || degrees <= 20){
    		degrees = encoders.getDistance(3)%360.0;
    		kicker.kick(0.1);
    	}*/
    	kicker.kick(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("inttttt");
    }
}
