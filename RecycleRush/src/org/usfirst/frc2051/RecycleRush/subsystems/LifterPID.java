// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;
import org.usfirst.frc2051.RecycleRush.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LifterPID extends PIDSubsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	SpeedController dARTMotors = RobotMap.lifterPIDDARTMotors;
	AnalogPotentiometer dARTPosition = RobotMap.lifterPIDDARTPosition;
	DigitalInput lifterLoaded = RobotMap.lifterPIDLifterLoaded;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Initialize your subsystem here
	public LifterPID()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
		super("LifterPID", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lifter PID", "PIDSubsystem Controller",
				getPIDController());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
	}

	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput()
	{
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
		return dARTPosition.get();
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	protected void usePIDOutput(double output)
	{
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
		dARTMotors.pidWrite(output);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}
}
