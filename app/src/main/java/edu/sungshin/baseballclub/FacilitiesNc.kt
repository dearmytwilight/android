package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesNc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_nc)

        val listView: ListView = findViewById(R.id.list_facilities_nc)

        // 데이터 초기화

        val places = listOf(
            Place("포토카드", "1층 111블럭"),
            Place("스크린야구", "2층 222블럭"),
            Place("엔팍필름", "2층 217블럭"),
            Place("오락실", "2층 204블럭"),
            Place("보조배터리", "1층 118블럭"),
            Place("AI사진", "2층 216블럭"),
            Place("AR사진", "2층 215블럭"),
            Place("흡연구역", "1층 gate4"),
            Place("수유실", "3층 317블럭 근처, 1층 108블럭 근처, 2층 204블럭 근처, 2층 220블럭 근처, 4층 416블럭 근처"),
            Place("안내센터", "정문광장에서 오른쪽방향"),
            Place("놀이방", "2층 201블럭 근처"),
            Place("다이노스몰", "gate5 외부 3루방향"),
            Place("티켓박스1 (정문광장)", "gate5 3루방향"),
            Place("티켓박스2 (북문광장)", "gate3 1루방향")
        )

        // 어댑터 설정
        val adapter = NcPlaceAdapter(this, R.layout.activity_list_facilities_nc, places)
        listView.adapter = adapter
    }
}