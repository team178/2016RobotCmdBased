
package org.usfirst.frc.team178.robot;
import java.io.*;

import edu.wpi.first.wpilibj.AnalogInput;
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

import org.usfirst.frc.team178.robot.commands.Autonomous;
import org.usfirst.frc.team178.robot.commands.TeleOp;
import org.usfirst.frc.team178.robot.commands.TestAutonomous2;
import org.usfirst.frc.team178.robot.commands.TurnOnRelay;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Encoders encoders;
	public static Intake intake;
	public static PhotoelectricSensor sensor;
	public static RelaybecauseAndrew relay;
	public static VisionValues vision;
	

	BufferedReader br; 
	BufferedWriter bw; 
	
    Command autonomousCommand;
    Command Teleop;
    SendableChooser chooser;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetrain  = new DriveTrain();
    	kicker = new Kicker();
    	encoders = new Encoders();
    	intake = new Intake();
    	sensor = new PhotoelectricSensor();
    	relay = new RelaybecauseAndrew();
		oi = new OI();
		vision = new VisionValues();
        chooser = new SendableChooser();
        chooser.addObject("Rough Terrain", new RoughTerrain());
        chooser.addObject("Do Nothing", null);
        chooser.addObject("Ramparts", new Ramparts());
        chooser.addObject("Moat", new Moat());
        chooser.addObject("Rock Wall", new RockWall());
        chooser.addObject("Cheval de Frise", new ChevalDeFrise());
        
        SmartDashboard.putData("Auto mode", chooser);
		

        NetworkTable.getTable("VisionVars");

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
        autonomousCommand = (Command) chooser.getSelected();
        
		/*String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Rough Terrain":
			autonomousCommand = new Autonomous();
			break;
		case "Default Auto":
		default:
			autonomousCommand = null;
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Teleop = new TeleOp();
        Teleop.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//System.out.println(oi.getY()+" "+oi.getX()+" "+oi.getTwist());
        Scheduler.getInstance().run();      
    }
    
    @Override
    public void testInit(){
    	relay.setvalue(true);
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
    	  System.out.println("PHOTOELECTRIC IS :" + sensor.getstuff());        // PhotoElectric Sensor
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
    //    System.out.println((new DigitalInput(14)).get());
    }
}
