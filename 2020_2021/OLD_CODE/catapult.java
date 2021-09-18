package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "catapult")
public class catapult extends LinearOpMode {

    DcMotor onlymotor;
    boolean buttonA;
    int target_position_launch=0;
    @Override
    public void runOpMode() throws InterruptedException {
        onlymotor = hardwareMap.dcMotor.get("Left");
        onlymotor.setTargetPosition(0);
        onlymotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        onlymotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        onlymotor.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive()) {
            buttonA = gamepad1.a;
            // When button A is pushed, rotate the slip gear one complete rotation.
            //  This will allow the gears to engage and pull the arm down, and then release it
            //  once the slip gear (with no teeth) is reached.
            if (buttonA) {
                telemetry.addData("A pressed.", " ");
                telemetry.update();
                target_position_launch+=1120;
                telemetry.addData("1 current position.", onlymotor.getCurrentPosition());
                telemetry.update();
                onlymotor.setPower(1.00);
                onlymotor.setTargetPosition(target_position_launch);
                telemetry.addData("2 current position.", onlymotor.getCurrentPosition());
                telemetry.update();
                while (onlymotor.isBusy()) ;
                onlymotor.setPower(0.00);
                telemetry.addData("Launch Complete", " ");
                telemetry.update();
            }

        }
    /*i based this section of program of of an Andymark 40:1 motor and a 2.5" diameter gear
        i then found that the ticks per rotation on an andymark 40:1 is 1120 per rotation
        based of this i th then divided my gear circumference by the ticks and found how many ticks
        are in an inch which turned out to be 142.675
     */
        /*public void launch ( double inches){
            float distance = (((float) inches) * (float) 142.675);
            int distance_int = Math.round(distance);
            int target_position_launch;
            target_position_launch = (onlymotor.getCurrentPosition() + distance_int);
            onlymotor.setPower(1.00);
            onlymotor.setTargetPosition(target_position_launch);
            onlymotor.setPower(0.00);
            telemetry.addData("surprize!.", " ");
            telemetry.update();
           while (onlymotor.isBusy());
*/

    }

}