package org.usfirst.frc.team4180.elevator;

import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;

public class Elevator {
	private static boolean MOVING;
	private Jaguar WINCH_JAGUAR;
	private double JOYSTICK_Y;
	private DigitalInput LIMIT_SWITCH_TOP = new DigitalInput(Port.TOP_LIMIT_SWITCH.GetPort());
	private DigitalInput LIMIT_SWITCH_BOTTOM = new DigitalInput(Port.BOTTOM_LIMIT_SWITCH.GetPort());

	private boolean STATUS_OF_BOTTOM_SWITCH;
	private boolean STATUS_OF_TOP_SWITCH;

   private DoubleSolenoid grip;
    private final double winchSpeed = 0.2;
	
	public Elevator(){
		WINCH_JAGUAR = new Jaguar(Port.ELEVATION_WINCH_JAGUAR.GetPort());
        grip = new DoubleSolenoid(Port.GRIPPER_PNEUMATIC_ACTUATOR_FORWARD.GetPort(), Port.GRIPPER_PNEUMATIC_ACTUATOR_REVERSE.GetPort());
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
	

	public void stopWinch() {
		setSpeed(0);
	}
	
	public boolean getMoving(){
		return MOVING;
	}
	
	public void updateLimitSwitches() {
		STATUS_OF_BOTTOM_SWITCH = LIMIT_SWITCH_BOTTOM.get();
		STATUS_OF_TOP_SWITCH = LIMIT_SWITCH_TOP.get();

		if(STATUS_OF_BOTTOM_SWITCH) {
			raiseArm();
			updateLimitSwitches();
		} else if(STATUS_OF_TOP_SWITCH) {
			lowerArm();
			updateLimitSwitches();
		} else {
			stopWinch();
		}
	}

	/**
     * Turns the grip solenoid on
     */
    public void gripSolenoidOn(){
        grip.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Turns the grip solenoid off
     */
    public void gripSolenoidOff(){
        grip.set(DoubleSolenoid.Value.kOff);
    }
    
    public void gripSolenoidReverse(){
        grip.set(DoubleSolenoid.Value.kReverse);
    }
}
