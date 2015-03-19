package org.usfirst.frc2051.RecycleRush;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
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
	public static SpeedController collectorCollectorAngle;

	// PID Constants for Lifter
	public static final double kP = 5.0;
	public static final double kI = 1.0;
	public static final double kD = 0.0;


//	Respects left side as correct side
//  Apply Dif constant to target locations on right side
//	ex. Robot.lifterPIDRight.getPosition() + RobotMap.LIFTER_LEFT_MINUS_RIGHT > RobotMap.LIFTER_MIN
	public static final double LIFTER_MAX = 0.930;
	public static final double LIFTER_MIN = 0.550;
	public static final double LIFTER_LEFT_MINUS_RIGHT = 0.5;
	public static final double LIFTER_RANGE = LIFTER_MAX - LIFTER_MIN;
	public static final double LIFTER_ZERO = LIFTER_MIN + (LIFTER_RANGE / 6) * 1;
	public static final double LIFTER_ONE = LIFTER_MIN + (LIFTER_RANGE / 6) * 2;
	public static final double LIFTER_TWO = LIFTER_MIN + (LIFTER_RANGE / 6) * 3;
	public static final double LIFTER_THREE = LIFTER_MIN + (LIFTER_RANGE / 6) * 4;
	public static final double LIFTER_FOUR = LIFTER_MIN + (LIFTER_RANGE / 6) * 5;
	public static final double LIFTER_CONTAINER = LIFTER_MIN + (LIFTER_RANGE / 6) * 3.5;

	
	// Directional Constants
	public enum Direction
	{
		kLEFT, kRIGHT
	}
	
	public static void init()
	{
		driveSystemRightFront = new Talon(3);//0
		LiveWindow.addActuator("Drive System", "Right Front", (Talon) driveSystemRightFront);

		driveSystemRightRear = new Talon(2);//1
		LiveWindow.addActuator("Drive System", "Right Rear", (Talon) driveSystemRightRear);

		driveSystemLeftFront = new Talon(0);//2
		LiveWindow.addActuator("Drive System", "Left Front", (Talon) driveSystemLeftFront);

		driveSystemLeftRear = new Talon(1);//3
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

		driveSystemMecanum = new RobotDrive(driveSystemLeftFront, driveSystemLeftRear, driveSystemRightFront, driveSystemRightRear);

		driveSystemMecanum.setSafetyEnabled(true);
		driveSystemMecanum.setExpiration(0.1);
		driveSystemMecanum.setSensitivity(0.5);
		driveSystemMecanum.setMaxOutput(1.0);
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);//false
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);//false
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);//true
		driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);//false

//		driveSystemGyro = new Gyro(2);
//		LiveWindow.addSensor("Drive System", "Gyro", driveSystemGyro);
//		driveSystemGyro.setSensitivity(0.007);

		// driveSystemUltrasonic = new Ultrasonic(11, 12);
		// LiveWindow.addSensor("Drive System", "Ultrasonic",
		// driveSystemUltrasonic);

		lifterPIDDARTMotorLeft = new Talon(5);
		LiveWindow.addActuator("Lifter PID", "DART Motors Left", (Talon) lifterPIDDARTMotorLeft);

		lifterPIDDARTMotorRight = new Talon(4);
		LiveWindow.addActuator("Lifter PID", "DART Motors Right", (Talon) lifterPIDDARTMotorRight);

		lifterPIDDARTPositionLeft = new AnalogPotentiometer(1, 1.0, 0.0);
		LiveWindow.addSensor("Lifter PID", "DART Position Left", lifterPIDDARTPositionLeft);

		lifterPIDDARTPositionRight = new AnalogPotentiometer(2, 1.0, 0.0);
		LiveWindow.addSensor("Lifter PID", "DART Position Right", lifterPIDDARTPositionRight);

		lifterPIDLifterTopLeft = new DigitalInput(24);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Left", lifterPIDLifterTopLeft);

		lifterPIDLifterTopRight = new DigitalInput(21);
		LiveWindow.addSensor("Lifter PID", "Lifter At Top Right", lifterPIDLifterTopRight);

		lifterPIDLifterBottomLeft = new DigitalInput(23);
		LiveWindow.addSensor("Lifter PID", "Lifter At Bottom Left", lifterPIDLifterBottomLeft);

		lifterPIDLifterBottomRight = new DigitalInput(22);
		LiveWindow.addSensor("Lifter PID", "Lifter At Bottom Right", lifterPIDLifterBottomRight);

		collectorCollectorRight = new Relay(0);
		collectorCollectorRight.setDirection(Relay.Direction.kBoth);
		LiveWindow.addActuator("Collector", "Collector Right", collectorCollectorRight);

		collectorCollectorLeft = new Relay(1);
		collectorCollectorLeft.setDirection(Relay.Direction.kBoth);
		LiveWindow.addActuator("Collector", "Collector Left", collectorCollectorLeft);

		collectorCollectorLeftTripped = new DigitalInput(9);
		LiveWindow.addSensor("Collector", "Collector Angle In (Left)", collectorCollectorLeftTripped);

		collectorCollectorRightTripped = new DigitalInput(8);
		LiveWindow.addSensor("Collector", "Collector Angle Out (Right)", collectorCollectorRightTripped);

		collectorCollectorAngle = new Talon(6);
		LiveWindow.addActuator("Collector", "Collector Angle", (Talon) collectorCollectorAngle);
	}
}
