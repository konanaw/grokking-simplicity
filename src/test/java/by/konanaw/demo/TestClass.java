package by.konanaw.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {

    @Test
    public void test_smoke() {
//        fail("test fails");
        assertTrue(true);
    }

    @Test
    public void calculateHashMapBucketCount() {
        String key = "abcdef";
        int n = 16;
        int index = key.hashCode() & (n-1);
        System.out.println(index);
    }

}
