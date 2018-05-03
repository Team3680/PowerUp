package org.usfirst.frc.team3680.robot.subsystems;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutonomousSubsystem extends Subsystem {
	
	public String gameData;


	public AutonomousSubsystem() {
		
		
	}
	
	public double gyroValue() {
		return Robot.driveSubsystem.getGyroAngle();
	}
	
	public String gameDataCheckSwitch() {
		if(DriverStation.getInstance().getGameSpecificMessage() != null) {
			gameData = new String(DriverStation.getInstance().getGameSpecificMessage());
		} else {
			gameData = new String("LLL");
		}
		if(gameData.charAt(0) == 'L') {
			return "left";
		} else if(gameData.charAt(0) == 'R') {
			return "right";
		} else {
			return null;
		}
	}
	
	public String gameDataCheckScale() {
		if(DriverStation.getInstance().getGameSpecificMessage() != null) {
			gameData = new String(DriverStation.getInstance().getGameSpecificMessage());
		} else {
			gameData = new String("LLL");
		}
		if(gameData.charAt(1) == 'L') {
			return "left";
		} else if(gameData.charAt(1) == 'R') {
			return "right";
		} else {
			return null;
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

