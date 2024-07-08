class Character{
    public String name;
    public int baseHP;
    public int startingHP;
    public int baseAtk;
    public int startingAtk;
    public int baseDef;
    public int startingDef;
    public int baseSpd;
    public int level;
    public int currentHP;
    public int currentEP;
    public Team team;

    //getter method to get the team the Character belongs to
    public Team getTeam(){
        return this.team;
    }

    //setter method to set the Character to a Team (that's given in the parameters)
    public void setTeam(Team team){
        this.team = team;
    }
    //Constructor
    public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd){
        this.name = name;
        this.baseHP = baseHP;
        this.startingHP = baseHP;
        this.baseAtk = baseAtk;
        this.startingAtk = baseAtk;
        this.baseDef = baseDef;
        this.startingDef = baseDef;
        this.baseSpd = baseSpd;
        this.level = 1;
        this.currentHP = this.baseHP;
        this.currentEP = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getMaxHP(){
        this.baseHP = (int) Math.round(this.startingHP * (Math.pow(this.level, 1.2)));
        return this.baseHP;
    }

    public int getAttack(){
        this.baseAtk = (int) Math.round(this.startingAtk * (Math.pow(this.level, 1.2)));
        return this.baseAtk;
    }

    public int getDefence(){
        this.baseDef = (int) Math.round(this.startingDef * (Math.pow(this.level, 1.2)));
        return this.baseDef;
    }

    public int getSpeed(){
        this.baseSpd = (int) Math.round(this.baseSpd * (Math.pow(this.level, 1.2)));
        return this.baseSpd;
    }

    public int getTargetEP(){
        return (int) Math.round(10 * (Math.pow(this.level, 1.5)));
    }

    public int getHP(){
        return this.currentHP;
    }

    public int getEP(){
        return this.currentEP;
    }

    public void increaseHP(int amount){
        //makes sure that when you increase HP it does not exceed the baseHP value
        if (this.currentHP + amount >= this.baseHP){
            this.currentHP = baseHP;
        } else{
            this.currentHP += amount;
        }
    }

    public void decreaseHP(int amount){
        //when decreasing HP ensures that it does not fall below 0
        if (this.currentHP - amount <= 0){
            this.currentHP = 0;
        } else{
            this.currentHP = this.currentHP - amount;
        }
    }

    public void increaseEP(int amount){
        //character levels up
        if (this.currentEP + amount >= getTargetEP()) {
            this.level += 1;
            //resets EP back to 0 after character levels up
            this.currentEP = 0;

            //resets the HP back to the maximum HP only if the character is still alive
            if (this.currentHP > 0) {
                this.currentHP = this.getMaxHP();
            } else {
                this.currentHP = 0;
            }

        } else{
            this.currentEP += amount;
        }
    }
}