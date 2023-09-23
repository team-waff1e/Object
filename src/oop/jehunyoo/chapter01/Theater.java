package oop.jehunyoo.chapter01;

import java.util.*;

public class Theater {

    private List<Movie> movies;
    private Map<Movie, List<Audience>> cinema;
    private TicketOffice ticketOffice;

    public Theater() {
        movies = new ArrayList<>();
        cinema = new HashMap<>();
        ticketOffice = new TicketOffice(); // todo: [refactor] dependency injection
    }

    public boolean welcome(Movie movie, Audience audience) {
        if (ticketOffice.sellTicket(movie, audience)) {
            List<Audience> audienceList = cinema.containsKey(movie) ?
                    cinema.get(movie) : new ArrayList<>();
            audienceList.add(audience);
            cinema.put(movie, audienceList);
            return true;
        }

        return false;
    }

    public void addMovies(Movie[] movies) {
        this.movies.addAll(Arrays.asList(movies));
    }
}
