package org.usfirst.frc.team4180.listeners;

public interface LimitSwitchListener {
	
    public void switchState(int port, boolean state);
   
    public void switchOn(int port);
    
    public void switchOff(int port);
}