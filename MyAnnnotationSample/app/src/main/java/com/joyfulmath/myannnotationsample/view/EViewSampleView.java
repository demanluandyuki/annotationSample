package com.joyfulmath.myannnotationsample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import com.joyfulmath.myannnotationsample.utils.TraceLog;

import org.androidannotations.annotations.EView;



/**
 * Created by deman on 2015/11/5.
 */
@EView
public class EViewSampleView extends TextView {

    public EViewSampleView(Context context,AttributeSet attributes)
    {
        super(context,attributes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setSpannableText(CharSequence text)
    {
        TraceLog.i(text.toString());
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(Color.GREEN),1,spannableString.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        setText(spannableString);
    }
}
