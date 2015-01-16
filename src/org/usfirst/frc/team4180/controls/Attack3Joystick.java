package org.usfirst.frc.team4180.controls;

public class Attack3Joystick extends edu.wpi.first.wpilibj.Joystick {
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
        
        private int buttonNumber;
        
        private Button(int buttonNumber) {
            this.buttonNumber = buttonNumber;
        }
        
        public int getButtonNumber() {
            return buttonNumber;
        }
        
        public String toString() {
            return "Button_" + buttonNumber;
        }
    } 
}
