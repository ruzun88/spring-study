package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 static으로 등록해버리므로, static 영역에 하나만 존재하게 된다
    private static final SingletonService instance = new SingletonService();

    // 생성할 수 있는 곳이 없으므로, 유일하게 이 객체를 받아오는 곳은 이 메서드 뿐이다.
    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자를 통해 외부에서 이 객체를 새로 생성하지 못하게 막는다.
    private SingletonService() {
    }
}
