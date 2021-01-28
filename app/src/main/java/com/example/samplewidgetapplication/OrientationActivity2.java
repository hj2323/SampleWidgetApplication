package com.example.samplewidgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class OrientationActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation2);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        //Configuration객체에는 orientation속성이 들어있어 단말의 방향이 가로로바뀌었는지 아니면 세로로 바뀌었는지 알 수 있다.
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            showToast("방향: ORIENTATION_LANDSCAPE");
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            showToast("방향: ORIENTATION_PORTRAIT");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
    }

    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}