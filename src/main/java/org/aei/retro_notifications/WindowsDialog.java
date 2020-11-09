package org.aei.retro_notifications;

import android.content.Context;

import androidx.annotation.NonNull;

public class WindowsDialog extends RetroDialog{
    public WindowsDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setDialogType(DialogType type) {
        switch(type){
            case INFO:
                this.dialogIcon.setImageResource(R.drawable.windows_info_icon);
                break;
            case ERROR:
                this.dialogIcon.setImageResource(R.drawable.windows_error_icon);
                break;
            case WARNING:
                this.dialogIcon.setImageResource(R.drawable.windows_warning_icon);
                break;
            case QUESTION:
                this.dialogIcon.setImageResource(R.drawable.wnidows_question_icon);
                break;
            default:
                break;
        }
    }
}
