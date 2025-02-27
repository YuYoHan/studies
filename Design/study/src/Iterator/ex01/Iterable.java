package Iterator.ex01;

import java.util.Iterator;

public interface Iterable<E> {
    // 이 메소드는 집합체에 대응하는 Iterator<E>를 만들기 위한 것입니다.
    public abstract Iterator<E> iterator();
}
