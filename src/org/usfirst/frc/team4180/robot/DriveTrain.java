package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	
	private Talon talonRight;
	private Talon talonLeft;
	private double joystickX;
	private double joystickY;
    private static final int TEMP_PORT = 10;
    private int GEAR_SHIFT_PORT = TEMP_PORT;
    private Relay gearShiftRelay;
    private Solenoid gearShift;
	
	public DriveTrain(){
        gearShiftRelay = new Relay(GEAR_SHIFT_PORT);
        gearShift = new Solenoid(GEAR_SHIFT_PORT);
		talonRight= new Talon(0);
		talonLeft = new Talon(1);
		joystickX = 0.0;
		joystickY = 0.0;
	}
		
	public void setSpeed(double rightTalonSpeed, double leftTalonSpeed){
		talonRight.set(rightTalonSpeed);
		talonLeft.set(leftTalonSpeed);
	}
	public void stopRobot(){
		setSpeed(0,0);
	}
	public void updateSpeed(){
		talonRight.set(Math.min((Math.max(-1, joystickY-joystickX)),1));
		talonLeft.set(Math.min((Math.max(-1, joystickY+joystickX)),1));
	}
	
    public void updateX(double newX){
    	joystickX = newX;
    }
    
    public void updateY(double newY){
    	joystickY = newY;
    }
    /**
     * Turns the gearShift solenoid on
     */
    public void gearShiftSolenoidOn(){
        gearShift.set(true);
    }
    
    /**
     * Turns on the gearShift relay
     */
    public void gearShiftRelayOn()
    {
        gearShiftRelay.set(Relay.Value.kForward);
    }

    /**
     * Gives the gearShift relay the value to reverse
     */
    public void gearShiftRelayReverse(){
        gearShiftRelay.set(Relay.Value.kReverse);
    }

    /**
     * Turns the gearShift relay off
     */
    public void gearShiftRelayOff() {
        gearShiftRelay.set(Relay.Value.kOn);
    }
    
    /**
     * Gives the port number of the gearShift relay
     * @return the port of the gearShift relay
     */
    public int getGearShiftRelayPort()
    {
        return GEAR_SHIFT_PORT;
    }

  /**
     * Turns the gearShift solenoid off
     */
    public void gearShiftSolenoidOff(){
        gearShift.set(false);
    }
}

