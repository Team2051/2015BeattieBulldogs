package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorAngleOut extends Command
{

	public CollectorAngleOut()
	{
		requires(Robot.collector);
	}

	protected void initialize()
	{
		
	}

	protected void execute()
	{
		if(!Robot.collector.atLimitOut())
		{
			Robot.collector.angleOut();
		}
	}

	protected boolean isFinished()
	{

		return Robot.collector.atLimitOut();
	}

	protected void end()
	{
		Robot.collector.angleStop();
	}

	protected void interrupted()
	{
		end();
	}

}