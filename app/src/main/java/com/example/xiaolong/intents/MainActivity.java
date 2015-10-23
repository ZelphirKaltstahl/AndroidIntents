package com.example.xiaolong.intents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String LOG_TAG_MAIN_ACTIVITY = "main activity";

    // @Bind(R.id.main_activity_label) TextView label;
    private TextView label;

    private Intent open_color_activity_intend;
    private Intent open_alignment_activity_intend;
    private Intent open_font_activity_intend;

    private Intent open_time_activity_intend;
    private Intent open_date_activity_intend;
    private Intent open_date_extended_activity_intend;

    private Intent open_web_intent;
    private Intent open_map_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = (TextView) findViewById(R.id.main_activity_label);
    }

    public void on_color(View view) {
        if(open_color_activity_intend == null) {
            open_color_activity_intend = new Intent(this, ColorActivity.class);
        }
        startActivityForResult(open_color_activity_intend, MyActivity.COLOR.ordinal());
    }

    public void on_alignment(View view) {
        if(open_alignment_activity_intend == null) {
            open_alignment_activity_intend = new Intent(this, AlignmentActivity.class);
        }
        startActivityForResult(open_alignment_activity_intend, MyActivity.ALIGNMENT.ordinal());
    }

    public void on_font(View view) {
        if(open_font_activity_intend == null) {
            open_font_activity_intend = new Intent(this, FontActivity.class);
        }
        startActivityForResult(open_font_activity_intend, MyActivity.FONT.ordinal());
    }

    public void on_time(View view) {
        if(open_time_activity_intend == null) {
            open_time_activity_intend = new Intent(
                    MyIntentFilterAction.SHOW_TIME.toString()
            );
            Bundle bundle = new Bundle();
            bundle.putString("Pretext", "Time");
            bundle.putString("Format", "HH:mm:ss");
            open_time_activity_intend.putExtras(bundle);
        }
        startActivity(open_time_activity_intend);
    }

    public void on_date(View view) {
        if(open_date_activity_intend == null) {
            open_date_activity_intend = new Intent(
                    MyIntentFilterAction.SHOW_DATE.toString()
            );
            Bundle bundle = new Bundle();
            bundle.putString("Pretext", "Date");
            bundle.putString("Format", "yyyy.MM.dd");
            open_date_activity_intend.putExtras(bundle);
        }
        startActivity(open_date_activity_intend);
    }

    public void on_date_extended(View view) {
        if(open_date_extended_activity_intend == null) {
            open_date_extended_activity_intend = new Intent(
                    MyIntentFilterAction.SHOW_DATE_EXTENDED.toString()
            );
            Bundle bundle = new Bundle();
            bundle.putString("Pretext", "Date ext.");
            bundle.putString("Format", "yyyy.MM.dd - HH:mm:ss");
            open_date_extended_activity_intend.putExtras(bundle);
        }
        startActivity(open_date_extended_activity_intend);
    }

    public void on_web(View view) {
        if(open_web_intent == null) {
            open_web_intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.duckduckgo.com")
            );
        }
        startActivity(open_web_intent);
    }

    public void on_map(View view) {
        if(open_map_intent == null) {
            open_map_intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:52.520007,13.404953999999975")
            );
        }
        startActivity(open_map_intent);
    }

    @Override
    protected void onActivityResult(int request_code, int response_code, Intent intent_with_data) {
        Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "RETURNED");
        if(intent_with_data == null) {
            return;
        }
        if(response_code == RESULT_OK) {
            if(request_code == MyActivity.COLOR.ordinal()) {
                Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "COLOR ACTIVITY RETURNED");
                change_color(intent_with_data);
            } else if(request_code == MyActivity.ALIGNMENT.ordinal()) {
                Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "ALIGNMENT ACTIVITY RETURNED");
                change_alignment(intent_with_data);
            } else if(request_code == MyActivity.FONT.ordinal()) {
                Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "FONT ACTIVITY RETURNED");
                change_font(intent_with_data);
            } else if(request_code == MyActivity.TIME_AND_DATE.ordinal()) {
                Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "TIME AND DATE ACTIVITY RETURNED");
                //TODO
            }
        }
    }

    private void change_color(Intent data_intent) {
        if(data_intent.hasExtra(TextProperties.COLOR.toString())) {
            String result = data_intent.getExtras().getString(TextProperties.COLOR.toString());
            Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "RESULT: " + result);
            if (result != null && result.length() > 0) {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                label.setTextColor(Color.parseColor(result));
            }
        }
    }
    private void change_alignment(Intent data_intent) {
        if(data_intent.hasExtra(TextProperties.ALIGNMENT.toString())) {
            int result = data_intent.getExtras().getInt(
                    TextProperties.ALIGNMENT.toString(),
                    Gravity.CENTER
            );
            Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "RESULT: " + result);
            label.setGravity(result);
        }
    }
    private void change_font(Intent data_intent) {
        if (data_intent.hasExtra(TextProperties.FONT.toString())) {
            int result = data_intent.getExtras().getInt(TextProperties.FONT.toString(), 10);
            Log.d(MainActivity.LOG_TAG_MAIN_ACTIVITY, "RESULT: " + result);
            label.setTextSize(result);
        }
    }
}
