package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterLeftUp extends Command
{

	public LifterLeftUp()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterLeft);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
//		if(Robot.lifterPIDLeft.getPosition() < RobotMap.LIFTER_MAX)
			Robot.lifterLeft.up();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.lifterLeft.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}

}
