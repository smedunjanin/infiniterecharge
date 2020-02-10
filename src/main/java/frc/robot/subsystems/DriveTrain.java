/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  Spark leftBackSpark;
  Spark leftFrontSpark;
  Spark rightBackSpark;
  Spark rightFrontSpark;

  private DifferentialDrive differentialDrive;

  public DriveTrain() {
    leftBackSpark = new Spark(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
    leftFrontSpark = new Spark(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
    rightBackSpark = new Spark(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);
    rightFrontSpark = new Spark(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontSpark, leftBackSpark);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontSpark, rightBackSpark);

    // This works
    rightMotors.setInverted(true);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void differentialDrive(double xAxis, double yAxis) {
    // Drive
    this.differentialDrive.arcadeDrive(xAxis, yAxis);
  }
}