package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterThree extends Command
{

	public LifterThree()
	{
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
	}

	@Override
	protected void initialize()
	{
		Robot.lifterPIDLeft.setSetpoint(RobotMap.LIFTER_THREE);
		Robot.lifterPIDRight.setSetpoint(RobotMap.LIFTER_THREE);		
	}

	@Override
	protected void execute()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished()
	{
		return ((Math.abs(Robot.lifterPIDLeft.getSetpoint()-Robot.lifterPIDLeft.getPosition()) < 0.1) &&
				(Math.abs(Robot.lifterPIDRight.getSetpoint()-Robot.lifterPIDRight.getPosition()) < 0.1));
	}

	@Override
	protected void end()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted()
	{
		// TODO Auto-generated method stub
		
	}

}
