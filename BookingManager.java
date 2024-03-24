package Assignment1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    public boolean isRoomAvailable(String roomId, Date startTime, Date endTime) {
        for (Booking booking : bookings) {
            if (roomId.equals(booking.getRoomId()) && startTime.before(booking.getEndTime()) && endTime.after(booking.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    public void makeBooking(Booking booking) {
        bookings.add(booking);
    }
}
