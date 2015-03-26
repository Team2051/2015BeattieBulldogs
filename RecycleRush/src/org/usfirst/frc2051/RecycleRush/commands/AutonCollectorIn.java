package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonCollectorIn extends Command {

	public AutonCollectorIn() 
	{
		requires(Robot.collector);
	}

	protected void initialize() 
	{
		setTimeout(1);
	}

	protected void execute() 
	{
		Robot.collector.in();
	}

	protected boolean isFinished() 
	{
		return isTimedOut() || Robot.collector.atLimitIn();
	}

	protected void end() 
	{
		Robot.collector.stop();
	}

	protected void interrupted() 
	{
		end();
	}

}
