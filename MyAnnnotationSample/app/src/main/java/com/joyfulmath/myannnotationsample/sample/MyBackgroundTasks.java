package com.joyfulmath.myannnotationsample.sample;

import com.joyfulmath.myannnotationsample.activity.MySampleActivity;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

/**
 * Created by deman on 2015/11/4.
 */
@EBean
public class MyBackgroundTasks {

    @RootContext
    MySampleActivity mySampleActivity;

    @Background
    public void doSomethingBackground()
    {
        int result = 0x1;
        updateUi(result);
    }

    @UiThread
    void updateUi(int result)
    {
        mySampleActivity.refershUi(result);
    }
}
