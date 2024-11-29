package dmax.dialog.app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

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

        findViewById(android.R.id.button1).setOnClickListener(v -> new SpotsDialog.Builder()
                .setContext(MainActivity.this)
                .build()
                .show());
        findViewById(android.R.id.button2).setOnClickListener(v -> new SpotsDialog.Builder()
                .setContext(MainActivity.this)
                .setTheme(R.style.Custom)
                .build()
                .show());
        findViewById(android.R.id.button3).setOnClickListener(v -> new SpotsDialog.Builder()
                .setContext(MainActivity.this)
                .setMessage("Custom message")
                .build()
                .show());
        findViewById(android.R.id.closeButton).setOnClickListener(v -> new SpotsDialog.Builder()
                .setContext(MainActivity.this)
                .setTheme(R.style.Custom)
                .setMessage(R.string.app_name)
                .build()
                .show());
    }
}