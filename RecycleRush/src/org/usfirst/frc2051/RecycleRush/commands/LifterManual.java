package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

public class LifterManual extends Command
{

	DigitalInput lifterTopRight = RobotMap.lifterPIDLifterTopRight;
	DigitalInput lifterBottomRight = RobotMap.lifterPIDLifterBottomRight;
	DigitalInput lifterTopLeft = RobotMap.lifterPIDLifterTopLeft;
	DigitalInput lifterBottomLeft = RobotMap.lifterPIDLifterBottomLeft;

	public LifterManual()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		/*
		 * Motor values for both lifter actuators need to be inverted
		 */				
		if ((lifterBottomRight.get() == true || lifterBottomLeft.get() == true)) // if
																					// bottom
																					// is
																					// hit
		{
			if (Robot.oi.controlStick.getY() < 0) // and moving down
			{
				RobotMap.lifterPIDDARTMotorLeft.set(0); // stop
				RobotMap.lifterPIDDARTMotorRight.set(0);
			} // if bottom is hit
			else
			// but not moving down
			{
				RobotMap.lifterPIDDARTMotorLeft.set(-Robot.oi.controlStick.getY()); // move
																					// up
				RobotMap.lifterPIDDARTMotorRight.set(-Robot.oi.controlStick.getY());
			}
		} else // if bottom is not hit
		if ((lifterTopRight.get() == true || lifterTopLeft.get() == true)) // but
																			// top
																			// is
																			// hit
																			// (inverted
																			// switches)
		{
			if (Robot.oi.controlStick.getY() > 0) // and moving up
			{
				RobotMap.lifterPIDDARTMotorLeft.set(0); // stop
				RobotMap.lifterPIDDARTMotorRight.set(0);
			} // if bottom is not hit
			else
			// but top is hit
			{ // and moving down
				RobotMap.lifterPIDDARTMotorLeft.set(-Robot.oi.controlStick.getY()); // move
																					// down
				RobotMap.lifterPIDDARTMotorRight.set(-Robot.oi.controlStick.getY());
			}
		} // if bottom is not hit
		else
		// if top is not hit
		{
			RobotMap.lifterPIDDARTMotorLeft.set(-Robot.oi.controlStick.getY()); // move
																				// freely
			RobotMap.lifterPIDDARTMotorRight.set(-Robot.oi.controlStick.getY());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	// This command never finishes. The toggle button action will kill it when
	// needed.
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		RobotMap.lifterPIDDARTMotorLeft.set(0);
		RobotMap.lifterPIDDARTMotorRight.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}