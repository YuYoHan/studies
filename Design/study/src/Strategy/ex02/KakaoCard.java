package Strategy.ex02;

public class KakaoCard implements PaymentStrategy{
    private String name;
    private String cardNum;
    private String cvv;
    private String dateExpire;

    public KakaoCard(String name,
                     String cardNum,
                     String cvv,
                     String dateExpire) {
        this.name = name;
        this.cardNum = cardNum;
        this.cvv = cvv;
        this.dateExpire = dateExpire;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid from KakaoCard");
    }
}
