package datastructure.map;

import datastructure.map.obj.Member;

public class MyTreeMapDriver {

    public static void main(String[] args) {
        MyTreeMap<Long, Member> memberMyTreeMap = new MyTreeMap<>();
        putMembers(memberMyTreeMap);

        Member member10 = find(10);

        Member member5 = find(5);
    }

    private static void putMembers(MyTreeMap<Long, Member> memberMyTreeMap){
        Member sara = new Member(9L, "사라", "sara@gmail.com", 37, "FEMALE");
        Member ndg = new Member(1L, "동길", "ndgndg91@gmail.com", 30, "MALE");
        Member jane = new Member(4L, "제이니", "jane@gmail.com", 37, "FEMALE");
        Member jin = new Member(6L, "진", "jin@gmail.com", 36, "FEMALE");
        Member john = new Member(5L, "존", "john@gmail.com", 32, "MALE");
        Member gil = new Member(2L, "기리", "giri@gmail.com", 30, "MALE");
        Member brian = new Member(7L, "브라이언", "brian@gmail.com", 29, "MALE");
        Member anne = new Member(8L, "안느", "anne@gmail.com", 31, "FEMALE");
        Member suzi = new Member(3L, "수지", "suzi@gmail.com", 26, "FEMALE");

        memberMyTreeMap.put(sara.getId(), sara);
        memberMyTreeMap.put(ndg.getId(), ndg);
        memberMyTreeMap.put(jane.getId(), jane);
        memberMyTreeMap.put(jin.getId(), jin);
        memberMyTreeMap.put(john.getId(), john);
        memberMyTreeMap.put(gil.getId(), gil);
        memberMyTreeMap.put(brian.getId(), brian);
        memberMyTreeMap.put(anne.getId(), anne);
        memberMyTreeMap.put(suzi.getId(), suzi);
    }

    private static Member find(long key) {
        return null;
    }

    private static void print(Member member) {
        System.out.println(member);
    }
}
