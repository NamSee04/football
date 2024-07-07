package com.demo.se104.footballLeagueManager.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeCompareUtils {
	    
	// Hàm chuyển đổi chuỗi thời gian thành LocalDateTime
    public static LocalDateTime parseMatchTime(String matchTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(matchTime, formatter);
    }
    
    // Hàm so sánh thời gian trận đấu với thời gian hiện tại
    public static Integer compareMatchDateTime(String matchTime) {
        LocalDateTime matchDateTime = parseMatchTime(matchTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        if (matchDateTime.isBefore(currentDateTime)) {
            return 1;
        } else if (matchDateTime.isAfter(currentDateTime)) {
            return 0;
        } else {
            return -1;
        }
    }
	
 // Hàm phân tích chuỗi thời gian với giá trị giờ, phút, giây có thể lớn hơn 23 và 59
    public static int compareTime(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        
        // Chuyển đổi thành các số nguyên
        int hours1 = Integer.parseInt(parts1[0]);
        int minutes1 = Integer.parseInt(parts1[1]);
        int seconds1 = Integer.parseInt(parts1[2]);
        
        int hours2 = Integer.parseInt(parts2[0]);
        int minutes2 = Integer.parseInt(parts2[1]);
        int seconds2 = Integer.parseInt(parts2[2]);
        
        // So sánh theo thứ tự giờ, phút, giây
        if (hours1 > hours2) {
            return 1;
        } else if (hours1 < hours2) {
            return 0;
        } else {
            if (minutes1 > minutes2) {
                return 1;
            } else if (minutes1 < minutes2) {
                return 0;
            } else {
                if (seconds1 > seconds2) {
                    return 1;
                } else if (seconds1 < seconds2) {
                    return 0;
                } else {
                    return 1; // Hai chuỗi thời gian bằng nhau
                }
            }
        }
    }
	
	// Hàm chuyển đổi chuỗi ngày sinh thành LocalDate
    public static LocalDate parseDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateOfBirth, formatter);
    }

    // Hàm tính tuổi dựa trên ngày sinh và ngày hiện tại
    public static int calculateAge(String dateOfBirth) {
        LocalDate birthDate = parseDateOfBirth(dateOfBirth);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
