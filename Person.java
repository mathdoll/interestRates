package pkg;

import org.apache.commons.lang3.StringUtils;

public class Person {

    private String name;

    private int age;

    private static final int MAX_AGE = 150;

    public Person(String name, int age)  {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (StringUtils.isBlank(name)){
            throw new RuntimeException("Name is not valid");
        }
        this.name = name;
    }

    private void setAge(int age)  {
        if (age <=0 ){
            throw new RuntimeException("Age should be > 0");
        } else if (age > MAX_AGE) {
            throw new RuntimeException("Age too high.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void growUp(int x) {
        setAge(getAge()+x);
    }

    public void changeName(String newName){
        setName(newName);
    }
}
