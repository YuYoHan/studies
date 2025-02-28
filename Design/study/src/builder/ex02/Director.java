package builder.ex02;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // Builder 추상클래스에 선언되어 있는 메서드를 사용해서 문서 생성 로직 구현
    // constructor 는 메소드 문서 구축 메소드로 Builder에서 선언되어 있는 메소드만 사용합니다.
    // 이 메소드를 호출하면 문서가 생성됩니다.
    public void construct() {
        builder.makeTitle("제목");
        builder.makeString("에스파");
        builder.makeItems(new String[]{"카리나", "윈터"});
        builder.close();
    }
}
