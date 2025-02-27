package Template.ex01;

public class Gun implements Weapon{
    @Override
    public void attack() {
        System.out.println("탕!");
    }
}
