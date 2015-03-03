
package org.usfirst.frc.team4180.robot;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.usfirst.frc.team4180.controls.Attack3Joystick;
import org.usfirst.frc.team4180.elevator.Elevator;
import org.usfirst.frc.team4180.listeners.BinArmButtonListener;
import org.usfirst.frc.team4180.listeners.ElevationListener;
import org.usfirst.frc.team4180.listeners.ElevatorSolenoidListener;
import org.usfirst.frc.team4180.listeners.GearShiftButtonListener;
import org.usfirst.frc.team4180.listeners.Button2Listener;
import org.usfirst.frc.team4180.listeners.MovementListener;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
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
	public static final double ELEVATOR_HOLD_POSITION_SPEED = -.2;
    public DriveTrain driveTrain; 
    public BinArm binArm;
    public Elevator elevator;
    private Attack3Joystick joystick1;
    private Attack3Joystick joystick2;
    private MovementListener movementListener;
    private GearShiftButtonListener button1Listener;
    private ElevatorSolenoidListener elevatorSolenoidListener;
    private ElevationListener elevationListener;
    private BinArmButtonListener binArmListener;
    private AutonomousRunner autonomousRunner;
	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	elevator = new Elevator();
    	driveTrain = new DriveTrain();
    	binArm = new BinArm();
    	autonomousRunner = new AutonomousRunner(driveTrain, elevator);
    	joystick1 = new Attack3Joystick(Port.JOYSTICK_ONE.GetPort());
    	joystick2 = new Attack3Joystick(Port.JOYSTICK_TWO.GetPort());
    	
    	movementListener = new MovementListener(driveTrain);
    	button1Listener = new GearShiftButtonListener(driveTrain);
    	elevationListener = new ElevationListener(elevator);
    	elevatorSolenoidListener = new ElevatorSolenoidListener(elevator);
    	binArmListener = new BinArmButtonListener(binArm);
    	
    	joystick1.addJoystickListener(movementListener);
    	joystick1.addButtonListener(Attack3Joystick.Button.BUTTON_1, button1Listener);
    	joystick2.addButtonListener(Attack3Joystick.Button.BUTTON_1, elevatorSolenoidListener);
    	joystick2.addButtonListener(Attack3Joystick.Button.BUTTON_2, binArmListener);
    	joystick2.addJoystickListener(elevationListener);
    	
//    	CameraServer camera = CameraServer.getInstance();
//    	camera.setQuality(50);
//    	camera.startAutomaticCapture("cam0");
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
    	int position = autonomousRunner.getDial().getPosition();
    	joystick1.listen();
    	joystick2.listen();
//    	elevator.updateLimitSwitches();
    }
    
    public void teleopInit(){
//    	driveTrain.gearShiftSolenoidOn();
    }
    
    public void autonomousInit(){
//     	autonomousRunner.driveToAutoZone();
//    	autonomousRunner.moveToteToAutoZone();
    	
//    	autonomousRunner.moveBinToAutoZone();
//    	autonomousRunner.setAutonomous();
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
