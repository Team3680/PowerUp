package org.usfirst.frc.team3680.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3680.robot.Robot;

public class DriveTeleop extends Command {
	public DriveTeleop() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.driveSubsystem.arcadeDrive(-Robot.oi.getRightY(), Robot.oi.getRightX());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
