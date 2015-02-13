package org.usfirst.frc2051.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup 
{
	public AutonomousCommand()
	{
		addSequential(new DriveForward());
	}
}
