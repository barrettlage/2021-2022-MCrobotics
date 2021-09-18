/*
FTC Team 4991 GearFreaks
Author:  Joe Walton
Date: 29 Apr 2020
Modified by:
Modified Date:
*/
package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@TeleOp(name="ct_hub_with_color")
public class ct_hub_with_color extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Left;
    DcMotor Right;

    boolean buttonA;
    boolean buttonB;

    ColorSensor sensorColor;
    DistanceSensor sensorDistance;

    @Override
    public void runOpMode() throws InterruptedException {

        Left = hardwareMap.dcMotor.get("left");
        Right = hardwareMap.dcMotor.get("right");

        Left.setDirection(DcMotor.Direction.REVERSE);

        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");

        // get a reference to the distance sensor that shares the same name.
        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_color_distance");

        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        final double SCALE_FACTOR = 255;

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
    //        Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
    //                (int) (sensorColor.green() * SCALE_FACTOR),
    //                (int) (sensorColor.blue() * SCALE_FACTOR),
    //                hsvValues);

            // send the info back to driver station using telemetry function.
            telemetry.addData("Distance (cm)",
                    String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.addData("Alpha", sensorColor.alpha());
            telemetry.addData("Red  ", sensorColor.red());
            telemetry.addData("Green", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());
            telemetry.addData("Hue", hsvValues[0]);
            telemetry.update();


            // get current button values
            float Yvalue1 = gamepad1.left_stick_y;
            float Xvalue2 = gamepad1.right_stick_x;

            float LF = (Yvalue1 - Xvalue2);
            float RF = (Yvalue1 + Xvalue2);

            LF = Range.clip(LF, -1, 1);
            RF = Range.clip(RF, -1, 1);

            Left.setPower(LF);
            Right.setPower(RF);

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
/*
        Left.setPower(0.00);
        Right.setPower(0.00);
        telemetry.addData("Program", "Stopped");
        telemetry.update();
*/
    }

}
