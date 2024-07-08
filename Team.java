import java.util.ArrayList;
import java.util.Iterator;
//abstract class
abstract class Team{
    public String name;
    public ArrayList<Character> members;

    //abstract method
    abstract public void move(Character member, Team enemyTeam) throws Exception;

    //Constructor
    public Team(String name){
        this.name = name;
        this.members = new ArrayList<Character>();
    }

    public String getName(){
        return this.name;
    }

    //returns an array (converts the ArrayList to an Array before returning)
    public Character[] getMembers(){
        Character[] array = this.members.toArray(new Character[0]);
        return array;
    }

    public int addMember(Character member) {
        //if there is nothing in the team, then add the character into it and return the size of the array list
        if (this.members.size() == 0) {
            this.members.add(member);
            return this.members.size();
        } else {
            int i = 0;
            //for loop to check if the character being added already exists in the array list
            for (Character character : this.members){
                Character currentCharacter = this.members.get(i);
                if (currentCharacter.getName() == member.getName()){
                    return -1;
                }
                i++;
            }

            if (this.members.size() == 5) {
                return -2;
            }

        }

        //if the size is not greater then 5, there are elements in the array list and the character trying to be added does not already exist then add the character to the array list
        this.members.add(member);
        return this.members.size();
    }
}