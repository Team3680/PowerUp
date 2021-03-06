package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PositionRightAuto extends CommandGroup {

    public PositionRightAuto() {
    	addSequential(new AutoDrive(0.75,0,2.8));
    	if(Robot.autoSubsystem.gameDataCheckSwitch() == "right") {
    		addSequential(new AutoDriveToAngle(90,-1));
    		addSequential(new LiftTime(0.8,2));
        	addSequential(new AutoDrive(0.75,0,0.3));
        	addSequential(new ExtendArm());
    	} else if (Robot.autoSubsystem.gameDataCheckSwitch() == "left") {
    		// Do nothing please. :D
    	}
    }
}
