package Methods;

import java.time.Duration;
import java.time.LocalDateTime;
import java.sql.SQLException;

public class Shift {
    private boolean clockedIn;
    private boolean startedToday;
    private LocalDateTime startTime;
    private LocalDateTime breakStartTime;
    private Duration breakDuration;
    private LocalDateTime endTime;
    private Duration shiftDuration;

    public Shift() {
        this.clockedIn = false; 
        this.startTime = null; 
        this.breakStartTime = null;
        this.breakDuration = null;
        this.endTime = null; 
        this.shiftDuration = null;
    }

    //This method handles checking if we are clocked in already and updates the shift if so
    // but need emi's help with setting a function to run as soon as we run page to update shift
    public void clockIn() 
    {
        if (clockedIn)
        {
            System.out.println("Already clocked in!");
            return;
        }
        Shift latestShift = getLatestShift();
        if (!latestShift.isClockedIn()) 
        {
            clockedIn = true; 
            startTime = LocalDateTime.now(); 
            boolean saveSuccess = saveShift();
            System.out.println("clock in Saved? " + saveSuccess);
            return;
        }
        System.out.println("Found open shift");
        setShift(latestShift);
        boolean saveSuccess = saveShift();

    }
    public void clockOut() {
        if (!clockedIn)
        {
            Shift latestShift = getLatestShift();
            if (!latestShift.isClockedIn()){
                System.out.println("No open shifts today!");
                return;
            }
            System.out.println("Open shift found");
            setShift(latestShift);
        }
        endTime = LocalDateTime.now();
        clockedIn = false;
        boolean success = saveShift();
        resetShift();
        System.out.println("Clocking out saved? " + success);
    }
 //______HELPERS_____________________________________________________________________________________________________________________________

    private boolean saveShift() {
        updateShiftDuration();
        DataAccess access = new DataAccess();
        System.out.println("SAVING...");
        try {
            access.saveShift(this);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("FAILED: " + e);
            return false;
        }
    }
 
    public Shift getLatestShift() {
        DataAccess access = new DataAccess();
        try {
            Shift latestShift = access.findRecentShift(4);
            return latestShift;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("FAILED GETTING LATEST SHIFT: " + e);
            return null;
        }
    }

    private void updateShiftDuration() {
        LocalDateTime currentTime = LocalDateTime.now();
        shiftDuration = Duration.between(startTime, currentTime);
    }

    private void resetShift()  {
        this.clockedIn = false; 
        this.startTime = null; 
        this.breakStartTime = null;
        this.breakDuration = null;
        this.endTime = null; 
        this.shiftDuration = null;
    }
    private void setShift(Shift shift) {
        this.clockedIn = shift.isClockedIn(); 
        this.startTime = shift.getStartTime(); 
        this.breakStartTime = shift.getBreakStartTime();
        this.breakDuration = shift.getBreakDuration();

    }


    public boolean isClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(boolean clockedIn) {
        this.clockedIn = clockedIn;
    }

    public boolean isStartedToday() {
        return startedToday;
    }

    public void setStartedToday(boolean startedToday) {
        this.startedToday = startedToday;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getBreakStartTime() {
        return breakStartTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public void setBreakStartTime(LocalDateTime breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public Duration getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(Duration breakDuration) {
        this.breakDuration = breakDuration;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Duration getShiftDuration() {
        return shiftDuration;
    }

    public void setShiftDuration(Duration shiftDuration) {
        this.shiftDuration = shiftDuration;
    }
}