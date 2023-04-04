package VideoStoreTp4Objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Inventory
{
    private ArrayList<Movie> billboard;
    private ArrayList<Ticket> tickets;

    public Inventory(ArrayList<Movie> movies, ArrayList<Ticket> tickets)
    {
        this.billboard = movies;
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket)//Used as a secondary function in "addTicketToTheInventory"
    {
        tickets.add(ticket);
    }

    public void showTickets()//Show the tickets of all the customers
    {
        System.out.println("\nAll tickets : \n");
        for(Ticket ticket: tickets)
        {
            if(ticket!=null)
            {
                System.out.println(ticket);
                System.out.println("\n");
            }
        }
    }

    public void showDevolutionOfTheDay()//Show the devolution that have to be made on the day
    {
        for(Ticket ticket : tickets)
        {
            if(ticket != null)
            {
                if(LocalDate.now().equals(ticket.getDevolutionDate()))
                {
                    System.out.println("The movie " + ticket.getMovie().getTitle() +
                            " belonging to the client = " + ticket.getClient().getName() + ", has to be returned today.");
                }
            }
        }
    }

    public void showRentsClient(Client client) //Show the rents of certain client
    {
        for(Ticket ticket : tickets)
        {
            if(ticket != null)
            {
                if(ticket.getClient().equals(client))
                {
                    System.out.println(ticket);
                }
            }
        }
    }

    public void popularMovies() //Show all the movies according to the amount of orders that it have.
    {
        ArrayList<Movie> aux = billboard;
        aux.sort(Comparator.comparingInt(Movie::getOrders));
        int n = aux.size();

        System.out.println("\nMovies sort according to his popularity = ");
        for(int i = n; i>0;i--)
        {
            System.out.println("\t\n_" + aux.get(i-1).getTitle());
        }
    }
    public void filterByGender(String gender) //Filter according to the gender and show the movies on popular sort
    {
        ArrayList<Movie> aux = billboard;
        aux.sort(Comparator.comparingInt(Movie::getOrders));

        System.out.println("Showing the most popular by gender " + gender + " in ascending order.");

        for (Movie movie : billboard)
        {
            if(movie.getGender().equals(gender.toLowerCase()))
            {
                System.out.println(movie.getTitle() + ". Total orders = " + movie.getOrders());
            }
        }
    }

    public void movieDetails(Movie movie)
    {
        System.out.println(movie);
    }
}
