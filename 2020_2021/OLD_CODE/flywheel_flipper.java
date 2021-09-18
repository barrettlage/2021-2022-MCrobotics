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
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="flywheel_flipper")
public class flywheel_flipper extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;
    Servo Flipper;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;
    boolean dpadright;
    boolean dpadleft;
    boolean dpadup;
    boolean dpaddown;

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("left");
        Right = hardwareMap.dcMotor.get("right");

        Left.setDirection(DcMotor.Direction.REVERSE);
        Flipper = hardwareMap.servo.get("flipper");

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {

            // get current button values
//            float Yvalue1 = gamepad1.left_stick_y;
//            float Xvalue2 = gamepad1.right_stick_x;

//            float LF = -(Yvalue1 - Xvalue2);
//            float RF = -(Yvalue1 + Xvalue2);

//            LF = Range.clip(LF, -1, 1);
//            RF = Range.clip(RF, -1, 1);

//            Left.setPower(LF);
//            Right.setPower(RF);

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;
            dpadright = gamepad1.dpad_right;
            dpadleft = gamepad1.dpad_left;
            dpadup = gamepad1.dpad_up;
            dpaddown = gamepad1.dpad_down;

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
            if (dpadup) {
                telemetry.addData("Moving Flipper", " ");
                telemetry.update();
                Flipper.setPosition(0);
                sleep(400);
                Flipper.setPosition(0.50);
            }
            if (dpaddown) {
                telemetry.addData("Moving Flipper", " ");
                telemetry.update();
                Flipper.setPosition(0);
                sleep(400);
                Flipper.setPosition(1.0);
            }
            if (dpadright) {
                telemetry.addData("power is 90%", " ");
                telemetry.update();
                Left.setPower(-0.90);
                Right.setPower(-0.90);
            }
/*            if (dpadup) {
                telemetry.addData("power is 85%", " ");
                telemetry.update();
                Left.setPower(-0.85);
                Right.setPower(-0.85);
            }
  */
             if (dpadleft) {
                telemetry.addData("power is 80%", " ");
                telemetry.update();
                Left.setPower(-0.80);
                Right.setPower(-0.80);
            }
/*            if (dpaddown) {
                telemetry.addData("power is 75%", " ");
                telemetry.update();
                Left.setPower(-0.75);
                Right.setPower(-0.75);

            }
*/            // end of OpMode = Game over/stop pushed
/*
        Left.setPower(0.00);
        Right.setPower(0.00);
        telemetry.addData("Program", "Stopped");
        telemetry.update();
*/
        }

    }
}

