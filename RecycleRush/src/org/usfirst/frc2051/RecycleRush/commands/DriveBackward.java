package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.Robot;

/**
 *
 */
public class DriveBackward extends Command
{

	private double speed;
	private double distance;

	/**
	 * Drive the robot backward
	 * 
	 * @param speed
	 *            from 0 to 1
	 * @param distance
	 *            in inches
	 */
	public DriveBackward(double speed, double distance)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveSystem);

		this.speed = -speed;
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveSystem.resetDist();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.driveSystem.moveIt(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		// -Units: Inches
		// -Numbers: final unit conversion = Inches
		return Robot.driveSystem.getDistFwdBack() > distance;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveSystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
