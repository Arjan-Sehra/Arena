import java.util.Random;
import java.util.Arrays;
//Boss class inherits the Character class and implements from Monster
class Boss extends Character implements Monster{
    public Boss(String name){
        //using the table given, I use these attributes to define a Boss character
        super(name, 8, 7, 8, 7);
    }

    public void strike(Character enemy){
        //I use toolbox here to get random numbers in order to define the chance of using the boss's abilities
        Toolbox myToolbox = new Toolbox();
        try {
            int randomNumber = myToolbox.getRandomInteger(100);
            this.increaseEP(3);
            //10% chance
            if (randomNumber <= 10) {
                this.ConcurrentModificationException(enemy);
                //10% chance
            } else if (randomNumber > 10 && randomNumber <= 20) {
                this.NoneTermination();
                //15% chance
            } else if (randomNumber > 20 && randomNumber <= 35) {
                this.ArrayIndexOutOfBoundException(enemy);
                //15% chance
            } else if (randomNumber > 35 && randomNumber <= 50) {
                this.NullPointerException();
                //50% chance
            } else if (randomNumber > 50) {
                this.SyntaxError(enemy);
            }
        } catch (Exception e){
            System.out.println("Boss :///");
        }
    }

    public void SyntaxError(Character enemy){
        enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.increaseEP(3);
        //if the monster defeats the character, the monster receives an additional 4 EPs
        if (enemy.getHP() <= 0){
            this.increaseEP(4);
        }
        //if the monster is attacking a Student, the Student receives 3 KPs
        if (enemy instanceof Student);{
            Student variable = (Student)enemy;
            variable.increaseKP(3);
        }
    }

    public void NullPointerException(){
        this.increaseHP(this.getDefence());
    }

    public void ArrayIndexOutOfBoundException(Character enemy){
        enemy.decreaseHP(2 * ((100 * this.getAttack()) / (100 + enemy.getDefence())));
        enemy.increaseEP(3);
        //if the monster defeats the character, the monster receives an additional 4 EPs
        if (enemy.getHP() <= 0){
            this.increaseEP(4);
        }
        //if the monster is attacking a Student, the Student receives 3 KPs
        if (enemy instanceof Student){
            Student variable = (Student)enemy;
            variable.increaseKP(3);
        }
    }

    //boss attack only
    public void NoneTermination(){
        Team team = this.getTeam();
        Character[] array = team.getMembers();
        //uses for loop to check if their any members of their team are dead. If they are, then Boss resurrects them to full HP
        for (int i=0; i < array.length; i++){
            if (array[i].getHP() <= 0){
                array[i].increaseHP(array[i].getMaxHP());
            }
        }
    }

    //boss attack only
    public void ConcurrentModificationException(Character enemy){
        Team enemyTeam = enemy.getTeam();
        Character[] array = enemyTeam.getMembers();
        for (int i=0; i < array.length; i++){
            //attacks the Characters that are alive
            if (array[i].getHP() > 0){
                array[i].decreaseHP((100 * this.getAttack()) / (100 + array[i].getDefence()));
                array[i].increaseEP(3);
                //if the monster defeats the character, the monster receives an additional 4 EPs
                if (array[i].getHP() <= 0){
                    this.increaseEP(4);
                }
                //if the monster is attacking a Student, the Student receives 3 KPs
                if (array[i] instanceof Student){
                    Student variable = (Student)array[i];
                    variable.increaseKP(3);
                }
            }
        }
    }
}