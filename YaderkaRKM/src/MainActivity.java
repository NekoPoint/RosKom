package com.example.myapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ссылки на элементы интерфейса
        EditText editBlock = findViewById(R.id.edit_block);
        EditText editReason = findViewById(R.id.edit_reason);
        Button btnConfirm = findViewById(R.id.btn_confirm);
        Button btnCancel = findViewById(R.id.btn_cancel);
        TextView txtResult = findViewById(R.id.txt_result);

        // Логика кнопки "Вы уверены?"
        btnConfirm.setOnClickListener(view -> {
            String blockText = editBlock.getText().toString();
            String reasonText = editReason.getText().toString();

            // Проверка, заполнены ли поля
            if (blockText.isEmpty() || reasonText.isEmpty()) {
                txtResult.setVisibility(View.VISIBLE);
                txtResult.setText("Пожалуйста, заполните все поля");
            } else {
                txtResult.setVisibility(View.VISIBLE);
                txtResult.setText("Готово! " + blockText + " заблокировано.\nПричина: " + reasonText);

                // Таймер: через 3 секунды сообщение "Действие нельзя отменить"
                new Handler().postDelayed(() -> txtResult.setText("Готово! Действие нельзя отменить."), 3000);
            }
        });

        // Логика кнопки "Нет"
        btnCancel.setOnClickListener(view -> {
            editBlock.setText("");
            editReason.setText("");
            txtResult.setVisibility(View.GONE);
        });
    }
}
