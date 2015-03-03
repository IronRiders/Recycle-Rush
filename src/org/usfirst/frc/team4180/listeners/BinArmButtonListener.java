package org.usfirst.frc.team4180.listeners;

import org.usfirst.frc.team4180.robot.BinArm;

public class BinArmButtonListener implements ButtonListener {
	private BinArm arm;
	private boolean open;
	
	public BinArmButtonListener(BinArm arm) {
		this.arm = arm;
		open = true;
	}
	
	public void buttonDown() {
		if(open) {
			arm.retractArm();
		} else {
			arm.extendArm();
		}
		open = !open;
	}

	public void buttonUp() {}
}
