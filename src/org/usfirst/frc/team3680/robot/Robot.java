
package org.usfirst.frc.team3680.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3680.robot.commands.AutoSwitch;
import org.usfirst.frc.team3680.robot.commands.DriveTeleop;
import org.usfirst.frc.team3680.robot.commands.PositionCenterAuto;
import org.usfirst.frc.team3680.robot.commands.PositionLeftAuto;
import org.usfirst.frc.team3680.robot.commands.PositionRightAuto;
import org.usfirst.frc.team3680.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.ExtenderSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.GrabberSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team3680.robot.subsystems.AutonomousSubsystem;

public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final AutonomousSubsystem autoSubsystem = new AutonomousSubsystem();
	public static final LiftSubsystem liftSubsystem = new LiftSubsystem();
	public static final ExtenderSubsystem extenderSubsystem = new ExtenderSubsystem();
	public static final GrabberSubsystem grabberSubsystem = new GrabberSubsystem();
	
	public static OI oi;
	public Compressor compressor = new Compressor(0);

	Command autonomousCommand;
	SendableChooser<Command> chooser1 = new SendableChooser<Command>();
	public static String gameData;
	
	@Override
	public void robotInit() {
		oi = new OI();
		gameData = new String();
	    
	    Robot.driveSubsystem.gyro.reset();
		Robot.driveSubsystem.gyro.calibrate();
		Robot.liftSubsystem.encoder.reset();
		
		chooser1.addObject("Nothing", null);
		chooser1.addObject("Position Left", new PositionLeftAuto());
		chooser1.addDefault("Position Center", new PositionCenterAuto());
		chooser1.addObject("Position Right", new PositionRightAuto());
		SmartDashboard.putData("Autonomous Chooser Me", chooser1);
		compressor.start();
		}
	


	@Override
	public void disabledInit() {
		compressor.stop();

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		if(DriverStation.getInstance().getGameSpecificMessage() != null) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		} else {
			gameData = "LLL";
		}
		if (chooser1.getSelected() != null) {
			chooser1.getSelected().start();
		}
		//autonomousCommand = new PositionLeftAuto();
		//autonomousCommand.start();
		compressor.start();
	}

	@Override
	public void autonomousPeriodic() {
		//System.out.println(Robot.driveSubsystem.getGyroAngle());
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (chooser1.getSelected() != null) {
			chooser1.getSelected().cancel();
		}
		
		compressor.start();
		
	 //if(autonomousCommand != null) { autonomousCommand.cancel(); }
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void testPeriodic() {
	}
}
