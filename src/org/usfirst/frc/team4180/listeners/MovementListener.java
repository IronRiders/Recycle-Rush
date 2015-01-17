package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.DriveTrain;

public class MovementListener implements JoystickListener {
	private DriveTrain driveTrain;
	
	@Override
	public void joystickMoved(double x, double y, double z) {
		// TODO Auto-generated method stub
		System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        driveTrain.updateX(x);
        driveTrain.updateY(y);
        driveTrain.updateSpeed();
	}

}
