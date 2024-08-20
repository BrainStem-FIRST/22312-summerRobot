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

    enum LiftStates {
        UP, DOWN, STATIC
    };

    LiftStates liftState;

    public Lift(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1) {
        super(hwMap, telemetry, gamepad1);

        liftMotor = (DcMotorEx) hwMap.dcMotor.get("LiftMotor");
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftState = LiftStates.STATIC;
    }

    private void raiseLift() {
        liftMotor.setPower(0.3);
    }
    private void dropLift() {
        liftMotor.setPower(-0.3);
    }
    private void holdLift() {
        liftMotor.setPower(0);
    }

    private void updateLiftState() {
        switch(liftState) {
            case UP:
                raiseLift();
                break;
            case DOWN:
                dropLift();
                break;
            case STATIC:
                holdLift();
                break;
        }
    }

    private void checkNewState() {
        if(gamepad1.a) {
            liftState = LiftStates.UP;
        } else if(gamepad1.b) {
            liftState = LiftStates.DOWN;
        } else {
            liftState = LiftStates.STATIC;
        }
    }

    public void update() {
        checkNewState();
        updateState();
    }
}
