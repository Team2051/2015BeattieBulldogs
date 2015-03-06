package org.usfirst.frc2051.RecycleRush.groups;

import org.usfirst.frc2051.RecycleRush.Robot;
import org.usfirst.frc2051.RecycleRush.commands.*;
import org.usfirst.frc2051.RecycleRush.commands.DriveSidetoSide.Direction;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonRight extends CommandGroup
{
	public AutonRight()
	{
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		
		// lower lifter
		//addSequential(new LifterZero());
		
		// drive to box
		//addSequential(new DriveSidetoSide(.7, 3, Direction.kRIGHT));
		
		//lift box
		//addSequential(new LifterOne());
		
		//stop for 2 seconds
		//addSequential(new Delay(1));
		
		// move to auto zone
		addSequential(new AutonDriveForward(.5));
		
	}
}
