// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2051.RecycleRush;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc2051.robot.RecycleRush.lib.PIDSpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static SpeedController driveSystemLeftFront;
	public static SpeedController driveSystemLeftRear;
	public static SpeedController driveSystemRightFront;
	public static SpeedController driveSystemRightRear;
	public static RobotDrive driveSystemMecanum;
	public static Gyro driveSystemGyro;
	public static Encoder driveSystemLeftFrontEnc;
	public static Encoder driveSystemLeftRearEnc;
	public static Encoder driveSystemRightFrontEnc;
	public static Encoder driveSystemRightRearEnc;
	public static Ultrasonic driveSystemUltrasonic;
	public static SpeedController lifterPIDDARTMotorLeft;
	public static SpeedController lifterPIDDARTMotorRight;
	public static AnalogPotentiometer lifterPIDDARTPositionLeft;
	public static AnalogPotentiometer lifterPIDDARTPositionRight;
	public static DigitalInput lifterPIDLifterTopLeft;
	public static DigitalInput lifterPIDLifterTopRight;
	public static DigitalInput lifterPIDLifterBottomLeft;
	public static DigitalInput lifterPIDLifterBottomRight;
	public static Relay collectorCollectorRight;
	public static Relay collectorCollectorLeft;
	public static DigitalInput collectorCollectorLeftTripped;
	public static DigitalInput collectorCollectorRightTripped;
	public static SpeedController collectorCollectorRightMotor;
	public static SpeedController collectorCollectorLeftMotor;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// PID Constants
	static final double kP = .0001;
	static final double kI = .0000001;
	static final double kD = .0000001;

	// Lifter position potentiometer constants
	public static final double LIFTER_DOWN = 0;
	public static final double LIFTER_ONE = 1;
	public static final double LIFTER_TWO = 2;
	public static final double LIFTER_THREE = 3;
	public static final double LIFTER_FOUR = 4;
	public static final double LIFTER_CONTAINER = 3.5;

	public static void init()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveSystemRightFront = new Talon(0);
		LiveWindow.addActuator("Drive System", "Right Front", (Talon) driveSystemRightFront);

		driveSystemRightRear = new Talon(1);
		LiveWindow.addActuator("Drive System", "Right Rear", (Talon) driveSystemRightRear);

		driveSystemLeftFront = new Talon(2);
		LiveWindow.addActuator("Drive System", "Left Front", (Talon) driveSystemLeftFront);

		driveSystemLeftRear = new Talon(3);
		LiveWindow.addActuator("Drive System", "Left Rear", (Talon) driveSystemLeftRear);

		driveSystemRightFrontEnc = new Encoder(0, 1, false, EncodingType.k4X);
		LiveWindow.addSensor("Drive System", "Right Front Enc", driveSystemRightFrontEnc);
		driveSystemRightFrontEnc.setDistancePerPulse(1.0);
		driveSystemRightFrontEnc.setPIDSourceParameter(PIDSourceParameter.kRate);

		driveSystemRightRearEnc = new Encoder(2, 3, false, EncodingType.k4X);
		LiveWindow.addSensor("Drive System", "Right Rear Enc", driveSystemRightRearEnc);
		driveSystemRightRearEnc.setDistancePerPulse(1.0);
		driveSystemRightRearEnc.setPIDSourceParameter(PIDSourceParameter.kRate);

		driveSystemLeftFrontEnc = new Encoder(4, 5, false, EncodingType.k4X);
		LiveWindow.addSensor("Drive System", "Left Front Enc", driveSystemLeftFrontEnc);
		driveSystemLeftFrontEnc.setDistancePerPulse(1.0);
		driveSystemLeftFrontEnc.setPIDSourceParameter(PIDSourceParameter.kRate);

		driveSystemLeftRearEnc = new Encoder(6, 7, false, EncodingType.k4X);
		LiveWindow.addSensor("Drive System", "Left Rear Enc", driveSystemLeftRearEnc);
		driveSystemLeftRearEnc.setDistancePerPulse(1.0);
		driveSystemLeftRearEnc.setPIDSourceParameter(PIDSourceParameter.kRate);

		driveSystemMecanum = new RobotDrive(new PIDSpeedController(driveSystemLeftFront, kP, kI, kD, driveSystemLeftFrontEnc), 
											new PIDSpeedController(driveSystemLeftRear, kP, kI, kD, driveSystemLeftRearEnc), 
											new PIDSpeedController(driveSystemRightFront, kP, kI, kD, driveSystemRightFrontEnc), 
											new PIDSpeedController(driveSystemRightRear, kP, kI, kD, driveSystemRightRearEnc));

		// driveSystemMecanum = new RobotDrive(driveSystemLeftFront,
		// driveSystemLeftRear, driveSystemRightFront,
		// driveSystemRightRear);

		driveSystemMecanum.setSafetyEnabled(true);
		driveSystemMecanum.setExpiration(0.1);
		driveSystemMecanum.setSensitivity(0.5);
		driveSystemMecanum.setMaxOutput(1.0);
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		driveSystemGyro = new Gyro(0);
		LiveWindow.addSensor("Drive System", "Gyro", driveSystemGyro);
		driveSystemGyro.setSensitivity(0.007);

		driveSystemUltrasonic = new Ultrasonic(11, 12);
		LiveWindow.addSensor("Drive System", "Ultrasonic", driveSystemUltrasonic);

		lifterPIDDARTMotorLeft = new Talon(4);
		LiveWindow.addActuator("Lifter PID", "DART Motors", (Talon) lifterPIDDARTMotorLeft);

		lifterPIDDARTMotorRight = new Talon(5);
		LiveWindow.addActuator("Lifter PID", "DART Motors", (Talon) lifterPIDDARTMotorRight);

		lifterPIDDARTPositionLeft = new AnalogPotentiometer(1, 1.0, 0.0);
		LiveWindow.addSensor("Lifter PID", "DART Position", lifterPIDDARTPositionLeft);

		lifterPIDDARTPositionRight = new AnalogPotentiometer(2, 1.0, 0.0);
		LiveWindow.addSensor("Lifter PID", "DART Position", lifterPIDDARTPositionRight);

		lifterPIDLifterTopLeft = new DigitalInput(9);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Left", lifterPIDLifterTopLeft);

		lifterPIDLifterTopRight = new DigitalInput(10);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Left", lifterPIDLifterTopRight);

		lifterPIDLifterBottomLeft = new DigitalInput(8);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Left", lifterPIDLifterBottomLeft);

		lifterPIDLifterBottomRight = new DigitalInput(1);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Left", lifterPIDLifterBottomRight);

		collectorCollectorRight = new Relay(7);
		LiveWindow.addActuator("Collector", "Collector Right", collectorCollectorRight);

		collectorCollectorLeft = new Relay(8);
		LiveWindow.addActuator("Collector", "Collector Left", collectorCollectorLeft);

		collectorCollectorLeftTripped = new DigitalInput(12);
		LiveWindow.addSensor("Collector", "Collector Opened", collectorCollectorLeftTripped);

		collectorCollectorRightTripped = new DigitalInput(13);
		LiveWindow.addSensor("Collector", "Collector Closed", collectorCollectorRightTripped);
		
		collectorCollectorLeftMotor = new Talon(6);
		LiveWindow.addActuator("Collector", "Collector Left Motor", (Talon) collectorCollectorLeftMotor);
		
		collectorCollectorRightMotor = new Talon(7);
		LiveWindow.addActuator("Collector", "Collector Right Motor",(Talon) collectorCollectorRightMotor);
		

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}
}
