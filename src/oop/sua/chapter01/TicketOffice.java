package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(long amount) {
        this.amount += amount;
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void sellTicketTo(Audience audience) {
        Ticket ticket = this.getTicket();
        plusAmount(audience.buy(ticket));
    }
}
