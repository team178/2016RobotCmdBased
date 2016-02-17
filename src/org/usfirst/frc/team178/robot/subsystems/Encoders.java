package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
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
	
	public double getDistance(int encoderId){
		int value;
		
		double slope = 5.3;
		double yIntercept = 1234;
		
		switch(encoderId){
			case 1:
				value = leftMotors.getRaw();
				break;
			case 2:
				value = rightMotors.getRaw();
				break;
			case 3:
				value = kicker.getRaw();
				break;
			case 4:
				value = intake.getRaw();
				break;
			default:
				value = -99;
				break;
		}
		
		return slope*value + yIntercept;
			
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

