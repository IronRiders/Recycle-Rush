package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;

public class ElevatorSolenoidListener implements ButtonListener {
	private Elevator elevator;
	private boolean open;
	
	public ElevatorSolenoidListener(Elevator elevator) {
		this.elevator = elevator;
		open = true;
	}
	
	public void buttonDown() {
		if(open) {
			elevator.gripSolenoidReverse();
		} else {
			elevator.gripSolenoidOn();
		}
		open = !open;
	}

	public void buttonUp() {}
}
