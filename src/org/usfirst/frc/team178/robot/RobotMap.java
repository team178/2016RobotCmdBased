package org.usfirst.frc.team178.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int JoystickPort = 0;
	
	public static int SwitchPort1 = 1;
	public static int SwitchPort2 = 2;
	public static int SwitchPort3 = 3;
	public static int SwitchPort4 = 4;
	
	
    public static int PhotoelectricSensor = 0;
    public static int kickerEncoderin = 1;
	public static int kickerEncoderout = 2;
	public static int intakeEncoderin = 3;
	public static int intakeEncoderout = 4;
	public static int leftmotorEncoderin = 5;
	public static int leftmotorEncoderout = 6;
	public static int rightmotorEncoderin = 7;
	public static int rightmotorEncoderout = 8;
	

    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
