package org.usfirst.frc.team4180.robot;

public class Elevator {
	private WINCH_JAGUAR;
	private double JOYSTICK_Y;

	public Elevator(){
		WINCH_JAGUAR= new Jaguar(2);
		//JOYSRICK_Y = something;
	}
	
	public void setSpeed(speed){
		WINCH_JAGUAR.set(speed);
	}
}
