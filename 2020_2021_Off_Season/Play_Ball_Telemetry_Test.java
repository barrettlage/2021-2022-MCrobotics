/*
FTC Team 4991 GearFreaks
Author(s):  Alex Pereira and Charles Burometto
Date: 15 Feb 2019
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

@TeleOp(name="Play_Ball_Telemetry_Test")
public class Play_Ball_Telemetry_Test extends LinearOpMode {

    // Declare OpMode members.
    DcMotor Catapult;  // need to use encoder with this motor - neverest 60
    int launch;
    boolean buttonA;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        Catapult = hardwareMap.dcMotor.get("catapult");
        Catapult.setTargetPosition(0);
        Catapult.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Catapult.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Current Catapult Position", Catapult.getCurrentPosition());
            telemetry.update();

        buttonA = gamepad1.a;

            //  The A and B buttons are used to turn ON/OFF the automatica launching mode
            if (buttonA) {
                telemetry.addData("Current Catapult Position", Catapult.getCurrentPosition());
                launch = Catapult.getCurrentPosition();
                launch+=1680;
                Catapult.setTargetPosition(launch);
                Catapult.setPower(0.01);
                telemetry.addData("Catapult New Position", Catapult.getCurrentPosition());
                telemetry.update();
            }
        }
    }
}