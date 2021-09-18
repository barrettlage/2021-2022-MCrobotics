package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Ticks_Autonomous_Base extends LinearOpMode {

    DcMotor FLMotor;
    DcMotor FRMotor;
    DcMotor BLMotor;
    DcMotor BRMotor;

    public void init_motors () {
        FLMotor = hardwareMap.dcMotor.get("flmotor");
        FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLMotor.setDirection(DcMotor.Direction.REVERSE);

        FRMotor = hardwareMap.dcMotor.get("frmotor");
        FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BLMotor = hardwareMap.dcMotor.get("blmotor");
        BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLMotor.setDirection(DcMotor.Direction.REVERSE);

        BRMotor = hardwareMap.dcMotor.get("brmotor");
        BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void mcdrive (double speed, int ticks) {
        speed = Range.clip(speed, -1, 1);

        BRMotor.setTargetPosition(ticks);
        BRMotor.setPower(speed);

        BLMotor.setTargetPosition(ticks);
        BLMotor.setPower(speed);

        FLMotor.setTargetPosition(ticks);
        FLMotor.setPower(speed);

        FRMotor.setTargetPosition(ticks);
        FRMotor.setPower(speed);

        while ((FLMotor.isBusy())|| (FRMotor.isBusy())|| (BLMotor.isBusy())|| (BRMotor.isBusy()));


    }

    public void mcstrafe (double speed, int ticks) {
        speed = Range.clip(speed, -1, 1);
        FLMotor.setPower(-speed);
        FLMotor.setTargetPosition(ticks);
        FRMotor.setPower(speed);
        FRMotor.setTargetPosition(ticks);
        BLMotor.setPower(speed);
        BLMotor.setTargetPosition(ticks);
        BRMotor.setPower(-speed);
        BRMotor.setTargetPosition(ticks);

        while ((FLMotor.isBusy())|| (FRMotor.isBusy())|| (BLMotor.isBusy())|| (BRMotor.isBusy()));
        FLMotor.setPower(0.00);
        FRMotor.setPower(0.00);
        BLMotor.setPower(0.00);
        BRMotor.setPower(0.00);
    }
    public void mcturn (double speed, int ticks) {
        speed = Range.clip(speed, -1, 1);
        FLMotor.setPower(-speed);
        FLMotor.setTargetPosition(ticks);
        FRMotor.setPower(speed);
        FRMotor.setTargetPosition(ticks);
        BLMotor.setPower(-speed);
        BLMotor.setTargetPosition(ticks);
        BRMotor.setPower(speed);
        BRMotor.setTargetPosition(ticks);

        while ((FLMotor.isBusy())|| (FRMotor.isBusy())|| (BLMotor.isBusy())|| (BRMotor.isBusy()));
        FLMotor.setPower(0.00);
        FRMotor.setPower(0.00);
        BLMotor.setPower(0.00);
        BRMotor.setPower(0.00);
    }


}