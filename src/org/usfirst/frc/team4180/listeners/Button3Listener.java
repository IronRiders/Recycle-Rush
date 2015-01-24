package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;

public class Button3Listener implements ButtonListener {
	private Elevator elevator;
	
	public Button3Listener(Elevator newelevator){
		elevator = newelevator;
		
	}
	@Override
	public void buttonDown() {
		elevator.raiseArm();
		
	}

	@Override
	public void buttonUp() {
		elevator.stop();
		
	}

}
