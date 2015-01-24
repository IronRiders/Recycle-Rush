package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class Button1Listener implements ButtonListener{
	private DriveTrain driving;
	
	public Button1Listener(DriveTrain newDriveTrain){
		driving = newDriveTrain;
	}
	@Override
	public void buttonDown(){
		driving.gearShiftSolenoidOn();
	}
	@Override
	public void buttonUp(){
		driving.gearShiftSolenoidOff();
	}
}
