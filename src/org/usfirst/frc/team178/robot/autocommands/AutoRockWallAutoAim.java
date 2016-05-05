package org.usfirst.frc.team178.robot.autocommands;

import org.usfirst.frc.team178.robot.commands.AutoAim;
import org.usfirst.frc.team178.robot.commands.AutoDrive;
import org.usfirst.frc.team178.robot.commands.DropIntake;
import org.usfirst.frc.team178.robot.commands.HoldBall;
import org.usfirst.frc.team178.robot.commands.Kick;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRockWallAutoAim extends CommandGroup {
	public AutoRockWallAutoAim(){
		addSequential(new AutoDrive(1), 2.5);
    	addSequential(new AutoAim());
    	addSequential(new DropIntake());
    	addSequential(new HoldBall());
    	addSequential(new Kick());
	}
}
	// by pooja swami and anusha patel