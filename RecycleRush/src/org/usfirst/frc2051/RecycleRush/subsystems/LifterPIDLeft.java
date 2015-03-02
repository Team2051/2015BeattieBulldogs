package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * PID controller for the left DART actuator
 */
public class LifterPIDLeft extends PIDSubsystem {
	SpeedController dARTMotorLeft = RobotMap.lifterPIDDARTMotorLeft;
	AnalogPotentiometer dARTPositionLeft = RobotMap.lifterPIDDARTPositionLeft;
	DigitalInput lifterTopLeft = RobotMap.lifterPIDLifterTopLeft;
	DigitalInput lifterBottomLeft = RobotMap.lifterPIDLifterBottomLeft;

	// Initialize your subsystem here
	public LifterPIDLeft() {
		super("LifterPIDLeft", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.05);
		setInputRange(0.0 /* min */, 1.0 /* max */);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lifter PID Left", "PIDSubsystem Controller",
				getPIDController());
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new Commmand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return dARTPositionLeft.pidGet();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		dARTMotorLeft.pidWrite(output);
	}

	// Is the actuator at the very top or bottom of allowed travel?
	// Digital inputs return False when the limit switch is pressed
	public boolean atLimit() {
		return (lifterTopLeft.get() == false)
				|| (lifterBottomLeft.get() == false);
	}
}
