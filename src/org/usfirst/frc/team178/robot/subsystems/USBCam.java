package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class USBCam extends Subsystem {

	USBCamera camera;
	String camname = "cam3";
	String fakecamname = "cam10";
	Boolean camOn = true;
	
	public USBCam() {
		// TODO Auto-generated constructor stub
		camera = new USBCamera("cam3");
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void cameraSwitch(){
		if(camOn){
			camera.startCapture();
			camOn=false;
		}
		else{
			camera.stopCapture();
		}
	}
	
	public USBCamera getCamera() {
		return camera;
	}
}
