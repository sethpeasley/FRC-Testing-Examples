// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    public static final class HoodConstants
    {
        public static final double k_hoodP = .0025;
        public static final double k_hoodI = 0;
        public static final double k_hoodD = 0.005;
        public static final double k_hoodTolerance = 5;
        public static final double k_hoodAutoSpeed = .5;

        public static final double limelightAngle = 32.4;// angle that the limelight is set at in degrees

        public static final double limelightHeight = 20.5; //from ground to limelight in inches
        public static final double goalHeight = 91.5; // LL crosshair height, found empirically
        public static final double heightDifference = goalHeight - limelightHeight;

    }
}
