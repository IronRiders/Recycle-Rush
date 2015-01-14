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
//    private Relay gearShiftRelay;
//    private Solenoid gearShift;
//
//    public DriveTrain() {
//        shiftRelay = new Relay(GEAR_SHIFT_PORT);
//        shift = new Solenoid(GEAR_SHIFT_PORT);
//    }
//    
//    /**
//     * Turns the gearShift solenoid on
//     */
//    public void gearShiftSolenoidOn(){
//        gearShift.set(true);
//    }
//    
//    /**
//     * Turns on the gearShift relay
//     */
//    public void gearShiftRelayOn()
//    {
//        gearShiftRelay.set(Relay.Value.kForward);
//    }
//
//    /**
//     * Gives the gearShift relay the value to reverse
//     */
//    public void gearShiftRelayReverse(){
//        gearShiftRelay.set(Relay.Value.kReverse);
//    }
//
//    /**
//     * Turns the gearShift relay off
//     */
//    public void gearShiftRelayOff() {
//        gearShiftRelay.set(Relay.Value.kOn);
//    }
//    
//    /**
//     * Gives the port number of the gearShift relay
//     * @return the port of the gearShift relay
//     */
//    public int getGearShiftRelayPort()
//    {
//        return GEAR_SHIFT_PORT;
//    }
//
//  /**
//     * Turns the gearShift solenoid off
//     */
//    public void gearShiftSolenoidOff(){
//        gearShift.set(false);
//    }
