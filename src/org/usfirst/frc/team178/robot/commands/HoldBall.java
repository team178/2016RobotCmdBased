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
    Encoders encoders;
    PhotoelectricSensor sensor;
    
    boolean shouldRun  = false;
    
    public HoldBall() {
        requires(Robot.encoders);
        requires(Robot.kicker);
        requires(Robot.sensor);
        kicker = Robot.kicker;
        sensor = Robot.sensor;
        encoders = Robot.encoders;
        
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      if (sensor.getstuff()){
    	  kicker.kick(0);
    	  shouldRun = true;
      }  
      else{
    	  shouldRun = false;
      }
     
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//if (sensor.getstuff()){
    		
    			kicker.kick(.1);
    			System.out.println(encoders.getDistance(3));
    	//	}
	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double currentPosition = encoders.getDistance(3)-((int)(encoders.getDistance(3)/360)*360.0);
    	if (currentPosition > 5 && shouldRun) {
    		return false;
    	}
    	else {
    	
    		return true;
    	}
       
    }

    // Called once after isFinished returns true
    protected void end() {
    	kicker.kick(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	kicker.kick(0);
    }
}
