package Assignment1;
import java.util.Date;

public class ConflictResolver {
    private BookingManager bookingManager;

    public ConflictResolver(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public ConflictResolver() {
		// TODO Auto-generated constructor stub
	}

	public boolean hasConflict(Booking newBooking) {
        return !bookingManager.isRoomAvailable(newBooking.getRoomId(), newBooking.getStartTime(), newBooking.getEndTime());
    }
}
