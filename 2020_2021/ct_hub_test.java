package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="ct_hub_test")
public class ct_hub_test extends LinearOpMode {

    DcMotor P0;
    DcMotor P1;
    DcMotor P2;
    DcMotor P3;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        P0 = hardwareMap.dcMotor.get("port0");
        P1 = hardwareMap.dcMotor.get("port1");
        P2 = hardwareMap.dcMotor.get("port2");
        P3 = hardwareMap.dcMotor.get("port3");

        telemetry.addData("P0: ", P0.getCurrentPosition());
        telemetry.addData("P1: ", P1.getCurrentPosition());
        telemetry.addData("P2: ", P2.getCurrentPosition());
        telemetry.addData("P3: ", P3.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY).
        waitForStart();

        while (opModeIsActive()) {

            P0.setPower(0.10);
            P1.setPower(0.10);
            P2.setPower(0.10);
            P3.setPower(0.10);
            telemetry.addData("P0: ", P0.getCurrentPosition());
            telemetry.addData("P1: ", P1.getCurrentPosition());
            telemetry.addData("P2: ", P2.getCurrentPosition());
            telemetry.addData("P3: ", P3.getCurrentPosition());
            telemetry.update();

        }
    }
}