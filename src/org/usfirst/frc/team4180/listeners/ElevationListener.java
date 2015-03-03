package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.elevator.Elevator;
import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class ElevationListener implements JoystickListener {
	private final DigitalInput TOP_LIMIT_SWITCH = new DigitalInput(Port.TOP_LIMIT_SWITCH.GetPort());
	private final DigitalInput BOTTOM_LIMIT_SWITCH = new DigitalInput(Port.BOTTOM_LIMIT_SWITCH.GetPort());
	private final double INCREMENT = 0.05;
	private double currentSpeed;
	private boolean first;
	private Elevator elevator;
//	private Encoder encoder = new Encoder(Port.MOVEMENT_ENCODER.GetPort(),0);
	
	public ElevationListener(Elevator newElevator){
		elevator = newElevator;
	}
	
	@Override
	public void joystickMoved(double x, double y, double z) {
		System.out.println("BottomSwitch: " + BOTTOM_LIMIT_SWITCH.get());
		System.out.println("TopSwitch:    " + TOP_LIMIT_SWITCH.get());

		if(!BOTTOM_LIMIT_SWITCH.get()) {
			elevator.raiseArm();
		} else if(!TOP_LIMIT_SWITCH.get()) {
			elevator.lowerArm();
		} else {
			if(y < .05 && y > -.05) {
				y = 0; //HELLO AARON //Alex is butt
			}
			y = -y;
			
			elevator.setSpeed(y);
		}
	}

//	private void setSpeed(double speed) { 
//		if(speed < 0.2 && speed > -0.2) {
//			if(!encoder.getStopped()) {
//				if(first) {
//					currentSpeed = speed;
//				}
//				
//				if(encoder.getDirection()) {
//					currentSpeed += INCREMENT;
//					elevator.setSpeed(currentSpeed);
//				} else {
//					currentSpeed -= INCREMENT;
//					elevator.setSpeed(currentSpeed);
//				}
//			} else {
//				first = true;
//			}
//		} else {
//			first = true;
//			elevator.setSpeed(speed);
//		}
//	}

}
