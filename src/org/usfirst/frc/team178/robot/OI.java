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

	Button button1 = new JoystickButton (TriggerHappy, 1);
	Button button2 = new JoystickButton (TriggerHappy, 2);
	Button button3 = new JoystickButton (TriggerHappy, 3);
	Button button4 = new JoystickButton(TriggerHappy, 4);
	Button button5 = new JoystickButton(TriggerHappy, 5);
	Button button6 = new JoystickButton(TriggerHappy, 6);
	Button button7 = new JoystickButton(TriggerHappy,7);
	Button button8 = new JoystickButton(TriggerHappy, 8);
	Button button9 = new JoystickButton(TriggerHappy, 9);
	Button button10 = new JoystickButton(TriggerHappy, 10);

	Joystick TriggerSappy = new Joystick(RobotMap.JoystickPortXbox);
	Button buttonA = new JoystickButton(TriggerSappy, 1);
	Button buttonX = new JoystickButton(TriggerSappy, 3);
	Button buttonY = new JoystickButton(TriggerSappy, 4);
	Button lBumper = new JoystickButton(TriggerSappy, 6);
	Button rBumper = new JoystickButton(TriggerSappy, 5);
	Button buttonB = new JoystickButton(TriggerSappy, 2);
	Button backButton = new JoystickButton(TriggerSappy, 7);
	
	

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
	
    public OI (){

        /*button3.whenPressed(new ChangeLightColor("enforcers"));
        button4.whenPressed(new ChangeLightColor("off"));*/
        buttonA.whenPressed(new Kick());
        buttonB.whenPressed(new HoldBall());
        buttonY.whenPressed(new LiftIntake());
        buttonX.whenPressed(new DropIntake());
        lBumper.whileHeld(new SpinIntakeIn());
        rBumper.whileHeld(new SpinIntakeOut());
        button2.whileHeld(new AutoAim());
        backButton.whileHeld(new AdjustKick());
        button9.whileHeld(new AdjustWheelLeft());
        button10.whileHeld(new AdjustWheelRight());
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
    	return TriggerHappy.getTwist();//
    }
    
    public boolean isTSPressed (int ButtonNumber){
    	return TriggerSappy.getRawButton(ButtonNumber);    	
    }
    
    public boolean isTHButtonPressed(int ButtonNumber){
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

