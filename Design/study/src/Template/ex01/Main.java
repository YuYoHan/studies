package Template.ex01;

public class Main {
    public static void main(String[] args) {
        Citizen h1 = new Citizen();
        AbstSoldierConscriptionHelper helper = new SoldierConscriptionHelperImpl();
        Soldier soldier = helper.conscription();
        soldier.attack();
        soldier.defense();
    }
}
