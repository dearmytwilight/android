package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesKiwoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_kiwoom)

        val listView: ListView = findViewById(R.id.list_facilities_kiwoom)

        // 데이터 초기화

        val places = listOf(
            Place("외야 매표소", "1층 외야 3루 방향"),
            Place("1루 매표소", "1층 내야 1루 방향"),
            Place("3루 매표소", "1층 내야 3루 방향"),
            Place("무인발권기", "1층 내야 3루 매표소 뒤"),
            Place("수유실", "2층 1번 통로 옆, 3층 외야 중앙"),
            Place("놀이방", "1층 중앙계단 방향"),
            Place("안전용품 대여소", "2층 내야 중앙"),
            Place("흡연부스", "1층 외야 G게이트 앞, 1층 3루 매표소 뒤, 2층 E게이트 앞, 2층 C게이트 앞"),
            Place("키움 팀스토어", "2층 7번 통로 맞은편"),
            Place("원정 구단 팀스토어", "2층 7번 통로 맞은편")
        )

        // 어댑터 설정
        val adapter = KiwoomPlaceAdapter(this, R.layout.activity_list_facilities_kiwoom, places)
        listView.adapter = adapter
    }
}