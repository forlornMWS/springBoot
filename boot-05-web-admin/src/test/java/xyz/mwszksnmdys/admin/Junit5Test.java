package xyz.mwszksnmdys.admin;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Junit5功能测试类")
public class Junit5Test {

    @DisplayName("测试@DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void testDisplayName2() {
        System.out.println(2);
    }

    @Disabled
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

//    断言失败其后代码均不会执行
    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertion(){
        int cal = cal(2, 3);
        Assertions.assertEquals(5, cal, "结果不相等");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "两个对象不一样");
    }

    @Test
    @DisplayName("组合断言")
    void all(){
         Assertions.assertAll("测试断言",
                 ()->assertEquals(10, 10),
                 ()->assertTrue(true && true));
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        assertThrows(ArithmeticException.class, ()->{int i = 10 / 0;}, "未抛异常");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){
        if(2 == 2)
            fail("测试失败");
    }

    int cal(int a, int b){
        return a + b;
    }

    @DisplayName("测试前置条件")
    @Test
    void testAssumption(){
        Assumptions.assumeTrue(true, "结果不是true");
        System.out.println("1111111111111111");
    }


    @Test
    @RepeatedTest(value = 5)
    void testReaptedTest(){
        System.out.println(5);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了。。。");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试均已结束");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了");
    }

}
