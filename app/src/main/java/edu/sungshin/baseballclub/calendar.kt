package edu.sungshin.baseballclub

import android.os.strictmode.InstanceCountViolation
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.widget.*


class Calendar : Activity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)
    }
}
