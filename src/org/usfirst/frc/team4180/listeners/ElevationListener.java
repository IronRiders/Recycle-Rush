package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;

public class ElevationListener implements JoystickListener {
	private Elevator elevator;
	public ElevationListener(Elevator newElevator){
		elevator = newElevator;
	}
	@Override
	public void joystickMoved(double x, double y, double z) {
		elevator.stopWinch();
		
	}

}
