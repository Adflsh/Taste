package com.xs.taste.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xs.taste.R;
import com.xs.taste.ui.fragment.Camera2BasicFragment;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }
}
