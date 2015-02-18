package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.elevator.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousRunner {
    private DigitalInput AUTO_SWITCH_1 = new DigitalInput(Port.AUTO_SWITCH_1.GetPort());
    private DigitalInput AUTO_SWITCH_2 = new DigitalInput(Port.AUTO_SWITCH_2.GetPort());
    private static double autonomousSpeed;
    private DriveTrain driveTrain;
    private Elevator elevator;
    
    public AutonomousRunner(DriveTrain driveTrain, Elevator elevator) {
    	this.elevator = elevator;
    	this.driveTrain = driveTrain;
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
    	autonomousSpeed = 0.3;
    }
    
    public void driveToAutoZone() {
//    	start in starting zone
//    	drive into auto zone
    	driveTrain.setSpeed(-autonomousSpeed);
    	Timer.delay(3); //TODO: test for delay
    	driveTrain.stopRobot();
    	
    }
    
    public void moveToteToAutoZone() {
//    	start facing tote
//    	pick up tote, rotate
//    	drive to autozone
    	elevator.gripSolenoidOn();
    	Timer.delay(1.5);
    	elevator.setSpeed(-.75);;
    	Timer.delay(2); //TODO: test for delay
    	elevator.stopWinch(); // change this after holding point is established
    	driveTrain.setSpeed(-0.5, -0.5); //TODO: to be tested
    	Timer.delay(0.35); //TODO: test for delay
    	driveTrain.setSpeed(-autonomousSpeed);
    	Timer.delay(4); //TODO: test for delay
    	//driveTrain.stopRobot();
    }
    
    public void moveBinToAutoZone() {
//    	start facing bin
//    	pick up bin, rotate
//    	drive to autozone
    	elevator.gripSolenoidOn();
    	Timer.delay(1.5);
    	elevator.setSpeed(-.75);
    	Timer.delay(1.5); //TODO: test for delay
    	elevator.stopWinch(); // change this after holding point is established
    	elevator.setSpeed(Robot.ELEVATOR_HOLD_POSITION_SPEED);
    	driveTrain.setSpeed(-0.5, 0.5); //TODO: to be tested turning
    	Timer.delay(1); //TODO: test for delay
    	driveTrain.setSpeed(-autonomousSpeed);
    	Timer.delay(3); //TODO: test for delay
    	driveTrain.stopRobot();
    } 
    
    public void disableAutonomous() {
    	
    }
}
