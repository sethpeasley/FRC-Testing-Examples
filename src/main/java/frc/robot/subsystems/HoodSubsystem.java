// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.HoodConstants;
import frc.robot.subsystems.interfaces.IHoodSubsystem;
import frc.robot.subsystems.interfaces.ITalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class HoodSubsystem extends SubsystemBase implements IHoodSubsystem
{
    private PIDController m_hoodPID;
    private ITalonSRX m_hoodMotor;

    // private TalonSRX hoodMotor = new TalonSRX(CANBusIDs.k_HoodID);
    // private DutyCycleEncoder m_hexAbsoluteEncoder = new DutyCycleEncoder(HexEncoderInputs.k_absoluteInput);
    // private Encoder m_hexQuadEncoder = new Encoder(HexEncoderInputs.k_quadratureA, HexEncoderInputs.k_quadratureB);
  
    private double m_hoodRotations;
    private static double m_quadOffset;
  
    
    /** Creates a new HoodSubsystem. */
    public HoodSubsystem(ITalonSRX talon) 
    {
        m_hoodMotor = talon;
        
        m_hoodPID = new PIDController(HoodConstants.k_hoodP, HoodConstants.k_hoodI, HoodConstants.k_hoodD);
        m_hoodPID.setTolerance(HoodConstants.k_hoodTolerance);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }


    public double hoodSetSetpoint(double setpoint)
    {
        return m_hoodPID.calculate((double) getQuadEncoder() + m_quadOffset, setpoint);
    }

    public int getQuadEncoder()
    {
        // return m_hexQuadEncoder.get();
        return -1;
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
