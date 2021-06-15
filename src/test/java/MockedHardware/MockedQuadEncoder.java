package MockedHardware;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

public class MockedQuadEncoder implements CounterBase, Sendable, AutoCloseable 
{
    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public int get() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

    @Override
    public double getPeriod() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxPeriod(double maxPeriod) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getStopped() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getDirection() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // TODO Auto-generated method stub

    }
    
}
