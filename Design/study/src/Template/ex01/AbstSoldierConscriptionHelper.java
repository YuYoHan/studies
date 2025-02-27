package Template.ex01;

public abstract class AbstSoldierConscriptionHelper {
    // 시민들 중 마린이 될 수 있는 조건의 시민 징집합니다.
    protected abstract Citizen conscriptionCitizen();
    // 징집된 군인들을 훈련합니다.
    protected abstract void training(Citizen citizen);
    //보직을 시민에서 병사로 변경합니다.
    protected abstract void supplyEquipment(Soldier soldier);
    //장비를 보급합니다.
    protected abstract Soldier changeOfPosition(Citizen citizen);

    // 시민들을 징집해서 병사로 만들어 주세요.
    public Soldier conscription() {
            Citizen citizen = conscriptionCitizen();
            training(citizen);
            Soldier soldier = changeOfPosition(citizen);
            supplyEquipment(soldier);
            return soldier;
        }
}
