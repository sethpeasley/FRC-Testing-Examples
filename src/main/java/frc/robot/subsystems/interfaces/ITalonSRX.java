package frc.robot.subsystems.interfaces;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public interface ITalonSRX 
{
    // public double hoodSetSetpoint(double setpoint);
    // public double hoodAngleFinder(double limelight_ty);

    public void set(TalonSRXControlMode mode, double value); 
    // {
    //     super.set(mode.toControlMode(), value);
    // }


}
