package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class Kicker extends Subsystem {
	public static Victor motor1;
	public static Victor motor2;
	public static Encoder encoder;

	public Kicker() {
		motor1 = new Victor(0);
		motor2 = new Victor(3);
		encoder = new Encoder(RobotMap.kickerEncoderin,RobotMap.kickerEncoderout, false, Encoder.EncodingType.k2X);
		encoder.setDistancePerPulse(360/1024.0);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void kick(double num) {
    	motor1.set(num);
    	motor2.set(num);
    }
    
    public void testDistance() {
    	double value = encoder.getDistance();
    }
    
    public double getDistance() {
    	double distance;
    	distance = -encoder.getDistance();
    	return distance;
    }
    public void reset(){
		encoder.reset();
    }
}

