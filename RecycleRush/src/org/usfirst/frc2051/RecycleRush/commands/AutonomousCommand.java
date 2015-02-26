package org.usfirst.frc2051.RecycleRush.commands;

import org.usfirst.frc2051.RecycleRush.groups.Dance;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCommand extends CommandGroup 
{
	public Command runCmd;
	public SendableChooser chooseCmd;
	
	public AutonomousCommand()
	{
		//addSequential(new DriveForward(.3, 12));
		
		//- Do Nothing
		chooseCmd = new SendableChooser();
		
		chooseCmd.addDefault("Do Nothing" , new DoNothing());
		chooseCmd.addObject("Drive forward", new DriveForward(.5, 24));
		chooseCmd.addObject("Dance", new Dance());
		
		SmartDashboard.putData("Auto Choice TM: ", chooseCmd);
	}
	
	/*public void runNothing()
	{
		runCmd = (Command)chooseCmd.getSelected();
		runCmd.start();
	}

	public void runAutoForward()
	{
		runCmd = (Command)chooseCmd.getSelected();
		runCmd.start();
	}*/
}
