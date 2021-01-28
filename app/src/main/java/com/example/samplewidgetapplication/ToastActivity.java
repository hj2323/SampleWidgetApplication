package com.example.samplewidgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ToastActivity extends AppCompatActivity {
    EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
    }
    public void onButton1Clicked(View v){
        try {
            Toast toastView = Toast.makeText(this, "위치가 바뀐 토스트 메시지 입니다.",
                    Toast.LENGTH_LONG);
            int xOffset = Integer.parseInt(editText.getText().toString());
            int yOffset = Integer.parseInt(editText2.getText().toString());

            toastView.setGravity(Gravity.TOP|Gravity.TOP, xOffset, yOffset);
            toastView.show();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v){
        //액티비티를 위해 만든 xml레이아웃 파일은 setContentView()메서드를사용해 액티비티에 설정되지만
        //토스트만을위한 레이아웃을 정의한다면 이레이아웃은 액티비티를위한 것이 아니기 때문에
        // //LayoutInflater객체를 사용해 직접 메모리에 객체화해야 합니다.
        LayoutInflater inflater=getLayoutInflater();//레이아웃 인플레이터 객체 참조
        View layout =inflater.inflate(//토스트를 위한 레이아웃 인플레이션
                R.layout.taostborder,
                (ViewGroup)findViewById(R.id.toast_layout_root));
        TextView text =layout.findViewById(R.id.text);
        Toast toast = new Toast(this);//토스트 객체생성
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER,0,-100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);//토스트가 보이는 뷰설정
        toast.show();
    }

    public void onButton3Clicked(View v){
        Snackbar.make(v,"스낵바입니다.",Snackbar.LENGTH_LONG).show();
    }


}