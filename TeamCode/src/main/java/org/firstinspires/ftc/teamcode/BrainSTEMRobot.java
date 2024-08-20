package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BrainSTEMRobot {
    // Don't touch these
    public Telemetry telemetry;
    public OpMode opMode;

    public DriveTrain driveTrain;
    public Lift lift;
    public Collector collector;

    public BrainSTEMRobot(HardwareMap hwMap, Telemetry telemetry, OpMode opMode, Gamepad gamepad1) {

        this.telemetry = telemetry;
        this.opMode = opMode;

        driveTrain = new DriveTrain(hwMap, telemetry, gamepad1);
        lift = new Lift(hwMap, telemetry, gamepad1);
        collector = new Collector(hwMap, telemetry, gamepad1);
    }

    public void update() {
        driveTrain.update();
        lift.update();
        collector.update();
    }
}