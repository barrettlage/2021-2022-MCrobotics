package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="RobotTankDrive")
public class RobotTankDrive extends LinearOpMode {
    DcMotor LMotor;
    DcMotor RMotor;

    double Yvalue1=0.0;
    double Xvalue2 = 0.0;
    double RightMotorPower = 0.0;
    double LeftMotorPower = 0.0;
    @Override
public void runOpMode() throws InterruptedException {
    LMotor = hardwareMap.dcMotor.get("left");
    RMotor = hardwareMap.dcMotor.get("right");
    LMotor.setDirection(DcMotor.Direction.REVERSE);
    waitForStart();

    while (opModeIsActive()) {
            Yvalue1 = gamepad1.left_stick_y;
            Xvalue2 = gamepad1.right_stick_x;

            if (Yvalue1 > 0.5) {
                RightMotorPower= (Yvalue1);
                LeftMotorPower= (Yvalue1);
                LMotor.setPower(LeftMotorPower);
                RMotor.setPower(RightMotorPower);

            }
            if (Xvalue2 > 0.5){
                RightMotorPower= (RightMotorPower - Xvalue2 );
                RMotor.setPower(RightMotorPower);
            }
            if (Xvalue2 < -0.5) {
                LeftMotorPower = (LeftMotorPower - Xvalue2);
                LMotor.setPower(LeftMotorPower);
            }
        }
    }
}
