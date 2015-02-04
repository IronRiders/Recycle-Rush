package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.elevator.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;

public class AutonomousRunner {
    private DigitalInput AUTO_SWITCH_1 = new DigitalInput(Port.AUTO_SWITCH_1.GetPort());
    private DigitalInput AUTO_SWITCH_2 = new DigitalInput(Port.AUTO_SWITCH_2.GetPort());
	private DriveTrain DRIVE_TRAIN; 
    private Elevator ELEVATOR;
    
    public AutonomousRunner() {
    	boolean switchOneValue = AUTO_SWITCH_1.get();
    	boolean switchTwoValue = AUTO_SWITCH_2.get();
    	if(switchOneValue && switchTwoValue) {
    		driveToAutoZone();
    	} else if(!switchOneValue && switchTwoValue) {
    		moveBinToAutoZone();
    	} else if(switchOneValue && !switchTwoValue) {
    		moveToteToAutoZone();
    	} else {
    		disableAutonomous();
    	}
    }
    
    private void driveToAutoZone() {
//    	start in starting zone
//    	drive into auto zone
    }
    
    private void moveToteToAutoZone() {
//    	start facing tote
//    	pick up bin, rotate
//    	drive to autozone
    	
    }
    
    private void moveBinToAutoZone() {
//    	start facing bin
//    	pick up bin, rotate
//    	drive to autozone
    } 
    
    private void disableAutonomous() {
    	
    }
}
