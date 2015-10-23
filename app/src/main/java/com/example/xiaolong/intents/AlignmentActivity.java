package com.example.xiaolong.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class AlignmentActivity extends Activity {

    private Intent left_response_intent;
    private Intent center_response_intent;
    private Intent right_response_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment);
    }

    public void on_left(View view) {
        left_response_intent = new Intent();
        left_response_intent.putExtra(TextProperties.ALIGNMENT.toString(), Gravity.LEFT);
        setResult(RESULT_OK, left_response_intent);
        finish();
    }
    public void on_center(View view) {
        center_response_intent = new Intent();
        center_response_intent.putExtra(TextProperties.ALIGNMENT.toString(), Gravity.CENTER);
        setResult(RESULT_OK, center_response_intent);
        finish();
    }
    public void on_right(View view) {
        right_response_intent = new Intent();
        right_response_intent.putExtra(TextProperties.ALIGNMENT.toString(), Gravity.RIGHT);
        setResult(RESULT_OK, right_response_intent);
        finish();
    }
}
