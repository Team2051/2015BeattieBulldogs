package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

/**
 *
 */
public class LifterZero extends Command
{

	public LifterZero()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.lifterPIDLeft.enable();
		Robot.lifterPIDRight.enable();
		Robot.lifterPIDLeft.setSetpoint(RobotMap.LIFTER_ZERO);
		Robot.lifterPIDRight.setSetpoint(RobotMap.LIFTER_ZERO);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return (Robot.lifterPIDLeft.onTarget() && Robot.lifterPIDRight.onTarget());
		// || Robot.lifterPIDLeft.atLimit() || Robot.lifterPIDRight.atLimit();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
