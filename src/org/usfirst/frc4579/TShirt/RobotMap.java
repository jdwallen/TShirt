// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.TShirt;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogGyro driveBaseAnalogGyro;
    public static SpeedController driveBaseLeftRearSpeedController;
    public static SpeedController driveBaseLeftFrontSpeedController;
    public static SpeedController driveBaseRightFrontSpeedController;
    public static SpeedController driveBaseRightRearSpeedController;
    public static RobotDrive driveBaseDriveMotors;
    public static AnalogPotentiometer liftArmLiftArmAnalogPotentiometer;
    public static SpeedController liftArmLiftArmSpeedController;
    public static PIDController liftArmLiftArmPIDController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveBaseAnalogGyro = new AnalogGyro(0);
        LiveWindow.addSensor("DriveBase", "AnalogGyro", driveBaseAnalogGyro);
        driveBaseAnalogGyro.setSensitivity(0.007);
        driveBaseLeftRearSpeedController = new Talon(1);
        LiveWindow.addActuator("DriveBase", "Left Rear Speed Controller", (Talon) driveBaseLeftRearSpeedController);
        
        driveBaseLeftFrontSpeedController = new Talon(0);
        LiveWindow.addActuator("DriveBase", "Left Front  Speed Controller", (Talon) driveBaseLeftFrontSpeedController);
        
        driveBaseRightFrontSpeedController = new Talon(2);
        LiveWindow.addActuator("DriveBase", "Right Front Speed Controller", (Talon) driveBaseRightFrontSpeedController);
        
        driveBaseRightRearSpeedController = new Talon(3);
        LiveWindow.addActuator("DriveBase", "Right Rear Speed Controller", (Talon) driveBaseRightRearSpeedController);
        
        driveBaseDriveMotors = new RobotDrive(driveBaseLeftFrontSpeedController, driveBaseLeftRearSpeedController,
              driveBaseRightFrontSpeedController, driveBaseRightRearSpeedController);
        
        driveBaseDriveMotors.setSafetyEnabled(true);
        driveBaseDriveMotors.setExpiration(0.1);
        driveBaseDriveMotors.setSensitivity(0.5);
        driveBaseDriveMotors.setMaxOutput(1.0);
        driveBaseDriveMotors.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveBaseDriveMotors.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        liftArmLiftArmAnalogPotentiometer = new AnalogPotentiometer(1, 1.0, 0.0);
        LiveWindow.addSensor("Lift Arm", "Lift Arm Analog Potentiometer", liftArmLiftArmAnalogPotentiometer);
        
        liftArmLiftArmSpeedController = new Talon(4);
        LiveWindow.addActuator("Lift Arm", "Lift Arm Speed Controller", (Talon) liftArmLiftArmSpeedController);
        
        liftArmLiftArmPIDController = new PIDController(1.0, 0.0, 0.0, 0.0, liftArmLiftArmAnalogPotentiometer, liftArmLiftArmSpeedController, 0.02);
        LiveWindow.addActuator("Lift Arm", "Lift Arm PID Controller", liftArmLiftArmPIDController);
        liftArmLiftArmPIDController.setContinuous(false);
        liftArmLiftArmPIDController.setAbsoluteTolerance(0.2);

        liftArmLiftArmPIDController.setOutputRange(-1.0, 1.0);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
