package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Easy test's class")
public class EmailTest {
    @Test
    @DisplayName("1 easy test")
    void test1(){
        System.out.println("Привет" );
    }
    @Test
    @DisplayName("2 easy test")
    void test2(){
        System.out.println("Hello" );
    }
    @Test
    @DisplayName("3 easy test")
    void test3(){
        throw new AssertionError("Упал");
    }

    }

