import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private Model model;
    private BookingView view;

    public BookingPresenter(Model model, BookingView view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesView() {
        view.showTables(model.loadTables());
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reserveTable(orderDate, tableNo, name);
        view.showReservationTableResult(reservationNo, name);
    }

    @Override
    public void onChangeReservation(int reservationId, Date newDate, int newTableNo, String newName) {
        boolean success = model.changeReservation(reservationId, newDate, newTableNo, newName);
        if (success) {
            view.showChangeReservationTableResult(reservationId, newName);
            updateTablesView();
        } else {
            view.showError("Failed to change reservation.");
        }
    }

    public void changeReservationTable(int reservationId, Date newDate, int newTableNo, String newName) {
        boolean success = model.changeReservationTable(reservationId, newDate, newTableNo, newName);
        if (success) {
            view.showReservationTableResult(reservationId, newName);
            updateTablesView();
        } else {
            view.showError("Failed to change reservation.");
        }
    }
}