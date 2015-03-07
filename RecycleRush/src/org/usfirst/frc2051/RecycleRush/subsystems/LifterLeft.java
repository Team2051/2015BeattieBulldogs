package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterLeft extends Subsystem
{
	SpeedController dARTMotorLeft = RobotMap.lifterPIDDARTMotorLeft;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void stop()
	{
		dARTMotorLeft.set(0);
	}

	public void up()
	{
		dARTMotorLeft.set(.7);
	}

	public void down()
	{
		dARTMotorLeft.set(-.7);
	}
}