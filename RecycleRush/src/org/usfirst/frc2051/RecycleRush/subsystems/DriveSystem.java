package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.OI;
import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.RobotMap;
import org.usfirst.frc2051.RecycleRush.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSystem extends Subsystem
{
	SpeedController leftFront = RobotMap.driveSystemLeftFront;
	SpeedController leftRear = RobotMap.driveSystemLeftRear;
	SpeedController rightFront = RobotMap.driveSystemRightFront;
	SpeedController rightRear = RobotMap.driveSystemRightRear;
	RobotDrive mecanum = RobotMap.driveSystemMecanum;
	Encoder leftFrontEnc = RobotMap.driveSystemLeftFrontEnc;
	Encoder leftRearEnc = RobotMap.driveSystemLeftRearEnc;
	Encoder rightFrontEnc = RobotMap.driveSystemRightFrontEnc;
	Encoder rightRearEnc = RobotMap.driveSystemRightRearEnc;
	Ultrasonic ultrasonic = RobotMap.driveSystemUltrasonic;

	DriveGyro driveGyro = Robot.driveGyro;

	double initialRightRearEnc;
	double initialLeftRearEnc;

	final double wheelRadiusIn = 4;
	final double wheelCircIn = 2 * Math.PI * wheelRadiusIn;
	final double tickPrRotation = 250 * 4; // Encoder is k4X
	final double inchPrTick = wheelCircIn / tickPrRotation;
	final double strafeInchPrTick = inchPrTick / 2.0; // Wild guess

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveByJoystick());
	}

	public void takeJoystickInputs(Joystick driveStick)
	{
		// If the gyro is enabled, factor that into driving, else use a value of
		// zero
		mecanum.mecanumDrive_Cartesian(OI.deadBand(driveStick.getX()), OI.deadBand(driveStick.getY()), OI.twistDeadBand(driveStick.getZ()), driveGyro.isGyroEnabled() ? driveGyro.getAngle() : 0.0);

		SmartDashboard.putNumber("Left Front Enc", leftFrontEnc.getDistance());
		SmartDashboard.putNumber("Left Rear Enc", leftRearEnc.getDistance());
		SmartDashboard.putNumber("Right Front Enc", rightFrontEnc.getDistance());
		SmartDashboard.putNumber("Right Rear Enc", rightRearEnc.getDistance());
	}

	public void stop()
	{
		mecanum.stopMotor();
	}

	/**
	 * moves it
	 * 
	 * @param speed
	 *            to move it
	 */
	public void moveIt(double speed)
	{
		mecanum.mecanumDrive_Cartesian(0, -speed, 0, 0.0);
	}

	public void moveItSideLeft(double speed)
	{
		mecanum.mecanumDrive_Cartesian(-speed, 0, 0, 0.0);
	}

	public void moveItSideRight(double speed)
	{
		mecanum.mecanumDrive_Cartesian(speed, 0, 0, 0.0);
	}
	
	public void moveItSpinLeft(double speed)
	{
		mecanum.mecanumDrive_Cartesian(0, 0, -speed, 0.0);
	}
	
	public void moveItSpinRight(double speed)
	{
		mecanum.mecanumDrive_Cartesian(0, 0, speed, 0.0);
	}

	/**
	 * Gets distance traveled since the last resetDist() when driving in the
	 * forward or backward direction where all wheels are turning in the same
	 * direction.
	 */
	public double getDistFwdBack()
	{
		return Math.abs(rightRearEnc.getDistance() - initialRightRearEnc) * inchPrTick;
	}

	/*
	 * Gets distance traveled since the last resetDist() when driving left
	 */
	public double getDistLeft()
	{
		return Math.abs(leftRearEnc.getDistance() - initialLeftRearEnc) * strafeInchPrTick;
	}

	/*
	 * Gets distance traveled since the last resetDist() when driving right
	 */
	public double getDistRight()
	{
		return Math.abs(rightRearEnc.getDistance() - initialRightRearEnc) * strafeInchPrTick;
	}

	// Resets distance
	public void resetDist()
	{
		initialRightRearEnc = rightRearEnc.getDistance();
		initialLeftRearEnc = leftRearEnc.getDistance();
	}

	/**
	 * 
	 * @param maxSpeed
	 * 				from 0 - 1
	 * @param finalDist
	 * 				in inches
	 * @param currentDist
	 * 				Robot.driveSystem.getDistFwdBack()
	 */
	public double autonSpeed(double maxSpeed, double finalDist, double currentDist)
	{
		final double rampSlope = ((1 - 0) / 12); // max speed minus min speed
													// over target inches for
													// slope.
		final double minSpeed = 0.25;

		double rampDist = (maxSpeed - minSpeed) / rampSlope;

		if (finalDist < rampDist)
			rampDist = finalDist / 2.0;

		if (currentDist <= rampDist) // if starting moving
			return (rampSlope * currentDist) + minSpeed; // begin acceleration
		else if (currentDist >= (finalDist - rampDist)) // if finishing moving
			return -rampSlope * (currentDist - (finalDist - rampDist)) + minSpeed; // begin
																					// deceleration
		else if (currentDist > rampDist && currentDist < (finalDist - rampDist)) // if
																					// moving
			return maxSpeed; // maintain coasting speed
		else
			// if error value
			return 0; // stop motors
	}
}