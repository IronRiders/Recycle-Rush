package org.usfirst.frc.team4180.robot;

import edu.wpi.first.wpilibj.Jaguar;

public class BinArm {
	private Jaguar arm;
	
	public BinArm() {
		arm = new Jaguar(Port.BIN_ARM_JAGUAR.GetPort());
		arm.set(0);
	}
	
	public void retractArm() {
		arm.setPosition(0.0);
	}
	
	public void extendArm() {
		arm.setPosition(.25);
	}
	
	public void stopArm() {
		arm.set(0);
	}
}
