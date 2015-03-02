package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * PID controller for the right DART actuator
 */
public class LifterPIDRight extends PIDSubsystem
{
	SpeedController dARTMotorRight = RobotMap.lifterPIDDARTMotorRight;
	AnalogPotentiometer dARTPositionRight = RobotMap.lifterPIDDARTPositionRight;
	DigitalInput lifterTopRight = RobotMap.lifterPIDLifterTopRight;
	DigitalInput lifterBottomRight = RobotMap.lifterPIDLifterBottomRight;

	// Initialize your subsystem here
	public LifterPIDRight()
	{
		super("LifterPIDRight", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.05);
		setInputRange(0.0 /* min */, 1.0 /* max */);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lifter PID Right", "PIDSubsystem Controller", getPIDController());
	}

	public void initDefaultCommand()
	{
		// setDefaultCommand(new Command());
	}

	protected double returnPIDInput()
	{
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return dARTPositionRight.pidGet();
	}

	protected void usePIDOutput(double output)
	{
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		dARTMotorRight.pidWrite(output);
	}

	// Is the actuator at the very top or bottom of allowed travel?
	// Digital inputs return False when the limit switch is pressed
	public boolean atLimit()
	{
		return (lifterTopRight.get() == false) || (lifterBottomRight.get() == false);
	}
}
