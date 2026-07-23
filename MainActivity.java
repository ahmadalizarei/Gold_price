package com.mycompany.myminigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private EditText e1, e2;
    private Button b1;

    private static final double OUNCE_TO_GRAM = 31.1034768;
    private static final double GOLD_PURITY = 900.0 / 999.0;
    private static final double GOLD_WEIGHT = 2.032035;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					String ounceText = e1.getText().toString().trim();
					String usdText = e2.getText().toString().trim();

					if (ounceText.isEmpty() || usdText.isEmpty()) {
						Toast.makeText(MainActivity.this,
									   "لطفاً هر دو مقدار را وارد کنید",
									   Toast.LENGTH_SHORT).show();
						return;
					}

					try {
						double ouncePrice = Double.parseDouble(ounceText);
						double usdPrice = Double.parseDouble(usdText);

						double result = (ouncePrice / OUNCE_TO_GRAM)
                            * GOLD_PURITY
                            * usdPrice
                            * GOLD_WEIGHT;
						DecimalFormat df = new DecimalFormat("#,##0.##");

						Toast.makeText(MainActivity.this,
									   df.format(result),
									   Toast.LENGTH_LONG).show();
						
						
					} catch (NumberFormatException e) {
						Toast.makeText(MainActivity.this,
									   "فقط عدد وارد کنید",
									   Toast.LENGTH_SHORT).show();
					}
				}
			});
    }
}
