package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Dane_reference")
public class Dane_reference extends LinearOpMode {


    DcMotor Motor1;
    DcMotor Motor2;



    @Override
    public void runOpMode() throws InterruptedException {



        Motor1 = hardwareMap.dcMotor.get("motor1");
        Motor2 = hardwareMap.dcMotor.get("motor2");

        waitForStart();

        while (opModeIsActive()) {
            Motor1.setPower(1.00);
            sleep(2000);
            Motor1.setPower(0.00);
            sleep(1000);
            Motor2.setPower(1.00);
            sleep(2000);
            Motor2.setPower(0.00);
            sleep(1000);

        }
        Motor1.setPower(0.00);
        Motor2.setPower(0.00);



    }
}


