package com.nsut.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nsut.demoapp.model.User;
import com.nsut.demoapp.persistence.UserDatabase;
import com.nsut.demoapp.persistence.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText ageEditText;
    private TextView fullNameTextView;
    private TextView ageTextView;
    private Button saveDataButton;
    private Button displaySavedData;

    private static UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullNameEditText = findViewById(R.id.fullNameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        fullNameTextView = findViewById(R.id.fullNameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        saveDataButton = findViewById(R.id.saveDataButton);
        displaySavedData = findViewById(R.id.displaySavedData);

        userRepository = new UserRepository(this);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                User user = new User(fullName, age);

                userRepository.insertUser(user);
            }
        });

        displaySavedData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> userList = userRepository.getTableData();
                printList(userList);

                fullNameTextView.setText(userList.get(0).getFullName());
                ageTextView.setText(userList.get(0).getAge());
            }
        });
    }

    private void printList(List<User> userList){
        System.out.println("Printing Users Lists : ");
        for(User user : userList){
            System.out.println(user);
        }
        System.out.println("Printing ENDS : ");
    }

}
