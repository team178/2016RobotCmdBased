package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team178.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
 
public class OI {
<<<<<<< HEAD
	
    
	
	Joystick TriggerHappy = new Joystick(RobotMap.JoystickPort);
=======
    Joystick mainJoy = new Joystick(0);
    Button button1 = new JoystickButton(mainJoy, 1);
        button2 = new JoystickButton(mainJoy, 2);
        button3 = new JoystickButton(mainJoy, 3);
        button4 = new JoystickButton(mainJoy, 4);
        button5 = new JoystickButton(mainJoy, 5);
        button6 = new JoystickButton(mainJoy, 6);
        Button7 = new JoystickButton(mainJoy, 7);
        Button8 = new JoystickButton(mainJoy, 8);
        Button9 = new JoystickButton(mainJoy, 9);
        Button10 = new JoystickButton(mainJoy, 10);
        Button11 = new JoystickButton(mainJoy, 11);
        Button12 = new JoystickButton(mainJoy, 12);
>>>>>>> 875da309eb4fd5004542029d2e812888df9f20c2
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    public OI (){
    	//new JoystickButton.whenPressed{};
    }
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    public double getx (){
    	return TriggerHappy.getX();
    }
    
    public double gety (){
    	return TriggerHappy.getY();
    }
    
    public double getz (){
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

