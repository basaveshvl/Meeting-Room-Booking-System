package Assignment1;

import java.util.Date;

public class Booking {
    private String roomId;
    private Date startTime;
    private Date endTime;

    public Booking(String roomId, Date startTime, Date endTime) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getRoomId() {
        return roomId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
