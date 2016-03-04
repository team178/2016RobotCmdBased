package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.Robot;
/**
 *
 */
public class PickUpBoulder extends Command {
	
	Intake intake;
	
    public PickUpBoulder() {
    	requires (Robot.encoders);
    	requires (Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intake = Robot.intake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//intake.lift();//This will not do what you want it to do. Replace with methods that do the right things.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.sensor.getstuff()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	//intake.stop();//Don't think you want this.
    	//intake.reverse();//Don't think you want this.
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
