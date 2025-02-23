package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesLotte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_lotte)

        val listView: ListView = findViewById(R.id.list_facilities_lotte)

        // 데이터 초기화

        val places = listOf(
            Place("자이언츠 프로페셔널 매장", "3층 중앙출입구 입장 후 왼쪽"),
            Place("커스텀 스튜디오", "2층 드림게이트 입구 안쪽"),
            Place("포토카드", "2층 1-19 게이트 앞"),
            Place("코어 어센틱 매장", "1층 중앙출입구 오른편"),
            Place("코어 레플리카 매장", "1층 광장 주차장 옆 컨테이너"),
            Place("인생네컷", "1층 광장 주차장 옆 컨테이너"),
            Place("G-스튜디오", "2층 3루 1-19 게이트"),
            Place("물품보관함", "1층 중앙 광장, 2층 1루 출입구, 3층 1루 2-1G, 3층 3루 2-16G, 3층 프로페셔널샵 근처, 2층 외야 출입구"),
            Place("보조배터리", "3층 1루 2-2G, 3층 3루 2-14G"),
            Place("키즈 바운스", "외야 2-6G 근처"),
            Place("흡연구역", "2층 1루 1-3G, 2층 3루 1-18G, 중앙게이트 출입구 맞은편"),
            Place("수유실", "3층 2-15G"),
            Place("의무실", "심판석 옆"),
            Place("1루매표소", "1층 1루 방향"),
            Place("3루매표소", "롯데자이언츠 박물관 오른쪽"),
            Place("외야매표소", "1층 외야 방향"),
            Place("예매전용 무인발권기", "중앙게이트 자이언츠샵 오른쪽")
        )

        // 어댑터 설정
        val adapter = LottePlaceAdapter(this, R.layout.activity_list_facilities_lotte, places)
        listView.adapter = adapter
    }
}