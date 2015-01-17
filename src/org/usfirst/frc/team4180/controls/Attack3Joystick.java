package org.usfirst.frc.team4180.controls;

import java.util.ArrayList;
import java.util.Hashtable;

import org.usfirst.frc.team4180.listeners.ButtonListener;
import org.usfirst.frc.team4180.listeners.JoystickListener;

public class Attack3Joystick extends edu.wpi.first.wpilibj.Joystick{
    
    private Hashtable<Button,ArrayList<ButtonListener>> BUTTON_LISTENERES;
    private ArrayList<JoystickListener> JOYSTICK_LISTENERS;
    private Thread[] THREADS;
    private Hashtable STATE;
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
        BUTTON_LISTENERES = new Hashtable();
        STATE = new Hashtable();
    }
        
    public void listen() {
        for (int i = 0; i < BUTTONS.length; i++) {
            final Button button = BUTTONS[i];
            
            final Boolean isPressed = Boolean.valueOf(getRawButton(button.getButtonNumber()));
            
            final Boolean wasPressed;
            if(((Boolean)STATE.get(button)) == null){
                wasPressed = Boolean.valueOf(!isPressed.booleanValue());
            }
            else{
                wasPressed = ((Boolean)STATE.get(button));
            }
            
            //if (THREADS[button.getButtonNumber() - 1] == null) {
            //    THREADS[button.getButtonNumber() - 1] = new Thread() {
            //        public void run(){
                        notifyButtonListeners(button, isPressed.booleanValue(), wasPressed.booleanValue());
            //        }
            //    };
            //}
            
            //if (THREADS[button.getButtonNumber() - 1] != null) {
            //    THREADS[button.getButtonNumber() - 1].start();
            //}
            
            // Save the new STATE of the button
            STATE.put(button, isPressed);
        }
        
        notifyJoystickListeners();
        
    } 
    
    public void addButtonListener(Button button, ButtonListener listener) {
        if (!BUTTON_LISTENERES.contains(button)) {
            BUTTON_LISTENERES.put(button, new ArrayList<ButtonListener>());
        }
        
        BUTTON_LISTENERES.get(button).add(listener);
    }
    
    public void addButtonListener(Button[] buttons, ButtonListener listener){
        for(int i = 0; i < buttons.length; i++){
            addButtonListener(buttons[i], listener);
            //System.out.println("Attached Button Listener");
        }
    }
           
    private void notifyButtonListeners(Button button, boolean isPressed, boolean wasPressed ) {
        ArrayList<ButtonListener> listeners = BUTTON_LISTENERES.get(button);
        if(listeners != null) {
        	if (isPressed && !wasPressed) {
                for (int count = 0; count < listeners.size(); count++){
                    ButtonListener bl = (ButtonListener)listeners.get(count);
                     // re-add the line below after the method has been implemented
//                    bl.buttonDown(button);
                }
            }
            else if (!isPressed && wasPressed) {
                for (int count = 0; count < listeners.size(); count++){
                    ButtonListener bl = (ButtonListener)listeners.get(count);
                 // re-add the line below after the method has been implemented
//                    bl.buttonUp(button);
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