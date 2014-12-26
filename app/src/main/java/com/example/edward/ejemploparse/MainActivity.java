package com.example.edward.ejemploparse;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView txtMensaje = (TextView)findViewById(R.id.textView1);
            txtMensaje.setText(extras.getString("texto"));
        }
        Parse.initialize(this, "9N5B1b9qBY95sr9fSYljOI1EvjTKnvEEtStWhfpm","0iQfmtrkuB7oeGtR8OVD9UprdLwyJiOXfYxKY2M6");
        PushService.setDefaultPushCallback(this, MainActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

}
