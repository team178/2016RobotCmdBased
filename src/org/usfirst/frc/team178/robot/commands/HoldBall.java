package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Encoders;
import org.usfirst.frc.team178.robot.subsystems.Kicker;
import org.usfirst.frc.team178.robot.subsystems.PhotoelectricSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldBall extends Command {
    Kicker kicker;
    //Encoders encoders;
    PhotoelectricSensor sensor;
    //double lastPosition; 
    
    public HoldBall() {
        //requires(Robot.encoders);
        requires(Robot.kicker);
        requires(Robot.sensor);
        kicker = Robot.kicker;
        sensor = Robot.sensor;
        //encoders = Robot.encoders;
        
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      if (sensor.getstuff()){
    	  kicker.kick(0);
    	  //lastPosition = encoders.getDistance(3);
      }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (sensor.getstuff()){
    		
    			kicker.kick(.1);
    			//System.out.println(encoders.getDistance(3));
    		}
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime >= 0.3) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	/*double currentPosition = encoders.getDistance(3);
    	if (currentPosition-lastPosition > 5) {
    		return false;
    	}
    	else {
    		currentPosition = lastPosition;
    		return true;
    	}*/
       
    }

    // Called once after isFinished returns true
    protected void end() {
    	kicker.kick(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
