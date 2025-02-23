package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var buttonFacilities: Button
private lateinit var buttonFnB: Button

class StadiumHanhwa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium_hanhwa)

        // 버튼 초기화
        buttonFacilities = findViewById(R.id.facilities_hanhwa)
        buttonFnB = findViewById(R.id.fnb_hanhwa)

        // 내부 편의시설 버튼 클릭 시 activity_facilities_hanhwa로 이동
        buttonFacilities.setOnClickListener {
            val intent = Intent(this, FacilitiesHanhwa::class.java)
            startActivity(intent)
        }

        // 내부 맛집 버튼 클릭 시 activity_food_hanhwa로 이동
        buttonFnB.setOnClickListener {
            val intent = Intent(this, FnBHanhwa::class.java)
            startActivity(intent)
        }
    }
}