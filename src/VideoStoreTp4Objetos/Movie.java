package VideoStoreTp4Objetos;
public class Movie
{

    private String gender;
    private int amountOfCopies;
    private int orders;
    private String title;
    private String releaseDate;
    private double duration;
    private String audience;
    private String countryAcronym;
    private String description;

    public Movie(String title, String releaseDate, double duration, String audience, String countryAcronym, String description, String gender, int amountOfCopies)
    {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.audience = audience;
        this.countryAcronym = countryAcronym;
        this.description = description;
        this.gender = gender;
        this.amountOfCopies = amountOfCopies;
        this.orders = 0;
    }

    public String getGender() {
        return gender;
    }
    public int getOrders() {
        return orders;
    }
    public String getTitle() {
        return title;
    }

    public int makeOrder()//Used as a secondary function, it just changes the amount of copies of the movie
    {
        if(amountOfCopies == 0)
        {
            System.out.println("There's no more copies of this movie");
            --amountOfCopies;//Without this, in the "add Movie" function the movie is added regardless of the fact that there are no copies
                             //Doesn't care if there are -1 copies, it is fixed in the "returnToInventory" function.
        }else
        {
            --amountOfCopies;
            ++orders;
        }

        return amountOfCopies;
    }

    public int returnToInventory() //If there is no copies or the amount is less than 0 (because of "makeOrder"), the function will set the copies in 1, if not, it will add 1
    {
        return amountOfCopies <= 0 ? amountOfCopies=1 : ++amountOfCopies;
    }

    @Override
    public String toString() {
        return "Movie : \n[Title = " + title +
                "\n | Gender = " + gender +
                "\n | Description = \" " + description + " \"" +
                "\n | Audience rating = " + audience +
                "\n | Duration (minutes) = " + duration +
                "\n | Country acronym = " + countryAcronym +
                "\n | Release date = " + releaseDate +"]";
    }
}