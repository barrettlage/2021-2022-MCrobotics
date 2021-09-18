package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Color_Test1")
public class Color_Test1 extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\


    //----------------------------- Color Sensor for Ball Loading --------------------------------------\\
    ColorSensor color1;

    //-------------------------------- Variables --------------------------------\\


    // Buttons that will be used to control the robot's functions.

    //Gamepad1 Variables

    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\

        color1 = hardwareMap.colorSensor.get("color1");
        color1.enableLed(true);
        color1.setI2cAddress(I2cAddr.create8bit(0x3c));

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("COLOR 1 R:   ", color1.red());
            telemetry.addData("COLOR 1 B:   ", color1.blue());
            telemetry.addData("COLOR 1 G:   ", color1.green());
            telemetry.update();

        }
    }
}
