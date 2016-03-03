package org.usfirst.frc.team178.robot.subsystems;

import javax.management.relation.Relation;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraRelay extends Subsystem {

	Relay CameraRelay; 
	public CameraRelay() {
		// TODO Auto-generated constructor stub
		CameraRelay = new Relay(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void turnOnRelay(){
		CameraRelay.set(Value.kForward);
	}
}
