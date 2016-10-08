package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.DropIntake;
import org.usfirst.frc.team178.robot.commands.HoldBall;
import org.usfirst.frc.team178.robot.commands.Kick;
import org.usfirst.frc.team178.robot.commands.LiftIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLowBarAutoAim extends CommandGroup {

	public AutoLowBarAutoAim() {
		// TODO Auto-generated constructor stub
		addSequential(new DropIntake());
		addSequential(new AutoDrive(-.5),1);
		addSequential(new AutoAim(),9);
		addSequential(new LiftIntake());
    	addSequential(new DropIntake());
    	addSequential(new LiftIntake());
    	addSequential(new DropIntake());
		addSequential(new HoldBall());
		addSequential(new Kick());
	}

}
