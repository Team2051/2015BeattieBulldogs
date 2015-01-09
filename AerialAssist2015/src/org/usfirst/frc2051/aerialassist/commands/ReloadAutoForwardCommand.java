// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2051.aerialassist.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.aerialassist.Robot;

/**
 *
 */
public class ReloadAutoForwardCommand extends Command {
	public ReloadAutoForwardCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.shootingMechanism);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!Robot.shootingMechanism.shooterForward()) {
			Robot.shootingMechanism.reloadForward();
		} else {
			Robot.shootingMechanism.reloadStop();
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.shootingMechanism.shooterForward();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shootingMechanism.reloadStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
