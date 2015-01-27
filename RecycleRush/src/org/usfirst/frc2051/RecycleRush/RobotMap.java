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
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
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
    public static SpeedController lifterPIDDARTMotors;
    public static AnalogPotentiometer lifterPIDDARTPosition;
    public static DigitalInput lifterPIDLifterLoaded;
    public static SpeedController collectorCollectorRight;
    public static SpeedController collectorCollectorLeft;
    public static DigitalInput collectorCollectorContactRight;
    public static DigitalInput collectorCollectorContactLeft;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSystemLeftFront = new Talon(1);
        LiveWindow.addActuator("Drive System", "Left Front", (Talon) driveSystemLeftFront);
        
        driveSystemLeftRear = new Talon(3);
        LiveWindow.addActuator("Drive System", "Left Rear", (Talon) driveSystemLeftRear);
        
        driveSystemRightFront = new Talon(0);
        LiveWindow.addActuator("Drive System", "Right Front", (Talon) driveSystemRightFront);
        
        driveSystemRightRear = new Talon(2);
        LiveWindow.addActuator("Drive System", "Right Rear", (Talon) driveSystemRightRear);
        
        driveSystemMecanum = new RobotDrive(driveSystemLeftFront, driveSystemLeftRear,
              driveSystemRightFront, driveSystemRightRear);
        
        driveSystemMecanum.setSafetyEnabled(true);
        driveSystemMecanum.setExpiration(0.1);
        driveSystemMecanum.setSensitivity(0.5);
        driveSystemMecanum.setMaxOutput(1.0);

        driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveSystemMecanum.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveSystemGyro = new Gyro(0);
        LiveWindow.addSensor("Drive System", "Gyro", driveSystemGyro);
        driveSystemGyro.setSensitivity(0.007);
        driveSystemLeftFrontEnc = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Left Front Enc", driveSystemLeftFrontEnc);
        driveSystemLeftFrontEnc.setDistancePerPulse(1.0);
        driveSystemLeftFrontEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveSystemLeftRearEnc = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Left Rear Enc", driveSystemLeftRearEnc);
        driveSystemLeftRearEnc.setDistancePerPulse(1.0);
        driveSystemLeftRearEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveSystemRightFrontEnc = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Right Front Enc", driveSystemRightFrontEnc);
        driveSystemRightFrontEnc.setDistancePerPulse(1.0);
        driveSystemRightFrontEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveSystemRightRearEnc = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Right Rear Enc", driveSystemRightRearEnc);
        driveSystemRightRearEnc.setDistancePerPulse(1.0);
        driveSystemRightRearEnc.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveSystemUltrasonic = new Ultrasonic(11, 12);
        LiveWindow.addSensor("Drive System", "Ultrasonic", driveSystemUltrasonic);
        
        lifterPIDDARTMotors = new Talon(6);
        LiveWindow.addActuator("Lifter PID", "DART Motors", (Talon) lifterPIDDARTMotors);
        
        lifterPIDDARTPosition = new AnalogPotentiometer(1, 1.0, 0.0);
        LiveWindow.addSensor("Lifter PID", "DART Position", lifterPIDDARTPosition);
        
        lifterPIDLifterLoaded = new DigitalInput(10);
        LiveWindow.addSensor("Lifter PID", "Lifter Loaded", lifterPIDLifterLoaded);
        
        collectorCollectorRight = new Talon(7);
        LiveWindow.addActuator("Collector", "Collector Right", (Talon) collectorCollectorRight);
        
        collectorCollectorLeft = new Talon(8);
        LiveWindow.addActuator("Collector", "Collector Left", (Talon) collectorCollectorLeft);
        
        collectorCollectorContactRight = new DigitalInput(8);
        LiveWindow.addSensor("Collector", "Collector Contact Right", collectorCollectorContactRight);
        
        collectorCollectorContactLeft = new DigitalInput(9);
        LiveWindow.addSensor("Collector", "Collector Contact Left", collectorCollectorContactLeft);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}