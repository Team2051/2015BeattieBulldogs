package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterEmergencyStop extends Command
{

	public LifterEmergencyStop()
	{

	}

	@Override
	protected void initialize()
	{
		
	}

	@Override
	protected void execute()
	{
		
	}

	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return Robot.lifterPIDLeft.isGreater() || Robot.lifterPIDRight.isGreater();
	}

	@Override
	protected void end()
	{
		RobotMap.lifterPIDDARTMotorLeft.set(0);
		RobotMap.lifterPIDDARTMotorRight.set(0);
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
	}

	@Override
	protected void interrupted()
	{
		
	}

}
