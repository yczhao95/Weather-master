package com.example.jasminechen.myapplication;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.firebase.client.DataSnapshot;
        import com.firebase.client.Firebase;
        import com.firebase.client.FirebaseError;
        import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView tvCondition;
    private Button btnSunny;
    private Button btnFoggy;
    private Button btnRainy;
    private Firebase mFireRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCondition = (TextView) findViewById(R.id.textViewCondition);

        mFireRef = new Firebase("https://fire-weather-b8112.firebaseio.com/condition");
        mFireRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String condition = dataSnapshot.getValue(String.class);
                tvCondition.setText(condition);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        btnSunny = (Button) findViewById(R.id.buttonSunny);
        btnFoggy = (Button) findViewById(R.id.buttonFoggy);
        btnRainy = (Button) findViewById(R.id.buttonRainy);
        btnSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFireRef.setValue("Sunny");
            }
        });
        btnFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFireRef.setValue("Foggy");
            }
        });
        btnRainy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFireRef.setValue("Rainy");
            }
        });
    }
}