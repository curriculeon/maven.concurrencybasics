package com.github.perschola.asynchronousrunner;

import com.github.perschola.AsyncronousRunner;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 12/19/2019.
 */
@SuppressWarnings("all")
public class PolymorphismTest {
    // given
    AsyncronousRunner asyncronousRunner = new AsyncronousRunner(null, null);

    @Test
    public void testRunnablePolymorphism() {
        // when
        Boolean isInstanceOfType = asyncronousRunner instanceof Runnable;

        // then
        Assert.assertTrue(isInstanceOfType);
    }


    @Test
    public void testThreadPolymorphism() {
        // when
        Boolean isInstanceOfType = (Object) asyncronousRunner instanceof Thread;

        // then
        Assert.assertFalse(isInstanceOfType);
    }
}
