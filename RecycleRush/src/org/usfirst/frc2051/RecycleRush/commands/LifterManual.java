package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2051.RecycleRush.OI;
import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

public class LifterManual extends Command
{
	//seconds from min to max height
	double lifterConst = 3;
	
	
	// (max - min) / (constant * iterations per second)
	double lifterSetPtRatio = RobotMap.LIFTER_RANGE / (lifterConst * 50);

	public LifterManual()
	
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterLeft);
		requires(Robot.lifterRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println("Starting Lifter Manual mode");
		Robot.lifterPIDLeft.enable();
		Robot.lifterPIDRight.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		//averages of potentiometer outputs
		double avgPot = (Robot.lifterPIDLeft.getPosition() + Robot.lifterPIDRight.getPosition()) / 2;
		
		//inverted joystick input raised or lowered to reach target distance
		double lifterSetPt = avgPot + OI.deadBand(-Robot.oi.controlStick.getY()) * lifterSetPtRatio;
		lifterSetPt = 0.9;
		/*
		if (lifterSetPt > RobotMap.LIFTER_MAX)
		{//remove brace upon pain of death
			lifterSetPt = RobotMap.LIFTER_MAX;
			Robot.lifterLeft.stop();
			Robot.lifterRight.stop();
		}
		else if (lifterSetPt < RobotMap.LIFTER_MIN)
		{
			lifterSetPt = RobotMap.LIFTER_MIN;
			Robot.lifterLeft.stop();
			Robot.lifterRight.stop();
		}
		else
		*/
		{
			Robot.lifterPIDLeft.setSetpoint(lifterSetPt);
			Robot.lifterPIDRight.setSetpoint(lifterSetPt);
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	// This command never finishes. The toggle button action will kill it when
	// needed.
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		System.out.println("Ending Lifter Manual mode");
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
		Robot.lifterLeft.stop();
		Robot.lifterRight.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}