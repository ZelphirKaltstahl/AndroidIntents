package com.example.xiaolong.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColorActivity extends Activity {

    private Intent red_response_intent;
    private Intent green_response_intent;
    private Intent blue_response_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void on_red(View view) {
        if(red_response_intent == null) {
            red_response_intent = new Intent();
            red_response_intent.putExtra(TextProperties.COLOR.toString(), MyColor.RED.toString());
        }
        setResult(RESULT_OK, red_response_intent);
        finish();
    }
    public void on_green(View view) {
        if(green_response_intent == null) {
            green_response_intent = new Intent();
            green_response_intent.putExtra(TextProperties.COLOR.toString(), MyColor.GREEN.toString());
        }
        setResult(RESULT_OK, green_response_intent);
        finish();
    }
    public void on_blue(View view) {
        if(blue_response_intent == null) {
            blue_response_intent = new Intent();
            blue_response_intent.putExtra(TextProperties.COLOR.toString(), MyColor.BLUE.toString());
        }
        setResult(RESULT_OK, blue_response_intent);
        finish();
    }
}
