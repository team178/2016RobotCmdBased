package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class USBCam extends Subsystem {

	USBCamera camera;
	String camname = "cam0";
	String fakecamname = "cam10";
	Boolean camOn = true;

	public USBCam() {
		try {
			camera = new USBCamera(camname);
		} catch (Exception ae1) {
			try {
				camera = new USBCamera("cam1");
			} catch (Exception e) {
				try {
					try {
						camera = new USBCamera("cam3");
					} catch (Exception e3) {
						//nothing
					}
				}
				catch(Exception ae3){
					
				}
			}
		}
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void cameraSwitch() {
		if (camOn) {
			try {
				camera.stopCapture();
			} catch (Exception e) {
				// Do nothing
			}
			camOn = false;
		} else {
			try {
				camera.startCapture();
			} catch (Exception e) {
				// Do nothing
			}
			camOn = true;
		}
	}

	public USBCamera getCamera() {
		return camera;
	}
}
