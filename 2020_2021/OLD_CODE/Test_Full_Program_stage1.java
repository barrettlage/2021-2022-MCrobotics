package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Test_Full_Program_stage1")
public class Test_Full_Program_stage1 extends LinearOpMode {

    // Motors
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;
    // - motor types and variable names

    // - drivetrain power variables

    // Intake motor
    // - motor type and variable name

    // Flipper motor
    // - motor type and variable name

    // Fly wheel motors
    DcMotor Flywheel1;
    DcMotor Flywheel2;
    //both Flywheel1 and Flywheel2 are neverrest 40's


    // buttons that will be used to control the robot's functions
    boolean buttonY;
    boolean buttonB;
    boolean buttonA;
    boolean buttonX;
    boolean dpad_up;
    boolean dpad_down;
    boolean RightBumper;
    float RightTrigger;
    float LeftTrigger;
    boolean LeftBumper;
    boolean dpad_right;
    boolean dpad_left;

    // additional variables used
    double current_power;
    boolean GOOD = true;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        // harware mapping
        // - drivetrain
        // - intake
        // - flipper
        // - flywheel
        Flywheel1 = hardwareMap.dcMotor.get("Left");
        Flywheel2 = hardwareMap.dcMotor.get("Right");
        Flywheel2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
            buttonA = gamepad1.a;
            buttonB = gamepad1.b;
            buttonX = gamepad1.x;
            buttonY = gamepad1.y;
            RightTrigger = gamepad1.right_bumper;
            LeftBumper = gamepad1.left_bumper;
            RightBumper = gamepad1.right_trigger;
            LeftTrigger = gamepad1.left_trigger;
            dpad_up = gamepad1.dpad_up;
            dpad_down = gamepad1.dpad_down;
            dpad_left = gamepad1.dpad_left;
            dpad_right = gamepad1.dpad_right;
            // Check the joysticks to control the drivetrain
            // 1. Get the joystick values
            // 2. Calculate the power levels for each mecanum wheel
            // 3. ensure the power levels are within the limits
            // 4. set the power for each wheel

            // check to see if any buttons are pressed
            // --- should be gamepad2

            // intake motor control
            // flipper motor control
            // flywheel motor control
            if (buttonB) {
                telemetry.addData("Stopping All Flywheel Motors.", " ");
                telemetry.update();
                current_power = Range.clip(current_power, -1, 1);
                Flywheel1.setPower(0.00);
                Flywheel2.setPower(0.00);
            }
            if (buttonA) {
                telemetry.addData("All Flywheel Motors Engaged.", " ");
                telemetry.update();
                current_power = Range.clip(current_power, -1, 1);
                Flywheel1.setPower(current_power);
                Flywheel2.setPower(current_power);
            }
            // The code below is used to put the Flywheel Motor(s) at 100% Throttle IN REVERSE when the 'A' button is pushed on the Controller.
            if (dpad_left) {
                telemetry.addData("Flywheel Motors Engaged in Reverse. ", " ");
                telemetry.update();
                current_power=(-1.00);
            }
            if (dpad_up) {
                telemetry.addData("Motors set to Top Goal.", " ,");
                telemetry.update();
                current_power=(1.00);
            }
            if (dpad_right) {
                telemetry.addData("Motors set to Middle Goal.", " ,");
                telemetry.update();
                current_power=(0.60);
            }
            if (dpad_down) {
                telemetry.addData("Motors set to Bottom Goal.", " ,");
                telemetry.update();
                current_power=(0.30);
            }
            if (buttonX && GOOD) {
                GOOD = false;
                telemetry.addData("Current Power Level Is: ", current_power);
                current_power = (current_power + 0.05);
                telemetry.addData("Calculated Power", current_power);
                current_power = Range.clip(current_power, -1, 1);
                telemetry.addData("Clipped Power", current_power);
                telemetry.addData("Motor 2 Power", Flywheel2.getPower());
                telemetry.update();
                GOOD = true;
                sleep(200);
            }
            if (buttonA && GOOD) {
                GOOD = false;
                telemetry.addData("Current Power Level Is: ", current_power);
                current_power = (current_power - 0.05);
                telemetry.addData("Calculated Power", current_power);
                current_power = Range.clip(current_power, -1, 1);
                telemetry.addData("clipped power", current_power);
                telemetry.update();
                GOOD = true;
                sleep(200);
            }
        }
    }
}