import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String currentTimeStr = scanner.next();
        String explosionTimeStr = scanner.next();
        
        String[] currentTimeArr = currentTimeStr.split(":");
        String[] explosionTimeArr = explosionTimeStr.split(":");
        
        int currentSeconds = timeToSeconds(currentTimeArr);
        int explosionSeconds = timeToSeconds(explosionTimeArr);
        
        int timeToExplosion = explosionSeconds - currentSeconds;
        if (timeToExplosion <= 0) {
            timeToExplosion += 24 * 60 * 60;
        }
        
        String timeToExplosionStr = secondsToTime(timeToExplosion);
        System.out.println(timeToExplosionStr);
        
        scanner.close();
    }
    
    public static int timeToSeconds(String[] timeArr) {
        int hours = Integer.parseInt(timeArr[0]);
        int minutes = Integer.parseInt(timeArr[1]);
        int seconds = Integer.parseInt(timeArr[2]);
        
        int totalSeconds = hours * 60 * 60 + minutes * 60 + seconds;
        return totalSeconds;
    }
    
    public static String secondsToTime(int totalSeconds) {
        int hours = totalSeconds / (60 * 60);
        totalSeconds %= 60 * 60;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        
        String timeStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return timeStr;
    }
}
