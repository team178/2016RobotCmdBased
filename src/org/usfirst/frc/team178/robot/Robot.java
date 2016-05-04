
package org.usfirst.frc.team178.robot;
import java.io.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.usfirst.frc.team178.robot.autocommands.AutoDeathSpin;
import org.usfirst.frc.team178.robot.autocommands.AutoDriveGroup;
import org.usfirst.frc.team178.robot.autocommands.AutoLowBarAutoAim;
import org.usfirst.frc.team178.robot.autocommands.ChevalDeFrise;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.CANTalon;


import org.usfirst.frc.team178.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain;
	public static OI oi;
	public static Kicker kicker;
	public static Intake intake;
	public static PhotoelectricSensor sensor;
	public static RelaybecauseAndrew relay;
	public static VisionValues vision;
	
	//public static LightController lights;

	BufferedReader br; 
	BufferedWriter bw; 
	
    Command autonomousCommand;
    SendableChooser chooser;
    //public static USBCam usbcamera;
	//public static CameraServer cameraServer;
	//public static Ultrasonic uSonic = new Ultrasonic();
	
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

    public void robotInit() {
    	drivetrain  = new DriveTrain();
    	kicker = new Kicker();
    	intake = new Intake();
    	sensor = new PhotoelectricSensor();
    	relay = new RelaybecauseAndrew();
    	//lights = new LightController();
		oi = new OI();
		vision = new VisionValues();
		//usbcamera = new USBCam();
		//cameraServer = CameraServer.getInstance();
		//cameraServer.startAutomaticCapture(usbcamera.getCamera());
        
		chooser = new SendableChooser();
		chooser.addDefault("Do Nothing", new AutoDoNothing());
        chooser.addObject("Drive Forward", new AutoDriveGroup());
        chooser.addObject("Cheval de Frise", new ChevalDeFrise());
        chooser.addObject("LowBar Auto Aim", new AutoLowBarAutoAim());
        chooser.addDefault("Auto Death Spin", new AutoDeathSpin());
        
        
        
        SmartDashboard.putData("Auto mode", chooser);
        
		
		//SmartDashboard.putData("Photoelectric Sensor", new PhotoelectricSensor());
	/*	
        usbcamera = new USBCam();
        cameraServer = CameraServer.getInstance();
        cameraServer.setSize(0);
        cameraServer.setQuality(50);
        cameraServer.startAutomaticCapture(usbcamera.getCamera());
*/
        NetworkTable.getTable("VisionVars");
        relay.setvalue(true);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        
		/*String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Rough Terrain":
			autonomousCommand = new AutoDrive();
			break;
		case "Do Nothing":
		default:
			autonomousCommand = new AutoDoNothing();
			break;
		case "Ramparts":
			autonomousCommand = new AutoDrive();
			break;
		case "Moat":
			autonomousCommand = new AutoDrive();
			break;
		case "Rock Wall":
			autonomousCommand = new AutoDrive();
			break;
		case "Cheval de Frise":
			autonomousCommand = new ChevalDeFrise();
			break;
		}*/
		autonomousCommand = ((Command) chooser.getSelected());
    	if(autonomousCommand!=null){
    		autonomousCommand.start();
    	}
    }
    
    public void autonomousPeriodic(){
    	Scheduler.getInstance().run();
    }
	@Override
	public void teleopInit() {
		// TODO Auto-generated method stuff
		if(autonomousCommand!=null){
    		autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		Scheduler.getInstance().run();
		super.teleopPeriodic();
		//SmartDashboard.putNumber("UltrasonicData", (uSonic.getDistance()));
	}

	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("UltrasonicData", (uSonic.getVoltage()));
	}


    
    public void testInit(){
    	
    }
    
    @Override
    public void testPeriodic() {
    	  //System.out.println("PHOTOELECTRIC IS :" + sensor.isActivated());        // PhotoElectric Sensor
    	//  System.out.println("VOLTAGE IS:" + (new AnalogInput(0)).getVoltage());  // Encoders
    	
    	//System.out.println("Top: " + intake.isTopLimitSwitchTripped());
    	//System.out.println("Bottom: " + intake.isBottomLimitSwitchTripped());

    	//try{
    		//bw.write("X: " + oi.getX() + " Twist: " + oi.getTwist() );
    		//bw.newLine();
    	//}catch(Exception e){
    		
    	//}
    	
        LiveWindow.run();
        relay.setvalue(true);
        //System.out.println(NetworkTable.getTable("VisionVars").getNumber("COG_X", 240));
        //System.out.println((new DigitalInput(14)).get());
    }
}
