package com.joyfulmath.myannnotationsample.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.joyfulmath.myannnotationsample.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.res.DrawableRes;

/**
 * Created by deman on 2015/11/4.
 */
@EBean
public class NotificationMgr {

    @SystemService
    NotificationManager notificationManager;

    @RootContext
    Context context;

    String title;
//    @DrawableRes(R.mipmap.ic_launcher)
//    Drawable myIcon;


    @AfterInject
    void setNotificationManager()
    {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentText(title);
        builder.setContentTitle("Annotation Samples");
        builder.setAutoCancel(false);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(0x110,builder.build());
    }

    public final void setNotificationTitle(String text)
    {
        title = text;
        setNotificationManager();
    }
}
