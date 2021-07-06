package com.sumit.perimissiondeniedbycheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED ) {

            showToast("Both Permission are granted");
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED ) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions[0])) {   //check box k liye

                showToast("Camera Denied Storage granted");
                showToast("My code is correct but it is not showing me dialog box");
            } else {
                showToast("camera is denied by do not show check box");
                showToast("Camera Denied Storage granted");
                showToast("My code is correct but it is not showing me dialog box");
            }
        }




}

    private void showToast(String message){
        Toast.makeText(this,message , Toast.LENGTH_SHORT).show();
    }
}