package org.usfirst.frc.team4180.robot;

/**
*
* @author Nate Spencer(A.K.A The Greatest)
*/
public enum Port {
	JOYSTICK_ONE (0),
	JOYSTICK_TWO(1),
	
	LEVEL_ZERO_LIMIT_SWITCH (0), 
	LEVEL_ONE_LIMIT_SWITCH (1), 
	LEVEL_TWO_LIMIT_SWITCH (2),
	LEVEL_THREE_LIMIT_SWITCH (3),
	LEVEL_FOUR_LIMIT_SWITCH (4),
	LEVEL_FIVE_LIMIT_SWITCH (5),
	
	RIGHT_TALONS (0),
	LEFT_TALONS (1),
	ELEVATION_WINCH_JAGUAR (2),
	
	PNEUMATIC_GEARBOX_SHIFTING (0),
	GRIPPER_PNEUMATIC_ACTUATOR (1);

	private int PORT_NUMBER;
	Port(int portNumber){
		PORT_NUMBER = portNumber;
	}
	
	public int GetPort() {
		return PORT_NUMBER;
	}
}

