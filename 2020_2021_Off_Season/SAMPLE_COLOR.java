package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="SAMPLE_COLOR")
public class SAMPLE_COLOR extends LinearOpMode {

    //Variable Name Declarations
    ColorSensor color;
    @Override

    public void runOpMode() throws InterruptedException {
        color = hardwareMap.colorSensor.get("color");
        waitForStart();
        while (opModeIsActive()) {

            telemetry.addData("RED", color.red());
            telemetry.addData("GREEN", color.green());
            telemetry.addData("BLUE", color.blue());
            telemetry.update();
        }
    }
}