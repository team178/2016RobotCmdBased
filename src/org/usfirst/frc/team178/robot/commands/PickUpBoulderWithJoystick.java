package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.Robot;
/**
 *
 */
public class PickUpBoulderWithJoystick extends Command {
	Intake intake;
	PhotoelectricSensor sensor;
	Encoders encoders;

    public PickUpBoulderWithJoystick() {
    	requires (Robot.encoders);
    	requires (Robot.intake);
    	requires (Robot.sensor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    
    	encoders = Robot.encoders;
    	intake = Robot.intake;
    	sensor = Robot.sensor;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.isPressed(8) && encoders.getDistance(4) < 10) {
    		intake.lift();//Needs to be replaced with code that will actually work.
    	}else if(Robot.oi.isPressed(9) && encoders.getDistance(4) > 0) {
    		intake.reverse();//Needs to be replaced with code that will actually work.
    	}
    	else {
    		intake.stop();//Not sure if you want this.
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
