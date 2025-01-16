package tdp.bikum.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button primeButton = findViewById(R.id.primeButton);
        primeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, primeActivity.class);
                startActivity(intent);
            }
        });

        Button squareButton = findViewById(R.id.squareButton);
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });
    }
}