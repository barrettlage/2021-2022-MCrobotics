package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="SAMPLE")
public class SAMPLE extends LinearOpMode {

    //Variable Name Declarations
    DcMotor motor;
    @Override

    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");
        waitForStart();
        while (opModeIsActive()) {

                motor.setPower(1.00);
                sleep(1000);
                motor.setPower(0.00);
                sleep(1000);
        }
        motor.setPower(0.00);
    }
}