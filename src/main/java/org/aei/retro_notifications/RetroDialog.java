package org.aei.retro_notifications;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public abstract class RetroDialog extends Dialog {
    protected View view;

    protected Button yes,no,cancel;

    protected ImageView exitImage;

    protected ImageView dialogIcon;

    protected TextView bodyText;

    public enum DialogType{
        INFO,WARNING,QUESTION,ERROR
    }

    public RetroDialog(@NonNull Context context) {
        super(context);
        this.view = getLayoutInflater().inflate(R.layout.layout_dialog,null);
        setContentView(view);
        bodyText = view.findViewById(R.id.dialog_body_text);
        yes = view.findViewById(R.id.dialog_yes_button);
        no = view.findViewById(R.id.dialog_no_button);
        cancel = view.findViewById(R.id.dialog_cancel_button);
        exitImage = view.findViewById(R.id.dialog_exit);
        dialogIcon = view.findViewById(R.id.dialog_icon);
        exitImage.setOnClickListener((e)->dismiss());
    }

    public interface DialogCallback{
        void onClicked();
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableYesButton(DialogCallback callback){
        yes.setVisibility(View.VISIBLE);
        yes.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableNoButton(DialogCallback callback){
        no.setVisibility(View.VISIBLE);
        no.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Enable Button and attach a onClick listener to it
     * @param callback
     */
    public void enableCancelButton(DialogCallback callback){
        cancel.setVisibility(View.VISIBLE);
        cancel.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Attach a onClick listener to exit button
     * @param callback
     */
    public void enableExitButton(DialogCallback callback){
        exitImage.setOnClickListener((e)->callback.onClicked());
    }

    /**
     * Set the body text of the Dialog
     * @param text text to show in the body of the Dialog
     */
    public void setBodyText(String text){
        bodyText.setText(text);
    }

    /**
     * Set dialog type. change the icon shown in the dialog
     * @param type the type of dialog. RetroDialog.DialogType.(INFO,WARNING,QUESTION,ERROR)
     */
    public abstract void setDialogType(DialogType type);
}
