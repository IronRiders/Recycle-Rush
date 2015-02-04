
package org.usfirst.frc.team4180.robot;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.usfirst.frc.team4180.controls.Attack3Joystick;
import org.usfirst.frc.team4180.elevator.Elevator;
import org.usfirst.frc.team4180.listeners.ElevationListener;
import org.usfirst.frc.team4180.listeners.GearShiftButtonListener;
import org.usfirst.frc.team4180.listeners.Button2Listener;
import org.usfirst.frc.team4180.listeners.MovementListener;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private final int AUTONOMOUS_DELAY = 10;
    public static DriveTrain driveTrain; 
    private Elevator elevator;
    private Attack3Joystick joystick1;
    private Attack3Joystick joystick2;
    private MovementListener movementListener;
    private GearShiftButtonListener button1Listener;
    private ElevationListener elevationListener;
    private DigitalInput autoSwitch1 = new DigitalInput(Port.AUTO_SWITCH_1.GetPort());
    private DigitalInput autoSwitch2 = new DigitalInput(Port.AUTO_SWITCH_2.GetPort());
    
	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	elevator = new Elevator();
    	driveTrain = new DriveTrain();
    	joystick1 = new Attack3Joystick(Port.JOYSTICK_ONE.GetPort());
    	joystick2 = new Attack3Joystick(Port.JOYSTICK_TWO.GetPort());
    	
//    	movementListener = new MovementListener(driveTrain);
//    	button1Listener = new GearShiftButtonListener(driveTrain);
    	elevationListener = new ElevationListener(elevator);
    	
//    	joystick1.addJoystickListener(movementListener);
//    	joystick1.addButtonListener(Attack3Joystick.Button.BUTTON_1, button1Listener);
    	joystick2.addJoystickListener(elevationListener);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
 	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	joystick1.listen();
    	joystick2.listen();
    	elevator.updateLimitSwitches();
    }
    
    public void teleopInit(){
//    	driveTrain.gearShiftSolenoidOn();
    }
    
    public void autonomousInit(){
    	if(autoSwitch1.get() && autoSwitch2.get()) {
    		//enable autonomous
    		//mode 1
    	} else if(autoSwitch1.get() && !autoSwitch2.get()) {
    		//enable autonomous
    		//mode 2
    	} else if(!autoSwitch1.get() && autoSwitch2.get()) {
    		//enable autonomous
    		//mode 3
    	} else {
    		//disable autonomous
    		//mode 4
    	}
    }
    
    public void disabledInit(){
    	
    }
    
    public void disabledPeriodic(){
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    /**
     * Official FRC java programming resource
     * https://wpilib.screenstepslive.com/s/4485/m/13809
     * First API
     * http://first.wpi.edu/FRC/roborio/release/docs/java/annotated.html
     */
    
}
