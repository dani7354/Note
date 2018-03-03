package com.example.note;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsp on 03/03/2018.
 */
public class ControllerTest {

    @Test
    public void SingletonWorks(){
        Controller instance1 = Controller.getInstance();

        Controller instance2 = Controller.getInstance();

        Assert.assertEquals(instance1, instance2);
    }










}