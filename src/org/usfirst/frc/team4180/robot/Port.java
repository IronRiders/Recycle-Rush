package org.usfirst.frc.team4180.robot;

/**
*
* @author Nate Spencer(A.K.A The Greatest)
*/
public enum Port {
	JOYSTICK_ONE (0),
	JOYSTICK_TWO(1),
	
	BOTTOM_LIMIT_SWITCH (0), 
	TOP_LIMIT_SWITCH (1),
	
	RIGHT_TALONS (0),
	LEFT_TALONS (1),
	ELEVATION_WINCH_JAGUAR (2),
	
	PNEUMATIC_GEARBOX_SHIFTING_FORWARD (0),
	PNEUMATIC_GEARBOX_SHIFTING_REVERSE (1),
	GRIPPER_PNEUMATIC_ACTUATOR_FORWARD (2),
	GRIPPER_PNEUMATIC_ACTUATOR_REVERSE (3);
	

	private int PORT_NUMBER;
	Port(int portNumber){
		PORT_NUMBER = portNumber;
	}
	
	public int GetPort() {
		return PORT_NUMBER;
	}
}

