public class Ticket implements Comparable<Ticket> {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIATA_Depature() {
        return IATA_Depature;
    }

    public void setIATA_Depature(String IATA_Depature) {
        this.IATA_Depature = IATA_Depature;
    }

    public String getIATA_Arrival() {
        return IATA_Arrival;
    }

    public void setIATA_Arrival(String IATA_Arrival) {
        this.IATA_Arrival = IATA_Arrival;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected int id;
    protected int price;
    protected String IATA_Depature;
    protected String IATA_Arrival;
    protected int flightTime;

    public Ticket(int id, int price, String IATA_Depature, String IATA_Arrival, int flightTime) {
        this.id = id;
        this.price = price;
        this.IATA_Depature = IATA_Depature;
        this.IATA_Arrival = IATA_Arrival;
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}

