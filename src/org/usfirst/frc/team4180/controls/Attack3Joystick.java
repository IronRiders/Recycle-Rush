package org.usfirst.frc.team4180.controls;

import java.util.ArrayList;
import java.util.Hashtable;

import org.usfirst.frc.team4180.listeners.ButtonListener;
import org.usfirst.frc.team4180.listeners.JoystickListener;
import org.usfirst.frc.team4180.robot.Robot;

public class Attack3Joystick extends edu.wpi.first.wpilibj.Joystick{
    
    private Hashtable<Button,ArrayList<ButtonListener>> BUTTON_LISTENERS;
    private ArrayList<JoystickListener> JOYSTICK_LISTENERS;
    private Thread[] THREADS;
    private Hashtable<Button,Boolean> STATE;
    public static final Button[] BUTTONS = new Button[] {
        Button.BUTTON_1,  
        Button.BUTTON_2,  
        Button.BUTTON_3, 
        Button.BUTTON_4,
        Button.BUTTON_5, 
        Button.BUTTON_6, 
        Button.BUTTON_7, 
        Button.BUTTON_8,
        Button.BUTTON_9, 
        Button.BUTTON_10, 
        Button.BUTTON_11};
    
    public Attack3Joystick(int port) {
        super(port);
        THREADS = new Thread[BUTTONS.length];
        JOYSTICK_LISTENERS = new ArrayList<JoystickListener>();
        BUTTON_LISTENERS = new Hashtable<Button,ArrayList<ButtonListener>>();
        STATE = new Hashtable<Button,Boolean>();
    }
        
    public void listen() {
        for (int i = 0; i < BUTTONS.length; i++) {
           Button button = BUTTONS[i];
            
            boolean isPressed = Boolean.valueOf(getRawButton(button.getButtonNumber()));
            
            boolean wasPressed;
            if(STATE.get(button) == null) {
                wasPressed = Boolean.valueOf(!isPressed);
            } else {
                wasPressed = STATE.get(button);
            }
            
           notifyButtonListeners(button, isPressed, wasPressed);
            
            STATE.put(button, isPressed);
        }
        
        notifyJoystickListeners();
        
    } 
    
    public void addButtonListener(Button button, ButtonListener listener) {
        if (!BUTTON_LISTENERS.contains(button)) {
        	
            BUTTON_LISTENERS.put(button, new ArrayList<ButtonListener>());
        }
        
        BUTTON_LISTENERS.get(button).add(listener);
    }
    
    public void addButtonListener(Button[] buttons, ButtonListener listener){
        for(int count = 0; count < buttons.length; count++){
            addButtonListener(buttons[count], listener);
        }
    }
           
    private void notifyButtonListeners(Button button, boolean isPressed, boolean wasPressed ) {
        ArrayList<ButtonListener> listeners = BUTTON_LISTENERS.get(button);
        if(listeners != null) {
        	if (isPressed && !wasPressed) {
                for (int count = 0; count < listeners.size(); count++){
                    ButtonListener buttonListener = listeners.get(count); //count);
                    buttonListener.buttonDown();
                }
            } else if (!isPressed && wasPressed) {
                for (int count = 0; count < listeners.size(); count++){
                    ButtonListener buttonListener = listeners.get(count);
                    buttonListener.buttonUp();
                }
            }
        }
        
        
    }
    
    public void addJoystickListener(JoystickListener listener){
        if (listener == null){
           System.out.println("Listener Nonexistant");
           return;
        }
        
        JOYSTICK_LISTENERS.add(listener);
        System.out.println("Attached Joystick Listener");
    }
    
    private void notifyJoystickListeners(){
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        z = (-z+1)/2;
        
        for(int count = 0; count < JOYSTICK_LISTENERS.size(); count ++){
            JoystickListener joystickListener = JOYSTICK_LISTENERS.get(count);
            if (joystickListener == null){
                System.out.println("No Listener at Index "+ count);
            }
            joystickListener.joystickMoved(x, y, z);
        }
    }
    
    public static class Button {
        
        public static final Button BUTTON_1 = new Button(1);
        public static final Button BUTTON_2 = new Button(2);
        public static final Button BUTTON_3 = new Button(3);
        public static final Button BUTTON_4 = new Button(4);
        public static final Button BUTTON_5 = new Button(5);
        public static final Button BUTTON_6 = new Button(6);
        public static final Button BUTTON_7 = new Button(7);
        public static final Button BUTTON_8 = new Button(8);
        public static final Button BUTTON_9 = new Button(9);
        public static final Button BUTTON_10 = new Button(10);
        public static final Button BUTTON_11 = new Button(11);
        
        private int BUTTON_NUMBER;
        
        private Button(int buttonNumber) {
            this.BUTTON_NUMBER = buttonNumber;
        }
        
        public int getButtonNumber() {
            return BUTTON_NUMBER;
        }
        
        public String toString() {
            return "Button_" + BUTTON_NUMBER;
        }
    } 
}
