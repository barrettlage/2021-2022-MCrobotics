package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Autonomous(name="Wheel_Tick_Test2")
public class Wheel_Tick_Test2 extends LinearOpMode {

    DcMotor FL;


    @Override
    public void runOpMode() throws InterruptedException {

        FL = hardwareMap.dcMotor.get("flmotor");
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        telemetry.addData("begin", FL.getCurrentPosition());
        telemetry.update();
        FL.setTargetPosition(2000);
        sleep(3000);
        FL.setPower(0.50);
        while(FL.isBusy()) {sleep(500);}
        //sleep(10000);
        telemetry.addData("end", FL.getCurrentPosition());
        telemetry.update();
        sleep(1000);
        //FL.setPower(0.00);




    }
}
