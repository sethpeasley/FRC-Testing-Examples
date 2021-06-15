package MockedHardware;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import frc.robot.subsystems.interfaces.ITalonSRX;

public class MockedTalonSRXController implements ITalonSRX
{
    private int m_deviceNumber;
    private TalonSRXControlMode m_mode;
    
    private double m_demandValue;


    public MockedTalonSRXController(int deviceNumber)
    {
        m_deviceNumber = deviceNumber;
    }

    public void set(TalonSRXControlMode mode, double value)
    {
        m_mode = mode;
        m_demandValue = value;
    }
    
}
