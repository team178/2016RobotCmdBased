package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionValues {

	/*
	public double COG_X;
	public double DISTANCE_TO_TARGET;
	public double PROCESS_TIME;
	public double IMAGE_WIDTH;
	public double BLOB_COUNT;
	*/
	
	/*
	 * This void method will return the number of blobs that RoboRealm has found
	 */
	public double getBLOB_COUNT() {
		return NetworkTable.getTable("VisionVars").getNumber("BLOB_COUNT",0);
	}
	
	/*
	 * This method returns the width of the image being processed
	 */
	public double getIMAGE_WIDTH() {
		return NetworkTable.getTable("VisionVars").getNumber("IMAGE_WIDTH",0);
	}
	
	/*
	 * This method returns the X-coordinate of the Center of Gravity of the target acquired. Be advised that this variable may not exist, and will default to the value 0.
	 */
	public double getCOG_X() {
		return NetworkTable.getTable("VisionVars").getNumber("COG_X",0);
	}
	
	/*
	 * This method returns the calculated distance to the target.
	 */
	public double getDISTANCE_TO_TARGET() {
		return NetworkTable.getTable("VisionVars").getNumber("DISTANCE_TO_TARGET",0);
	}
	
	/*
	 * This method returns the time taken by RoboRealm to process the image.
	 */
	public double getPROCESS_TIME() {
		return NetworkTable.getTable("VisionVars").getNumber("PROCESS_TIME",0);
	}

	public VisionValues() {
		//Empty Constructor
	}

}
