package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntakeOut extends Command {

	public SpinIntakeOut() {
		// TODO Auto-generated constructor stub
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intake.setInOut(-1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(Robot.oi.isTSPressed(5))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.intake.setInOut(0);
		Robot.intake.allStop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}


}
