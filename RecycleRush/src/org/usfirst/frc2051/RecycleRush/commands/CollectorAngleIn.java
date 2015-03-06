package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorAngleIn extends Command
{

	public CollectorAngleIn()
	{
		requires(Robot.collector);
	}

	protected void initialize()
	{
		
	}

	protected void execute()
	{
		Robot.collector.angleIn();
	}

	protected boolean isFinished()
	{

		return Robot.collector.atLimitIn();
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