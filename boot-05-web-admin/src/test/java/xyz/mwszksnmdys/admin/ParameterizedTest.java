package xyz.mwszksnmdys.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import java.util.stream.Stream;


@DisplayName("参数化测试")
public class ParameterizedTest {

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testParameterized(int i) {
        System.out.println(i);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("stringProvider")
    void testParameterized2(String str) {
        System.out.println(str);
    }


    static Stream<String> stringProvider(){
        return Stream.of("apple", "banana", "pear");
    }
}
