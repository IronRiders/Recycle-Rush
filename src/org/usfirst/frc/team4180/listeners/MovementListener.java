package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class MovementListener implements JoystickListener {
	private DriveTrain driveTrain;
	
	public MovementListener(DriveTrain newDriveTrain){
		driveTrain = newDriveTrain;
	}
	
	@Override
	public void joystickMoved(double x, double y, double z) {
		//tolerance zone
		if(y > -.05 && y < .05){
			y = 0;
		}
		if(x > -.05 && x < .05){
			x = 0;
		}
		System.out.println("xx = " + x);
		System.out.println("yy = " + y);
//        driveTrain.updateX(x);
//        driveTrain.updateY(y);
//        driveTrain.updateSpeed();
	}

}
