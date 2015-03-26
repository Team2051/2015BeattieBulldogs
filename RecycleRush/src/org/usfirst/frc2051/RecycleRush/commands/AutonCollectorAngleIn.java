package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonCollectorAngleIn extends Command {

	public AutonCollectorAngleIn() 
	{
		requires(Robot.collector);
	}

	protected void initialize() 
	{
		setTimeout(1);
	}

	protected void execute() 
	{
		Robot.collector.angleIn();
	}

	protected boolean isFinished() 
	{
		return isTimedOut();
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
