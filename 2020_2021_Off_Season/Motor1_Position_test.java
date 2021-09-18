package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Motor1_Position_test")
public class Motor1_Position_test extends LinearOpMode {

    DcMotor Motor1;
    DcMotor Motor2;
    int TICKS = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        Motor1 = hardwareMap.dcMotor.get("motor1");
        Motor1.setTargetPosition(0);
        Motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Motor2 = hardwareMap.dcMotor.get("motor2");
        Motor2.setTargetPosition(0);
        Motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        TICKS = Motor1.getCurrentPosition();
        telemetry.addData("BEGIN Ticks: ", TICKS);
        telemetry.update();
        TICKS += 1180;
        Motor1.setPower(1.00);
        Motor1.setTargetPosition(TICKS);
        telemetry.addData("Should be going: ", TICKS);
        telemetry.update();

        while(Motor1.isBusy()) {
            telemetry.addData("Ticks: ", Motor1.getCurrentPosition());
            telemetry.update();
        }
        telemetry.addData("END Ticks: ", Motor1.getCurrentPosition());
        telemetry.update();
sleep(10000);

        TICKS = Motor2.getCurrentPosition();
        telemetry.addData("BEGIN Ticks: ", TICKS);
        telemetry.update();
        TICKS += 1180;
        Motor2.setPower(1.00);
        Motor2.setTargetPosition(TICKS);
        telemetry.addData("Should be going: ", TICKS);
        telemetry.update();

        while(Motor2.isBusy()) {
            telemetry.addData("Ticks: ", Motor2.getCurrentPosition());
            telemetry.update();
        }
        telemetry.addData("END Ticks: ", Motor2.getCurrentPosition());
        telemetry.update();
        sleep(10000);


    }
}
