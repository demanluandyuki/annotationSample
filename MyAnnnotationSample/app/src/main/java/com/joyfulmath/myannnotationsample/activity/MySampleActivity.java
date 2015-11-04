package com.joyfulmath.myannnotationsample.activity;

import android.app.Activity;
import android.widget.TextView;

import com.joyfulmath.myannnotationsample.R;
import com.joyfulmath.myannnotationsample.utils.NotificationMgr;
import com.joyfulmath.myannnotationsample.utils.TraceLog;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.Click;

/**
 * Created by deman on 2015/11/4.
 */
@EActivity(R.layout.activity_sample)
public class MySampleActivity extends Activity {

    @ViewById(R.id.textView)
    TextView textView;

    @Bean
    NotificationMgr notificationMgr;

    int i = 0;

    @Click
    void mySampleButton()
    {
        TraceLog.d("currentthread:" + Thread.currentThread().getId());
        translateinBackground(textView.getText().toString()+i++);
    }

    @Background
    void translateinBackground(String text)
    {
        TraceLog.d("currentthread:" + Thread.currentThread().getId());
        String str = text.trim();
        showResult(str);
        updateNotification();
    }

    @UiThread
    void showResult(String str) {
        TraceLog.d("currentthread:"+Thread.currentThread().getId());
        textView.setText(str);
    }

    @AfterInject
    void updateNotification()
    {
        notificationMgr.setNotificationTitle("notify sample annotation");
    }
}