// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2051.RecycleRush.subsystems;

import org.usfirst.frc2051.RecycleRush.RobotMap;
import org.usfirst.frc2051.RecycleRush.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveSystem extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.driveSystemLeftFront;
    SpeedController leftRear = RobotMap.driveSystemLeftRear;
    SpeedController rightFront = RobotMap.driveSystemRightFront;
    SpeedController rightRear = RobotMap.driveSystemRightRear;
    RobotDrive mecanum = RobotMap.driveSystemMecanum;
    Gyro gyro = RobotMap.driveSystemGyro;
    Encoder leftFrontEnc = RobotMap.driveSystemLeftFrontEnc;
    Encoder leftRearEnc = RobotMap.driveSystemLeftRearEnc;
    Encoder rightFrontEnc = RobotMap.driveSystemRightFrontEnc;
    Encoder rightRearEnc = RobotMap.driveSystemRightRearEnc;
    Ultrasonic ultrasonic = RobotMap.driveSystemUltrasonic;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    double m=0;//gyro dummy
    double x;
    double deadbandZ;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveByJoystick());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void takeJoystickInputs(Joystick driveStick) {
		mecanum.mecanumDrive_Cartesian(driveStick.getX(), driveStick.getY(), deadBand(driveStick.getZ()), m);
	
    }

	public void stop() 
	{
		mecanum.drive(0, 0);
	}
	
	private double deadBand(double x)
	{
		//x^(1/x);
		if(x<0)
		{
			return -(Math.pow(-x, 1/(-1.75*x)));
		}
		else if(x==0)
		{							
			return 0; 
		}
		else
		{
			return (Math.pow(x, 1/(1.75*x)));
		}
	}
}