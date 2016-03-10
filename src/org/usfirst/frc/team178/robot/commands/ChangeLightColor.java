package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.LightController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeLightColor extends Command {
	LightController lights;
	String color; 
	
    public ChangeLightColor(String c) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.lights);
    //	lights = Robot.lights;
    	color = c;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Chosen Color: " + color);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return lights.saySomething(color);
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("FINISHED");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
