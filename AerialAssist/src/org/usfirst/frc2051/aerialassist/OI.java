// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2051.aerialassist;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2051.aerialassist.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton driveButton2;
    public JoystickButton driveButton3;
    public Joystick driveStick;
    public JoystickButton accessoryButton1;
    public JoystickButton accessoryButton2;
    public JoystickButton accessoryButton3;
    public JoystickButton accessoryButton4;
    public JoystickButton accessoryButton5;
    public JoystickButton accessoryButton6;
    public JoystickButton accessoryButton7;
    public Joystick accessoryStick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        accessoryStick = new Joystick(2);
        
        accessoryButton7 = new JoystickButton(accessoryStick, 1);
        accessoryButton7.whileHeld(new ReloadCommand());
        accessoryButton6 = new JoystickButton(accessoryStick, 1);
        accessoryButton6.whenPressed(new CollectorIntakeCommand());
        accessoryButton5 = new JoystickButton(accessoryStick, 1);
        accessoryButton5.whenPressed(new CollectorDownCommand());
        accessoryButton4 = new JoystickButton(accessoryStick, 1);
        accessoryButton4.whileHeld(new CollectorUpCommand());
        accessoryButton3 = new JoystickButton(accessoryStick, 1);
        accessoryButton3.whileHeld(new ArmDownCommand());
        accessoryButton2 = new JoystickButton(accessoryStick, 1);
        accessoryButton2.whileHeld(new ArmUpCommand());
        accessoryButton1 = new JoystickButton(accessoryStick, 1);
        accessoryButton1.whenPressed(new TriggerCommand());
        driveStick = new Joystick(1);
        
        driveButton3 = new JoystickButton(driveStick, 3);
        driveButton3.whenPressed(new LightOffCommand());
        driveButton2 = new JoystickButton(driveStick, 2);
        driveButton2.whenPressed(new LightOnCommand());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive Command", new DriveCommand());
        SmartDashboard.putData("Arm Up Command", new ArmUpCommand());
        SmartDashboard.putData("Arm Down Command", new ArmDownCommand());
        SmartDashboard.putData("Collector Up Command", new CollectorUpCommand());
        SmartDashboard.putData("Collector Down Command", new CollectorDownCommand());
        SmartDashboard.putData("Collector Intake Command", new CollectorIntakeCommand());
        SmartDashboard.putData("Reload Command", new ReloadCommand());
        SmartDashboard.putData("Trigger Command", new TriggerCommand());
        SmartDashboard.putData("Reload Manual Drive Command", new ReloadManualDriveCommand());
        SmartDashboard.putData("Light On Command", new LightOnCommand());
        SmartDashboard.putData("Light Off Command", new LightOffCommand());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveStick() {
        return driveStick;
    }
    public Joystick getAccessoryStick() {
        return accessoryStick;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
