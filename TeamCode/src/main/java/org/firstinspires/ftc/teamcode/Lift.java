package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift extends Subsystem {

    HardwareMap hwMap;
    Telemetry telemetry;

    DcMotorEx liftMotor;
    DcMotorEx collectMotor;

    public Lift(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1) {
        super(hwMap, telemetry, gamepad1);

        liftMotor = (DcMotorEx) hwMap.dcMotor.get("LiftMotor");
        collectMotor = (DcMotorEx) hwMap.dcMotor.get("CollectMotor");

        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        collectMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void update() {
        liftMotor.setPower(0);
        if (gamepad1.b) {
            liftMotor.setPower(0.3);
        }
        else if (gamepad1.a) {
            liftMotor.setPower(-0.3);
        }

        collectMotor.setPower(0);
        if (gamepad1.right_trigger > 0.2) {
            collectMotor.setPower(-gamepad1.right_trigger * 0.5);
        }
    }
}
