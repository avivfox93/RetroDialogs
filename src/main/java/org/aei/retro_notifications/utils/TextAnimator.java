package org.aei.retro_notifications.utils;

import android.app.Activity;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TextAnimator {
    private boolean cursor = true;
    private long interval_ms = 100;
    private String text = "";
    private TextView textView;
    private int index = 0;
    private Activity activity;
    private Timer timer;

    public TextAnimator(Activity activity, TextView textView){
        this.textView = textView;
        this.activity = activity;
        timer = new Timer();
    }

    public TextAnimator setText(String text){
        this.text = text;
        return this;
    }

    public TextAnimator setInterval(int interval_ms){
        this.interval_ms = interval_ms;
        return this;
    }

    public TextAnimator setCursor(boolean cursor){
        this.cursor = cursor;
        return this;
    }

    public void startAnimation(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(()->{
                    textView.setText(String.format(Locale.ENGLISH,"%s%s", text.substring(0, ++index),
                            (index == text.length()) ? "" : "_"));
                    if(index >= text.length()) {
                        index = 0;
                        timer.cancel();
                    }
                });
            }
        },100,interval_ms);
    }
    public void stopAnimation(){
        timer.cancel();
    }
}
