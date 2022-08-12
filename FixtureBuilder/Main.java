package FixtureBuilder;



public class Main {
    public static void main(String[] args) {
        TeamsController teamsController=new TeamsController();
        teamsController.list.add("Beşiktaş");
        teamsController.list.add("Fenerbahçe");
        teamsController.list.add("Galatasaray");
        teamsController.list.add("Başakşehir");
        teamsController.list.add("Ankara Gücü");
        teamsController.list.add("Trabzonspor");
        teamsController.list.add("Gençlerbirliği");

        teamsController.ligFixture();



    }
}
