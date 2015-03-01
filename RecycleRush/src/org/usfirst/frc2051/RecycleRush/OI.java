// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2051.RecycleRush;

import org.usfirst.frc2051.RecycleRush.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick driveStick;
	public Joystick controlStick;

	public JoystickButton disableGyroBtn;
	public JoystickButton zeroGyroBtn;
	public JoystickButton dropoffBtn;
	public JoystickButton driveForwardBtn;
	public JoystickButton controlLifterBtn;
	public JoystickButton lifterTwoBtn;
	public JoystickButton lifterThreeBtn;
	public JoystickButton lifterFourBtn;
	public JoystickButton lifterContBtn;

	public OI()
	{
		driveStick = new Joystick(0);
		controlStick = new Joystick(1);

		disableGyroBtn = new JoystickButton(driveStick, 11);
		disableGyroBtn.toggleWhenPressed(new DisableGyro());

		zeroGyroBtn = new JoystickButton(driveStick, 12);
		zeroGyroBtn.toggleWhenPressed(new ZeroGyro());
		
		dropoffBtn = new JoystickButton(controlStick, 1);
		dropoffBtn.whenPressed(new PickUpStack());
		
		controlLifterBtn = new JoystickButton(controlStick, 2);
		controlLifterBtn.toggleWhenPressed(new LifterManual());
		
		lifterTwoBtn = new JoystickButton(controlStick, 6);
		lifterTwoBtn.whenPressed(new LifterTwo());
		
		lifterThreeBtn = new JoystickButton(controlStick, 7);
		lifterThreeBtn.whenPressed(new LifterThree());
		
		lifterFourBtn = new JoystickButton(controlStick, 10);
		lifterFourBtn.whenPressed(new LifterFour());

		lifterContBtn = new JoystickButton(controlStick, 11);
		lifterContBtn.whenPressed(new LifterCont());
		
		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		SmartDashboard.putData("Drive By Joystick", new DriveByJoystick());
		SmartDashboard.putData("Disable Drive Gyro", new DisableGyro());
		SmartDashboard.putData("Drive Forward", new DriveForward(.3, 12));
		SmartDashboard.putData("Dropoff Stack", new PickUpStack());
		SmartDashboard.putData("Collector Intake", new CollectorIntake());
		SmartDashboard.putData("Collector Pushout", new CollectorPushout());
		SmartDashboard.putData("Collector Spin Right", new CollectorSpinRight());
		SmartDashboard.putData("Collector Spin Left", new CollectorSpinLeft());
		SmartDashboard.putData("Drop Off Stack", new DropoffStack());
		SmartDashboard.putData("Lifter Manual Control", new LifterManual());
		SmartDashboard.putData("Pick Up Stack", new PickUpStack());
		SmartDashboard.putData("Zero Drive Gyro", new ZeroGyro());
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getDriveStick()
	{
		return driveStick;
	}

	public Joystick getControlStick()
	{
		return controlStick;
	}

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
