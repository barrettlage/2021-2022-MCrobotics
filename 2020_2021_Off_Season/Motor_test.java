package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Motor_test")
public class Motor_test extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\
    // Motors are Neverest 60:1 Motors and rotate with 1680 Ticks per Rotation.
    DcMotor Motor1;


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
    boolean ButtonX1;
    boolean dpad_down;
    boolean dpad_up;
    int Current_Position;
    boolean AutoMode = false;


    @Override
    public void runOpMode() throws InterruptedException {


        //-------------------------------- Hardware Mapping --------------------------------\\


        // Hardware mapping the Drivetrain's 2 drive motors, they are Neverest 60 Motors and go 1680 ticks per rotation.
        Motor1 = hardwareMap.dcMotor.get("motor1");

        // Reversing 1 of the Drivetrain motors to allow the wheels to both move in the correct direction.
        //RightMotor.setDirection(DcMotor.Direction.REVERSE);
        Color1 = hardwareMap.colorSensor.get("color1");

        waitForStart();

        while (opModeIsActive()) {
            Motor1.setPower(1.00);
            sleep(1000);
            Motor1.setPower(0.00);
            sleep(1000);

            ///-------------------------------- Defining Buttons and Drivetrain code --------------------------------\\



            //-------------------------------- Ball Launching Code --------------------------------\\




        }
        Motor1.setPower(0.00);
    }
}
