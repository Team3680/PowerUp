package org.usfirst.frc.team3680.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutonomousSubsystem extends Subsystem {
	
	public String outputGameData = DriverStation.getInstance().getGameSpecificMessage();


	public AutonomousSubsystem() {
		
		final String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

