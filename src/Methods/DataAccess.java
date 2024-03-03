package Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Login.DatabaseConnection;

public class DataAccess {
    //Calling this will search the database for any shifts with the same date time value and update if found. otherwise creates new
    public void saveShift(Shift shift) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        
        String sql = "INSERT INTO shifts (user_id, clocked_in, start_time, break_start_time, break_duration, end_time, shift_duration) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?) "
                     + "ON DUPLICATE KEY UPDATE "
                     + "clocked_in = VALUES(clocked_in), "
                     + "break_start_time = VALUES(break_start_time), break_duration = VALUES(break_duration), "
                     + "end_time = VALUES(end_time), shift_duration = VALUES(shift_duration)";
    
        try (PreparedStatement statement = connectDB.prepareStatement(sql)) {
            statement.setInt(1, 4); // User id placeholder for when i implement global user
            statement.setBoolean(2, shift.isClockedIn());
            statement.setString(3, shift.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            statement.setString(4, (shift.getBreakStartTime() != null) ? shift.getBreakStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null);
            statement.setLong(5, (shift.getBreakDuration() != null) ? shift.getBreakDuration().toMinutes() : 0);
            statement.setString(6, (shift.getEndTime() != null) ? shift.getEndTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null);
            statement.setLong(7, (shift.getShiftDuration() != null) ? shift.getShiftDuration().toMinutes() : 0);
    
            statement.executeUpdate();
        }
    }
    public Shift findRecentShift(int userId) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
    
        String sql = "SELECT * FROM shifts WHERE user_id = ? ORDER BY start_time DESC LIMIT 1";
        
        try (PreparedStatement statement = connectDB.prepareStatement(sql)) {
            statement.setInt(1, userId);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Shift shift = new Shift();
                    shift.setClockedIn(resultSet.getBoolean("clocked_in"));
                    shift.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
                    // Set other attributes 
                    
                    return shift;
                } else {
                    return null;
                }
            }
        }
    }
    
}
