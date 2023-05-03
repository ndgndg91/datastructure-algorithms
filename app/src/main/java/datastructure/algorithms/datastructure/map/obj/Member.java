package datastructure.algorithms.datastructure.map.obj;

public final class Member {
    private final long id;
    private final String name;
    private final Email email;
    private final int age;
    private final Sex sex;

    private enum Sex {
        MALE,
        FEMALE,
        ETC
    }

    public Member(long id, String name, String email, int age, String sex) {
        this.id = id;
        this.name = name;
        this.email = new Email(email);
        this.age = age;
        this.sex = Sex.valueOf(sex);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    private static final class Email {
        private final String address;

        public Email(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("address=")
                    .append(address)
                    .toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        return toStringBuilder
                .append("id=")
                .append(id)
                .append("name=")
                .append(name)
                .append("email=")
                .append(email)
                .append("age=")
                .append(age)
                .append("sex=")
                .append(sex)
                .toString();
    }
}
