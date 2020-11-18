package iesnervion.fjmarquez.recyclerviewnba;

public class Team {

    private String nameTeam;
    private int imgTeam;

    public Team (String nameTeam, int imgTeam){
        this.nameTeam = nameTeam;
        this.imgTeam = imgTeam;
    }

    public String getNameTeam(){
        return this.nameTeam;
    }

    public int getImgTeam(){
        return this.imgTeam;
    }

}