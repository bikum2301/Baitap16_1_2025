package tdp.bikum.mycontact;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class primeActivity extends AppCompatActivity {

    private EditText inputNumbers;
    private Button checkPrimesButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prime);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNumbers = findViewById(R.id.inputNumbers);
        checkPrimesButton = findViewById(R.id.checkPrimesButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkPrimesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumbers.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(primeActivity.this, "Vui lòng nhập các số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<Integer> numbers = parseInput(input);
                if (numbers.isEmpty()) {
                    Toast.makeText(primeActivity.this, "Định dạng nhập không hợp lệ! Vui lòng nhập các số cách nhau bằng dấu phẩy.", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<Integer> primes = findPrimes(numbers);

                StringBuilder result = new StringBuilder("Các số nguyên tố: ");
                for (int prime : primes) {
                    result.append(prime).append(" ");
                    Log.d("PrimeNumber", "Số nguyên tố: " + prime);
                }

                resultTextView.setText(result.toString());
            }
        });
    }

    private ArrayList<Integer> parseInput(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part.trim()));
            } catch (NumberFormatException e) {
                // Bỏ qua các phần không phải số
            }
        }
        return numbers;
    }

    private ArrayList<Integer> findPrimes(ArrayList<Integer> numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}