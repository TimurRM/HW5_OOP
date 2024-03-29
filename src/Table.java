import java.util.ArrayList;
import java.util.List;

public class Table {
    private int no;
    private List<Reservation> reservations;

    public Table(int no) {
        this.no = no;
        this.reservations = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}

