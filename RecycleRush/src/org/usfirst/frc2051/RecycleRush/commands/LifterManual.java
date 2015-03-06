package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2051.RecycleRush.OI;
import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;

public class LifterManual extends Command
{
	//seconds from min to max height
	double lifterConst = 3;
	
	
	// (max - min) / (constant * iterations per second)
	double lifterSetPtRatio = (RobotMap.LIFTER_MAX - RobotMap.LIFTER_MIN) / (lifterConst * 50);

	AnalogPotentiometer lifterPosLeft = RobotMap.lifterPIDDARTPositionLeft;
	AnalogPotentiometer lifterPosRight = RobotMap.lifterPIDDARTPositionRight;
	DigitalInput lifterTopRight = RobotMap.lifterPIDLifterTopRight;
	DigitalInput lifterBottomRight = RobotMap.lifterPIDLifterBottomRight;
	DigitalInput lifterTopLeft = RobotMap.lifterPIDLifterTopLeft;
	DigitalInput lifterBottomLeft = RobotMap.lifterPIDLifterBottomLeft;

	public LifterManual()
	
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lifterPIDLeft);
		requires(Robot.lifterPIDRight);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.lifterPIDLeft.enable();
		Robot.lifterPIDRight.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		//averages of potentiometer outputs
		double avgPot = (lifterPosLeft.get() + lifterPosRight.get()) / 2;
		
		//inverted joystick input raised or lowered to reach target distance
		double lifterSetPt = avgPot + OI.deadBand(-Robot.oi.controlStick.getY()) * lifterSetPtRatio;
		
		if (lifterSetPt > RobotMap.LIFTER_MAX)
		{//remove brace upon pain of death
			lifterSetPt = RobotMap.LIFTER_MAX;
		}
		
		if (lifterSetPt < RobotMap.LIFTER_MIN)
		{
			lifterSetPt = RobotMap.LIFTER_MIN;
		}
		
		Robot.lifterPIDLeft.setSetpoint(lifterSetPt);
		Robot.lifterPIDRight.setSetpoint(lifterSetPt);
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
		Robot.lifterPIDLeft.disable();
		Robot.lifterPIDRight.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}