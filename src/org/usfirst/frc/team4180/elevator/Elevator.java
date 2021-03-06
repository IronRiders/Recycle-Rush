package org.usfirst.frc.team4180.elevator;

import org.usfirst.frc.team4180.robot.Port;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

public class Elevator {
	private static boolean MOVING;
	private static Jaguar WINCH_JAGUAR;
    private static DoubleSolenoid grip;
    private static Solenoid gripValve;
    private final static double winchSpeed = 0.2;
	
    /**
     * The constructor for the Elevator class which controls the elevator on the robot
     * It assigns the ports for the elevation solenoid and the Jaguar.
     */
    public Elevator(){
		WINCH_JAGUAR = new Jaguar(Port.ELEVATION_WINCH_JAGUAR.GetPort());
		gripValve = new Solenoid(Port.GRIPPER_VALVE.GetPort()); 
        grip = new DoubleSolenoid(Port.GRIPPER_PNEUMATIC_ACTUATOR_FORWARD.GetPort(), Port.GRIPPER_PNEUMATIC_ACTUATOR_REVERSE.GetPort());
	}
	
    /**
     * Gives the Jaguar the value for speed
     */
 	public void setSpeed(double speed){
// 		System.out.println("ss = " + speed);
		WINCH_JAGUAR.set(speed);
		//double random = WINCH_JAGUAR.get();
		//WINCH_JAGUAR.set(random);
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
 	
 	public void raiseArmDistance(double dist){
 		//TODO:test for distance later
 	}
	
    /**
     * Returns whether the elevator is currently moving in the form of a boolean
     */
  	public boolean getMoving(){
		return MOVING;
	}
	
//  	REQUIRES COMMENTS----------------------------------------------------------------------

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
    
    public void gripSolenoidReverse(){
        grip.set(DoubleSolenoid.Value.kReverse);
    }
     
    public static void openGripperValve() {
    	gripValve.set(true);
    }
    
    public static void closeGripperValve() {
    	gripValve.set(false);
    }
}
