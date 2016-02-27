package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * You ladies need to read this: #TRIGGERED#
 * https://wpilib.screenstepslive.com/s/4485/m/13810/l/241875-encoders-measuring-rotation-of-a-wheel-or-other-shaft
 * It will clear a lot of stuff up! If it is too much text, just look at the example code and what it means.
 * Good Luck!
 */
public class Encoders extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static Encoder leftMotors;
	public static Encoder rightMotors;
	public static Encoder kicker;
	public static Encoder intake;
	public static final double circumference=2*Math.PI*73;
	
	public Encoders(){
		leftMotors = new Encoder(RobotMap.leftmotorEncoderin,RobotMap.leftmotorEncoderout, true, Encoder.EncodingType.k4X);
		rightMotors = new Encoder(RobotMap.rightmotorEncoderin,RobotMap.rightmotorEncoderout, false, Encoder.EncodingType.k4X);
		kicker = new Encoder(RobotMap.kickerEncoderin,RobotMap.kickerEncoderout, false, Encoder.EncodingType.k2X);
		intake = new Encoder(RobotMap.intakeEncoderin,RobotMap.intakeEncoderout, false, Encoder.EncodingType.k4X);
		leftMotors.setDistancePerPulse(1/1440.0*circumference);
		rightMotors.setDistancePerPulse(1/1440.0*circumference);
		kicker.setDistancePerPulse(360/1440.0);
		intake.setDistancePerPulse(1/1440.0);
	}

	public void testDistance (){
		
			double value0 = leftMotors.getDistance();
			
			double value1 = rightMotors.getDistance();
			
			double value2 = kicker.getDistance();
			
			double value3 = intake.getDistance();
			
		SmartDashboard.putNumber("distance Left", value0);
		SmartDashboard.putNumber("distance Right", value1);
		SmartDashboard.putNumber("distance Kicker", value2);
		SmartDashboard.putNumber("distance Intake", value3);
	}
	public double getDistance(int encoderId){
		double distance;
		
		switch(encoderId){
			case 1:
				distance = leftMotors.getDistance();
				break;
			case 2:
				distance = rightMotors.getDistance();
				break;
			case 3:
				distance = -kicker.getDistance();
				break;
			case 4:
				distance = intake.getDistance();
				break;
			default:
				distance = -99;
				break;
		}
		
		return distance;
			
	}
	
	public void reset(int encoderId){
		kicker.reset();
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

