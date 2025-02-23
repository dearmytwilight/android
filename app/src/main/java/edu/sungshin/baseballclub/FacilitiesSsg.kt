package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesSsg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_ssg)

        val listView: ListView = findViewById(R.id.list_facilities_ssg)

        // 데이터 초기화

        val places = listOf(
            Place("의무실, 수유실", "1층 gate3 근처"),
            Place("무인발권기", "1루, 3루, 외야매표소 근처"),
            Place("외야 매표소", "경기장 바깥 gate7 근처"),
            Place("3루 매표소", "경기장 바깥 gate5 근처"),
            Place("지정석 매표소", "경기장 바깥 gate3 근처"),
            Place("1루 매표소", "경기장 바깥 gate1 근처"),
            Place("화장실", "1층 gate3 근처"),
            Place("흡연구역", "gate7, gate2, gate6, gate5 슬로프 위쪽")
        )

        // 어댑터 설정
        val adapter = SsgPlaceAdapter(this, R.layout.activity_list_facilities_ssg, places)
        listView.adapter = adapter
    }
}