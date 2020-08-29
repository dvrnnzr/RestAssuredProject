package day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SampleTest {
    @Test
    public void  calculatorTest(){
        System.out.println("Hello World");
        assertEquals(9,4+5);

        //assertEquals(10,5+4,"hey wrong result!!");

    }

    //u can add the display name for your test instead of method name
    @DisplayName("I am testing the name")
    @Test
    public void nameTest(){
        String firstName="Dovran";
        String lastName="Nazarov";
        String fullName="Dovran Nazarov";
        assertEquals(fullName,firstName+" "+lastName);
    }

}
