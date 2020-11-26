package org.aei.retrodialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.aei.retro_notifications.RetroDialog;
import org.aei.retro_notifications.RetroGameDialog;
import org.aei.retro_notifications.WindowsDialog;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button windows = findViewById(R.id.main_windows_btn);
        Button gaming = findViewById(R.id.main_retro_game_btn);

        windows.setOnClickListener((e)->{
            WindowsDialog windowsDialog = new WindowsDialog(this);
            windowsDialog.enableYesButton(()->{
                Toast.makeText(this,"Yes Slected",Toast.LENGTH_LONG).show();
            });
            windowsDialog.enableNoButton(()->{
                Toast.makeText(this,"No Slected",Toast.LENGTH_LONG).show();
            });
            windowsDialog.enableCancelButton(()->{
                Toast.makeText(this,"Cancel Slected",Toast.LENGTH_LONG).show();
                windowsDialog.dismiss();
            });
            windowsDialog.enableExitButton(()->{
                Toast.makeText(this,"Exit Slected",Toast.LENGTH_LONG).show();
                windowsDialog.dismiss();
            });
            windowsDialog.setBodyText("This is the body :)");

            windowsDialog.setDialogType(RetroDialog.DialogType.INFO);
            windowsDialog.show();
        });

        gaming.setOnClickListener((e)->{
            RetroGameDialog retroGameDialog = new RetroGameDialog(this);
            retroGameDialog.enableYesButton(()->{
                Toast.makeText(this,"Yes Slected",Toast.LENGTH_LONG).show();
            });
            retroGameDialog.enableNoButton(()->{
                Toast.makeText(this,"No Slected",Toast.LENGTH_LONG).show();
            });
            retroGameDialog.enableCancelButton(()->{
                Toast.makeText(this,"Cancel Slected",Toast.LENGTH_LONG).show();
                retroGameDialog.dismiss();
            });
            retroGameDialog.setText("Just an example...\nHow Are You?\nEnjoy!");
            retroGameDialog.show();
            retroGameDialog.startAnimation(this,150,true);
        });
    }
}