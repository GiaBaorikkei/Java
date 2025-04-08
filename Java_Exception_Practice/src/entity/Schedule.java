package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Schedule implements IApp {
    private int scheduleId;
    private int classroomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public void inputData(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        this.classroomId = Integer.parseInt(scanner.nextLine());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.print("Enter start time (yyyy-MM-dd HH:mm:ss): ");
        this.startTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Enter end time (yyyy-MM-dd HH:mm:ss): ");
        this.endTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        if (endTime.isBefore(startTime)) {
            throw new Exception("End time must be after start time!");
        }
    }

    // Getters and setters
    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }
}