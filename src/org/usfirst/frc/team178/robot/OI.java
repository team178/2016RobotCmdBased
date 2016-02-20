package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
 
public class OI {
	
	Joystick TriggerHappy = new Joystick(RobotMap.JoystickPort);
	Button button7 = new JoystickButton (TriggerHappy, 7);
	Button button8 = new JoystickButton (TriggerHappy, 8);
	Button button9 = new JoystickButton (TriggerHappy, 9);
	Button button10 = new JoystickButton(TriggerHappy, 10);
	Button button11 = new JoystickButton(TriggerHappy, 11);
	Button button12 = new JoystickButton(TriggerHappy, 12);
	Joystick TriggerSappy = new Joystick(RobotMap.JoystickPortXbox);
	Button buttonA = new JoystickButton(TriggerSappy, 1);
	Button buttonX = new JoystickButton(TriggerSappy, 3);
	Button buttonY = new JoystickButton(TriggerSappy, 4);
	Button lBumper = new JoystickButton(TriggerSappy, 5);
	Button rBumper = new JoystickButton(TriggerSappy, 6);

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
	
    public OI (){
        button7.whenPressed(new Kick());
        button9.whileHeld(new LiftIntake());
        button10.whileHeld(new DropIntake());
        button11.whileHeld(new SpinIntakeIn());
        button12.whileHeld(new SpinIntakeOut());
        buttonA.whenPressed(new Kick());
        buttonX.whenPressed(new DropIntake());
        buttonY.whenPressed(new LiftIntake());
        lBumper.whileHeld(new SpinIntakeOut());
        rBumper.whileHeld(new SpinIntakeIn());
    }
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    public double getX (){
    	return TriggerHappy.getX();
    }
    
    public double getY (){
    	return TriggerHappy.getY();
    }
    
    public double getTwist (){
    	return TriggerHappy.getTwist();
    }
    
    public boolean isPressed (int ButtonNumber){
    	return TriggerHappy.getRawButton(ButtonNumber);
    }

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

