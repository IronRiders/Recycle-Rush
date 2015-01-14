package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Aaron Jacobson
 * @author Thomas Noble
 */
public class Pneumatics {
    //NOTE: Reassign ports when we know which port things go to
    private static final int TEMP_PORT_ONE = 10;
    private static final int TEMP_PORT_TWO = 11;
    private int RELAY_PORT_GRIP = TEMP_PORT_ONE;
    private int RELAY_PORT_SHIFT = TEMP_PORT_TWO;
    private int GRIP_PORT = TEMP_PORT_ONE;
    private Relay gripRelay;
    private int SHIFT_PORT = TEMP_PORT_TWO;
    private Solenoid grip;
    private Relay shiftRelay;
    private Solenoid shift;

    /**
     * The constructor for the Pressure class which controls the pneumatics on the robot
     * It assigns the ports for the solenoids and relays
     */
    public Pneumatics()
    {
        gripRelay = new Relay(RELAY_PORT_GRIP);
        grip = new Solenoid(GRIP_PORT);
        shiftRelay = new Relay(RELAY_PORT_SHIFT);
        shift = new Solenoid(SHIFT_PORT);
    }
    
    /**
     * Gives the grip relay the value to reverse
     */
    public void gripRelayReverse(){
        gripRelay.set(Relay.Value.kReverse);
    }
    
    /**
     * Gives the shift relay the value to reverse
     */
    public void shiftRelayReverse(){
        shiftRelay.set(Relay.Value.kReverse);
    }

    /**
     * Turns on the grip relay
     */
    public void gripRelayOn()
    {
        gripRelay.set(Relay.Value.kForward);
    }
    
    /**
     * Turns on the shift relay
     */
    public void shiftRelayOn()
    {
        shiftRelay.set(Relay.Value.kForward);
    }
    
    /**
     * Turns the grip relay off
     */
    public void gripRelayOff() {
        gripRelay.set(Relay.Value.kOn);
    }
    
    /**
     * Turns the shift relay off
     */
    public void shiftRelayOff() {
        shiftRelay.set(Relay.Value.kOn);
    }
    
    /**
     * Gives the port number of the grip relay
     * @return the port of the grip relay
     */
    public int getGripRelayPort()
    {
        return RELAY_PORT_GRIP;
    }
    
    /**
     * Gives the port number of the shift relay
     * @return the port of the shift relay
     */
    public int getShifRelayPort()
    {
        return RELAY_PORT_SHIFT;
    }
    
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
    
    /**
     * Turns the shift solenoid on
     */
    public void shiftSolenoidOn(){
        shift.set(true);
    }
    
    /**
     * Turns the shift solenoid off
     */
    public void shiftSolenoidOff(){
        shift.set(false);
    }
}
