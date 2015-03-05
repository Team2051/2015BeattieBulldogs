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
		RobotMap.collectorCollectorLeft.set(Relay.Value.kReverse);
		RobotMap.collectorCollectorRight.set(Relay.Value.kReverse);
	}

	public void right()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kForward);
		RobotMap.collectorCollectorRight.set(Relay.Value.kForward);
	}

	public void in()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kForward);
		RobotMap.collectorCollectorRight.set(Relay.Value.kReverse);
	}

	public void out()
	{
		RobotMap.collectorCollectorLeft.set(Relay.Value.kReverse);
		RobotMap.collectorCollectorRight.set(Relay.Value.kForward);
	}
}