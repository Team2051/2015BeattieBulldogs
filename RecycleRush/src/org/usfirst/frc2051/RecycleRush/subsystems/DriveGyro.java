package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the drive system gyroscope sensor If enabled, provides
 * field-relative driving
 */
public class DriveGyro extends Subsystem
{
	// Used in the DriveSubsystem to decide if the gyro will
	// be factored into the tele-op driving mode.
	// Initialize as "true" so the gyro will be enabled at startup
	private boolean gyroEnabled = true;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new YourCommand());
		// No default command for this subsystem!
	}

	public void gyroEnable()
	{
		gyroEnabled = true;
	}

	public void gyroDisable()
	{
		gyroEnabled = false;
	}

	public boolean isGyroEnabled()
	{
		return gyroEnabled;
	}

	public void gyroReset()
	{
		RobotMap.driveSystemGyro.reset();
	}

	public double getAngle()
	{
		return RobotMap.driveSystemGyro.getAngle();
	}
}