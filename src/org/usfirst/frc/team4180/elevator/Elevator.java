package org.usfirst.frc.team4180.elevator;

import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;

public class Elevator {
	private static boolean MOVING;
	private static Talon WINCH_TALON;
	private DigitalInput LIMIT_SWITCH_TOP = new DigitalInput(Port.TOP_LIMIT_SWITCH.GetPort());
	private DigitalInput LIMIT_SWITCH_BOTTOM = new DigitalInput(Port.BOTTOM_LIMIT_SWITCH.GetPort());

	private boolean STATUS_OF_BOTTOM_SWITCH;
	private boolean STATUS_OF_TOP_SWITCH;

   private static DoubleSolenoid grip;
    private final static double winchSpeed = 0.2;
	
    /**
     * The constructor for the Elevator class which controls the elevator on the robot
     * It assigns the ports for the elevation solenoid and the Jaguar.
     */
    public Elevator(){
		WINCH_TALON = new Talon(Port.ELEVATION_WINCH_TALON.GetPort());
        grip = new DoubleSolenoid(Port.GRIPPER_PNEUMATIC_ACTUATOR_FORWARD.GetPort(), Port.GRIPPER_PNEUMATIC_ACTUATOR_REVERSE.GetPort());
	}
	
    /**
     * Gives the Jaguar the value for speed
     */
 	public void setSpeed(double speed){
		WINCH_TALON.set(speed);
	}
	
    /**
     * calls setSpeed and sends it to the correct speed
     */
 	public void raiseArm(){
		setSpeed(winchSpeed);
	}
	
    /**
     * calls setSpeed and sends it to the correct speed
     */
 	public void lowerArm(){
		setSpeed(-winchSpeed);
	}
	

    /**
     * calls setSpeed and sends it to 0
     */
 	public void stopWinch() {
		setSpeed(0);
	}
	
    /**
     * Returns whether the elevator is currently moving in the form of a boolean
     */
  	public boolean getMoving(){
		return MOVING;
	}
	
//  	REQUIRES COMMENTS----------------------------------------------------------------------
	public void updateLimitSwitches() {
		STATUS_OF_BOTTOM_SWITCH = LIMIT_SWITCH_BOTTOM.get();
		STATUS_OF_TOP_SWITCH = LIMIT_SWITCH_TOP.get();

		if(STATUS_OF_BOTTOM_SWITCH) {
			raiseArm();
		} else if(STATUS_OF_TOP_SWITCH) {
			lowerArm();
		} else {
			stopWinch();
		}
	}

	/**
     * Turns the grip solenoid on
     */
    public void gripSolenoidOn() {
    	System.out.println("  -GripSolenoidOn");
        grip.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Turns the grip solenoid off
     */
    public void gripSolenoidOff() {
    	System.out.println("  -GripSolenoidOff");
        grip.set(DoubleSolenoid.Value.kOff);
    }
    
    /**
     *  Gives the grip relay the value to reverse
     */
    public void gripSolenoidReverse(){
        grip.set(DoubleSolenoid.Value.kReverse);
    }
}
