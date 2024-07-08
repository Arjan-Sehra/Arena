class AIStudent extends Student{
//Using the table given, created an AIStudent with the right attributes
    public AIStudent(String name){
        super(name, 6, 7, 7, 5, 3);
    }

    public void machineLearning(Character enemy) throws Exception {
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            enemy.decreaseHP(2 * ((100 * this.getAttack()) / (100 + enemy.getDefence())));
            //if the enemy dies because of this move, the Student gains an additional 4 EP
            if (enemy.getHP() <= 0) {
                this.increaseEP(4);
            }
        }
    }

    public void naturalLanguageProcessing() throws Exception{
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            this.increaseHP(this.getDefence());
        }
    }

}