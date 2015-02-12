package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

public class LifterManual extends Command
{

	public LifterManual()
	{
		requires(Robot.lifterPIDRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		RobotMap.lifterPIDDARTMotorLeft.set(Robot.oi.controlStick.getY());
		RobotMap.lifterPIDDARTMotorRight.set(Robot.oi.controlStick.getY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		RobotMap.lifterPIDDARTMotorLeft.set(0);
		RobotMap.lifterPIDDARTMotorRight.set(0);
		Robot.lifterPIDLeft.enable();
		Robot.lifterPIDRight.enable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}