package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.USBCam;

import edu.wpi.first.wpilibj.command.Command;

public class CameraSwitch extends Command {

	private boolean isDone=false;
	
	public CameraSwitch() {
		// TODO Auto-generated constructor stub
		requires(Robot.usbCamera);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		//Intentionally blank
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.usbCamera.cameraSwitch();
		isDone = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isDone;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		isDone = false;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}