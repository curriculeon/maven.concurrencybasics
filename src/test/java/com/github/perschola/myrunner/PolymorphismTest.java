package com.github.perschola.myrunner;

import com.github.perschola.MyRunner;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 12/19/2019.
 */
public class PolymorphismTest {
    @Test
    public void testRunnablePolymorphism() {
        // given
        MyRunner myRunner = new MyRunner();

        // when
        Boolean isInstanceOfType = myRunner instanceof Runnable;

        // then
        Assert.assertTrue(isInstanceOfType);
    }


    @Test
    public void testThreadPolymorphism() {
        // given
        MyRunner myRunner = new MyRunner();

        // when
        Boolean isInstanceOfType = (Object)myRunner instanceof Thread;

        // then
        Assert.assertFalse(isInstanceOfType);
    }
}
