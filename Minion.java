import java.util.Random;
import java.util.Arrays;
//Minion class inherits the Character class and implements from Monster
class Minion extends Character implements Monster{
    public Minion(String name){
        //using the table given, I use these attributes to define a Minion character
        super(name, 5, 5, 5, 5);
    }

    public void strike(Character enemy){
        //I use toolbox here to get random numbers in order to define the chance of using the boss's abilities
        Toolbox myToolbox = new Toolbox();
        try {
            int randomNumber = myToolbox.getRandomInteger(100);
            //10% chance
            if (randomNumber <= 10) {
                this.ArrayIndexOutOfBoundException(enemy);
                //15% chance
            } else if (randomNumber > 10 && randomNumber <= 25) {
                this.NullPointerException();
                //75% chance
            } else if (randomNumber > 25) {
                this.SyntaxError(enemy);
            }
        } catch (Exception e){
            System.out.println("minion :/");
        }
    }

    public void SyntaxError(Character enemy){
        this.increaseEP(3);
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
        this.increaseEP(3);
        this.increaseHP(this.getDefence());
    }

    public void ArrayIndexOutOfBoundException(Character enemy){
        this.increaseEP(3);
        enemy.decreaseHP(2 * ((100 * this.getAttack()) / (100 + enemy.getDefence())));
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

}