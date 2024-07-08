import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.lang.*;
import java.io.*;

class Battle{
    int rounds = 0;

    public String fight(StudentTeam studentTeam, MonsterTeam monsterTeam){
        //creates 2 arrays of Characters from the 2 teams in the parameter to make them into a StudentTeam and a MonsterTeam
        Character[] studentMembers = studentTeam.getMembers();
        Character[] monsterMembers = monsterTeam.getMembers();

        //creates 3 arraylists (allMembers is created to contain all 10 people that are taking part in the fight)
        ArrayList<Character> StudentMembers = new ArrayList<Character>(Arrays.asList(studentMembers));
        ArrayList<Character> MonsterMembers = new ArrayList<Character>(Arrays.asList(monsterMembers));
        ArrayList<Character> allMembers = new ArrayList<Character>();

        for (int k=0; k < studentMembers.length; k++){
            allMembers.add(studentMembers[k]);
        }
        for (int l=0; l < monsterMembers.length; l++){
            allMembers.add(monsterMembers[l]);
        }

        //sorts the arraylist allMembers in reverse order depending on their speed
        Collections.sort(allMembers, Collections.reverseOrder());

        try {
            //slows the program down by 1 second
            Thread.sleep(1000);

            for (int i = 0; i < allMembers.size(); i++) {
                if (allMembers.get(i).getHP() > 0) {
                    Character randomPerson = allMembers.get(i);
                    //this if condition determines if the member in allMembers is a Student
                    if (allMembers.get(i).baseHP > 5 && allMembers.get(i).getSpeed() < 7) {
                        try {
                            studentTeam.move(randomPerson, monsterTeam);
                        } catch (Exception e) {
                            System.out.println("");
                        }
                        System.out.println("Student " + randomPerson.getName() + " is performing a move.");

                        //this if condition determines if the member in allMembers is a Monster
                    } else if (allMembers.get(i).baseHP < 6 || allMembers.get(i).getSpeed() > 6) {
                        try {
                            monsterTeam.move(randomPerson, studentTeam);
                        } catch (Exception e) {
                            System.out.println("");
                        }
                        System.out.println("Monster " + randomPerson.getName() + " is perfoming a move.");
                    }

                } else {}
            }
            rounds += 1;
        } catch (InterruptedException ie){
            System.out.println("Fight method is not working");
        }

        //this is to determine who won (if anyone won)
        if (studentMembers[0].getHP() <= 0 && studentMembers[1].getHP() <= 0 && studentMembers[2].getHP() <= 0 && studentMembers[3].getHP() <= 0 && studentMembers[4].getHP() <= 0){
            return ("The monsters have won.");
        } else if (monsterMembers[0].getHP() <= 0 && monsterMembers[1].getHP() <= 0 && monsterMembers[2].getHP() <= 0 && monsterMembers[3].getHP() <= 0 && monsterMembers[4].getHP() <= 0){
            return ("The students have won.");
        } else if (rounds >= 30){
            return null;
        } else {
            return ("");
        }
    }
}