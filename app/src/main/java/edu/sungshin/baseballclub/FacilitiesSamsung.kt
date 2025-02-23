package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesSamsung : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_samsung)

        val listView: ListView = findViewById(R.id.list_facilities_samsung)

        // 데이터 초기화

        val places = listOf(
                Place("매표소", "gate1, gate2(외야), gate3 옆"),
        Place("물품보관소", "gate3 양 옆"),
        Place("수유실", "3층 T3-1구역 뒤, T1-1구역 뒤, 스카이석 09 출입구 앞"),
        Place("흡연실", "1루 출입구 옆, 5층 스카이석 U1구역 출입구 뒤, 3루 출입구 매표소 뒤, 팀스토어 맞은편"),
        Place("팀스토어", "gate2 옆"),
        Place("어린이 쉼터", "3층 T3-1구역 뒤")
        )

        // 어댑터 설정
        val adapter = SamsungPlaceAdapter(this, R.layout.activity_list_facilities_samsung, places)
        listView.adapter = adapter
    }
}