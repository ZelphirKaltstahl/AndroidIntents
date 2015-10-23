package com.example.xiaolong.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateDisplayerActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_time_and_date_displayer);

        textView = (TextView) findViewById(R.id.time_and_date_activity_label);

        react_on_intent(getIntent());
    }

    private void react_on_intent(Intent intent) {
        Bundle bundle = getIntent().getExtras();
        SimpleDateFormat simpleDateFormat = null;
        String pretext = bundle.getString("Pretext", "Date or Time");

        if (intent.getAction().equals(MyIntentFilterAction.SHOW_TIME.toString())) {
            simpleDateFormat = new SimpleDateFormat(
                    bundle.getString("Format", "HH:mm:ss")
            );

        } else if (intent.getAction().equals(MyIntentFilterAction.SHOW_DATE.toString())) {
            simpleDateFormat = new SimpleDateFormat(
                    bundle.getString("Format", "yyyy.MM.dd")
            );

        } else if (intent.getAction().equals(MyIntentFilterAction.SHOW_DATE_EXTENDED.toString())) {
            simpleDateFormat = new SimpleDateFormat(
                    bundle.getString("Format", "yyyy.MM.dd - HH:mm:ss")
            );
        }

        String dateTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        textView.setText(pretext + ": " + dateTime);
    }
}
