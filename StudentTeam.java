import java.util.Random;
class StudentTeam extends Team {
    public StudentTeam(String name){
        super(name);
    }

    public void move(Character member, Team enemyTeam) throws Exception {
        //array of enemy team
        Character[] enemyTeamArray = enemyTeam.getMembers();
        Random rand = new Random();
        int positionFromEnemyTeam = rand.nextInt(enemyTeamArray.length);
        //chooses a random target to attack
        Character enemy = enemyTeamArray[positionFromEnemyTeam];

        //array of character team
        Team memberTeam = member.getTeam();
        Character[] memberTeamArray = memberTeam.getMembers();
        Random rando = new Random();
        int characterFromTeam = rando.nextInt(memberTeamArray.length);
        //chooses a random teammate to help or support
        Character person = enemyTeamArray[characterFromTeam];

        Random ran = new Random();
        int randomNumber = ran.nextInt(100);

        //this makes sure that if the KP is < 3. It has a 50/50 chance to either attack or selfStudy
        Student member0 = (Student) member;
        if (member0.currentKP < 3) {
            if (randomNumber < 50) {
                member0.javaProgramming(enemy);
            } else {
                member0.selfStudy();
            }

            //this else means if the KP is >= 3
        } else {

            //if member is in AIStudent, it calculates which move to complete (according to what AIStudent can do)
            if (member instanceof AIStudent) {
                AIStudent member1 = (AIStudent) member;
                //25% chance
                if (randomNumber <= 24) {
                    member1.javaProgramming(enemy);
                    //25% chance
                } else if (randomNumber > 24 && randomNumber <= 49) {
                    member1.selfStudy();
                    //25% chance
                } else if (randomNumber > 49 && randomNumber <= 74) {
                    member1.machineLearning(enemy);
                    //25% chance
                } else if (randomNumber > 74) {
                    member1.naturalLanguageProcessing();
                }
            }
            //if member is in CSStudent, it calculates which move to complete (according to what CSStudent can do)
            if (member instanceof CSStudent) {
                CSStudent member2 = (CSStudent) member;
                //25% chance
                if (randomNumber <= 24) {
                    member2.javaProgramming(enemy);
                    //25% chance
                } else if (randomNumber > 24 && randomNumber <= 49) {
                    member2.selfStudy();
                    //25% chance
                } else if (randomNumber > 49 && randomNumber <= 74) {
                    member2.pairWorking(person, enemy);
                    //25% chance
                } else if (randomNumber > 74) {
                    member2.support(person);
                }
            }
            //if member is in CyberStudent, it calculates which move to complete (according to what CyberStudent can do)
            if (member instanceof CyberStudent) {
                CyberStudent member3 = (CyberStudent) member;
                //33% chance
                if (randomNumber <= 32) {
                    member3.javaProgramming(enemy);
                    //33% chance
                } else if (randomNumber > 32 && randomNumber <= 65) {
                    member3.selfStudy();
                } else {
                    //34% chance
                    member3.cyberAttack(enemyTeam);
                }
            }
            //if member is in SEStudent, it calculates which move to complete (according to what SEStudent can do)
            if (member instanceof SEStudent) {
                SEStudent member4 = (SEStudent) member;
                //25% chance
                if (randomNumber <= 24) {
                    member4.javaProgramming(enemy);
                    //25% chance
                } else if (randomNumber > 24 && randomNumber <= 49) {
                    member4.selfStudy();
                    //25% chance
                } else if (randomNumber > 49 && randomNumber <= 74) {
                    member4.groupWork(enemy);
                    //25% chance
                } else {
                    member4.groupDiscussion();
                }
            }
        }
    }
}