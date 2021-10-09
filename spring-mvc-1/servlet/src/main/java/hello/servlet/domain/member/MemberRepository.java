package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제가 고려되지 않았으므로, Concurrent Hashmap, AtomicLong 사용 고려
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository(){}

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store 자체를 보호하기 위해 새로운 객체에 담아서 준다.
    }

    public void clearStore() {
        store.clear();
    }
}
