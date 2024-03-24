package Assignment1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Room getRoom(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
