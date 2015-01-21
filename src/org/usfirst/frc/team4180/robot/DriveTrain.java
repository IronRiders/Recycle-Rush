package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	
	private Talon talonRight;
	private Talon talonLeft;
	private double joystickX;
	private double joystickY;
    private Solenoid gearShift;
	
	public DriveTrain(){
        gearShift = new Solenoid(Port.PNEUMATIC_GEARBOX_SHIFTING.GetPort());
		talonRight= new Talon(Port.RIGHT_TALONS.GetPort());
		talonLeft = new Talon(Port.LEFT_TALONS.GetPort());
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
     * Turns the gearShift solenoid off
     */
    public void gearShiftSolenoidOff(){
        gearShift.set(false);
    }
    
}

