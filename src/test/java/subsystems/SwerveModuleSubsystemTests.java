package subsystems;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.wpi.first.wpilibj.geometry.Rotation2d;

import static org.mockito.Mockito.*;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;

import frc.robot.subsystems.SwerveModule;



public class SwerveModuleSubsystemTests
{
    CANSparkMax m_driveMotor;
    CANSparkMax m_angleMotor;
    CANCoder m_canCoder; 
    Rotation2d m_offset;
    

    // @BeforeEach
    // private void TestFixtureSetup()
    // {
    //     m_driveMotor = mock(CANSparkMax.class);
    //     m_angleMotor = mock(CANSparkMax.class);
    //     m_canCoder = mock(CANCoder.class);
    //     m_offset = new Rotation2d();
    // }

    @Test
    public void GetStateReturnsValidStates()
    {
        System.out.println("start here");

        m_driveMotor = mock(CANSparkMax.class);
        m_angleMotor = mock(CANSparkMax.class);
        m_canCoder = mock(CANCoder.class);
        m_offset = new Rotation2d();

        when(m_driveMotor.getPIDController()).thenReturn(mock(CANPIDController.class));
        when(m_driveMotor.getEncoder()).thenReturn(mock(CANEncoder.class));

        SwerveModule sm = new SwerveModule(m_driveMotor, m_angleMotor, m_canCoder, m_offset);
        
        System.out.println("now here");



        var enc = m_driveMotor.getEncoder();
        when(enc.getVelocity()).thenReturn(100.0);



        when(m_canCoder.getPosition()).thenReturn(45.0);





        var x = sm.getState();
        System.out.print(x.speedMetersPerSecond);
        System.out.println(x.angle);


    }

}
