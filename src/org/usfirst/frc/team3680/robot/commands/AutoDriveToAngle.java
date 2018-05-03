package org.usfirst.frc.team3680.robot.commands;

import org.usfirst.frc.team3680.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveToAngle extends Command {
	
	public double commandAngle;
	public double commandRotationDirection;
	public double commandRotationSpeed;

    public AutoDriveToAngle(double angle, double rotationDirection) {
        requires(Robot.driveSubsystem);
        commandAngle = angle;
        commandRotationDirection = rotationDirection;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.driveSubsystem.gyro.reset();
    		setTimeout(10);
    		System.out.println(commandAngle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    //	while(Robot.driveSubsystem.getGyroAngle() > commandAngle*0.95 || Robot.driveSubsystem.getGyroAngle() < commandAngle*1.05 && DriverStation.getInstance().isAutonomous()) {
    		Robot.driveSubsystem.arcadeDrive(0,commandRotationDirection*0.7);
    //	}
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(Robot.driveSubsystem.getGyroAngle()) > commandAngle*0.98 && Math.abs(Robot.driveSubsystem.getGyroAngle()) < commandAngle*1.02) {
        		return true;
        } else {
        		return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    		System.out.println(Robot.driveSubsystem.gyro.getAngle());
    		
    		Robot.driveSubsystem.arcadeDrive(0,0);
 
    		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
