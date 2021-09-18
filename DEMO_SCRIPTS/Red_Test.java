package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="Red_Test")
public class Red_Test extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\
    // Motors are Neverest 60:1 Motors and rotate with 1680 Ticks per Rotation.
    DcMotor LeftMotor;
    DcMotor RightMotor;
    DcMotor LaunchingMotor;
    //-----------------------------Touch Sensor for Ball Loading--------------------------------------\\

    //This is sensing if a ball is ready to be loaded.
    ColorSensor Color1;

    //-------------------------------- Variables --------------------------------\\


    // Buttons that will be used to control the robot's functions.

    //Gamepad1 Variables
    float left_y_value; //The right Joystick
    float right_y_value; //The left Joystick
    double LeftMotorPower; //Left wheel's motor
    double RightMotorPower; //Right wheel's motor
    boolean ButtonA1; //Launch button

    @Override

    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\


        // Hardware mapping the Drivetrain's 2 drive motors, they are Neverest 60 Motors and go 1680 ticks per rotation.
        LeftMotor = hardwareMap.dcMotor.get("LeftMotor");
        RightMotor = hardwareMap.dcMotor.get("RightMotor");
        // Reversing 1 of the Drivetrain motors to allow the wheels to both move in the correct direction.
        LeftMotor.setDirection(DcMotor.Direction.REVERSE);
        Color1 = hardwareMap.colorSensor.get("Color1");
        Color1.enableLed(true);

        waitForStart();


        while (opModeIsActive()) {


            ///-------------------------------- Defining Buttons and Drivetrain Code --------------------------------\\

            left_y_value = gamepad1.left_stick_y;
            right_y_value = gamepad1.right_stick_y;
            LeftMotorPower = left_y_value;
            RightMotorPower = right_y_value;
            LeftMotorPower = Range.clip(LeftMotorPower, -1, 1);
            RightMotorPower = Range.clip(RightMotorPower, -1, 1);
            LeftMotor.setPower(LeftMotorPower);
            RightMotor.setPower(RightMotorPower);

            ButtonA1 = gamepad1.a;
        //-------------------------------- Receiving Color Values --------------------------------\\

            //Automatic and Manual Mode Actions
            telemetry.addData("Color Values", Color1.red());
            telemetry.addData("Color Values", Color1.blue());
            telemetry.addData("Color Values", Color1.green());
            telemetry.update();

            if (ButtonA1) {
                LaunchingMotor.setTargetPosition(1680);
                LaunchingMotor.setPower(0.50);
                sleep(5000);
            }
        }
    }
}
