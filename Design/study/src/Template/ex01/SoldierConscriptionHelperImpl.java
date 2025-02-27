package Template.ex01;

public class SoldierConscriptionHelperImpl extends AbstSoldierConscriptionHelper {

    @Override
    protected Soldier changeOfPosition(Citizen citizen) {
        System.out.println("시민->병사 변경!");
        return new Soldier(citizen);
    }

    @Override
    protected void supplyEquipment(Soldier soldier) {
        soldier.setWeapon(new Gun());
        soldier.setArmor(new SteelAmor());
        System.out.println("장비 보급!");
    }

    @Override
    protected void training(Citizen citizen) {
        citizen.updateStrength(5);
        citizen.updateAgility(4);
        citizen.updateIntelligence(-3);
        System.out.println("병사 훈련!");
    }

    @Override
    protected Citizen conscriptionCitizen() {
        System.out.println("징집!");
        return new Citizen();
    }
}
