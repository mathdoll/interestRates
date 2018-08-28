package pkg;


import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonTest {

    // TODO : check if the age is either: Larger than 150, 0, or negative (age<=0)
    // TODO : check if name is null or empty string

    @Test(expected = RuntimeException.class)
    public void testMtString(){
        Person p = new Person("", 5);
    }

    @Test(expected = RuntimeException.class)
    public void testNullString(){
        Person p = new Person(null,5);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeAge(){
        Person p = new Person("Rinisha",-1);
    }


    @Test(expected = RuntimeException.class)
    public void testSpaces(){
        Person p = new Person("                  ",10);
    }


    @Test(expected = RuntimeException.class)
    public void testAgeZero(){
        Person p = new Person("Rinisha",0);
    }

    @Test(expected = RuntimeException.class)
    public void testNotInt(){
        Person p = new Person("Rinisha",5);
        p.growUp(Integer.MAX_VALUE);
    }

    @Test(expected = RuntimeException.class)
    public void testAddMore150(){
        Person p = new Person ("p",10);
        p.growUp(150);
    }

    @Test
    public void validDataTest(){
        Person p = new Person("Rinisha",5);
        assertThat(p.getName()).isEqualTo("Rinisha");
        Assert.assertEquals("Rinisha", p.getName());

    }
}
