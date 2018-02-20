package org.usfirst.frc.team3680.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExtenderSubsystem extends Subsystem {
	
	public DoubleSolenoid extenderSolenoid;

    public ExtenderSubsystem() {
    		extenderSolenoid = new DoubleSolenoid(0,1);
    }
    
    public void extendExtender(String extended) { 
    		if(extended == "true") {
    			extenderSolenoid.set(DoubleSolenoid.Value.kForward);
    		} else if (extended == "false") {
    			extenderSolenoid.set(DoubleSolenoid.Value.kReverse);
    		} else if (extended == "off") {
    			extenderSolenoid.set(DoubleSolenoid.Value.kOff);
    		}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

