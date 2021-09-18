package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="control_hub_test_1")
public class control_hub_test_1 extends LinearOpMode {

    //-------------------------------- Drivetrain Motors --------------------------------\\
    // Motors are Gobilda 5202 and rotate at around 435 Revolutions/Rotations Per Minute (RPM).
    DcMotor p0;
    DcMotor p1;
    DcMotor p2;
    DcMotor p3;

    //Gamepad1 Buttons
    boolean buttonA1;     // Increments the destination variable by 100
    boolean buttonB1;     //This button is for subtracting 100 ticks to the motor as it moves upwards 90 degrees.
    boolean buttonX1;     //This button, if used, is to bring the motor to half its ticks per rotation, 95.9.
    boolean buttonY1;     // not used
    boolean LeftBumper1;  // This is used to start the intake motors to pick up the Rings.
    boolean RightBumper1; // This is used to load the rings into the storage so they are ready to be loaded into the Flywheel.
    int rightTrigger1;    // not used
    int leftTrigger1;     // not used
    boolean dpad_down1;
    boolean dpad_up1; //This button, when used, will move the motor to its rest position, pointed upwards.
    boolean dpad_right1;  //This button is for letting go of the wobble goals.
    boolean dpad_left1;     //This button is for grabbing the wobble goals.

    //Gamepad2 Buttons

    boolean buttonY2; // This button is used to decrease the Flywheel Motors' power by 0.05%.
    boolean buttonB2; // This button is used to bring both of the Flywheel's motors to a complete stop.
    boolean buttonA2; // This button is used to set the Flywheel's power to what the variable current_power's value is.
    boolean buttonX2; // This button is used to increase the Flywheel Motors' power by 0.05%.
    //boolean rightBumper2;
    //boolean leftBumper2;
    float RightTrigger2; // This is for loading rings and resetting the flipper.
    // float LeftTrigger2;
    boolean dpad_down2; // This is used to set the Flywheel Motors to aim at the Bottom Goal.
    boolean dpad_up2; // This is used to set the Flywheel Motors to aim at the Top Goal.
    boolean dpad_right2; // This is used to set the Flywheel Motors to aim at the Middle Goal.
    // boolean dpad_left2;


    // The X and Y values of the Joystick.
    float StickX2;
    float StickY2;
    int destination=0;  //This variable is for storing 100 ticks and adding or subtracting 100 more

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {


        p0 = hardwareMap.dcMotor.get("port0");
        p1 = hardwareMap.dcMotor.get("port1");
        p2 = hardwareMap.dcMotor.get("port2");
        p3 = hardwareMap.dcMotor.get("port3");


        // Wait for the game to start (driver presses PLAY).
        waitForStart();
        while (opModeIsActive()) {

            buttonA1 = gamepad1.a;
            buttonB1 = gamepad1.b;
            buttonX1 = gamepad1.x;
            buttonY1 = gamepad1.y;

            p0.setPower(0.25);
            p1.setPower(0.25);
            p2.setPower(0.25);
            p3.setPower(0.25);

        }
    }
}