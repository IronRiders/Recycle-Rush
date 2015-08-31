package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.elevator.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousRunner {
    private static final double AUTONOMOUS_SPEED = 0.5;
//    private AutonomousDial dial;
    private DriveTrain driveTrain;
    private Elevator elevator;
	private static final double SPEED_ON_TILE = 25.0;
	private static final double TURNING_RATE_ON_TILE = 115.0/2.0; //degree per second
	private static final double TURNING_RATE_ON_CARPET = 115.0/2.0;
    
    public AutonomousRunner(DriveTrain driveTrain, Elevator elevator) {
    	this.elevator = elevator;
    	this.driveTrain = driveTrain;
//    	this.dial = new AutonomousDial(2,3,4,5);
//      public void setAutonomous() {
//    	int position = dial.getPosition();
//    	switch(position) {
//    	case 1:
//    		disableAutonomous();
//    		break;
//    	case 2:
//    		driveToAutoZone();
//    		break;
//    	case 3:
//    		moveToteToAutoZone();
//    		break;
//    	case 4:
//    		moveBinToAutoZone();
//    		break;
//    	}
//    }
//    
//    public AutonomousDial getDial() {
//    	return dial;
//    }
    }
    
    public void driveToAutoZone() {
////    start in starting zone facing the autozone
		moveDistance(115);
    }
    
    //precondition: facing tote.
    public void moveToteToAutoZone() {
    	driveTrain.gearShiftSolenoidOn();
    	elevator.gripSolenoidOn();
    	Timer.delay(.6); //TODO:test
    	turnDegree(110);
    	driveToAutoZone();
    }
    
    public void moveBinToAutoZone() {
////    	start facing bin
    	//	grip bin
    		Timer.delay(5);
    		driveTrain.gearShiftSolenoidOn();
    		elevator.gripSolenoidReverse();
    		Timer.delay(.6); //TODO:test
    		elevator.stopWinch();
    		turnDegree(-110);
    		driveToAutoZone();
    } 
    
    public void toteAndBinToAutoZone(){
    	//grip bin
    	driveTrain.gearShiftSolenoidOn();
    	elevator.gripSolenoidOn();
    	Timer.delay(.6);//TODO:test
    	elevator.stopWinch();
    	//TODO: create a method in elevator which defines a distance to raise the arm
    	elevator.raiseArm(); 
    	Timer.delay(.6);//TODO:test
    	elevator.stopWinch();
    	moveDistance(20);
    	//set bin on tote
    	//TODO: create a method in elevator which defines a distance to lower the arms
    	elevator.lowerArm(); 
    	Timer.delay(.6);//TODO:test
    	elevator.stopWinch();
    	turnDegree(110);
    	driveToAutoZone();
    }
    
    private void moveDistance(double inches) { //calibrated for tile
    	driveTrain.setSpeed(-AUTONOMOUS_SPEED, -AUTONOMOUS_SPEED);
    	Timer.delay(inches/SPEED_ON_TILE);
    	driveTrain.stopRobot();
    }
    
    private void turnDegree(double degree) { //calibrated for tile
    	if(degree >= 0) { //greater than zero turns to the right
    		driveTrain.setSpeed(AUTONOMOUS_SPEED, -AUTONOMOUS_SPEED); 
    	} else { //this turns it to the left
        	driveTrain.setSpeed(-AUTONOMOUS_SPEED, AUTONOMOUS_SPEED); 
    	}
    	Timer.delay(Math.abs(degree)/TURNING_RATE_ON_TILE);
    	driveTrain.stopRobot();
    }
    public void testSpeed(){
    	driveTrain.setSpeed(0.1);
    }
    public void disableAutonomous() {
    	
    }
    
    public void testMovement() {
    	driveTrain.gearShiftSolenoidOff();
//    	moveDistance();
    	turnDegree(90);
//    	Timer.delay(1);
//    	turnDegree(-90);
    }
    
    public void testAcceleromter(){
    	driveTrain.setSpeed(-.25);
    }
}
