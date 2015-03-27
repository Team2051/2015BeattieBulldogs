package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonDriveForward extends Command {

	double speed;
	public AutonDriveForward(double speed) 
	{
		requires(Robot.driveSystem);
		this.speed =  speed;
	}

	protected void initialize() 
	{
		Robot.driveSystem.resetDist();
		setTimeout(2.4);
	}

	protected void execute() 
	{
		Robot.driveSystem.moveIt(speed);
	}

	protected boolean isFinished() 
	{
		return isTimedOut();
	}

	protected void end() 
	{
		Robot.driveSystem.stop();
	}

	protected void interrupted() 
	{
		end();
	}

}
