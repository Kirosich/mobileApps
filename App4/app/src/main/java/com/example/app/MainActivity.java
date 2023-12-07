package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener  {

    CheckBox cb1;
    CheckBox cb2;

    private TextView mLabel;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cb1 = findViewById(R.id.myCheckBox1); // Инициализация CheckBox
        cb2 = findViewById(R.id.myCheckBox2); // Инициализация CheckBox


        // Установка обработчика событий для CheckBox
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);



        // Toggle Button
        final ToggleButton tb = findViewById(R.id.toggleButton);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Изменение цвета ToggleButton в зависимости от его состояния
                int color = isChecked ? getResources().getColor(R.color.colorEnabled) : getResources().getColor(R.color.colorDisabled);
                tb.setBackgroundColor(color);
            }
        });

        mLabel = findViewById(R.id.mLabel);
        mImage = findViewById(R.id.mImage);



        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                mLabel.setText("Время года: " + rb.getText());

                if (checkedId == R.id.radio1) {
                    mImage.setImageResource(R.drawable.winter);
                } else if (checkedId == R.id.radio2) {
                    mImage.setImageResource(R.drawable.summer);
                }
            }
        });

        ImageButton myImageButton = findViewById(R.id.myImageButton);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageButtonClick(v);
            }
        });
    }

    public void onImageButtonClick(View view) {
        Toast.makeText(this, "Тут спрятался инстаграм", Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // Обработка событий для всех CheckBox
        if (buttonView == cb1) {
            updateCheckBoxText(cb1, buttonView, isChecked);
        } else if (buttonView == cb2) {
            updateCheckBoxText(cb2, buttonView, isChecked);
        }
    }

//    public void ToggleButton(CompoundButton buttonView, boolean isChecked) {
//
//    }
    private void updateCheckBoxText(CheckBox checkBox, CompoundButton buttonView, boolean isChecked) {
        String additionalText = isChecked ? " - Дело Сделано" : " - Дело Не Сделано";
        if (buttonView == cb1) {
            String taskDescription = getString(R.string.task_description1, additionalText);
            checkBox.setText(taskDescription);
            checkBox.setChecked(isChecked);
        } else if (buttonView == cb2) {
            String taskDescription = getString(R.string.task_description2, additionalText);
            checkBox.setText(taskDescription);
            checkBox.setChecked(isChecked);
        }
        // Установка состояния чекбокса в соответствии с измененным текстом
        checkBox.setChecked(isChecked);
    }
}
