// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.TShirt.subsystems;

import org.usfirst.frc4579.TShirt.Robot;
import org.usfirst.frc4579.TShirt.RobotMap;
import org.usfirst.frc4579.TShirt.commands.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.filters.LinearDigitalFilter;

/**
 *
 */
public class DriveBase extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogGyro analogGyro = RobotMap.driveBaseAnalogGyro;
    private final SpeedController leftRearSpeedController = RobotMap.driveBaseLeftRearSpeedController;
    private final SpeedController leftFrontSpeedController = RobotMap.driveBaseLeftFrontSpeedController;
    private final SpeedController rightFrontSpeedController = RobotMap.driveBaseRightFrontSpeedController;
    private final SpeedController rightRearSpeedController = RobotMap.driveBaseRightRearSpeedController;
    private final RobotDrive driveMotors = RobotMap.driveBaseDriveMotors;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //private LinearDigitalFilter m_xFilter = new LinearDigitalFilter();
    
    
    private double m_xPosFiltered  = 0.0; // Filtered value of joystick X position
    private double m_yPosFiltered  = 0.0; // Filtered value of joystick Y position
    private double m_twistFiltered = 0.0; // Filtered value of joystick twist
    private double m_gyroFiltered  = 0.0; // Filtered value of gyro angle
    
    // Get the filtered values of the drive inputs and invoke the mechanum drive.
    public void mechanumDrive () {
    	
    	double X = Robot.oi.getJoystick1().getX();
    	double Y = Robot.oi.getJoystick1().getY();
    	double T = Robot.oi.getJoystick1().getTwist();
    	
    	// Implement filter?
    	m_xPosFiltered  = X;
    	m_yPosFiltered  = Y;
    	m_twistFiltered = T;
    	m_gyroFiltered  = analogGyro.getAngle();
    	
    	/* The gyro rotation will adjust the rotation value supplied, in this case, from the twist axis 
    	 * of the joystick to be relative to the field rather than relative to the robot. This is particularly
    	 * useful with mecanum drive since, for the purposes of steering, the robot really has no front, 
    	 * back or sides. It can go in any direction. Adding the angle in degrees from a gyro object will 
    	 * cause the robot to move away from the drivers when the joystick is pushed forwards, and towards 
    	 * the drivers when it is pulled towards them - regardless of what direction the robot is facing!
    	 *
    	 * The use of field-oriented driving makes often makes the robot much easier to drive, especially 
    	 * compared to a "robot-oriented" drive system where the controls are reversed when the robot is 
    	 * facing the drivers. */
    	
    	// Compensate for wheel slippage?
    	
    	driveMotors.mecanumDrive_Cartesian(m_xPosFiltered, m_yPosFiltered, m_twistFiltered, m_gyroFiltered);
	
    }
    
    // Stop all speed controllers.
    public void stop () {
    	
    	leftRearSpeedController  .stopMotor();
    	leftFrontSpeedController .stopMotor();
    	rightFrontSpeedController.stopMotor();
    	rightRearSpeedController .stopMotor();
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DefaultMechanumDrive());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

