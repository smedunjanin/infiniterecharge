/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Motors
    public static final int DRIVETRAIN_RIGHT_FRONT_SPARK = 2;
    public static final int DRIVETRAIN_LEFT_FRONT_SPARK = 1;
    public static final int DRIVETRAIN_RIGHT_BACK_SPARK = 3;
    public static final int DRIVETRAIN_LEFT_BACK_SPARK = 0;
    //Serializer Motors
    public static final int TOP_SERIALIZER_MOTOR = 0;
    public static final int BOTTOM_SERIALIZER_MOTOR = 0;
    // public static final int SERIALIZER_MOTOR = 0; For use with Falcon 500

    // Sensors
    public static final int PHOTOELECTRIC_SENSOR_1 = 7;
    public static final int PHOTOELECTRIC_SENSOR_2 = 8;
    public static final int PHOTOELECTRIC_SENSOR_3 = 9;
    // Controllers
    public static final int JOYSTICK = 0;
}