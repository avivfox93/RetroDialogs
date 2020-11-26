package org.aei.retro_notifications;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.aei.retro_notifications.utils.TextAnimator;

import java.io.PrintStream;
import java.util.Objects;

public class RetroGameDialog extends Dialog {

    protected View view;
    protected TextView bodyText;

    protected View yes,no,cancel;

    protected String text;

    private TextAnimator textAnimator;

    public RetroGameDialog(@NonNull Context context) {
        super(context);
        this.view = getLayoutInflater().inflate(R.layout.layout_retro_game,null);
        setContentView(view);
        bodyText = view.findViewById(R.id.retro_gaming_body_text);
        cancel = view.findViewById(R.id.retro_gaming_cancel_btn);
        yes = view.findViewById(R.id.retro_gaming_yes_btn);
        no = view.findViewById(R.id.retro_gaming_no_btn);
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableYesButton(RetroDialog.DialogCallback callback){
        yes.setVisibility(View.VISIBLE);
        if(callback != null)
            yes.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableNoButton(RetroDialog.DialogCallback callback){
        no.setVisibility(View.VISIBLE);
        if(callback != null)
            no.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableCancelButton(RetroDialog.DialogCallback callback){
        cancel.setVisibility(View.VISIBLE);
        if(callback != null)
            cancel.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Set the body text of the Dialog
     * @param text the text to display
     */
    public void setText(String text){
        this.text = text;
        bodyText.setText(text);
    }

    /**
     * Start text animation, print char by char
     * @param activity the activity that the dialog lives in
     */
    public void startAnimation(Activity activity){
        bodyText.setText("");
        textAnimator = new TextAnimator(activity, bodyText).setText(text);
        textAnimator.startAnimation();
    }

    /**
     * Start text animation, print char by chara
     * @param activity the activity that the dialog lives in
     * @param interval_ms time to wait between chars
     * @param showCursor show/hide the cursor while printing the chars
     */
    public void startAnimation(@NonNull Activity activity, int interval_ms, boolean showCursor){
        bodyText.setText("");
        if(textAnimator != null)
            textAnimator.stopAnimation();
        textAnimator = new TextAnimator(activity, bodyText)
                .setInterval(interval_ms)
                .setCursor(showCursor)
                .setText(text);
        textAnimator.startAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(textAnimator != null)
            textAnimator.stopAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Objects.requireNonNull(this.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
