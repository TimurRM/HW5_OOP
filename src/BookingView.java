
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println("Table No: " + table.getNo());
        }
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo >0) {
            System.out.println("Reservation successful. ID: " + reservationNo);
        } else {
            System.out.println("Reservation failed." + reservationNo);
        }
    }
    public void showReservationTableResult(int reservationId, String name) {
        System.out.println("Reservation successful. ID: " + reservationId + " Name: " + name);
    }

    public void showChangeReservationTableResult(int reservationId, String name) {
        System.out.println("New Reservation successful. ID: " + reservationId + " Name: " + name);
    }


    public void reservationTable(Date orderDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }
    public void showError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void changeReservationTable(int reservationId, Date newDate, int newTableNo, String newName) {
        for (ViewObserver observer : observers) {
            observer.onChangeReservation(reservationId, newDate, newTableNo, newName);
        }
    }
}
