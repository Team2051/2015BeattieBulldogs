package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonLifterOne extends Command {

	public AutonLifterOne() 
	{
		requires(Robot.lifterLeft);
		requires(Robot.lifterRight);
	}

	protected void initialize() 
	{
		setTimeout(.25);
	}

	protected void execute() 
	{
		if(Robot.lifterPIDLeft.getPosition() < RobotMap.LIFTER_MAX || Robot.lifterPIDRight.getPosition() < RobotMap.LIFTER_MAX)
		{
			Robot.lifterLeft.up();
			Robot.lifterRight.up();
		}
		else
		{
			Robot.lifterLeft.stop();
			Robot.lifterRight.stop();
		}
	}

	protected boolean isFinished() 
	{
		return isTimedOut();
	}

	protected void end() 
	{
		Robot.lifterLeft.stop();
		Robot.lifterRight.stop();
	}

	protected void interrupted() 
	{
		end();
	}

}
