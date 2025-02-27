package Factory.ex02;

// 여기 역할이 creator인데
// Creator 역할이 가지고 있는 정보는 Product 역할과
// 인스턴스 생성의 메소드를 호출하면 Product가 생성된다는 것 뿐입니다.
// new를 사용해서 실제의 인스턴스를 생성하는 대신에 인스턴스 생성을 위한
// 메서드를 호출해서 구체적인 클래스 이름에 의한 속박에서 상위 클래스를
// 자유롭게 만듭니다.
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 상품을 생성
    protected abstract Product createProduct(String owner);

    // 상품을 등록
    protected abstract void registerProduct(Product product);
}
