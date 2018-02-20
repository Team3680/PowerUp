package org.usfirst.frc.team3680.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberSubsystem extends Subsystem {

    public DoubleSolenoid grabberSolenoid;
    
    public GrabberSubsystem() {
    		grabberSolenoid = new DoubleSolenoid(2,3);
    }
    
    public void clampGrabber(String clamped) { 
		if(clamped == "true") {
			grabberSolenoid.set(DoubleSolenoid.Value.kForward);
		} else if (clamped == "false") {
			grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else if (clamped == "off") {
			grabberSolenoid.set(DoubleSolenoid.Value.kOff);
		}
}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

