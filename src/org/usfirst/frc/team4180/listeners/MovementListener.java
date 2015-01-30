package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class MovementListener implements JoystickListener {
	private DriveTrain driveTrain;
	
	public MovementListener(DriveTrain newDriveTrain){
		driveTrain = newDriveTrain;
	}
	
	@Override
	public void joystickMoved(double x, double y, double z) {
		// TODO Auto-generated method stub
////		if(x == 0 || y == 0){
//			System.out.println("MovementListener: x = " + x);
//			System.out.println("MovementListener: y = " + y);
////		}
		if((y < .05 && y > 0) || (y > -.05 && y < 0)){
			y = 0;
		}
		if((x < .05 && x > 0) || (x > -.05 && x < 0)){
			x = 0;
		}
        driveTrain.updateX(x);
        driveTrain.updateY(y);
        driveTrain.updateSpeed();
	}

}
