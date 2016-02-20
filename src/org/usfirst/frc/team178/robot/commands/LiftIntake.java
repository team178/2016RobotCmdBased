package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.command.Command;

public class LiftIntake extends Command {

	public LiftIntake() {
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
		Robot.intake.setUpDown(1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.intake.isTopLimitSwitchTripped();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.intake.setUpDown(0);
		Robot.intake.allStop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.intake.setUpDown(0);
		Robot.intake.allStop();
	}

}
