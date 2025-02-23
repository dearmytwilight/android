package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesLgds : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_lgds)

        val listView: ListView = findViewById(R.id.list_facilities_lgds)

        // 데이터 초기화

        val places = listOf(
            Place("안내데스크", "2층 내야 1루 방향 출입구 옆"),
            Place("중앙 매표소", "1층 외야 1루 방향"),
            Place("제 1매표소", "1층 외야 1루 방향"),
            Place("제 2매표소", "1층 내야 1루 방향"),
            Place("제 3매표소", "1층 외야 1루 방향"),
            Place("무인 발권기", "1층 외야 1루 방향"),
            Place("수유실", "2.5층 내야 중앙"),
            Place("놀이방", "2.5층 내야 중앙"),
            Place("흡연부스", "1층 내야 1루, 3루 출입구 옆"),
            Place("LG 팀스토어", "1층 외야 중앙, 2층 내야 1루 방향"),
            Place("두산 팀스토어", "1층 외야 중앙, 2층 내야 1루 방향, 2층 내야 3루 방향"),
            Place("원정 구단 팀스토어", "2층 내야 3루 방향")
        )

        // 어댑터 설정
        val adapter = LgdsPlaceAdapter(this, R.layout.activity_list_facilities_lgds, places)
        listView.adapter = adapter
    }
}