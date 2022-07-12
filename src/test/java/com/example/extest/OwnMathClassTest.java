package com.example.extest;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class OwnMathClassTest {

    private final Logger logger = Logger.getLogger("TestLogger");

    @Test
    @DisplayName("Equation with two results") //két tömböt adott vissza
    void testIfEquationHasTwoResults() {
        final double[] RESULT = OwnMathClass.quadraticEquationSolver(1,-4,-5);
        final double[] EXPECTED = {5,-1};

        assertEquals(EXPECTED.length, RESULT.length,
                "a:1 b:-4 c:-5 egyenletre nem megfelelő elemszámú tömböt adott vissza");
        assertArrayEquals(EXPECTED,RESULT,
                "a:1 b:-4 c:-5 egyenletre adott gyökök nem megfelelőek!");
    }

    @Test
    @DisplayName("Equation with one result") //egy tömböt adott vissza
    void testIfEquationHasOneResult() {
        final double[] RESULT = OwnMathClass.quadraticEquationSolver(1,6,9);
        final double[] EXPECTED = {-3} ;

        assertEquals(EXPECTED.length, RESULT.length,
                "a:1 b:6 c:9 egyenletre nem megfelelő elemszámú tömböt adott vissza");
        assertArrayEquals(EXPECTED,RESULT,
                "a:1 b:6 c:9 egyenletre adott gyökök nem megfelelőek!");
    }

    @Test
    @DisplayName("Equation with no real roots") //0 tömböt adott vissza
    void testIfEquationHasNoRealRoots() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> {
            OwnMathClass.quadraticEquationSolver(1,2,8); },
                "a:1 b:6 c:9 egyenletre nem dob ArithmeticException");

        assertEquals("No real roots", ex.getMessage(),
                "Az ArithmeticException szövege nem megfelelő");
    }

    @DisplayName("Equations with random coefficients")
    @RepeatedTest(20) //20x ismétli meg a tesztet
    @ExtendWith(RandomBeansExtension.class)
    void testWithRandomNumbers(
          @Random(type = Double.class) Double a,
          @Random(type = Double.class) Double b,
          @Random(type = Double.class) Double c
    ) {
        double discriminant = b*b - 4.0 * a * c;
        logger.info(String.format("A teszt random értékei: a:%f b:%f c:%f -> Diszkrimináns: %f",a,b,c, discriminant));

        assumingThat(discriminant == 0, ()->{
            assertEquals(1, OwnMathClass.quadraticEquationSolver(a, b, c).length,
                    String.format("a:%f b:%f c:%f egyenletre nem megfelelő elemszámú tömböt adott vissza", a,b,c));
        });
        assumingThat(discriminant > 0, ()->{
            assertEquals(2, OwnMathClass.quadraticEquationSolver(a, b, c).length,
                    String.format("a:%f b:%f c:%f egyenletre nem megfelelő elemszámú tömböt adott vissza", a,b,c));
        });
        assumingThat(discriminant < 0, ()-> {
            ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
                OwnMathClass.quadraticEquationSolver(a, b, c);
            }, String.format("a:%f b:%f c:%f egyenletre nem dob ArithmeticException", a, b, c));
            assertEquals("No real roots", ex.getMessage(),
                    "Az ArithmeticException szövege nem megfelelő");
        });
    }

    @Test
    void testOnlyOnDevEnvironment() {
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")), "ONLY IN DEV");
        // Csak DEV környezetben futnak le!
    }

    @Test
    void testOnlyOnProdEnvironment() {
        assumingThat("PROD".equals(System.getenv("PROD")),
                () -> {
                    // Csak PROD környezetben futnak le [egymásbaágyazott verzió]!
                }

                );
        // Itt már lefut minden környezetben!
    }
}