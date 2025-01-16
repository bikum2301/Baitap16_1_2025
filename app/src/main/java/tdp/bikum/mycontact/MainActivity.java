package tdp.bikum.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        CircleImageView imageView = findViewById(R.id.imageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView positionTextView = findViewById(R.id.positionTextView);

        // Thiết lập hình ảnh và thông tin
        imageView.setImageResource(R.drawable.your_image);
        nameTextView.setText("Trần Đông Phương - 22162034");
        positionTextView.setText("Sinh viên ngành An toàn thông tin");

        // Lấy các view
        Button exerciseButton = findViewById(R.id.exerciseButton);
        LinearLayout exerciseButtonsLayout = findViewById(R.id.exerciseButtonsLayout);
        Button primeButton = findViewById(R.id.primeButton);
        Button squareButton = findViewById(R.id.squareButton);

        // Xử lý sự kiện khi nhấn vào nút "Bài tập"
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị hoặc ẩn hai nút con
                if (exerciseButtonsLayout.getVisibility() == View.GONE) {
                    exerciseButtonsLayout.setVisibility(View.VISIBLE);
                } else {
                    exerciseButtonsLayout.setVisibility(View.GONE);
                }
            }
        });

        // Xử lý sự kiện khi nhấn vào nút "Bài in số nguyên tố"
        primeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, primeActivity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào nút "Bài in số chính phương"
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });
    }
}