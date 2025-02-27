package Strategy.ex01;

public class GameCharacter {
    // 접근점
    private Weapon weapon;

    // 교환 가능
    // 이 메서드를 통해서 접근점을 변경할 수 있다.
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // 무기(Weapon)은 공격이라는 기능을 가지는 하나의 접근점이 된다.
    public void attack() {
        if(weapon == null) {
            System.out.println("맨손 공격");
        } else {
            // 위임
            weapon.attack();
        }
    }
}
