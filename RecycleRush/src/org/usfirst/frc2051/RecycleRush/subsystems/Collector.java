//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem
{
	Relay collectorRight = RobotMap.collectorCollectorRight;
	Relay collectorLeft = RobotMap.collectorCollectorLeft;
	DigitalInput collectorContactRight = RobotMap.collectorCollectorRightTripped;
	DigitalInput collectorContactLeft = RobotMap.collectorCollectorLeftTripped;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void stop()
	{
		RobotMap.collectorCollectorLeftMotor.set(0);
		RobotMap.collectorCollectorRightMotor.set(0);
	}

	public void left(double speed)
	{
		RobotMap.collectorCollectorLeftMotor.set(-speed);
		RobotMap.collectorCollectorRightMotor.set(-speed);
	}

	public void right(double speed)
	{
		RobotMap.collectorCollectorLeftMotor.set(speed);
		RobotMap.collectorCollectorRightMotor.set(speed);
	}
	
	public void in(double speed)
	{
		RobotMap.collectorCollectorLeftMotor.set(speed);
		RobotMap.collectorCollectorRightMotor.set(-speed);
	}
	
	public void out(double speed)
	{
		RobotMap.collectorCollectorLeftMotor.set(-speed);
		RobotMap.collectorCollectorRightMotor.set(speed);
	}
}