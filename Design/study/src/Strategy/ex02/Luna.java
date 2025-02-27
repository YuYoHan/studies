package Strategy.ex02;

public class Luna implements PaymentStrategy{
    private String id;
    private String password;

    public Luna(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount+"paid using from LunaCard");
    }
}
