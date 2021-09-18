package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Color_Test2")
public class Color_Test2 extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\


    //----------------------------- Color Sensor for Ball Loading --------------------------------------\\
    ColorSensor color2;

    //-------------------------------- Variables --------------------------------\\


    // Buttons that will be used to control the robot's functions.

    //Gamepad1 Variables

    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\

        color2 = hardwareMap.colorSensor.get("color2");

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("COLOR 2 R:   ", color2.red());
            telemetry.addData("COLOR 2 B:   ", color2.blue());
            telemetry.addData("COLOR 2 G:   ", color2.green());
            telemetry.update();

        }
    }
}
