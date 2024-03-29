import java.util.Date;

public class Program {

    public static void main(String[] args) {
        TableService model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);


        model.loadTables();
        presenter.updateTablesView();

        presenter.onReservationTable(new Date(), 1, "Иван Иванов");
        presenter.onChangeReservation(101, new Date(), 4, " Даниил");
        presenter.changeReservationTable(102, new Date(), 5, "Петр Ильич");
        presenter.changeReservationTable(103, new Date(),  5, "Сергей Николаев");
    }
}

