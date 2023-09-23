package oop.jehunyoo.chapter01;

import java.util.Set;

public class Audience {

    Set<Belongings> bag;
    PaymentPolicy[] paymentPolicies;

    public boolean pay(int price, PaymentPolicy paymentPolicy) {
        paymentPolicy.pay();
        /* do something */
        return true;
    }

    public boolean supports(PaymentPolicy paymentPolicy) {
        return true;
    }

    public void addBelongings(Belongings belongings) {
        bag.add(belongings);
    }

    public boolean hasInvitation(Movie movie) {
        return false;
    }
}
