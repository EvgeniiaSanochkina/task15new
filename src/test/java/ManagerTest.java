import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Ticket ticket1 = new Ticket(1, 1000, "IST", "OVB", 5);
    Ticket ticket2 = new Ticket(2, 2000,"OVB", "VVO", 4);
    Ticket ticket3 = new Ticket(3, 2500,"VVO", "PEK", 6);
    Ticket ticket4 = new Ticket(4, 1000, "PEK", "IST", 6);
    Ticket ticket5 = new Ticket(5, 2000,"IST", "BER", 4);
    Ticket ticket6 = new Ticket(6, 1500,"VVO", "PEK", 4);
    Ticket ticket7 = new Ticket(7, 1000, "PEK", "IST", 5);
    Ticket ticket8 = new Ticket(8, 2000,"IST", "BER", 7);
    Ticket ticket9 = new Ticket(9, 1500,"VVO", "PEK", 3);
    @Test
    public void searchByArrivalandDepatureTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.findAllBy("VVO","PEK");
        Ticket[] expected = {ticket6, ticket9, ticket3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void searchByArrivalTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.searchByArrival("VVO");
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void searchByDepatureTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.searchByDepature("IST");
        Ticket[] expected = {ticket1, ticket5};
        Assertions.assertArrayEquals(actual, expected);
    }
}
