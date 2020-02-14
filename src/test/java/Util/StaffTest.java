package Util;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class StaffTest{

    @Test
    public void ageFromDateofBirth(){

        Staff person = new Staff(1255l,"mohamed","jama",new Date(1996,7,26),"+353864892");

        assertEquals(24, person.getAge(),"from 26/7/1996 to now person is 26 years old");
    }


}