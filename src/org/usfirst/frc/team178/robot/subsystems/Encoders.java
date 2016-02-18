package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * You ladies need to read this:
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
	
	public Encoders(){
		leftMotors = new Encoder(RobotMap.leftmotorEncoderin,RobotMap.leftmotorEncoderout);
		rightMotors = new Encoder(RobotMap.rightmotorEncoderin,RobotMap.rightmotorEncoderout);
		kicker = new Encoder(RobotMap.kickerEncoderin,RobotMap.kickerEncoderout);
		intake = new Encoder(RobotMap.intakeEncoderin,RobotMap.intakeEncoderout);
	}
	
	public void testDistance (){
		
			int value0 = leftMotors.getRaw();
			
			int value1 = rightMotors.getRaw();
			
			int value2 = kicker.getRaw();
			
		
			int value3 = intake.getRaw();
			
		SmartDashboard.putNumber("distance Left", value0);
		SmartDashboard.putNumber("distance Right", value1);
		//SmartDashboard.putNumber("distance Kicker", value2);
		//SmartDashboard.putNumber("distance Intake", value3);
	}
	public int getDistance(int encoderId){
		int pulses;	
		int ppr = 1440;
		int distance;
		
		switch(encoderId){
			case 1:
				pulses = leftMotors.getRaw();
				break;
			case 2:
				pulses = rightMotors.getRaw();
				break;
			case 3:
				pulses = kicker.getRaw();
				break;
			case 4:
				pulses = intake.getRaw();
				break;
			default:
				pulses = -99;
				break;
		}
		
		distance = pulses;
		
		return distance;
			
		
	}	
	public int getRevolutions(int encoderId){
		int pulses;	
		int ppr = 1440;
		int revolutions;
		
		switch(encoderId){
			case 1:
				pulses = leftMotors.getRaw();
				break;
			case 2:
				pulses = rightMotors.getRaw();
				break;
			case 3:
				pulses = kicker.getRaw();
				break;
			case 4:
				pulses = intake.getRaw();
				break;
			default:
				pulses = -99;
				break;
		}
		
		revolutions = pulses/ppr;
		System.out.println("Revolutions: " + revolutions);
		System.out.println("Pulses:" + pulses);
		return revolutions;
			
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

