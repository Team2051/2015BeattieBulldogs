package org.usfirst.frc2051.RecycleRush.subsystems;

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
	SpeedController collectorAngle = RobotMap.collectorCollectorAngle;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void stop()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kOff);
		RobotMap.collectorCollectorRight.set(Relay.Value.kOff);
	}

	public void left()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kReverse); // inverted
		RobotMap.collectorCollectorRight.set(Relay.Value.kReverse);
	}

	public void right()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kForward); // inverted
		RobotMap.collectorCollectorRight.set(Relay.Value.kForward);
	}

	public void in()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kForward); // inverted
		RobotMap.collectorCollectorRight.set(Relay.Value.kReverse);
	}

	public void out()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kReverse); // inverted
		RobotMap.collectorCollectorRight.set(Relay.Value.kForward);
	}
	
	public void angleIn()
	{
		collectorAngle.set(-1);
	}
	
	public void angleOut()
	{
		collectorAngle.set(1);
	}
	
	public void angleStop()
	{
		collectorAngle.set(0);
	}
	
	public boolean atLimitOut()
	{
		return collectorContactRight.get() == false;
	}
	
	public boolean atLimitIn()
	{
		return collectorContactLeft.get() == false;
	}
}