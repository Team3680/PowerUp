
package org.usfirst.frc.team3680.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
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
	SendableChooser<Command> chooser = new SendableChooser<>();
	// private VisionThread visionThread;
	public double centerX = 0.0;
	private final Object imgLock = new Object();
	
	@Override
	public void robotInit() {
		oi = new OI();
		SmartDashboard.putData("Autonomous Chooser", chooser);
		
		/*UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setExposureManual(75);
		
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (imgLock) {
	                centerX = r.x + (r.width / 2);
	            }
	        }
	    });
	    visionThread.start(); */
	    
	    Robot.driveSubsystem.gyro.reset();
		Robot.driveSubsystem.gyro.calibrate();
		Robot.liftSubsystem.encoder.reset();
		
		chooser.addObject("Nothing", null);
		chooser.addDefault("AutoSwitch", new AutoSwitch());
		
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
		if(chooser.getSelected() != null) {
			chooser.getSelected().start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Angle", Robot.driveSubsystem.getGyroAngle());
	}

	@Override
	public void teleopInit() {
		chooser.getSelected().cancel();
		compressor.start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Angle", Robot.driveSubsystem.getGyroAngle());
		/*double centerX;
		synchronized (imgLock) {
			centerX = this.centerX;
		} */
		
		if(Robot.liftSubsystem.getLimitSwitch() == true) {
			Robot.liftSubsystem.resetEncoder();
		}
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
