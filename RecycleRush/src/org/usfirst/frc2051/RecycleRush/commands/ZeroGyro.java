package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.Robot;

/**
 * This command resets the gyro angle to zero and enables it for driving If
 * invoked, it "requires" the driveGyro subsystem so will kill off the
 * DisableGyro command
 */
public class ZeroGyro extends Command
{

	public ZeroGyro()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveGyro);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveGyro.gyroReset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
