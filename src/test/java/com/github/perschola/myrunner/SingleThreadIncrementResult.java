package com.github.perschola.myrunner;

import com.github.perschola.MyRunner;
import com.github.perschola.ThreadResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 12/19/2019.
 */
public class SingleThreadIncrementResult {
    private void testAnyNumberOfThreads(String expectedResultAsString, Integer numberOfIncrements, Integer numberOfThreadsToCreate) {
        // given
        ThreadResult result = new ThreadResult();
        MyRunner runner = new MyRunner(numberOfIncrements, result);
        Runnable runnableRunner = (Runnable)runner;
        for (int currentThreadNumber = 0; currentThreadNumber < numberOfThreadsToCreate; currentThreadNumber++) {
            Thread thread = new Thread(runnableRunner);

            // when
            thread.start();
        }

        // then
        ThreadResult threadResult = runner.getThreadResult();
        String actualResultAsString = threadResult.toString();
        Assert.assertEquals(expectedResultAsString, actualResultAsString);
    }

    private void testSingleThread(String expectedResultAsString, Integer numberOfIncrements) {
        testAnyNumberOfThreads(expectedResultAsString, numberOfIncrements, 1);
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
        Integer numberOfIncrements = 3;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("2").append("\n")
                .append("3").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements);
    }
}
