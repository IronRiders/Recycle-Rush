package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class AutonomousDial {
    private DigitalInput positionOne;
    private DigitalInput positionTwo;
    private DigitalInput positionThree;
    private DigitalInput positionFour;
    
    public AutonomousDial(int positionOne, int positionTwo, int positionThree, int positionFour) {
        this.positionOne = new DigitalInput(positionOne);
        this.positionTwo = new DigitalInput(positionTwo);
        this.positionThree = new DigitalInput(positionThree);
        this.positionFour = new DigitalInput(positionFour);
    }
    
    public int getPosition() {
        if(!positionOne.get()) {
            return 1;
        } else if(!positionTwo.get()) {
            return 2;
        } else if(!positionThree.get()) {
        	return 3;
        } else if(!positionFour.get()) {
        	return 4;
        } else {
        	return 0;
        }
    }
}

