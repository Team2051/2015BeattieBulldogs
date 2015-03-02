// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.Robot;

/**
 *
 */
public class DriveSidetoSide extends Command
{

	private double speed;
	private double distance;
	private int side;

	/**
	 * Drive the robot side to side
	 * 
	 * @param left
	 *            : 0 right: 1
	 * @param speed
	 *            from 0 to 1
	 * @param distance
	 *            in inches
	 */
	public DriveSidetoSide(double speed, double distance, int side)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveSystem);

		this.speed = speed;
		this.distance = distance;
		this.side = side;

	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveSystem.resetDist();// resets dist
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
