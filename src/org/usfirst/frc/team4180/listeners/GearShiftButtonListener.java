package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class GearShiftButtonListener implements ButtonListener{
	private DriveTrain driving;
	
	public GearShiftButtonListener(DriveTrain newDriveTrain){
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
