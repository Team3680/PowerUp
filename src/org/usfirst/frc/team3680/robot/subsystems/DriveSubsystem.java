package org.usfirst.frc.team3680.robot.subsystems;

import org.usfirst.frc.team3680.robot.RobotMap;
import org.usfirst.frc.team3680.robot.commands.DriveTeleop;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	
	private Victor left1, left2, right1, right2;
	private DifferentialDrive robotDrive;
	public ADXRS450_Gyro gyro;

	public DriveSubsystem() {
		left1 = new Victor(RobotMap.driveControllerLeftFront);
		left2 = new Victor(RobotMap.driveControllerLeftBack);
		SpeedControllerGroup d_left = new SpeedControllerGroup(left1, left2);
		
		right1 = new Victor(RobotMap.driveControllerRightFront);
		right2 = new Victor(RobotMap.driveControllerRightBack);
		SpeedControllerGroup d_right = new SpeedControllerGroup(right1, right2);
		
		robotDrive = new DifferentialDrive(left1, right1);
		gyro = new ADXRS450_Gyro();
	}
	
	public void arcadeDrive(double forward, double rotation) {
		robotDrive.arcadeDrive(rotation, forward);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTeleop());
	}
}
