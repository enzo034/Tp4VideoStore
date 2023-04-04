package VideoStoreTp4Objetos;
import java.util.ArrayList;


public class Client
{

    private String name;
    private String phone;
    private String address;
    private ArrayList<Movie> movies;


    public Client(String name, String phone, String address)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.movies = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    private Ticket generateTicket(Movie movie)
    {
        return new Ticket(this, movie);
    }

    private void addTicketToTheInventory(Inventory tickets, Movie movie) //It generates a ticket with the movie that the customer order
    {
        Ticket ticket = generateTicket(movie);
        tickets.addTicket(ticket);
        System.out.println("The movie " + ticket.getMovie().getTitle() + " has been added to the inventory.\n" +
                "It has been rented by the client Pedro = " + this.name +".\n");

    }

    public void addMovie(Movie movie, Inventory tickets) //Add the movie to the list of movies of the customer
    {
        int amountOfCopies = movie.makeOrder();
        addTicketToTheInventory(tickets, movie);
        if(amountOfCopies >= 0)
        {
            movies.add(movie);
        }
        else
        {
            System.out.println("Try to reserve " + movie.getTitle() + " in another.");
        }
    }

    public void returnMovie(Movie movie) //Bring back the movie to the store inventory
    {
        if(movies.contains(movie))
        {
            movie.returnToInventory(); //++ to the amount of copies of the movie
            System.out.println("The movie " + movie.getTitle() + " has been returned to the inventory.");
            movies.remove(movie);
        }
        else
        {
            System.out.println("The movie " + movie.getTitle() + " cannot be returned because the customer doesn't own it.");
        }

    }

    public String actualMovies() //StringBuilder with all the actual movies of the customer, not the ones that he returned
    {
        StringBuilder movieString = new StringBuilder();
        movieString.append("\n");
        for(Movie movie: movies)
        {
            if(movie != null)
            {
                movieString.append("\t\t-").append(movie.getTitle());
                movieString.append("\n");
            }
        }

        return ""+movieString;
    }

    @Override
    public String toString() {
        return "Client = " + name +
                "\nRented movies = " + actualMovies() +
                "\nAddress = " + address +
                "\nPhone number = " + phone;
    }
}