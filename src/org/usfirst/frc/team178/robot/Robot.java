
package org.usfirst.frc.team178.robot;

import java.io.*;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.CameraSwitch;
import org.usfirst.frc.team178.robot.subsystems.CameraRelay;
import org.usfirst.frc.team178.robot.subsystems.USBCam;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.*;
import org.usfirst.frc.team178.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static VisionValues vision;
	public static Kicker kicker;
	public static Encoders encoders;
	public static Intake intake;
	public static PhotoelectricSensor sensor;
	public static RelaybecauseAndrew relay;
	public static Scalar scalar;
	public static LightController lights;
    Command autonomousCommand;
    AutoAim autoAim;
    SendableChooser chooser;
    CameraRelay cameraRelay;
    public static USBCam usbCamera = new USBCam();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		vision = new VisionValues();
		autoAim = new AutoAim();
		cameraRelay = new CameraRelay();
		cameraServer = CameraServer.getInstance();
		cameraServer.setSize(0);
		cameraServer.setQuality(50);
		cameraServer.startAutomaticCapture(usbCamera.getCamera());
		SmartDashboard.putData("SwitchCams", new CameraSwitch());

    	drivetrain  = new DriveTrain();
    	kicker = new Kicker();
    	encoders = new Encoders();
    	intake = new Intake();
    	sensor = new PhotoelectricSensor();
    	relay = new RelaybecauseAndrew();
    	lights = new LightController();
		oi = new OI();
		vision = new VisionValues();
		//scalar = new Scalar();
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

    	chooser.addObject("Rough Terrain", new RoughTerrain());
        chooser.addObject("Do Nothing", null);
        chooser.addObject("Ramparts", new Ramparts());
        chooser.addObject("Moat", new Moat());
        chooser.addObject("Rock Wall", new RockWall());
        chooser.addObject("Cheval de Frise", new ChevalDeFrise());
    	autonomousCommand = (Command) chooser.getSelected();

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
        //if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
<<<<<<< HEAD
        Scheduler.getInstance().run();
=======
    	//System.out.println(oi.getY()+" "+oi.getX()+" "+oi.getTwist());
        Scheduler.getInstance().run();
        System.out.println("Top: " + intake.isTopLimitSwitchTripped());
        System.out.println("Bottom: " + intake.isBottomLimitSwitchTripped());
    }
    
    @Override
    public void testInit(){
    	relay.setvalue(true);
    	
>>>>>>> master
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        autoAim.start();
        cameraRelay.turnOnRelay();
        Scheduler.getInstance().run();
    }
}
