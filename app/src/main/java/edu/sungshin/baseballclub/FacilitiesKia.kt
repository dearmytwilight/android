package edu.sungshin.baseballclub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FacilitiesKia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facilities_kia)

        val listView: ListView = findViewById(R.id.list_facilities_kia)

        // 데이터 초기화
        val places = listOf(
            Place("키즈 챔피언스 필드", "3매표소와 8gate 사이 내부"),
            Place("샌드파크", "3매표소와 7gate 사이 내부, 8출입구 내부"),
            Place("현금인출기", "8gate 옆"),
            Place("수유실", "3층(112,118) / 5층 5,13gate"),
            Place("놀이방", "3층(113,116)"),
            Place("물품보관함", "3gate 옆, 3매표소 옆"),
            Place("흡연구역", "5층 501구역 옆"),
            Place("역사관", "6gate와 7gate 사이"),
            Place("매표소", "1매표소 : 2gate 옆 / 2매표소 : 5gate 옆 / 3매표소 : 7gate와 8gate 사이"),
            Place("종합안내소", "중앙출입구와 3gate 사이"),
            Place("무인발권기", "5gate와 6gate 사이, 1매표소, 8gate 옆"),
            Place("스카이박스 및 단체티켓수령", "종합안내소"),
            Place("경품수령", "종합안내소"),
            Place("상품매장", "중앙출입구와 4gate 사이")
        )

        // 어댑터 설정
        val adapter = KiaPlaceAdapter(this, R.layout.activity_list_facilities_kia, places)
        listView.adapter = adapter
    }
}