package com.cookandroid.doitmission_09;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainFragment extends Fragment {
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");

    EditText editTextName, editTextAge;
    Button buttonBirthDate, buttonSave;
    Date birthDate = new Date();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        editTextName = rootView.findViewById(R.id.editTextName);
        editTextAge = rootView.findViewById(R.id.editTextAge);
        buttonBirthDate = rootView.findViewById(R.id.buttonBirthDate);
        buttonSave = rootView.findViewById(R.id.buttonSave);

        buttonBirthDate.setOnClickListener(new View.OnClickListener() {
            final Calendar calendar = Calendar.getInstance();

            public void onClick(View v) {
                final DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        birthDate = calendar.getTime();
                        buttonBirthDate.setText(dateFormat.format(birthDate));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                dialog.show();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String birthDate = buttonBirthDate.getText().toString();

                Toast.makeText(getContext(), "이름: " + name + ", 나이: " + age + ", 생년월일: " + birthDate, Toast.LENGTH_SHORT).show();
            }
        });

        buttonBirthDate.setText(dateFormat.format(birthDate));
        return rootView;
    }
}
