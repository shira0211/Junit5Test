import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(LoggerExtension.class)
public class CalculatorTest {

    private Calculator calculator;
    static Stream<Arguments> divisionProvider() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(9, 3, 3),
                Arguments.of(100, 10, 10)
        );
    }

    @BeforeAll
    public static void setUpAll() {
        System.out.println("התחלת הרצת כל הבדיקות");
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println(" BeforeEach: יצירת מופע Calculator לפני טסט");
    }
    @AfterEach
    public void tearDown() {
        System.out.println(" טסט הסתיים ");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println(" כל הבדיקות הסתיימו");
    }

    //אופציה 1
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 7, 12",
            "-3, 3, 0",
            "0, 0, 0"
    })
    public void add(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
    //אופציה 2
    @ParameterizedTest()
    @MethodSource("divisionProvider")
    public void divide(int a, int b, int expected) {
        int res=calculator.divide(a, b);
        assertEquals(expected,res,"Division Failed");
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        System.out.println(" בדיקת חלוקה באפס");
    }
}
