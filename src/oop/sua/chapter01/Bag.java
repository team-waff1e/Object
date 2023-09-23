package chapter1;

public class Bag {
    private Ticket ticket;
    private Invitation invitation;
    private Long amount;

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long hold(Ticket ticket) {
        Long fee = ticket.getFee();
        if (this.hasInvitation()) {
            this.setTicket(ticket);
            return 0L;
        } else {
            this.minusAmount(fee);  // pay for ticket
            this.setTicket(ticket);
            return fee;
        }
    }
}
