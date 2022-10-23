import java.util.Arrays;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] searchByArrival(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchesArrival(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesArrival(Ticket ticket, String search) {
        if (ticket.getIATA_Arrival().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] searchByDepature(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchesDepature(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matchesDepature(Ticket ticket, String search) {
        if (ticket.getIATA_Depature().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAllBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchesFromAndTo(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matchesFromAndTo(Ticket ticket, String from, String to) {
        if (!ticket.getIATA_Depature().equals(from)) {
            return false;
        }

        if (!ticket.getIATA_Arrival().equals(to)) {
            return false;
        }
        return true;
    }
}
