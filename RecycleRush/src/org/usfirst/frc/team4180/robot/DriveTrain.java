package org.usfirst.frc.team4180.robot;

public class DriveTrain {
	
	private TALON_RIGHT
	private TALON_LEFT
	private double JOYSTICK_X
	private double JOYSTICK_Y
	
	public DriveTrain(){
		TALON_RIGHT= new Talon(0);
		TALON_LEFT= new Talon(1);
		JOYSTICK_X = 0.0;
		JOYSTICK_Y = 0.0;
	}
		
	public void setSpeed(rightTalonSpeed, leftTalonSpeed){
		TALON_RIGHT.set(rightTalonSpeed);
		TALON_LEFT.set(leftTalonSpeed);
	}
	
}


//    private static final int TEMP_PORT = 10;
//    private int GEAR_SHIFT_PORT = TEMP_PORT;
//    private Solenoid gearShift;
//
//    public DriveTrain() {
//        gearShift = new Solenoid(GEAR_SHIFT_PORT);
//    }
//    
//    /**
//     * Turns the shift solenoid on
//     */
//    public void gearShiftSolenoidOn(){
//        gearShift.set(true);
//    }
//    
//    /**
//     * Turns the shift solenoid off
//     */
//    public void gearShiftSolenoidOff(){
//        gearShift.set(false);
//    }
