package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Color_Test3")
public class Color_Test3 extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\


    //----------------------------- Color Sensor for Ball Loading --------------------------------------\\
    ColorSensor color3;

    //-------------------------------- Variables --------------------------------\\


    // Buttons that will be used to control the robot's functions.

    //Gamepad1 Variables

    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\

        color3 = hardwareMap.colorSensor.get("color3");

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("COLOR 3 R:   ", color3.red());
            telemetry.addData("COLOR 3 B:   ", color3.blue());
            telemetry.addData("COLOR 3 G:   ", color3.green());
            telemetry.update();

        }
    }
}
