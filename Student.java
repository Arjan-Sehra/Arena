//Student inherits the Character class
class Student extends Character{
    public int maxKP;
    public int currentKP;

    //Constructor
    public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP){
        //attributes of the Character class (being used in the Student class)
        super(name, baseHP, baseAtk, baseDef, baseSpd); //this allows us to use methods that belong in the Character class
        this.currentKP = 0;
        this.maxKP = maxKP;
    }

    public void increaseKP(int amount){
        //ensures the KP does not exceed the maximum KP allowed
        if (this.currentKP + amount > this.maxKP){
            this.currentKP = this.maxKP;
        } else{
            this.currentKP += amount;
        }
    }

    public void javaProgramming(Character enemy){
        this.increaseEP(3);
        this.increaseKP(1);
        enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.increaseEP(2);
        //if the enemy dies from this attack, this Student receives an additional 4 EPs
        if (enemy.getHP() <= 0){
            this.increaseEP(4);
        }
    }

    public void selfStudy(){
        this.increaseHP(2);
        this.increaseEP(6);
        this.increaseKP(2);
    }
}