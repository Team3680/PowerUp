
package org.usfirst.frc.team3680.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3680.robot.commands.DriveTeleop;
import org.usfirst.frc.team3680.robot.subsystems.DriveSubsystem;

public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	private VisionThread visionThread;
	public double centerX = 0.0;
	private final Object imgLock = new Object();
	
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new DriveTeleop());
		SmartDashboard.putData("Auto mode", chooser);
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setExposureManual(75);
		
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (imgLock) {
	                centerX = r.x + (r.width / 2);
	            }
	        }
	    });
	    visionThread.start();
	    Robot.driveSubsystem.gyro.reset();
		Robot.driveSubsystem.gyro.calibrate();
	    
		}
	


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		double centerX;
		synchronized (imgLock) {
			centerX = this.centerX;
		}
		System.out.println(driveSubsystem.gyro.getAngle());
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
