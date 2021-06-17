// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants.SwerveDriveModuleConstants.HoodConstants;
import frc.robot.Constants.SwerveDriveModuleConstants.ShooterConstants;

public class HoodSubsystem extends SubsystemBase 
{
    private PIDController m_hoodPID;
    private TalonSRX m_hoodMotor;

    private DutyCycleEncoder m_hexAbsoluteEncoder;
    private Encoder m_hexQuadEncoder;
  
    private double m_hoodRotations;
    private static double m_quadOffset;
  
    
    /** */


    /**
     * Creates a Hood Subsystem. The Hood includes the motor to move the  
     * @param hoodMotor
     * @param hexAbsoluteEncoder
     * @param hexQuadEncoder
     */
    public HoodSubsystem(TalonSRX hoodMotor, DutyCycleEncoder hexAbsoluteEncoder, Encoder hexQuadEncoder) 
    {
        m_hoodMotor = hoodMotor;
        m_hexAbsoluteEncoder = hexAbsoluteEncoder;
        m_hexQuadEncoder = hexQuadEncoder;
        
        m_hoodPID = new PIDController(HoodConstants.k_hoodP, HoodConstants.k_hoodI, HoodConstants.k_hoodD);
        m_hoodPID.setTolerance(HoodConstants.k_hoodTolerance);

        m_hoodMotor.configOpenloopRamp(ShooterConstants.k_rampRate);
        m_hoodMotor.setNeutralMode(NeutralMode.Brake); 
    
        m_hexQuadEncoder.setReverseDirection(true);
        m_hexQuadEncoder.reset();
        m_hoodPID.disableContinuousInput();

        adjustHood();

    }

    @Override
    public void periodic() 
    {
        // This method will be called once per scheduler run
        m_hoodRotations = m_hexAbsoluteEncoder.get();
        SmartDashboard.putNumber("Hood Abs Encoder", getAbsEncoder());
        SmartDashboard.putNumber("Hood Quad Encoder", (double) getQuadEncoder() + m_quadOffset);
        SmartDashboard.putNumber("QuadOffset", m_quadOffset);
    }

    public void adjustHood()
    {
        m_hoodRotations = m_hexAbsoluteEncoder.get();
        m_quadOffset = (m_hoodRotations - HoodConstants.k_retractAbsSetpoint) * HoodConstants.k_quadTicksPerRotation;
    }


    public double hoodSetSetpoint(double setpoint)
    {
        return m_hoodPID.calculate((double) getQuadEncoder() + m_quadOffset, setpoint);
    }

    public double getAbsEncoder()
    {
        return m_hexAbsoluteEncoder.get();
    }

    public int getQuadEncoder()
    {
        return m_hexQuadEncoder.get();
    }


    /**
     * Provides the angle to set the shooter hood.
     * 
     * @param limelight_ty The angle sensed by the Limelight
     * @return The new hood angle
     */
    public double hoodAngleFinder(double limelight_ty)
    {
        /*    d = (h1-h2) / tan(a1+a2)    */
        //angle is in degrees
        double angle = limelight_ty + HoodConstants.limelightAngle;
        angle *= (Math.PI / 180); // convert to radians
        //distance is in inches, angle radians
        var distance = HoodConstants.heightDifference / Math.tan(angle);

        SmartDashboard.putNumber("hood angle", angle);
        SmartDashboard.putNumber("distance inches", distance);

        if (distance > 250)
        {
            distance = 250;
        }
        
        if (distance < 50)
        {
            distance = 50;
        }

        var hoodPosition = 0.000002775*(Math.pow(distance, 4)) - 0.0013*(Math.pow(distance, 3)) + 0.081*(Math.pow(distance, 2)) + 28.303*distance - 60.17;

        SmartDashboard.putNumber("Hood Commanded Position", hoodPosition);

        return hoodPosition;
    }
}
