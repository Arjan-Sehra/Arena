class CSStudent extends Student{
    //Using the table given, created a CSStudent with the right attributes
    public CSStudent(String name){
        super(name, 7, 6, 6, 6, 4);
    }

    public void pairWorking(Character friend, Character enemy) throws Exception {
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            enemy.decreaseHP(this.getAttack() + friend.getAttack());
        }
        //if the enemy dies because of this move, the Student gains an additional 4 EP
        if (enemy.getHP() <= 0) {
            this.increaseEP(4);
        }
    }

    public void support(Character friend) throws Exception {
        //makes sure that the Student cannot use their special abilities if their KP is not their max KP
        if (this.currentKP != this.maxKP) {
            throw new ArithmeticException("You do not have enough KPs to perform this move.");
        } else {
            this.increaseEP(4);
            //resets their KP back to 0
            this.currentKP = 0;
            friend.increaseHP(this.getDefence());
        }
    }

}