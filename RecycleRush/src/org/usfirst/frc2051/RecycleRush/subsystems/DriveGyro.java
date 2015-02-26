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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the drive system gyroscope sensor
 * If enabled, provides field-relative driving
 */
public class DriveGyro extends Subsystem
{
	Gyro gyro = RobotMap.driveSystemGyro;

	private boolean gyroEnabled = false;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		//setDefaultCommand(new YourCommand());
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
		gyro.reset();
	}
	
	public double getAngle()
	{
		return gyro.getAngle();
	}
}