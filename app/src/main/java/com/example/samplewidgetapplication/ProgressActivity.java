package com.example.samplewidgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity {
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ProgressBar progressBar =findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);

        Button button=findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //프로그레스 대화상자 객체 만들고설정하기
                dialog=new ProgressDialog(ProgressActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다.");
                dialog.show();
            }
        });

        Button button2=findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(dialog!=null){//프로그레스 대화상자 없애기
                    dialog.dismiss();
                }
            }
        });

    }

}