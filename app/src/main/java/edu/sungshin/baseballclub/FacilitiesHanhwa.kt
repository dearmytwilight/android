package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesHanhwa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_hanhwa)

        val listView: ListView = findViewById(R.id.list_facilities_hanhwa)

        // 데이터 초기화

        val places = listOf(
            Place("매표소", "중앙GATE부근"),
            Place("물품보관소", "중앙GATE와 3루 사이, 305블럭"),
            Place("키즈존", "326B 뒤"),
            Place("팀스토어", "2-2 GATE 내부"),
            Place("흡연실", "119-120구역, 319-320구역 출입구")
        )
        // 어댑터 설정
        val adapter = HanhwaPlaceAdapter(this, R.layout.activity_list_facilities_hanhwa, places)
        listView.adapter = adapter
    }
}