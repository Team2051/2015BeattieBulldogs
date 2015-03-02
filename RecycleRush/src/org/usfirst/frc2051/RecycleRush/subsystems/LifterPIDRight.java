package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LifterPIDRight extends PIDSubsystem {
	SpeedController dARTMotorRight = RobotMap.lifterPIDDARTMotorRight;
	AnalogPotentiometer dARTPositionRight = RobotMap.lifterPIDDARTPositionRight;
	DigitalInput lifterTopRight = RobotMap.lifterPIDLifterTopRight;
	DigitalInput lifterBottomRight = RobotMap.lifterPIDLifterBottomRight;

	// Initialize your subsystem here
	public LifterPIDRight() {
		super("LifterPIDRight", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		setInputRange(0.0 /* min */, 1.0 /* max */);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lifter PID Right", "PIDSubsystem Controller",
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
		return dARTPositionRight.pidGet();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		dARTMotorRight.pidWrite(output);
	}

	public void stop() {
		Robot.lifterPIDRight.setSetpoint(getPosition());
	}

	public boolean isGreater() {
		return Robot.lifterPIDRight.getPosition() > (Robot.lifterPIDLeft
				.getPosition() - .05);
	}
}
