package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;

public class Elevator {
	private static boolean MOVING;
	private Jaguar WINCH_JAGUAR;
	private double JOYSTICK_Y;
    private static final int TEMP_PORT = 11;
    private int GRIP_PORT = TEMP_PORT;
    private Solenoid grip;
    private final double winchSpeed = 0.2;
	
	public Elevator(){
		WINCH_JAGUAR= new Jaguar(2);
		//JOYSRICK_Y = something;
        	grip = new Solenoid(Port.GRIPPER_PNEUMATIC_ACTUATOR.GetPort());
	}
	
	public void setSpeed(double speed){
		WINCH_JAGUAR.set(speed);
	}
	
	public void raiseArm(){
		setSpeed(winchSpeed);
	}
	
	public void lowerArm(){
		setSpeed(-winchSpeed);
	}
	
	public void stop(){
		stopWinch();
	}

	
	public void stopWinch() {
		setSpeed(0);
	}
	
	public boolean getMoving(){
		return MOVING;
	}
    
    /**
     * Turns the grip solenoid on
     */
    public void gripSolenoidOn(){
        grip.set(true);
    }
    
    /**
     * Turns the grip solenoid off
     */
    public void gripSolenoidOff(){
        grip.set(false);
    }
}
