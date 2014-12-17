/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2051.aerialassist.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2051.aerialassist.Robot;

/**
 *
 * @author Administrator
 */
public class FireAndReloadCommand extends CommandGroup
{
    public FireAndReloadCommand()
    {
        addSequential(new TriggerCommand());
        addSequential(new ReloadAutoForwardCommand());
        addSequential(new ReloadAutoBackCommand());
    }
}
