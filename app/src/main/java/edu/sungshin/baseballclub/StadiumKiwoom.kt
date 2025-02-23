package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var buttonFacilities: Button
private lateinit var buttonFnB: Button

class StadiumKiwoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium_kiwoom)

        // 버튼 초기화
        buttonFacilities = findViewById(R.id.facilities_kiwoom)
        buttonFnB = findViewById(R.id.fnb_kiwoom)

        // 내부 편의시설 버튼 클릭 시 activity_facilities_kiwoom로 이동
        buttonFacilities.setOnClickListener {
            val intent = Intent(this, FacilitiesKiwoom::class.java)
            startActivity(intent)
        }

        // 내부 맛집 버튼 클릭 시 activity_food_kiwoom로 이동
        buttonFnB.setOnClickListener {
            val intent = Intent(this, FnBKiwoom::class.java)
            startActivity(intent)
        }
    }
}