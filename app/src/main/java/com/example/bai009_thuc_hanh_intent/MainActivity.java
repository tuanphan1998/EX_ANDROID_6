package com.example.bai009_thuc_hanh_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed1 , ed2;
    private Button btn1;
    private TextView txt6;
    int Event = 0;
    private static final  int SECONDARY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn1 = findViewById(R.id.btn1);
        txt6 = findViewById(R.id.txt6);
        // click kiem tra
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                String usename = ed1.getText().toString();
                String Pass = ed2.getText().toString();
                //try catch data
                if(usename.length() > 0 && Pass.length() > 0)
                {
                    Event = 1;
                }
                else if(usename.length() > 0 && Pass.length() == 0)
                {
                    Event = 2;
                    Toast.makeText(MainActivity.this, "Nhập thiếu pass kìa", Toast.LENGTH_SHORT).show();
                }
                else if(usename.length() == 0 && Pass.length() > 0)
                {
                    Event = 3;
                    Toast.makeText(MainActivity.this, "Nhập thiếu use case kìa", Toast.LENGTH_SHORT).show();
                }
                else if(usename.length() == 0 && Pass.length() == 0)
                {
                    Event = 4;
                    Toast.makeText(MainActivity.this, "Rỗng", Toast.LENGTH_SHORT).show();
                }
                switch (Event)
                {
                    case 1:
                        usenameAndPassYes(usename , Pass);
                        break;
                    case 2:
                        usenameYesAndPassNo(usename , Pass);
                        break;
                    case 3:
                        usenameNoAndPassYesss(usename , Pass);
                        break;
                    case 4:
                        usenameNoAndPassNo(usename , Pass);
                        break;

                }
            }
        });
    }
    private void usenameAndPassYes(String usename , String Pass)
    {
          String usename2 = "tuanphan";
          String pass2 = "1234ABC";
          if(usename.equals(usename2) == true && Pass.equals(pass2) == true)
          {
              Intent intent = new Intent(MainActivity.this ,Main2Activity.class);
              intent.putExtra("guidata" , ed1.getText().toString());
              startActivityForResult(intent , SECONDARY);

          }
          else
          {
              txt6.setText("Chúng tôi nhận ra usename và pass sai");
          }
    }
    private void usenameYesAndPassNo(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == true && Pass.equals(pass2) == false)
            {
                txt6.setText("Mat khẩu bạn nhập sai");
            }
            else
            {
                txt6.setText("Mat khẩu bạn nhập sai");
            }

    }
    private void usenameNoAndPassYesss(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == false && Pass.equals(pass2) == true)
            {
                txt6.setText("Nhap use name nhập sai");
            }
            else
            {
                txt6.setText("Nhap use name sai");
            }
    }
    private void usenameNoAndPassNo(String usename , String Pass)
    {

            String usename2 = "tuanphan";
            String pass2 = "1234ABC";
            if(usename.equals(usename2) == false && Pass.equals(pass2) == false)
            {
                txt6.setText("cả mật khẩi và tài khoản chưa nhập");
            }
            else
            {
                txt6.setText("cả mật khẩi và tài khoản chưa nhập");
            }
    }

}
