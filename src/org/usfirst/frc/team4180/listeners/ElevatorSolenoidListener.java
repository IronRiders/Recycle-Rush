package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;
import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.Jaguar;

public class ElevatorSolenoidListener implements ButtonListener {
	Jaguar arm = new Jaguar(Port.BIN_ARM_JAGUAR.GetPort());
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
//		arm.set(.25);

	}

	public void buttonUp() {
		arm.set(0);
	}
}
