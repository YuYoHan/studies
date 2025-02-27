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
        builder.makeTitle("Greeting");
        builder.makeString("아침과 낮에");
        builder.makeItems(new String[]{"좋은 아침입니다.", "안녕하세요"});
        builder.makeItems(new String[]{
                "안녕하세요",
                "안녕히 주무세요",
                "안녕히 계세요",
        });
        builder.close();
    }
}
