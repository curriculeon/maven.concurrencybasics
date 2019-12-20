package com.github.perschola.asynchronousrunner;

import com.github.perschola.AsyncronousRunner;
import com.github.perschola.ThreadResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by leon on 12/19/2019.
 */
public class MultiThreadIncrementResult {
    // given
    private void testSingleThread(String expectedResultAsString, Integer numberOfIncrements, Integer numberOfThreadsToCreate) {
        ThreadResult result = new ThreadResult();
        AsyncronousRunner runner = new AsyncronousRunner(numberOfIncrements, result);
        Runnable runnableRunner = (Runnable) runner;
        IntStream
                .range(0, numberOfThreadsToCreate) // begin stream
                .mapToObj(i -> new Thread(runnableRunner)) // create threads

                // when
                .forEach(Thread::start); // begin threads

        // then
        ThreadResult threadResult = runner.getThreadResult();
        String actualResultAsString = threadResult.toString();
        Assert.assertEquals(expectedResultAsString, actualResultAsString);
    }


    @Test
    public void test0() {
        Integer numberOfIncrements = 1;
        Integer numberOfThreads = 2;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("1").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements, numberOfThreads);
    }


    @Test
    public void test1() {
        Integer numberOfIncrements = 1;
        Integer numberOfThreads = 3;
        String expectedResult = new StringBuilder()
                .append("1").append("\n")
                .append("1").append("\n")
                .append("1").append("\n")
                .toString();
        testSingleThread(expectedResult, numberOfIncrements, numberOfThreads);
    }
}
