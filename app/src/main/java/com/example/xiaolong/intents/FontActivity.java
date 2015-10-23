package com.example.xiaolong.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FontActivity extends Activity {

    private Intent small_response_intent;
    private Intent medium_response_intent;
    private Intent large_response_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
    }

    public void on_small(View view) {
        small_response_intent = new Intent();
        small_response_intent.putExtra(TextProperties.FONT.toString(), 16);
        setResult(RESULT_OK, small_response_intent);
        finish();
    }
    public void on_medium(View view) {
        medium_response_intent = new Intent();
        medium_response_intent.putExtra(TextProperties.FONT.toString(), 24);
        setResult(RESULT_OK, medium_response_intent);
        finish();

    }
    public void on_large(View view) {
        large_response_intent = new Intent();
        large_response_intent.putExtra(TextProperties.FONT.toString(), 32);
        setResult(RESULT_OK, large_response_intent);
        finish();

    }
}
