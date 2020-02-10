/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BackCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LaunchPrepCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Serializer;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 // commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public DriveTrain m_drivetrain;
  public DriveCommand m_driveCommand;
  // So basically
  public Joystick m_driverController;
  private Serializer m_serializer;
  private BackCommand m_backCommand;
  private LaunchPrepCommand m_launchPrepCommand;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    this.m_driverController = new Joystick(Constants.JOYSTICK);
    this.m_drivetrain = new DriveTrain();
    this.m_serializer = new Serializer();
    this.m_driveCommand = new DriveCommand((() -> this.m_driverController.getRawAxis(0)),
        (() -> this.m_driverController.getRawAxis(1)), this.m_drivetrain);
   // this.m_backCommand = new BackCommand(this.m_serializer);
    this.m_launchPrepCommand = new LaunchPrepCommand(this.m_serializer);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //JoystickButton  bob = new JoystickButton(m_driveController, 0);
    JoystickButton ballPrep = new JoystickButton(m_driverController, 1);
    JoystickButton ballsBack = new JoystickButton(m_driverController, 2);
    ballPrep.toggleWhenPressed(this.m_launchPrepCommand);
    ballsBack.toggleWhenPressed(this.m_backCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getTeleopCommand() {
    // An ExampleCommand will run in autonomous
    return this.m_driveCommand;
  }
}
