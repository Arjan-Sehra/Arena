import java.util.Random;
class MonsterTeam extends Team {
    public MonsterTeam(String name){
        super(name);
    }

    public void move(Character member, Team enemyTeam) throws Exception{
        //array of the enemy team
        Character[] array = enemyTeam.getMembers();
        Random rando = new Random();
        int characterFromEnemyTeam = rando.nextInt(array.length);
        Character enemy = array[characterFromEnemyTeam];

        Team memberTeam = member.getTeam();
        //array of the character's team
        Character[] array1 = memberTeam.getMembers();
        Random rand = new Random();
        int characterFromTeam = rand.nextInt(array1.length);
        Character person = array[characterFromEnemyTeam];

        Random ran = new Random();
        int randomNumber = ran.nextInt(100);
        //if the member is a minion
        if (member instanceof Minion){
            Minion member1 = (Minion)member;
            member1.strike(enemy);
        //if the member is a boss
        } else if (member instanceof Boss){
            Boss member1 = (Boss)member;
            member1.strike(enemy);
        }
    }
}