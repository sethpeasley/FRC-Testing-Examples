package subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import frc.robot.subsystems.HoodSubsystem;




public class HoodExercisingTestingExperiments 
{
    //HoodSubsystem m_hood;

    // @Test
    // @DisplayName("A hooded subsystem")
    // void getsHoodSetpoint()
    // {
    //     var m_talon = new MockedTalonSRXController(1);
    //     m_hood = new HoodSubsystem(m_talon);


    //     var st = m_hood.hoodSetSetpoint(2.1);

    //     assertEquals(-2.1, st);
    // }

    @Test
    @DisplayName("Testing Hood Angle Finder")
    public void testHoodAgleFinder()
    {
        var talon = mock(TalonSRX.class);
        var hexAbsoluteEncoder = mock(DutyCycleEncoder.class);
        var hexQuadEncoder = mock(Encoder.class);


        //var m_talon = new MockedTalonSRXController(1);
        var m_hood = new HoodSubsystem(talon, hexAbsoluteEncoder, hexQuadEncoder);

        var angle = m_hood.hoodAngleFinder(1.0);
        assertEquals(2676.61866267594, angle, 0.001);

        // var angle1 = m_hood.hoodAngleFinder(22.9888);
        // assertEquals(1384.21162, angle1, 0.1);
    }

    @Test
    public void testPeriodic()
    {
        var talon = mock(TalonSRX.class);
        var hexAbsoluteEncoder = mock(DutyCycleEncoder.class);
        var hexQuadEncoder = mock(Encoder.class);


        //var m_talon = new MockedTalonSRXController(1);
        var m_hood = new HoodSubsystem(talon, hexAbsoluteEncoder, hexQuadEncoder);

        m_hood.periodic();

        // assertEquals(1,  actual);
    }


    //angle in, angle out
    //
    // 0        57.8550104815136
    // 

}
