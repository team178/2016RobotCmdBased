package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class LiftIntake extends Command {

	Timer timer;
	
	public LiftIntake() {
		// TODO Auto-generated constructor stub
		timer = new Timer();
		timer.stop();
		timer.reset();
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		timer = new Timer();
		timer.start();
		timer.reset();
		this.setTimeout(0.5);
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intake.setUpDown(-1.0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		/*if(Robot.intake.isTopLimitSwitchTripped()||timer.get()>=2)
		{
			return true;
		}
		else
		{
			return false;
		}*/
		return(this.isTimedOut());
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.intake.setUpDown(0);
		Robot.intake.allStop();
		timer.stop();
		timer.reset();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.intake.setUpDown(0);
		Robot.intake.allStop();
		timer.stop();
		timer.reset();
	}

}
