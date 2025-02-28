package builder.ex02;

// 문서를 만들 메서드들 선언하고 있는 추상 클래스
// Builder 역할은 인스턴스를 생성하기 위한 인터페이스(API)를 결정합니다.
// Builder 역할에는 인스턴스의 각 부분을 만들기 위한 메서드가 준비되어 있습니다.
public interface Builder {
     void makeTitle(String title);
     void makeString(String string);
     void makeItems(String[] items);
     void close();
}
