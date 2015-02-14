package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class GearShiftButtonListener implements ButtonListener{
	private DriveTrain driving;
	private boolean open;
	
	public GearShiftButtonListener(DriveTrain newDriveTrain){
		driving = newDriveTrain;
		open = true;
	}
	@Override
	public void buttonDown(){
		if(open) {
			driving.gearShiftSolenoidReverse();
		} else {
			driving.gearShiftSolenoidOn();
		}
		open = !open;
	}
	
	@Override
	public void buttonUp() {}
}
