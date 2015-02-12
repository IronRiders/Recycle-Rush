package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.elevator.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousRunner {
    private DigitalInput AUTO_SWITCH_1 = new DigitalInput(Port.AUTO_SWITCH_1.GetPort());
    private DigitalInput AUTO_SWITCH_2 = new DigitalInput(Port.AUTO_SWITCH_2.GetPort());
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
    	autonomousSpeed = 0.5; //TODO: to be tested
    }
    
    private void driveToAutoZone() {
//    	start in starting zone
//    	drive into auto zone
    	Robot.driveTrain.setSpeed(autonomousSpeed);
    	timer.delay(5); //TODO: test for delay
    	Robot.driveTrain.stopRobot();
    	
    }
    
    private void moveToteToAutoZone() {
//    	start facing tote
//    	pick up tote, rotate
//    	drive to autozone
    	Robot.elevator.gripSolenoidOn();
    	timer.delay(5);	//TODO: test for delay
    	Robot.elevator.gripSolenoidOff();
    	Robot.elevator.raiseArm();
    	timer.delay(5); //TODO: test for delay
    	Robot.elevator.stopWinch();
    	Robot.driveTrain.setSpeed(0.5, 0.5); //TODO: to be tested
    	timer.delay(5); //TODO: test for delay
    	Robot.driveTrain.stopRobot();
    	Robot.driveTrain.setSpeed(autonomousSpeed);
    	timer.delay(5); //TODO: test for delay
    	Robot.driveTrain.stopRobot();
    }
    
    private void moveBinToAutoZone() {
//    	start facing bin
//    	pick up bin, rotate
//    	drive to autozone
    	Robot.elevator.gripSolenoidOn();
    	timer.delay(5);	//TODO: test for delay
    	Robot.elevator.gripSolenoidOff();
    	Robot.elevator.raiseArm();
    	timer.delay(5); //TODO: test for delay
    	Robot.elevator.stopWinch();
    	Robot.driveTrain.setSpeed(0.5, 0.5); //TODO: to be tested
    	timer.delay(5); //TODO: test for delay
    	Robot.driveTrain.stopRobot();
    	Robot.driveTrain.setSpeed(autonomousSpeed);
    	timer.delay(5); //TODO: test for delay
    	Robot.driveTrain.stopRobot();
    } 
    
    private void disableAutonomous() {
    	
    }
}
