// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.interfaces.IHoodSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

//** Moves the Hood to the extended position */
public class HoodForceExtend extends CommandBase 
{
    IHoodSubsystem m_hood;


    /** Creates a new ForceExtendHood. */
    public HoodForceExtend() 
    {
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
