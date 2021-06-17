package MockedHardware;

import static org.mockito.Mockito.*;

import frc.robot.subsystems.HoodSubsystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WithMockito 
{
    private HoodSubsystem mockedHood = mock(HoodSubsystem.class);


    @Test
    @DisplayName("Testing Hood Angle Finder")
    public void testHoodAgleFinder()
    {

        var x = mockedHood.hoodAngleFinder(50);
        System.out.print("Here is mockedHood.hoodAngleFinder(50): ");
        System.out.println(x);
    }

}
