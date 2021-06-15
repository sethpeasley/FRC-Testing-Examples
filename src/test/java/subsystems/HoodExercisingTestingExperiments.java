package subsystems;

import MockedHardware.MockedTalonSRXController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import frc.robot.subsystems.HoodSubsystem;
import frc.robot.subsystems.interfaces.IHoodSubsystem;



public class HoodExercisingTestingExperiments 
{
    IHoodSubsystem m_hood;

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
        var m_talon = new MockedTalonSRXController(1);
        m_hood = new HoodSubsystem(m_talon);

        var angle = m_hood.hoodAngleFinder(1.0);
        System.out.println(angle);

        assertEquals(2676.61866267594, angle, 0.01);

    }
}
