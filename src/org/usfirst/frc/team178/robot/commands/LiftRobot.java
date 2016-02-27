package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Encoders;
import org.usfirst.frc.team178.robot.subsystems.Scalar;

/**
 *
 */


public class LiftRobot extends Command {
	Encoders encoders; 
	Scalar scalar;
	
    public LiftRobot() {
    	requires(Robot.scalar);
    	requires(Robot.encoders);
    	//Might require encoders? Probably not.
    	
    }

    protected void initialize() {
    	scalar = Robot.scalar;
    	encoders = Robot.encoders;

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scalar.moveScalar(-0.8);
    	//From what I know, the motors should be moving in the same direction.
    	//One motor pushes the tape out, the other helps to pull it out.
    	//If it seems confusing, you can ask Chris for clarification.
    	//Also check what speeds they want.
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    	//Ask what buttons they want for this command and change accordingly.

    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.scalar.moveScalar(0);    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.scalar.moveScalar(0);
    }
    //Totally didn't copy/paste this one.
}
