import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();
    int reserveTable(Date reservationDate, int tableNo, String name);
    boolean changeReservation(int reservationId, Date newDate, int newTableNo, String newName);

    boolean changeReservationTable(int reservationId, Date newDate, int newTableNo, String newName);
}
