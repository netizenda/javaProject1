import java.util.ArrayList;

public class SportsClubManagementSystem {
    // sport class
    static class Sport {
        private String name, type;
        private int numberOfPlayers;
        // constructor
        public Sport(String name, String type, int numberOfPlayers) {
            this.name = name;
            this.type = type;
            this.numberOfPlayers = numberOfPlayers;
        }
        public String getName() { return name; }
        // method to display sport details
        public void displaySportDetails() {
            System.out.println("Sport: " + name + ", Type: " + type + ", Players: " + numberOfPlayers);
        }
    }
    // athlete Class
    static class Athlete {
        private String name;
        private int age;
        private Sport sport;
        // constructor
        public Athlete(String name, int age, Sport sport) {
            this.name = name;
            this.age = age;
            this.sport = sport;
        }
        public String getName() { return name; }
        // method to athletes details
        public void displayAthleteDetails() {
            System.out.println("Athlete: " + name + ", Age: " + age + ", Sport: " + sport.getName());
        }
        // method to compare athletes by name
        public boolean isSameAthlete(Athlete other) { return this.name.equals(other.name); }
    }
    // SportsClub Class
    static class SportsClub {
        private String clubName;
        private ArrayList<Athlete> athletes = new ArrayList<>();

        public SportsClub(String clubName) { this.clubName = clubName; }
        // add an athlete to the club
        public void addAthlete(Athlete athlete) { athletes.add(athlete); }
        // display all athletes in the club
        public void displayClubDetails() {
            System.out.println("Sports Club: " + clubName);
            athletes.forEach(Athlete::displayAthleteDetails);
        }
        // compare athletes by name
        public void compareAthletes(Athlete a1, Athlete a2) {
            System.out.println(a1.getName() + (a1.isSameAthlete(a2) ? " and " : " and ") + a2.getName() + " are " + (a1.isSameAthlete(a2) ? "the same." : "different."));
        }
    }
    // main function
    public static void main(String[] args) {
        Sport basketball = new Sport("Basketball", "Team", 5);
        Sport tennis = new Sport("Tennis", "Individual", 1);

        Athlete athlete1 = new Athlete("Danial", 18, basketball);
        Athlete athlete2 = new Athlete("Damir", 19, tennis);
        Athlete athlete3 = new Athlete("Diana", 18, basketball);

        SportsClub club = new SportsClub("Tiger Sports Club");
        club.addAthlete(athlete1);
        club.addAthlete(athlete2);
        club.addAthlete(athlete3);

        club.displayClubDetails();
        club.compareAthletes(athlete1, athlete2);
        club.compareAthletes(athlete1, athlete3);
    }
}
