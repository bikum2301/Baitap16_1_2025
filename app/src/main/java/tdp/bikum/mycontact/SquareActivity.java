package tdp.bikum.mycontact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SquareActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Button checkSquareButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        inputNumber = findViewById(R.id.inputNumber);
        checkSquareButton = findViewById(R.id.checkSquareButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkSquareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(SquareActivity.this, "Vui lòng nhập một số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    long number = Long.parseLong(input);
                    if (number < 1) {
                        Toast.makeText(SquareActivity.this, "Vui lòng nhập một số nguyên dương!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    List<Long> perfectSquares = findPerfectSquares(number);
                    if (perfectSquares.isEmpty()) {
                        resultTextView.setText("Không có số chính phương nào trong khoảng từ 1 đến " + number + ".");
                        Toast.makeText(SquareActivity.this, "Không có số chính phương nào trong khoảng từ 1 đến " + number + ".", Toast.LENGTH_SHORT).show();
                    } else {
                        StringBuilder result = new StringBuilder("Các số chính phương từ 1 đến " + number + ":\n");
                        for (int i = 0; i < perfectSquares.size(); i++) {
                            result.append(perfectSquares.get(i));
                            if (i < perfectSquares.size() - 1) {
                                result.append("; "); // Thêm dấu chấm phẩy và khoảng trắng
                            }
                        }
                        resultTextView.setText(result.toString());
                        Toast.makeText(SquareActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(SquareActivity.this, "Định dạng nhập không hợp lệ! Vui lòng nhập một số nguyên.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<Long> findPerfectSquares(long number) {
        List<Long> perfectSquares = new ArrayList<>();
        for (long i = 1; i * i <= number; i++) {
            perfectSquares.add(i * i);
        }
        return perfectSquares;
    }
}