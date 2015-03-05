package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.Robot;

/**
 * This command enables or disables the gyroscope It's intended to be on a
 * toggle button (in IO.java). The first press will run this command, putting the
 * gyro into disabled state. The second press will kill this command, re-enabling
 * the gyro. In between time, the command runs continuously but does nothing.
 */
public class DisableGyro extends Command
{

	public DisableGyro()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveGyro);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveGyro.gyroDisable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		// This command never finishes. The toggle button action will kill it
		// when needed.
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveGyro.gyroEnable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
