package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp (name="Parents_VS_Kids")
public class Parents_VS_Kids extends LinearOpMode {

    DcMotor left;
    DcMotor right;
    float left_y_value;
    float right_y_value;
    double LPower;
    double RPower;

    @Override
    public void runOpMode() throws InterruptedException {

        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        left.setDirection(DcMotor.Direction.REVERSE);
        right.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            //Drivetrain
            left_y_value = -gamepad1.left_stick_y;
            right_y_value = -gamepad1.right_stick_y;
            LPower = left_y_value;
            RPower = right_y_value;
            LPower = Range.clip(LPower, -1, 1);
            RPower = Range.clip(RPower, -1, 1);
            left.setPower(LPower);
            right.setPower(RPower);

        }

    }

}
