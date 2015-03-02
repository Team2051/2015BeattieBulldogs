package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterContainer extends Command {

	public LifterContainer() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.lifterPIDLeft.enable();
		Robot.lifterPIDRight.enable();
		Robot.lifterPIDLeft.setSetpoint(RobotMap.LIFTER_CONTAINER);
		Robot.lifterPIDRight.setSetpoint(RobotMap.LIFTER_CONTAINER);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.lifterPIDLeft.atLimit()
				|| Robot.lifterPIDRight.atLimit()
				|| (Robot.lifterPIDLeft.onTarget() && 
					Robot.lifterPIDRight.onTarget());
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
