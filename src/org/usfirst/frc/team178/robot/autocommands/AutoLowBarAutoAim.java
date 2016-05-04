package org.usfirst.frc.team178.robot.autocommands;

import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.HoldBall;
import org.usfirst.frc.team178.robot.commands.Kick;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLowBarAutoAim extends CommandGroup {

	public AutoLowBarAutoAim() {
		// TODO Auto-generated constructor stub
		addSequential(new AutoDrive(.7),.7);
		addSequential(new AutoAim());
		addSequential(new HoldBall());
		addSequential(new Kick());
	}

}
