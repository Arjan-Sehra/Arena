import java.util.ArrayList;
import java.util.Arrays;
class SEStudent extends Student {
    //Using the table given, created a SEStudent with the right attributes
    public SEStudent(String name){
        super(name, 8, 5, 8, 4, 10);
    }

    public void groupWork(Character enemy) throws Exception {
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            Team team = this.getTeam();
            Character[] array = team.getMembers();
            //for loop so that every member of the Student team attacks the same enemy
            for (int i=0; i < array.length; i++) {
                //ensures that only alive members can attack the enemy
                if (array[i].getHP() > 0) {
                    enemy.decreaseHP((100 * array[i].getAttack()) / (100 + enemy.getDefence()));
                }
            }
        }
        //if the enemy dies because of this move, the Student gains an additional 4 EP
        if (enemy.getHP() <= 0) {
            this.increaseEP(4);
        }
    }

    public void groupDiscussion() throws Exception{
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            Team team = this.getTeam();
            Character[] array = team.getMembers();
            //for loop to ensure that every member gets healed (only the alive members)
            for (int i=0; i < array.length; i++) {
                //makes sure only the alive members get healed
                if (array[i].getHP() > 0) {
                    array[i].increaseHP(this.getDefence() / 2);
                }
            }
        }
    }

}