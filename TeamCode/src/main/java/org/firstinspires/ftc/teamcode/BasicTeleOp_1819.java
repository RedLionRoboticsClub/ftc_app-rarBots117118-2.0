package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="BasicTeleOp1819", group="Test")

public class BasicTeleOp_1819 extends LinearOpMode {

    //Connect Hardware Maps
    BasicHardwareMap1819 robot = new BasicHardwareMap1819();

    //Run LinearOpMode
    @Override
    public void runOpMode() {

        //Initiate Hardware Map
        robot.init(hardwareMap);

        //Add Telemetry to confirm Robot Start. Recommended to name her here
        telemetry.addData("Say", "Hello, Endeavor Signing On");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //check for strafing then define X and Y values for standard drive
            if (gamepad1.right_trigger > 0) {
                //robot.motorFR.setPower(-0.5);
                //robot.motorFL.setPower(-0.5);
                robot.motorBL.setPower(0.5);
                robot.motorBR.setPower(0.5);
            } else if (gamepad1.left_trigger > 0) {
                //robot.motorFR.setPower(0.5);
                //robot.motorFL.setPower(0.5);
                robot.motorBL.setPower(-0.5);
                robot.motorBR.setPower(-0.5);
            } else {
                float yValue = gamepad1.left_stick_y;
                float xValue = gamepad1.right_stick_y;

                xValue = Range.clip(xValue, -1, 1);
                yValue = Range.clip(yValue, -1, 1);

                //set power based on X and Y values
                //robot.motorFL.setPower(yValue);
                robot.motorBL.setPower(yValue);
                //robot.motorFR.setPower(-xValue);
                robot.motorBR.setPower(-xValue);
            }
            if (gamepad1.right_bumper) {
                robot.hopperT.setPower(1);
                robot.hopperB.setPower(1);
            }
            else if (gamepad1.left_bumper) {
                robot.hopperT.setPower(-1);
                robot.hopperB.setPower(-1);
            }
            else {
                robot.hopperT.setPower(0);
                robot.hopperB.setPower(0);
            }
            if (gamepad1.x){
                robot.box.setPosition(0.25);
            }
            else if (gamepad1.y){
                robot.box.setPosition(0.65);
            }
        }
    }
}

