package org.usfirst.frc2051.RecycleRush;

import org.usfirst.frc2051.RecycleRush.commands.*;
import org.usfirst.frc2051.RecycleRush.groups.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	public JoystickButton lifterContainerBtn;

	public OI()
	{
		driveStick = new Joystick(0);
		controlStick = new Joystick(1);

		// DisableGyro is run as a toggle, unlike most commands
		disableGyroBtn = new JoystickButton(driveStick, 11);
		disableGyroBtn.toggleWhenPressed(new DisableGyro());

		zeroGyroBtn = new JoystickButton(driveStick, 12);
		zeroGyroBtn.whenPressed(new ZeroGyro());
		
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

		lifterContainerBtn = new JoystickButton(controlStick, 11);
		lifterContainerBtn.whenPressed(new LifterContainer());
		
		//TODO Need to finalize the button layout (add collector commands, etc.)
		
		// SmartDashboard Buttons for testing individual commands
		// This should match the list of classes in the *.commands and *.groups packages
		SmartDashboard.putData("Collector Intake", new CollectorIntake());
		SmartDashboard.putData("Collector Pushout", new CollectorPushout());
		SmartDashboard.putData("Collector Spin Right", new CollectorSpinRight());
		SmartDashboard.putData("Collector Spin Left", new CollectorSpinLeft());
		SmartDashboard.putData("Disable Drive Gyro", new DisableGyro());
		SmartDashboard.putData("Do Nothing", new DoNothing());
		SmartDashboard.putData("Drive Backward", new DriveBackward(.3, 12));
		SmartDashboard.putData("Drive By Joystick", new DriveByJoystick());
		SmartDashboard.putData("Drive Forward", new DriveForward(.3, 12));
		SmartDashboard.putData("Drive Side to Side (left)", new DriveSidetoSide(.3, 12, 0));
		SmartDashboard.putData("Drive Side to Side (right)", new DriveSidetoSide(.3, 12, 1));
		SmartDashboard.putData("Dropoff Stack", new DropoffStack());
		SmartDashboard.putData("Lifter Cont", new LifterContainer());
		SmartDashboard.putData("Lifter Four", new LifterFour());
		SmartDashboard.putData("Lifter Manual Control", new LifterManual());
		SmartDashboard.putData("Lifter Three", new LifterThree());
		SmartDashboard.putData("Lifter Two", new LifterTwo());
		SmartDashboard.putData("Pickup Stack", new PickUpStack());
		SmartDashboard.putData("Zero Drive Gyro", new ZeroGyro());
		SmartDashboard.putData("Dance", new Dance());
	}

	public Joystick getDriveStick()
	{
		return driveStick;
	}

	public Joystick getControlStick()
	{
		return controlStick;
	}
}
