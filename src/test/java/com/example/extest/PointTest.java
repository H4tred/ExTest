package com.example.extest;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    private final Logger logger = Logger.getLogger("TestLogger");

    @Test
    void checkObject(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);

        assertThat(p1).isNotEqualTo(p2);
    }

    @Test
    void checkBoolean() {
        assertThat(false).isFalse();
        assertThat(true).isTrue();
    }

    @Test
    void checkIterable() {
        int[] a = {1, 2, 3};
        int[] b = {3, 2, 1};

        assertThat(a).contains(b);
    }
}