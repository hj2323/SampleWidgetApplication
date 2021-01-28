package com.example.samplewidgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrientationActivity extends AppCompatActivity {
    String name;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                name=editText.getText().toString();//버튼을 클릭했을 때 사용자가 입력한 값을 name변수에할당
                showToast("입력된 값을 변수에 저장했습니다:"+name);
            }
        });
        if(savedInstanceState!=null){//이 화면이 초기화될때name 변수의 값 복원
            name=savedInstanceState.getString("name");
            showToast("값을 복원했습니다:"+name);
        }
    }

    //단말 방향을 바꾸어 액티비티가 소멸되었다가 다시만들어질때,
    //onSaveInstanceState()메서드 안에서 name변수의 값을 파라미터로 전달받은 Bundle 객체에 넣어줍니다.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("name",name);//name변수의값 저장
    }

    @Override
    protected void onStart() {
        super.onStart();
       // showToast("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy 호출됨");
    }

    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }


}