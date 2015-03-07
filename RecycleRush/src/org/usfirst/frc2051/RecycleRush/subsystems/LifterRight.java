package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterRight extends Subsystem
{
	SpeedController dARTMotorRight = RobotMap.lifterPIDDARTMotorRight;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void stop()
	{
		dARTMotorRight.set(0);
	}

	public void up()
	{
		dARTMotorRight.set(.4);
	}

	public void down()
	{
		dARTMotorRight.set(-.4);
	}
}