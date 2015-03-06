package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

	double seconds;
	public Delay(double seconds) 
	{
		requires(Robot.driveSystem);
		requires(Robot.collector);
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
		
		this.seconds = seconds;
	}

	protected void initialize() 
	{
		setTimeout(seconds);
	}

	protected void execute() 
	{
		;
	}

	protected boolean isFinished() 
	{
		return isTimedOut();
	}

	protected void end() 
	{
		;
	}

	protected void interrupted() 
	{
		end();
	}

}
