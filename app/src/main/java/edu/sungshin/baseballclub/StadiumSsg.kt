package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var buttonFacilities: Button
private lateinit var buttonFnB: Button

class StadiumSsg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadium_ssg)

        // 버튼 초기화
        buttonFacilities = findViewById(R.id.facilities_ssg)
        buttonFnB = findViewById(R.id.fnb_ssg)

        // 내부 편의시설 버튼 클릭 시 activity_facilities_ssg로 이동
        buttonFacilities.setOnClickListener {
            val intent = Intent(this, FacilitiesSsg::class.java)
            startActivity(intent)
        }

        // 내부 맛집 버튼 클릭 시 activity_food_ssg로 이동
        buttonFnB.setOnClickListener {
            val intent = Intent(this, FnBSsg::class.java)
            startActivity(intent)
        }
    }
}