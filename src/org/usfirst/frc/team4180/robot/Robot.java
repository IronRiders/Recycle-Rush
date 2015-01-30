
package org.usfirst.frc.team4180.robot;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.usfirst.frc.team4180.controls.Attack3Joystick;
import org.usfirst.frc.team4180.elevator.Elevator;
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
	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	elevator = new Elevator();
    	driveTrain = new DriveTrain();
    	joystick1 = new Attack3Joystick(Port.JOYSTICK_ONE.GetPort());
    	joystick2 = new Attack3Joystick(Port.JOYSTICK_TWO.GetPort());
    	
    	movementListener = new MovementListener(driveTrain);
    	button1Listener = new GearShiftButtonListener(driveTrain);
    	
    	joystick1.addJoystickListener(movementListener);
    	joystick1.addButtonListener(Attack3Joystick.Button.BUTTON_1, button1Listener);
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
    }
    
    public void teleopInit(){
    	
    }
    
    public void autonomousInit(){
    	
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
