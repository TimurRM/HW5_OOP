import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TableService implements Model {
    private Map<Integer, Table> tables;
    private int reservationCounter;

    public TableService() {
        this.tables = new HashMap<>();
        this.reservationCounter = 100;
        initializeTables();
    }

    private void initializeTables() {
        // Инициализация столов
        for (int i = 1; i <= 5; i++) {
            tables.put(i, new Table(i));
        }
    }

    @Override
    public Collection<Table> loadTables() {
        return tables.values();
    }

    @Override
    public int reserveTable(Date reservationDate, int tableNo, String name) {
        Table table = tables.get(tableNo);
        if (table != null) {
            Reservation reservation = new Reservation(++reservationCounter, tableNo, reservationDate, name);
            table.getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Table number is invalid.");
    }

    @Override
    public boolean changeReservation(int reservationId, Date newDate, int newTableNo, String newName) {
        for (Table table : tables.values()) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationId) {
                    table.getReservations().remove(reservation);
                    Reservation newReservation = new Reservation(++reservationCounter, newTableNo, newDate, newName);
                    Table newTable = tables.get(newTableNo);
                    if (newTable != null) {
                        newTable.getReservations().add(newReservation);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param reservationId идентификатор резервации
     * @param newDate       новая дата резервации
     * @param newTableNo    новый номер столика
     * @param newName       новое имя для бронирования
     * @return true, если резервация успешно изменена, иначе false
     */
    @Override
    public boolean changeReservationTable(int reservationId, Date newDate, int newTableNo, String newName) {
        for (Table table : tables.values()) {
            for (Reservation reservation : table.getReservations()) {
                // Если найдено бронирование с указанным идентификатором
                if (reservation.getId() == reservationId) {
                    Reservation newReservation = new Reservation(++reservationCounter, newTableNo, newDate, newName);
                    Table newTable = tables.get(newTableNo);
                    if (newTable != null) {
                        newTable.getReservations().add(newReservation);
                        table.getReservations().remove(reservation);
                        return true;
                    } else {
                        // Если новый столик не найден, возвращаем false
                        return false;
                    }
                }
            }
        }
        return false;
    }
}