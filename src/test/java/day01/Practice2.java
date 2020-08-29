package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Practice2 {

    @Test
    public void test1(){
        int num1=5;
        int num2=4;

        assertThat(num1+num2,is(9));
        assertThat(num1+num2,equalTo(9));
        assertThat(num1+num2,is(equalTo(9)));

        assertThat(num1+num2,not(11));

        String firstName="Dovran ";
        String lastName="Nazarov";

        assertThat(firstName+lastName,is("Dovran Nazarov"));
        assertThat(firstName+lastName,equalTo("Dovran Nazarov"));
        assertThat(firstName+lastName,is(equalTo("Dovran Nazarov")));

        assertThat(firstName+lastName,equalToIgnoringCase("dovran NAZAROV"));
        assertThat(firstName,equalToCompressingWhiteSpace("Dovran"));

    }
    @DisplayName("Support for collection")
    @Test
    public void test2(){
        List<Integer> numList= Arrays.asList(11,44,3,55,88,5);
        assertThat(numList, hasSize(6));
        assertThat(numList,hasItem(44));

        assertThat(numList,contains(11,44,3,55,88,5));
        assertThat(numList,containsInAnyOrder(11,44,55,3,5,88));



    }
}
