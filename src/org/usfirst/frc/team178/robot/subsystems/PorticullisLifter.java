package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PorticullisLifter extends Subsystem {
	public static DoubleSolenoid sol1;
	
	public PorticullisLifter()//Creates DoubleSolenoid for the Pneumatic Piston
	{
		sol1 = new DoubleSolenoid(1,2);
	}
	
	@Override
	protected void initDefaultCommand() {
		//This is not the method your looking for, move along.
	}
	
	public void off()//Sets the DoubleSolenoid to off
	{
		sol1.set(DoubleSolenoid.Value.kOff);
	}
	
	public void lift()//Sets the DoubleSolenoid to forward
	{
		sol1.set(DoubleSolenoid.Value.kForward);
	}

	public void drop()//Sets the DoubleSolenoid to reverse
	{
		sol1.set(DoubleSolenoid.Value.kReverse);
	}
}
