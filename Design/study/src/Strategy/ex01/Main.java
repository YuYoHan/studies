package Strategy.ex01;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();
        // 맨손 공격이 나온다.
        character.attack();

        // Weapon에게 Knife를 접근하게 해서 칼 공격이 나옴
        character.setWeapon(new Knife());
        character.attack();
        // Weapon에게 Sword를 접근하게 해서 검 공격이 나옴
        character.setWeapon(new Sword());
        character.attack();

        /*
        *   하나의 인터페이스를 통해서 여러개의 상속받은 클래스들에게 접촉해서
        *   오버라이딩한 메서드를 사용할 수 있다.
        *   이렇게 하면 장점은 여러 클래스를 추가하기 편합니다.
        * */
    }
}
