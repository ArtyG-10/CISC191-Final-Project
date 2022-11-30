
/*
 * This class is currently only used to store a players name. For the future it may be used to store a players high score.
 */
public class Player
{
    private String name;		//Users inputed name

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}