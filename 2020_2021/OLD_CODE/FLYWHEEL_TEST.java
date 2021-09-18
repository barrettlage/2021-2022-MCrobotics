/*
FTC Team 4991 GearFreaks
Author:  Joe Walton
Date: 29 Apr 2020
Modified by:
Modified Date:
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="FLYWHEEL_TEST")
public class FLYWHEEL_TEST extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;

    boolean buttonA;
    boolean buttonB;

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("left");
        Right = hardwareMap.dcMotor.get("right");

        Left.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {

            // get current button values
            float Yvalue1 = gamepad1.left_stick_y;
            float Xvalue2 = gamepad1.right_stick_x;

            float LF = -(Yvalue1 - Xvalue2);
            float RF = -(Yvalue1 + Xvalue2);

            LF = Range.clip(LF, -1, 1);
            RF = Range.clip(RF, -1, 1);

//            Left.setPower(LF);
//            Right.setPower(RF);

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;

            if (buttonA) {
                telemetry.addData("Starting motor1", " ");
                telemetry.update();
                Left.setPower(1.00);
                Right.setPower(1.00);
            }
            if (buttonB) {
                telemetry.addData("Stopping Motor 1", " ");
                telemetry.update();
                Left.setPower(0.00);
                Right.setPower(0.00);
            }
            if (buttonX) {
                telemetry.addData("Starting motor1", " ");
                telemetry.update();
                Left.setPower(-1.00);
                Right.setPower(-1.00);
            }
            if (buttonY) {
                telemetry.addData("Stopping Motor 1", " ");
                telemetry.update();
                Left.setPower(0.00);
                Right.setPower(0.00);
            }

        }
        // end of OpMode = Game over/stop pushed
/*
        Left.setPower(0.00);
        Right.setPower(0.00);
        telemetry.addData("Program", "Stopped");
        telemetry.update();
*/
    }

}

