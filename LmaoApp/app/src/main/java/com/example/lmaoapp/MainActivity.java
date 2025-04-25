package com.example.lmaoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB, edtKQ;
    private Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Ánh xạ Id cho các biến giao diện
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTong = findViewById(R.id.btnTong);

        //Xử lý sự kiện click cho nút btnTong
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Lấy giá trị từ EditText và chuyển đổi thành số
                    float a = Float.parseFloat(edtA.getText().toString());
                    float b = Float.parseFloat(edtB.getText().toString());

                    //Tính tổng
                    float kq = a + b;

                    //Hiển thị kết quả vào EditText edtKQ
                    edtKQ.setText(String.valueOf(kq));
                } catch (NumberFormatException e) {
                    //Xử lý lỗi nếu người dùng nhập không phải số
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}