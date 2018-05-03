package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PositionCenterAuto extends CommandGroup {

	// ALL VALUES ARE READ FROM THE BACK LEFT HAND CORNER BUMPER
	
    public PositionCenterAuto() {
        if (Robot.autoSubsystem.gameDataCheckSwitch() == "left") {
        		System.out.println("Center Left");
        		addSequential(new AutoDrive(0.8,0,1)); // Forward 1 foot
        		addSequential(new AutoDriveToAngle(90,-1)); // Rotate to -90 degrees
        		addSequential(new AutoDrive(0.8,0,1)); // Forward to perpendicular to switch
        		addSequential(new AutoDriveToAngle(90,1)); // Rotate to 0 degrees
        		addSequential(new LiftTime(0.8,2)); // Lift to switch height
        		addSequential(new AutoDrive(0.8,0,0.5)); // Forward to switch
        		addSequential(new ExtendArm()); // Release cube
        } else if (Robot.autoSubsystem.gameDataCheckSwitch() == "right") {
        	System.out.println("Center Right");
        		addSequential(new AutoDrive(0.8,0,1)); // Forward 1 foot
        		addSequential(new AutoDriveToAngle(90,1)); // Rotate to 90 degrees
        		addSequential(new AutoDrive(0.8,0,1)); // Forward to perpendicular to switch
        		addSequential(new AutoDriveToAngle(90,-1)); // Rotate to 0 degrees
        		addSequential(new LiftTime(0.8,2)); // Lift to switch height
        		addSequential(new AutoDrive(0.8,0,1)); // Forward to switch
        		addSequential(new ExtendArm()); // Release cube
        }
    }
}
