package oop.jehunyoo.chapter01;

import java.util.Arrays;
import java.util.Optional;

public class TicketOffice {

    private PaymentPolicy[] paymentPolicies;

    public TicketOffice() {}

    public TicketOffice(PaymentPolicy[] paymentPolicies) {
        this.paymentPolicies = paymentPolicies;
    }

    public boolean sellTicket(Movie movie, Audience audience) {
        if (audience.hasInvitation(movie))
            return true;

        Optional<PaymentPolicy> paymentPolicyOptional = Arrays.stream(paymentPolicies)
                .filter(p -> audience.supports(p))
                .findFirst();

        if (paymentPolicyOptional.isPresent()) { // todo: [refactor] isPresent - get
            PaymentPolicy paymentPolicy = paymentPolicyOptional.get();
            audience.pay(movie.getPrice(), paymentPolicy);
            return true;
        }

        return false;
    }

}
