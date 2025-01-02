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

        // getter method
        public String getName() {
            return name;
        }

        public void displaySportDetails() {
            System.out.println("Sport: " + name + ", Type: " + type + ", Players: " + numberOfPlayers);
        }
    }

    // TeamSport class extending Sport
    static class TeamSport extends Sport {
        private int teamSize;

        public TeamSport(String name, String type, int numberOfPlayers, int teamSize) {
            super(name, type, numberOfPlayers);
            this.teamSize = teamSize;
        }

        @Override
        public void displaySportDetails() {
            super.displaySportDetails();
            System.out.println("Team Size: " + teamSize);
        }
    }

    // IndividualSport class extending Sport
    static class IndividualSport extends Sport {
        public IndividualSport(String name, String type, int numberOfPlayers) {
            super(name, type, numberOfPlayers);
        }

        @Override
        public void displaySportDetails() {
            super.displaySportDetails();
            System.out.println("This is an individual sport.");
        }
    }

    // athlete Class
    static class Athlete {
        private String name;
        private int age;
        private Sport sport;
        private String coach;
        private String trainingSchedule;

        // constructor
        public Athlete(String name, int age, Sport sport, String coach, String trainingSchedule) {
            this.name = name;
            this.age = age;
            this.sport = sport;
            this.coach = coach;
            this.trainingSchedule = trainingSchedule;
        }

        // getter method
        public String getName() {
            return name;
        }

        public void displayAthleteDetails() {
            System.out.println("Athlete: " + name + ", Age: " + age + ", Sport: " + sport.getName());
            System.out.println("Coach: " + coach);
            System.out.println("Training Schedule: " + trainingSchedule);
        }

        // method to compare athletes by name
        public boolean isSameAthlete(Athlete other) {
            return this.name.equals(other.name);
        }
    }

    // SportsClub Class
    static class SportsClub {
        private String clubName;
        private String location;
        private ArrayList<Athlete> athletes = new ArrayList<>();

        public SportsClub(String clubName, String location) {
            this.clubName = clubName;
            this.location = location;
        }

        // add an athlete to the club
        public void addAthlete(Athlete athlete) {
            athletes.add(athlete);
        }

        // display all athletes in the club
        public void displayClubDetails() {
            System.out.println("Sports Club: " + clubName);
            System.out.println("Location: " + location);
            athletes.forEach(Athlete::displayAthleteDetails);
        }

        // find athlete by name
        public Athlete findAthleteByName(String name) {
            return athletes.stream()
                    .filter(athlete -> athlete.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
        }
    }

    // main function
    public static void main(String[] args) {
        Sport BJJ = new TeamSport("Brazilian Jiu-Jitsu", "Team", 5, 12);
        Sport box = new IndividualSport("Box", "Individual", 1);

        Athlete athlete1 = new Athlete("Danial", 18, BJJ, "Coach Khabib", "Monday, Wednesday, Friday 10:00 AM - 12:00 PM");
        Athlete athlete2 = new Athlete("Damir", 19, box, "Coach Mike", "Tuesday, Thursday 2:00 PM - 4:00 PM");
        Athlete athlete3 = new Athlete("Diana", 18, BJJ, "Coach Khabib", "Monday, Wednesday, Friday 10:00 AM - 12:00 PM");

        SportsClub club = new SportsClub("Tiger Sports Club", "Astana");
        club.addAthlete(athlete1);
        club.addAthlete(athlete2);
        club.addAthlete(athlete3);

        club.displayClubDetails();

        // Find an athlete by name
        String searchName = "Diana";
        Athlete foundAthlete = club.findAthleteByName(searchName);
        if (foundAthlete != null) {
            System.out.println("Found athlete:");
            foundAthlete.displayAthleteDetails();
        } else {
            System.out.println("Athlete with name " + searchName + " not found.");
        }
    }
}
