package com.example.aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return calculateBinder;
    }

    private final aidlInterface.Stub calculateBinder=new aidlInterface.Stub() {

        @Override
        public int calculateData(int firstValue, int secondValue, int operationType) {
            return performCalculation(firstValue,secondValue,operationType);
        }
    };





    private int performCalculation(int firstValue, int secondValue, int operation) {
        switch (operation) {
            case 1:
                return firstValue + secondValue;

            case 2:
                return firstValue - secondValue;

            case 3:
                return firstValue * secondValue;

            case 4:
                return firstValue / secondValue;

            default:
                Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
                return 0;
        }
    }
}
