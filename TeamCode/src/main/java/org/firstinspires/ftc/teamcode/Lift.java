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

    enum LiftStates {
        UP, DOWN, STATIC
    };
    enum CollectorStates {
        ON, OFF
    };

    LiftStates liftState;
    CollectorStates collectorState;

    public Lift(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1) {
        super(hwMap, telemetry, gamepad1);

        liftMotor = (DcMotorEx) hwMap.dcMotor.get("LiftMotor");
        collectMotor = (DcMotorEx) hwMap.dcMotor.get("CollectMotor");

        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        collectMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftState = LiftStates.STATIC;
        collectorState = CollectorStates.OFF;

    }

    private void turnCollecterOn() {
        collectMotor.setPower(-gamepad1.right_trigger * 0.5);
    }
    private void turnCollectorOff() {
        collectMotor.setPower(0);
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
    private void updateCollectorState() {
        switch(collectorState) {
            case ON:
                turnCollecterOn();
                break;
            case OFF:
                turnCollectorOff();
                break;
        }
    }

    private void checkLiftControls() {
        if(gamepad1.a) {
            liftState = LiftStates.UP;
        } else if(gamepad1.b) {
            liftState = LiftStates.DOWN;
        } else {
            liftState = LiftStates.STATIC;
        }
    }
    private void checkCollectorControls() {
        if(gamepad1.right_trigger > 0.2) {
            collectorState = CollectorStates.ON;
        } else {
            collectorState = CollectorStates.OFF;
        }
    }

    private void checkNewStates(){
        checkLiftControls();
        checkCollectorControls();
    }

    private void updateStates() {
        updateLiftState();
        updateCollectorState();
    }

    public void update() {
        checkNewStates();
        updateStates();
    }
}
