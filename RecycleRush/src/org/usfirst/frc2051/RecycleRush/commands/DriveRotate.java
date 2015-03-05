package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveRotate extends Command{

	public enum Direction
	{
		kLEFT, kRIGHT
	}
	
	private double speed;
	private double distance;
	private Direction side;
	
	/**
	 * 
	 * @param speed
	 * @param distance
	 * 			angle in degrees 0 - 360
	 * @param side
	 * 			Left or Right
	 */
	public DriveRotate(double speed, double distance, Direction side) 
	{
		requires(Robot.driveSystem);

		this.speed = speed;
		this.distance = distance;
		this.side = side;
	}

	protected void initialize() 
	{
		Robot.driveGyro.gyroReset();
	}

	protected void execute() 
	{
		if (side == Direction.kLEFT)
			Robot.driveSystem.moveItSpinLeft(speed);
		else
			Robot.driveSystem.moveItSpinRight(speed);
	}

	protected boolean isFinished() 
	{
		return (side == Direction.kLEFT ? Math.abs(Robot.driveGyro.getAngle()) : Math.abs(Robot.driveGyro.getAngle())) >= distance;
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
