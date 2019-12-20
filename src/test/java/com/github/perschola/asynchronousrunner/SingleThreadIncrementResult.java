package com.github.perschola.asynchronousrunner;

import com.github.perschola.AsyncronousRunner;
import com.github.perschola.ThreadResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 12/19/2019.
 */
@SuppressWarnings("all")
public class SingleThreadIncrementResult {
    // given
    private void testSingleThread(String expectedResultAsString, Integer numberOfIncrements) {
        ThreadResult result = new ThreadResult();
        AsyncronousRunner runner = new AsyncronousRunner(numberOfIncrements, result);
        Runnable runnableRunner = (Runnable)runner;
        Thread thread = new Thread(runnableRunner);

        // when
        thread.start();

        // then
        ThreadResult threadResult = runner.getThreadResult();
        String actualResultAsString = threadResult.toString();
        Assert.assertEquals(expectedResultAsString, actualResultAsString);
    }

    @Test
    public void test0() {
        Integer numberOfIncrements = 1;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }


    @Test
    public void test1() {
        Integer numberOfIncrements = 1;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("1").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }

    @Test
    public void test2() {
        Integer numberOfIncrements = 2;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("2").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }

    @Test
    public void test3() {
        Integer numberOfIncrements = 3;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("2").append("\n")
                .append("3").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }


    @Test
    public void test4() {
        Integer numberOfIncrements = 4;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("2").append("\n")
                .append("3").append("\n")
                .append("3").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }
}
