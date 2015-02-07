package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.elevator.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousRunner {
    private DigitalInput AUTO_SWITCH_1 = new DigitalInput(Port.AUTO_SWITCH_1.GetPort());
    private DigitalInput AUTO_SWITCH_2 = new DigitalInput(Port.AUTO_SWITCH_2.GetPort());
	private DriveTrain DRIVE_TRAIN; 
    private Elevator ELEVATOR;
    private double autonomousSpeed; 
    private Timer timer = new Timer();
    
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
    	autonomousSpeed = 0.5; // # to be determined
    }
    
    private void driveToAutoZone() {
//    	start in starting zone
//    	drive into auto zone
    	Robot.driveTrain.setSpeed(autonomousSpeed);
    	timer.delay(5); // # to be determined
    	Robot.driveTrain.stopRobot();
    	
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
