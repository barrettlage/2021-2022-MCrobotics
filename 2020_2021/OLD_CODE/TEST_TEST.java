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

@TeleOp(name="TEST_TEST")
public class TEST_TEST extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;

    boolean buttonA;
    boolean buttonB;
    boolean buttonX;
    boolean buttonY;

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

            buttonA = gamepad1.a;
            buttonB = gamepad1.b;

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

        }
        // end of OpMode = Game over/stop pushed
    }

}

