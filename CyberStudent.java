import java.util.ArrayList;
import java.util.Arrays;
class CyberStudent extends Student{
    //Using the table given, created a CyberStudent with the right attributes
    public CyberStudent(String name){
        super(name, 7, 7, 5, 6, 6);
    }

    public void cyberAttack(Team enemyTeam){
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            Character[] array = enemyTeam.getMembers();
            //for loop to attack every member on the enemy team
            for (int i=0; i < array.length; i++) {
                //makes sure the enemy being attacked is alive (the Student attacks only alive members of the Monster Team)
                if (array[i].getHP() > 0){
                    array[i].decreaseHP(this.getAttack());
                    //if the enemy dies because of this move, the Student gains an additional 4 EP
                    if (array[i].getHP() <= 0) {
                        this.increaseEP(4);
                    }
                }
            }
        }
    }
}