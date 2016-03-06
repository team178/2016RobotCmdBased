package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Encoders;
import org.usfirst.frc.team178.robot.subsystems.Kicker;
import org.usfirst.frc.team178.robot.subsystems.PhotoelectricSensor;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldBall extends Command {
    Kicker kicker;
    //Encoders encoders;
    PhotoelectricSensor sensor;
    //double lastPosition; 
    //Timer timer;
    
    public HoldBall() {
        //requires(Robot.encoders);
        requires(Robot.kicker);
        requires(Robot.sensor);
        kicker = Robot.kicker;
        sensor = Robot.sensor;
        //encoders = Robot.encoders;
        this.setTimeout(0.7);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//No initialization code
    	//timer = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (sensor.isActivated()){
    			kicker.kick(.1);
    			//System.out.println(encoders.getDistance(3));
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    @Override
	public synchronized void start() {
    	//timer = new Timer();
    	//timer.start();
		super.start();
	}

	protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	kicker.kick(0);
    	//timer.stop();
    	//timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	kicker.kick(0);
    }
}
