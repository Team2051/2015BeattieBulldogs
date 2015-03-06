package org.usfirst.frc2051.RecycleRush;

import org.usfirst.frc2051.RecycleRush.commands.*;
import org.usfirst.frc2051.RecycleRush.commands.DriveSidetoSide.Direction;
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
	public JoystickButton driveForwardBtn;
	public JoystickButton controlLifterBtn;
	public JoystickButton captureInBtn;
	public JoystickButton captureOutBtn;
	public JoystickButton captureLeftBtn;
	public JoystickButton captureRightBtn;	
	public JoystickButton lifterZeroBtn;
	public JoystickButton lifterOneBtn;
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

		//zeroGyroBtn = new JoystickButton(driveStick, 9);
		//zeroGyroBtn.whenPressed(new ZeroGyro());

		controlLifterBtn = new JoystickButton(controlStick, 1);
		controlLifterBtn.toggleWhenPressed(new LifterManual());
		
		captureInBtn = new JoystickButton(controlStick, 2);
		captureInBtn.whileHeld(new CollectorIntake());
		
		captureOutBtn = new JoystickButton(controlStick, 3);
		captureOutBtn.whileHeld(new CollectorPushout());
		
		captureLeftBtn = new JoystickButton(controlStick, 4);
		captureLeftBtn.whileHeld(new CollectorSpinLeft());

		captureRightBtn = new JoystickButton(controlStick, 5);
		captureRightBtn.whileHeld(new CollectorSpinRight());
		
		lifterOneBtn = new JoystickButton(controlStick, 6);
		lifterOneBtn.whenPressed(new LifterOne());

		lifterTwoBtn = new JoystickButton(controlStick, 7);
		lifterTwoBtn.whenPressed(new LifterTwo());
		
		
		lifterZeroBtn = new JoystickButton(controlStick, 8);
		lifterZeroBtn.whileHeld(new CollectorAngleIn());
//		lifterZeroBtn.whenPressed(new LifterZero());

		lifterContainerBtn = new JoystickButton(controlStick, 9);
		lifterContainerBtn.whileHeld(new CollectorAngleOut());
//		lifterContainerBtn.whenPressed(new LifterContainer());

		lifterThreeBtn = new JoystickButton(controlStick, 10);
		lifterThreeBtn.whenPressed(new LifterThree());

		lifterFourBtn = new JoystickButton(controlStick, 11);
		lifterFourBtn.whenPressed(new LifterFour());

		// SmartDashboard Buttons for testing individual commands
		// This should match the list of classes in the *.commands and *.groups
		// packages
		SmartDashboard.putData("Collector Intake", new CollectorIntake());
		SmartDashboard.putData("Collector Pushout", new CollectorPushout());
		SmartDashboard.putData("Collector Spin Right", new CollectorSpinRight());
		SmartDashboard.putData("Collector Spin Left", new CollectorSpinLeft());
		SmartDashboard.putData("Disable Drive Gyro", new DisableGyro());
		SmartDashboard.putData("Do Nothing", new DoNothing());
		SmartDashboard.putData("Drive Backward", new DriveBackward(.3, 12));
		SmartDashboard.putData("Drive By Joystick", new DriveByJoystick());
		SmartDashboard.putData("Drive Forward", new DriveForward(.8, 24, Robot.driveSystem.getDistFwdBack()));
		SmartDashboard.putData("Drive Side to Side (left)", new DriveSidetoSide(.3, 12, Direction.kLEFT));
		SmartDashboard.putData("Drive Side to Side (right)", new DriveSidetoSide(.3, 12, Direction.kRIGHT));
		SmartDashboard.putData("Lifter Cont", new LifterContainer());
		SmartDashboard.putData("Lifter Four", new LifterFour());
		SmartDashboard.putData("Lifter Manual Control", new LifterManual());
		SmartDashboard.putData("Lifter One", new LifterOne());
		SmartDashboard.putData("Lifter Three", new LifterThree());
		SmartDashboard.putData("Lifter Two", new LifterTwo());
		SmartDashboard.putData("Lifter Zero", new LifterZero());
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
	
	/**
	 * Joystick deadband function that behaves consistently with positive and
	 * negative inputs Uses the curve f(x) = x ^ (1/x) Type this into Google
	 * Search to graph it: graph x^(1/x) Returns zero for values less than about
	 * 0.25, then scales up to return 1 for an input of 1
	 */
	public static double deadBand(double x)
	{
		if (x > 0)
			return Math.pow(x, 1.0 / x);
		else if (x < 0)
			return -deadBand(-x);
		else
			return 0;
	}

	/**
	 * Joystick deadband function that behaves consistently with positive and
	 * negative inputs Uses the curve f(x) = x ^ (4/x) Type this into Google
	 * Search to graph it: graph x^(4/x) Returns zero for values less than about
	 * 0.5, then scales up to return 1 for an input of 1
	 */
	public static double twistDeadBand(double x)
	{
		if (x > 0)
			return Math.pow(x, 4.0 / x);
		else if (x < 0)
			return -twistDeadBand(-x);
		else
			return 0;
	}
	
	/** 
	 * Translate throttle value from joystick (range -1..+1) into motor speed (range 0..+1)
	 * The joystick value in the top position is -1, opposite of what might be expected,
	 * so multiply by negative one to invert the readings.
	 */
	public static double throttleSpeed(Joystick stick)
	{
		return (-stick.getThrottle() + 1) / 2;
	}
}
