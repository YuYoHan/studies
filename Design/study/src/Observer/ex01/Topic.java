package Observer.ex01;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
    private List<Observer> observerList;
    private String message;

    public Topic() {
        this.observerList = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer obj) {
        // contains() 함수는 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수
        // 대소문자 구분
        if(!observerList.contains(obj)) {
            observerList.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        observerList.remove(obj);
    }

    @Override
    public void notifyObservers() {
        this.observerList.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }
    public void postMessage(String msg) {
        System.out.println("Message sended to Topic : " + msg);
        this.message = msg;
        notifyObservers();
    }
}
