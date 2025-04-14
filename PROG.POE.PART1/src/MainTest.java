import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    @Test
    public void testUsernameComplexity() {
        assertTrue(Main.usernameComplexity("kly_1"));
        assertFalse(Main.usernameComplexity("kyle!!!!")); // No underscore
    }


    @Test
    public void testPasswordComplexity() {
        assertFalse(Main.passwordComplexity("password")); // Too short
        assertFalse(Main.passwordComplexity("password")); // No capital letter
        assertTrue(Main.passwordComplexity("Ch&&sec@ke99!!"));
    }



    @Test
    public void phoneNumberComplexity() {
        assertFalse(Main.passwordComplexity("08966553")); // Too short
        assertFalse(Main.phoneNumberComplexity("false")); // Contains letters
        assertFalse(Main.phoneNumberComplexity("false")); // Contains le
      assertTrue(Main.phoneNumberComplexity("true"));
}}