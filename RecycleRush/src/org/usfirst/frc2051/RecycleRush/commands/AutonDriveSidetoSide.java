package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap.Direction;

import edu.wpi.first.wpilibj.command.Command;

public class AutonDriveSidetoSide extends Command {

	double speed;
	private Direction side;
	

	public AutonDriveSidetoSide(double speed, Direction side) 
	{
		requires(Robot.driveSystem);
		this.speed =  speed;
		this.side = side;
	}

	protected void initialize() 
	{
		Robot.driveSystem.resetDist();
		setTimeout(2.1);
	}

	protected void execute() 
	{
		if(side == Direction.kLEFT)
			Robot.driveSystem.moveItSideLeft(speed);
		else
			Robot.driveSystem.moveItSideRight(speed);
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
