package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionValues {

	public double COG_X;
	public double DISTANCE_TO_TARGET;
	public double PROCESS_TIME;
	public double IMAGE_WIDTH;
	public double BLOB_COUNT;
	
	public double getBLOB_COUNT() {
		return NetworkTable.getTable("VisionVars").getNumber("BLOB_COUNT",0);
	}

	public double getIMAGE_WIDTH() {
		return NetworkTable.getTable("VisionVars").getNumber("IMAGE_WIDTH",0);
	}

	public double getCOG_X() {
		return NetworkTable.getTable("VisionVars").getNumber("COG_X",0);
	}

	public double getDISTANCE_TO_TARGET() {
		return DISTANCE_TO_TARGET;
	}

	public double getPROCESS_TIME() {
		return PROCESS_TIME;
	}

	public VisionValues() {
		//Empty Constructor
	}

}
