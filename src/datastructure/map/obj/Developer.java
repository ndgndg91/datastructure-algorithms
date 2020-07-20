package datastructure.map.obj;

import java.util.Objects;

public final class Developer {
    private final String name;
    private final int age;
    private final Sex sex;
    private final Language language;

    private enum Language {
        JAVA,
        GO,
        PYTHON,
        C
    }

    private enum Sex {
        MALE,
        FEMALE,
        ETC
    }

    public Developer(String name, int age, String sex, String language) {
        this.name = name;
        this.age = age;
        this.sex = Sex.valueOf(sex);
        this.language = Language.valueOf(language);
    }

    public Developer(String name, int age, Sex sex, Language language) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return age == developer.age &&
                Objects.equals(name, developer.name) &&
                sex == developer.sex &&
                language == developer.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, language);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        return toStringBuilder
                .append("Developer : name=")
                .append(name)
                .append(",")
                .append("age=")
                .append(age)
                .append(",")
                .append("sex=")
                .append(sex)
                .append(",")
                .append("language=")
                .append(language)
                .toString();
    }
}
