package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.PorticullisLifter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class RaiseLifter extends Command {

	Timer timer;

	public RaiseLifter() {
		timer = new Timer();
		timer.stop();
		timer.reset();
		requires(Robot.lifter);
	}
	
	protected void initialize() {
		timer = new Timer();
		timer.start();
		timer.reset();
	}
	
	protected void execute() {
		Robot.lifter.lift();
	}

	protected boolean isFinished() {
		if(timer.get() >= 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	protected void end() {
		Robot.lifter.off();
		timer.stop();
		timer.reset();
	}
	
	protected void interrupted() {
		Robot.lifter.off();
		timer.stop();
		timer.reset();
	}
}