package oop.jehunyoo.chapter01;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater();
        Movie[] movies = {
                new Movie("Avatar2", 10000),
                new Movie("Interstellar", 12000)
        };
        Audience[] audiences = new Audience[]{
                new Audience(),
                new Audience()
        };

        theater.addMovies(movies);
        for (int i = 0; i < audiences.length; i++) {
            if (theater.welcome(movies[i], audiences[i]))
                System.out.println("audiences[i] = " + audiences[i]);
        }
    }
}
