package assets;

/**
 * Created by $Bob, Bram en Michel on $6-2-2017.
 */

public class Artist{
    private String name;
    private String genre;
    private int members;

    public Artist(){
        name = "bob";
        genre = "muziek";
        members = 2;
    }

    public Artist(String name, String genre, int members){
        this.name = name;
        this.genre = genre;
        this.members = members;
    }

    public String getName(){
        return name;
    }

    public String getGenre(){
        return genre;
    }

    public int getMembers(){
        return members;
    }
}


