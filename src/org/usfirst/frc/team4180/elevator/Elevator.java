package org.usfirst.frc.team4180.elevator;

import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;

public class Elevator {
	private static boolean MOVING;
	private Jaguar WINCH_JAGUAR;
	private double JOYSTICK_Y;
	private DigitalInput LIMIT_SWITCH_5 = new DigitalInput(Port.TOP_LIMIT_SWITCH.GetPort());
	private DigitalInput LIMIT_SWITCH_0 = new DigitalInput(Port.BOTTOM_LIMIT_SWITCH.GetPort());
	//This is defined here because: "Array constants can only be used in initializers" (error).

	private boolean STATUS_OF_BOTTOM_SWITCH;
	private boolean STATUS_OF_TOP_SWITCH;
	//private boolean[] STATUS_OF_MID_SWITCHES_ARRAY = {false, false, false, false};

    //private static final int TEMP_PORT = 11;
    //private int GRIP_PORT = TEMP_PORT;
    private Solenoid grip;
    private final double winchSpeed = 0.2;
	
	public Elevator(){
		WINCH_JAGUAR = new Jaguar(Port.ELEVATION_WINCH_JAGUAR.GetPort());
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
	
	public void updateLimitSwitchZeroStatus() {
		STATUS_OF_BOTTOM_SWITCH = LIMIT_SWITCH_0.get();
	}
	
//public void updateLimitSwitchArrayStatus() {
		//for(int y = 0; y < 4; y++) {
		//	STATUS_OF_MID_SWITCHES_ARRAY[y] = LIMIT_SWITCH_ARRAY[y].get();
	//	}
//	}
	
//	public void updateLimitSwitchFiveStatus() {
//		STATUS_OF_LVL_FIVE_SWITCH = LIMIT_SWITCH_5.get();
//	}

    
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
