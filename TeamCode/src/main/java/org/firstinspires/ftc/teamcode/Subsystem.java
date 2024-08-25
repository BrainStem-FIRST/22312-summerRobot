package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Subsystem {

    protected HardwareMap hwMap;
    protected Telemetry telemetry;
    protected Gamepad gamepad1;

    public Subsystem(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1) {
        this.hwMap = hwMap;
        this.telemetry = telemetry;
        this.gamepad1 = gamepad1;
    }
}
