package com.joyfulmath.myannnotationsample.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.joyfulmath.myannnotationsample.R;
import com.joyfulmath.myannnotationsample.utils.TraceLog;
import com.joyfulmath.myannnotationsample.view.EViewSampleView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

/**
 * Created by deman on 2015/11/5.
 */
@EFragment(R.layout.fragment_efragment_sample)
public class EFragmentSampleFragment extends BaseFragment {

    public final static String ACTION = "efagment.samplefragment.action";

    @ViewById(R.id.textFragmentView)
    TextView textView;

    @ViewById(R.id.eViewSample)
    EViewSampleView eViewSampleView;

    @Click(R.id.textFragmentView)
    void sendBroadCast()
    {
        eViewSampleView.setVisibility(View.VISIBLE);
        eViewSampleView.setSpannableText("custom define text");
        doBackground();
    }

    @Background
    void doBackground()
    {
        TraceLog.i("sendBroadCast");
        getActivity().sendBroadcast(new Intent(ACTION));
    }
}
