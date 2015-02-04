package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;

public class Button2Listener implements ButtonListener {
	private Elevator elevator;
	
	public Button2Listener(Elevator newelevator){
		elevator = newelevator;
		
	}
	@Override
	public void buttonDown() {
		elevator.lowerArm();
		
	}

	@Override
	public void buttonUp() {
		elevator.stopWinch();
	}

}
