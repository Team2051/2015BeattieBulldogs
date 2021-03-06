package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class LifterRightDown extends Command
{

	public LifterRightDown()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{		
		if(Robot.lifterPIDRight.getPosition() > RobotMap.LIFTER_MIN)
			Robot.lifterRight.down();
		else
			Robot.lifterRight.stop();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.lifterRight.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}

}
