package VideoStoreTp4Objetos;

import java.time.LocalDate;

public class Ticket
{

    private LocalDate orderDate;
    private LocalDate devolutionDate;
    private Client client;
    private Movie movie;


    public Ticket(Client cliente, Movie pelicula)
    {
        this.orderDate = LocalDate.now();
        this.devolutionDate = orderDate.plusDays(7);
        this.client = cliente;
        this.movie = pelicula;
    }

    public Client getClient() {
        return client;
    }
    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }
    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Client's ticket : " + client.getName() +
                "\nFor the movie : " + movie.getTitle() +
                "\nDate of order : " + orderDate +
                "\nDate of devolution expected : " + devolutionDate;
    }
}