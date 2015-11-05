package com.joyfulmath.myannnotationsample.activity;

import android.app.Activity;
import com.joyfulmath.myannnotationsample.R;
import com.joyfulmath.myannnotationsample.fragment.EFragmentSampleFragment;
import com.joyfulmath.myannnotationsample.utils.TraceLog;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.Receiver;

@EActivity(R.layout.activity_eactivity_sample)
public class EActivitySampleActivity extends Activity {

    @FragmentById(R.id.myFragemnt)
    EFragmentSampleFragment eFragmentSampleFragment;

    @Receiver(actions = EFragmentSampleFragment.ACTION)
    void myReceiver()
    {
        TraceLog.i("receive:"+EFragmentSampleFragment.ACTION);
    }
}
