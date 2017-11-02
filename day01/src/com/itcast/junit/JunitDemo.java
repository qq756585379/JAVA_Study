package com.itcast.junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitDemo {

    @Test
    public void test1() {
        Calc c = new Calc();
        Assert.assertEquals(8, c.add(3, 5));
    }

    @Test
    public void test2() {
        Calc c = new Calc();
        Assert.assertEquals(3, c.div(10, 3), 0.3);
    }

}
