package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LifterPIDLeft extends PIDSubsystem {
	SpeedController dARTMotorLeft = RobotMap.lifterPIDDARTMotorLeft;
	AnalogPotentiometer dARTPositionLeft = RobotMap.lifterPIDDARTPositionLeft;
	DigitalInput lifterTopLeft = RobotMap.lifterPIDLifterTopLeft;
	DigitalInput lifterBottomLeft = RobotMap.lifterPIDLifterBottomLeft;

	// Initialize your subsystem here
	public LifterPIDLeft() {
		super("LifterPIDLeft", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		setInputRange(0.0 /* min */, 1.0 /* max */);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lifter PID Left", "PIDSubsystem Controller",
				getPIDController());
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		enable();
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new LifterEmergencyStop());
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

	// Stops actuators at current location
	public void stop() {
		Robot.lifterPIDLeft.setSetpoint(getPosition());
	}

	// Detects if this side is up higher than the other
	public boolean isGreater() {
		return Robot.lifterPIDLeft.getPosition() > (Robot.lifterPIDRight
				.getPosition() - .05);
	}
}
