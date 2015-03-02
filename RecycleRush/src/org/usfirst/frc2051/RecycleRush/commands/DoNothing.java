package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is one of the options for autonomous. It's supposed to do
 * absolutely nothing, holding the robot in its place.
 */
public class DoNothing extends Command
{

	public DoNothing()
	{
		// Use requires() here to declare subsystem dependencies
		// requires(Robot.subsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		// do nothing
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
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
