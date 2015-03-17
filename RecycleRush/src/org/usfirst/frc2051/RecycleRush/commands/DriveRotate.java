//package org.usfirst.frc2051.RecycleRush.commands;
//
//import org.usfirst.frc2051.RecycleRush.Robot;
//import org.usfirst.frc2051.RecycleRush.RobotMap.Direction;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class DriveRotate extends Command{
//
//	private double speed;
//	private int angle;
//	private Direction side;
//	
//	/**
//	 * 
//	 * @param speed
//	 * @param angle
//	 * 			0 - 360
//	 * @param side
//	 * 			Left or Right
//	 */
//	public DriveRotate(double speed, int angle, Direction side) 
//	{
//		requires(Robot.driveSystem);
//
//		this.speed = speed;
//		this.angle = angle;
//		this.side = side;
//	}
//
//	protected void initialize() 
//	{
//		Robot.driveGyro.gyroReset();
//	}
//
//	protected void execute() 
//	{
//		if (side == Direction.kLEFT)
//			Robot.driveSystem.moveItSpinLeft(speed);
//		else
//			Robot.driveSystem.moveItSpinRight(speed);
//	}
//
//	protected boolean isFinished() 
//	{
//		return (side == Direction.kLEFT ? Math.abs(Robot.driveGyro.getAngle()) : Math.abs(Robot.driveGyro.getAngle())) >= angle;
//	}
//
//	protected void end() 
//	{
//		Robot.driveSystem.stop();
//		
//	}
//
//	protected void interrupted()
//	{
//		end();
//	}
//
//}
