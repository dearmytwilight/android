package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBKia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_kia)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("CU", "3층 1루, 3층 3루, 5층 3루, 외야, 8GATE 옆", "편의점"),
            Fnb("BHC", "3층 1루, 3층 3루, 5층 1루", "뿌링클"),
            Fnb("원샷치킨", "1루 클럽라운지, 3루 클럽라운지", "원샷치킨"),
            Fnb("프랭크버거", "3루 클럽라운지, 3층 3루", "베이컨 치즈버거"),
            Fnb("스테이션", "3층 1루", "크림새우"),
            Fnb("XOXO 핫도그", "3층 1루, 3층 3루, 1루 클럽라운지", "렐리쉬 핫도그"),
            Fnb("짝태패밀리", "3층 1루, 1루 클럽라운지, 3루 클럽라운지", "오징어"),
            Fnb("파파존스", "5층 1루, 3층 1루", "존스 페이보릿 피자"),
            Fnb("스트릿츄러스", "3층 1루, 3층 3루", "아츄(아이스크림+츄러스)"),
            Fnb("마성떡볶이", "3층 1루, 3층 3루, 5층 3루", "마성떡볶이")
        )

        // 어댑터 설정
        val adapter = KiaFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_kia)
        listView.adapter = adapter
    }
}