package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitch extends CommandGroup {

    public AutoSwitch() {
    		//addSequential(new AutoDrive(0.8,0,5));
    		addSequential(new AutoDriveToAngle(90,1));
    		addSequential(new AutoDrive(0.25,0,1));
    		addSequential(new AutoDriveToAngle(180,1));
    		// addSequential(new ArmToSwitch());
    		// addSequential(new ArmRelease());
    		// addSequential(new ArmDown());
    }
    
}
