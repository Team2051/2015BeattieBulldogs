package org.usfirst.frc2051.RecycleRush;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2051.RecycleRush.commands.*;
import org.usfirst.frc2051.RecycleRush.groups.*;
import org.usfirst.frc2051.RecycleRush.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{

	Command autonomousCommand;
	SendableChooser autoChooser;

	public static OI oi;
	public static DriveSystem driveSystem;
	public static DriveGyro driveGyro;
	public static LifterPIDLeft lifterPIDLeft;
	public static LifterPIDRight lifterPIDRight;
	public static Collector collector;
	public static Camera camera;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		// First step: initialize all the RobotMap sensors and actuators
		RobotMap.init();

		// Create subsystems
		driveGyro = new DriveGyro();
		driveSystem = new DriveSystem();
		lifterPIDLeft = new LifterPIDLeft();
		lifterPIDRight = new LifterPIDRight();
		collector = new Collector();
		camera = new Camera();

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// Create SmartDashboard menu to select the autonomous period command
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Lift and Drive to Auton", new Dance());
		autoChooser.addObject("Drive Forward", new DriveForward(0.5, 24, Robot.driveSystem.getDistFwdBack()));
		autoChooser.addObject("Do Nothing", new DoNothing());
		SmartDashboard.putData("Auto Chooser", autoChooser);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		autonomousCommand = (Command) autoChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
