package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap.Direction;
import edu.wpi.first.wpilibj.command.Command;

public class AutonRotate extends Command {

	double speed;
	double angle = 70;
	private Direction side;
	

	public AutonRotate(double speed, Direction side) 
	{
		requires(Robot.driveSystem);
		this.speed =  speed;
		this.side = side;
	}

	protected void initialize() 
	{
		Robot.driveGyro.gyroReset();
		setTimeout(2.5);
	}

	protected void execute() 
	{
		if(side == Direction.kLEFT)
			Robot.driveSystem.moveItSpinLeft(speed);
		else
			Robot.driveSystem.moveItSpinRight(speed);
	}

	protected boolean isFinished() 
	{
		return isTimedOut() || Math.abs(Robot.driveGyro.getAngle()) >= angle;
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
