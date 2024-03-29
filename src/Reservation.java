import java.util.Date;

public class Reservation {
    private int id;
    private int tableNo;
    private Date date;
    private String name;

    public Reservation(int id, int tableNo, Date date, String name) {
        this.id = id;
        this.tableNo = tableNo;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public void setName(String name) {
        this.name = name;
    }
}


