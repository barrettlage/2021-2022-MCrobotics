package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="Manual_Ball_Launching")
public class Manual_Ball_Launching extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\
    // Motors are Neverest 60:1 Motors and rotate with 1680 Ticks per Rotation.
    DcMotor LeftMotor;
    DcMotor RightMotor;
    DcMotor LaunchingMotor;

    //----------------------------- Color Sensor for Ball Loading --------------------------------------\\

    //This is sensing if a ball is ready to be loaded.
    ColorSensor Color1;

    //-------------------------------- Variables --------------------------------\\


    // Buttons that will be used to control the robot's functions.

    //Gamepad1 Variables
    float left_y_value;
    float right_y_value;
    double LeftMotorPower;
    double RightMotorPower;
    boolean ButtonA1;
    boolean ButtonB1;
    boolean dpad_down;
    boolean dpad_up;
    int Current_Position;
    boolean ButtonX1;

    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\


        // Hardware mapping the Drivetrain's 2 drive motors, they are Neverest 60 Motors and go 1680 ticks per rotation.
        LeftMotor = hardwareMap.dcMotor.get("LeftMotor");
        RightMotor = hardwareMap.dcMotor.get("RightMotor");
        LaunchingMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LaunchingMotor.setTargetPosition(500);
        LaunchingMotor.setPower(0.50);
        // Reversing 1 of the Drivetrain motors to allow the wheels to both move in the correct direction.
        LeftMotor.setDirection(DcMotor.Direction.REVERSE);

        while (opModeIsActive()) {


            ///-------------------------------- Defining Buttons and Drivetrain code --------------------------------\\

            left_y_value = gamepad1.left_stick_y;
            right_y_value = gamepad1.right_stick_y;
            LeftMotorPower = left_y_value;
            RightMotorPower = right_y_value;
            LeftMotorPower = Range.clip(LeftMotorPower, -1, 1);
            RightMotorPower = Range.clip(RightMotorPower, -1, 1);
            LeftMotor.setPower(LeftMotorPower);
            RightMotor.setPower(RightMotorPower);


            ButtonA1 = gamepad1.a;
            ButtonB1 = gamepad1.b;
            ButtonX1 = gamepad1.x;

            //-------------------------------- Ball Launching Code --------------------------------\\

            //This Button brings the motor to the right by 100 ticks
            if (ButtonA1) {
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                Current_Position = LaunchingMotor.getCurrentPosition();
                LaunchingMotor.setTargetPosition(Current_Position + 100);
                LaunchingMotor.setPower(0.50);
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                telemetry.update();
            }

            //This Button brings the motor to the left by 100 ticks
            if (ButtonB1) {
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                Current_Position = LaunchingMotor.getCurrentPosition();
                LaunchingMotor.setTargetPosition(Current_Position - 100);
                LaunchingMotor.setPower(0.50);
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                telemetry.update();
            }

            //This Button rotates the motor a full rotation, launching it
            if (ButtonX1) {
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                Current_Position = LaunchingMotor.getCurrentPosition();
                LaunchingMotor.setTargetPosition(Current_Position + 1680);
                LaunchingMotor.setPower(0.50);
                telemetry.addData("Initial Position", LaunchingMotor.getCurrentPosition());
                telemetry.update();
            }
        }
    }
}