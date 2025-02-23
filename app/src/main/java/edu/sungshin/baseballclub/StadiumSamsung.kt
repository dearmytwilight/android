package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var buttonFacilities: Button
private lateinit var buttonFnB: Button

class StadiumSamsung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium_samsung)

        // 버튼 초기화
        buttonFacilities = findViewById(R.id.facilities_samsung)
        buttonFnB = findViewById(R.id.fnb_samsung)

        // 내부 편의시설 버튼 클릭 시 activity_facilities_samsung로 이동
        buttonFacilities.setOnClickListener {
            val intent = Intent(this, FacilitiesSamsung::class.java)
            startActivity(intent)
        }

        // 내부 맛집 버튼 클릭 시 activity_food_samsung로 이동
        buttonFnB.setOnClickListener {
            val intent = Intent(this, FnBSamsung::class.java)
            startActivity(intent)
        }
    }
}