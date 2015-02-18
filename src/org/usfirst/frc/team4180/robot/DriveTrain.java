package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	
	private Talon talonRight;
	private Talon talonLeft;
	private double joystickX;
	private double joystickY;
    private DoubleSolenoid gearShift;
    private Solenoid gearShift1;
    private Solenoid gearShift2;
	
	public DriveTrain(){
		gearShift = new DoubleSolenoid(Port.PNEUMATIC_GEARBOX_SHIFTING_FORWARD.GetPort(), Port.PNEUMATIC_GEARBOX_SHIFTING_REVERSE.GetPort());
		//gearShift1 = new Solenoid(0);
		//gearShift2 = new Solenoid(1);
		//gearShift = new DoubleSolenoid(0, 1);
		talonRight= new Talon(Port.RIGHT_TALONS.GetPort());
		talonLeft = new Talon(Port.LEFT_TALONS.GetPort());
		joystickX = 0.0;
		joystickY = 0.0;
	}
	
	public void setSpeed(double speed) {
		setSpeed(speed,speed);
	}
		
	public void setSpeed(double rightTalonSpeed, double leftTalonSpeed){
		talonRight.set(-rightTalonSpeed);
		talonLeft.set(leftTalonSpeed);
	}
	
	public void stopRobot(){
		setSpeed(0,0);
	}
	
	public void updateSpeed(){
		setSpeed(
				Math.min((Math.max(-1, joystickY+joystickX)),1), 
				Math.min((Math.max(-1, joystickY-joystickX)),1)
		);
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
        gearShift.set(DoubleSolenoid.Value.kForward);
    	//gearShift1.set(true);
    	//gearShift2.set(true);
    }
    
    /**
     * Turns the gearShift solenoid off
     */
    
    public void gearShiftSolenoidOff(){
        gearShift.set(DoubleSolenoid.Value.kOff);
    	//gearShift1.set(false);
    	//gearShift2.set(false);
    }
    
    public void gearShiftSolenoidReverse(){
        gearShift.set(DoubleSolenoid.Value.kReverse);
    }
    
}

