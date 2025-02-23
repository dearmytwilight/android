package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_kt)

        val listView: ListView = findViewById(R.id.list_facilities_kt)

        // 데이터 초기화

        val places = listOf(
            Place("안내 데스크", "2층 내야 중앙"),
            Place("중앙 매표소", "1층 내야 1루 방향"),
            Place("외야 매표소", "1층 외야 3루 방향"),
            Place("무인 발권기", "1층 내야 3루 방향"),
            Place("의무실", "2층 내야 중앙"),
            Place("수유실", "2층 내야 중앙"),
            Place("놀이방", "2층 내야 중앙"),
            Place("물품보관소", "1층 내야 1루, 3루 방향 메인게이트"),
            Place("흡연부스", "1층 외야 1루, 3루 방향"),
            Place("kt 팀스토어", "1층 내야 중앙"),
            Place("원정 구단 팀스토어", "1층 내야 중앙")
        )

        // 어댑터 설정
        val adapter = KtPlaceAdapter(this, R.layout.activity_list_facilities_kt, places)
        listView.adapter = adapter
    }
}