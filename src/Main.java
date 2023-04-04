import VideoStoreTp4Objetos.Inventory;

import java.util.ArrayList;
import VideoStoreTp4Objetos.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets= new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        Inventory invTickets = new Inventory(movies, tickets);

        Movie movie1 = new Movie("Fast and furious", "20/10/1999", 128.0, "R", "USA", "American media franchise focused on a series of action films dealing heavily with automobiles", "action", 15);
        Movie movie2 = new Movie("Snow white and the seven dwarfs", "3/12/1980", 94.0, "G", "USA", "Animated movie", "fantasy", 5);
        Movie movie3 = new Movie("Wish in boots: The Last Puss", "5/1/2023", 100, "G", "USA", "Animated movie", "adventure", 15);
        Movie movie4 = new Movie("Puss In Boots: The Last Wish", "5/1/2023", 100, "G", "USA", "Animated movie", "adventure", 15);
        Movie movie5 = new Movie("Terrifier 2", "6/10/2022", 138, "NC-17", "USA", "Movie of terror and gore", "horror", 5);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        Client client1 = new Client("Jorge Ramirez", "2234512785", "Fake 123");
        Client client2 = new Client("Pedro Cuchitril", "2234512443", "Fake 321");
        Client client3 = new Client("Juan Titiberto", "2231137886", "Fake 456");

        client1.addMovie(movie1, invTickets);
        client1.addMovie(movie1, invTickets);
        client2.addMovie(movie1, invTickets);
        client3.addMovie(movie2, invTickets);
        client3.addMovie(movie2, invTickets);
        client3.addMovie(movie3, invTickets);

        invTickets.showRentsClient(client1);

        invTickets.popularMovies();
        invTickets.filterByGender("action");

        client1.returnMovie(movie1);

        invTickets.movieDetails(movie1);

        invTickets.showTickets();
        invTickets.showDevolutionOfTheDay();

        //A menu would be ideal for this (:(
    }
}