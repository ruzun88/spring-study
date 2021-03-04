package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 동시 다발적으로 접근할 수 있어야 한다면, Concurrent hashmap 사용 필요 (공부하는 지금은 그냥 해쉬맵을 사용한다..)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
