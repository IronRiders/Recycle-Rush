package org.usfirst.frc.team4180.robot;

public class DriveTrain {
    private static final int TEMP_PORT = 10;
    private int GEAR_SHIFT_PORT = TEMP_PORT_TWO;
    private Solenoid gearShift;

    public DriveTrain() {
        gearShift = new Solenoid(GEAR_SHIFT_PORT);
    }
    
    /**
     * Turns the shift solenoid on
     */
    public void gearShiftSolenoidOn(){
        gearShift.set(true);
    }
    
    /**
     * Turns the shift solenoid off
     */
    public void gearShiftSolenoidOff(){
        gearShift.set(false);
    }
}
