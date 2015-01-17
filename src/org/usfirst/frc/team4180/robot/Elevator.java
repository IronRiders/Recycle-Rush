package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Jaguar;

public class Elevator {
	private static boolean MOVING;
	private Jaguar WINCH_JAGUAR;
	private double JOYSTICK_Y;
//    private static final int TEMP_PORT = 11;
//    private int RELAY_PORT_GRIP = TEMP_PORT;
//    private int GRIP_PORT = TEMP_PORT;
//    private Relay gripRelay;
//    private Solenoid grip;
	
	public Elevator(){
		WINCH_JAGUAR= new Jaguar(2);
		//JOYSRICK_Y = something;
//        gripRelay = new Relay(RELAY_PORT_GRIP);
//        grip = new Solenoid(GRIP_PORT);
	}
	
	public void setSpeed(double speed){
		WINCH_JAGUAR.set(speed);
	}
	
	public void stopWinch() {
		setSpeed(0);
	}
	
	public boolean getMoving(){
		return MOVING;
	}

//     /**
//     * Gives the grip relay the value to reverse
//     */
//   public void gripRelayReverse(){
//        gripRelay.set(Relay.Value.kReverse);
//    }
//
//    /**
//     * Turns on the grip relay
//     */
//    public void gripRelayOn()
//    {
//        gripRelay.set(Relay.Value.kForward);
//    }
//    
//    /**
//     * Turns the grip relay off
//     */
//    public void gripRelayOff() {
//        gripRelay.set(Relay.Value.kOn);
//    }
//    
//    /**
//     * Gives the port number of the grip relay
//     * @return the port of the grip relay
//     */
//    public int getGripRelayPort()
//    {
//        return RELAY_PORT_GRIP;
//    }
//    
//    /**
//     * Turns the grip solenoid on
//     */
//    public void gripSolenoidOn(){
//        grip.set(true);
//    }
//    
//    /**
//     * Turns the grip solenoid off
//     */
//    public void gripSolenoidOff(){
//        grip.set(false);
//    }
}
