package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *!!!!!! ATTANTION !!!!!! The lift and reverse methods need to be fixed, probably removed. The commands that use them need to be fixed.
 */
public class Intake extends Subsystem {
	CANTalon inOut;//Turns pulleys on intake.
	CANTalon upDown;//Lifts intake up and down.
	
	public Intake(){
		inOut = new CANTalon(18);
		upDown = new CANTalon(19);
	}
	
	public void in()//Intakes ball.
	{
		inOut.set(-1);
	}
	
	public void out()//Outakes ball.
	{
		inOut.set(1);
	}
	
	public void inOutStop()//Stops pulleys/wheels.
	{
		inOut.set(0);
	}
	
	public void up()//Raises intake.
	{
		upDown.set(1);
	}
	
	public void down()//Lowers intake.
	{
		upDown.set(-1);
	}
	
	public void upDownStop()//Stops all up down.
	{
		upDown.set(0);
	}
    
	public void lift//This spins a ball out of the robot and at the same time raises the robot at .25 power.
	{
		inOut.set(1);
		upDown.set(0.25);
	}
	
	
	public void stop()//Stops all intake motors.
	{
		inOut.set(0);
		upDown.set(0);
	}
	
	public void reverse()//This spins a ball into the robot and leaves the intake where it is.
	{
		inOut.set(-1);
		upDown.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
