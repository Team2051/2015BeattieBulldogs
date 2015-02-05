package org.usfirst.frc2051.RecycleRush.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem
{
	CameraServer server;

	public Camera()
	{
		this("cam0");
	}

	public Camera(String name)
	{
		server = CameraServer.getInstance();
        server.setQuality(69);//tee hee
        server.startAutomaticCapture(name);
	}

	protected void initDefaultCommand()
	{

	}

}
