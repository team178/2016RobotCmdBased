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
    
    public HoldBall() {
        //requires(Robot.encoders);
        requires(Robot.kicker);
        requires(Robot.sensor);
        kicker = Robot.kicker;
        sensor = Robot.sensor;
        //encoders = Robot.encoders;
        this.setTimeout(0.7);
    }
    protected void initialize() {
    	//No initialization code
    }
    protected void execute() 
    {
    	if (sensor.isActivated()){
    			kicker.kick(.1);
    			//System.out.println(encoders.getDistance(3));
    	}
    }
    

    @Override
	public synchronized void start() {
		super.start();
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
    	return isTimedOut();
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
