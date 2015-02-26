package org.usfirst.frc2051.RecycleRush.groups;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Dance extends Command
{
	public Dance()
	{
		
	}

	@Override
	protected void initialize() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() 
	{
		// TODO Auto-generated method stub
		Robot.driveSystem.stop();
	}

	@Override
	protected void interrupted() 
	{
		// TODO Auto-generated method stub
		end();
	}
}
