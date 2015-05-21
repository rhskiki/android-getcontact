package com.rhskiki.getcontactexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rhskiki.teste.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGetEmails = (Button) findViewById(R.id.main_btn_get_emails);
        btnGetEmails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.main_btn_get_emails:
                intent = new Intent(this, EmailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
