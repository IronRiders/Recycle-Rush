
package org.usfirst.frc.team4180.robot;

import org.usfirst.frc.team4180.controls.Attack3Joystick;
import org.usfirst.frc.team4180.elevator.Elevator;
import org.usfirst.frc.team4180.listeners.Button1Listener;
import org.usfirst.frc.team4180.listeners.Button2Listener;
import org.usfirst.frc.team4180.listeners.MovementListener;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private DriveTrain driveTrain; 
    private Elevator elevator;
    private Attack3Joystick joystick1;
    private Attack3Joystick joystick2;
    private MovementListener movementListener;
    private Button1Listener button1Listener;
    //private AnalogInput holofexTest;
	
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
    	button1Listener = new Button1Listener(driveTrain);
    	
    	joystick1.addJoystickListener(movementListener);
    	joystick1.addButtonListener(Attack3Joystick.Button.BUTTON_1, button1Listener);
    	//joystick1.addButtonListener(Attack3Joystick.Button.BUTTON_2, new Button2Listener(elevator));
    	//holofexTest = new AnalogInput(0);
    	//System.out.println("Aaron is butt da first time: " + holofexTest.getChannel());
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
    	//System.out.println("Aaron is a butt: " + holofexTest.getChannel());
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
