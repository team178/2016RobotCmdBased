package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.commands.*;
import org.usfirst.frc.team178.robot.*;

public class ChevalDeFrise extends Command {
    
    Intake intake;
    DriveTrain drivetrain;
    Timer timer;
    
    public ChevalDeFrise() {
        requires(Robot.intake);
        requires(Robot.drivetrain);
        intake = Robot.intake;
        drivetrain = Robot.drivetrain;
        timer = new Timer();
        timer.stop();
        timer.reset();
    }
    
    protected void initialize() {
        
    }
    
    protected void execute() {
        timer.start();
        while(timer.get() <= 1.5)
        {
            drivetrain.drive(0.8, -0.8);
        }
        intake.dropIntake();
        while(timer.get() <= 5)//I think 3.5 seconds is too long to go at 100% power... timer should be reduced by about a 1.5, maybe even 2.
        {
            drivetrain.drive(1, -1);
        }
    }

    protected boolean isFinished() {//W leave our selves with at least 10 seconds, we can stick in some auto aim code here to try to shoot.
        return (timer.get() > 5);        
    }

    protected void end() {
        drivetrain.drive(0,0);
        timer.stop();
        timer.reset();
    }
    
    protected void interrupted() {
        drivetrain.drive(0,0);
        timer.stop();
    }

}

