package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.Robot;

/**
 *
 */
public class DriveForward extends Command
{

	private double maxSpeed;
	private double finalDist;
	private double currentDist;
	

	/**
	 * Drive the robot forward
	 * 
	 * @param maxSpeed
	 *            from 0 to 1
	 * @param finalDist
	 *            in inches
	 * @param currentDist
	 * 			  Robot.driveSystem.getDistFwdBack()
	 */
	public DriveForward(double maxSpeed, double finalDist, double currentDist)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveSystem);

		this.maxSpeed = maxSpeed;
		this.finalDist = finalDist;
		this.currentDist = currentDist;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveSystem.resetDist();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.driveSystem.moveIt(Robot.driveSystem.autonSpeed(maxSpeed, finalDist, currentDist));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		// -Units: Inches
		// -Numbers: final unit conversion = Inches
		return Robot.driveSystem.getDistFwdBack() >= finalDist;
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
