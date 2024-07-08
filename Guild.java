import java.util.ArrayList;
class Guild{
    public ArrayList<Character> guild;

    public Guild(){
        this.guild = new ArrayList<Character>();
    }

    public void addMember(Character member){
        this.guild.add(member);
    }

    public ArrayList<Character> getMembers(){
        return this.guild;
    }

    public Character[] getTeam(Team team){
        return team.getMembers();
    }

}