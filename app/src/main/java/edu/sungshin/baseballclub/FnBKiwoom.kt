package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBKiwoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_kiwoom)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("피자", "2층 내야 2번 통로 맞은편", "불고기 피자"),
            Fnb("쉬림프 셰프", "2층 내야 4번 통로 맞은편", "크림새우"),
            Fnb("편밀밀", "2층 내야 4번 통로 맞은편", "만두라자냐"),
            Fnb("펠리스돔", "2층 내야 5~6번 통로 사이", "치즈스테이크"),
            Fnb("감탄계", "2층 내야 5~6번 통로 사이", "소금구이치킨"),
            Fnb("올떡", "2층 내야 9번 통로 맞은편, 2층 내야 3~4번 통로 사이, 3층 외야 2~3번 통로 사이", "떡볶이"),
            Fnb("스트릿 츄러스", "2층 내야 8번 통로 맞은편, 3층 외야 4번 통로 맞은편", "츄러스"),
            Fnb("스테프 핫도그", "2층 내야 11번 통로 맞은편, 2층 내야 3~4번 통로 사이, 3층 외야 1~2번 통로 사이", "스테프 핫도그"),
            Fnb("맘스터치", "2층 내야 3~4번 통로 사이, 2층 내야 9~10번 통로 사이, 4층 내야 26~27번 통로 사이, 3층 외야 4번 통로 맞은편", "싸이버거"),
            Fnb("BBQ", "2층 내야 3~4번 통로 사이, 2층 내야 9~10번 통로 사이, 4층 내야 26~27번 통로 사이, 3층 외야 4번 통로 맞은편", "핫윙"),
            Fnb("탐앤탐스", "2층 내야 3~4번 통로 사이, 2층 내야 9~10번 통로 사이, 3층 외야 1~2번 통로 사이", "꼰대라떼"),
            Fnb("강릉아이스크림", "2층 내야 3~4번 통로 사이, 3층 외야 2~3번 통로 사이", "감자아이스크림"),
            Fnb("마왕족발", "2층 내야 9~10번 통로 사이", "통구이레드"),
            Fnb("알통떡강정", "2층 내야 9~10번 통로 사이, 3층 외야 4번 통로 맞은편", "소떡소떡"),
            Fnb("휴온담", "2층 내야 9~10번 통로 사이, 4층 내야 24~25번 통로 사이, 4층 내야 28~29번 통로 사이, 3층 외야 2~3번 통로 사이", "닭꼬치"),
            Fnb("BHC", "2층 내야 5, 9번 통로 맞은편, 4층 내야 23~24번 통로 사이, 4층 내야 29~30번 통로 사이, 3층 외야 4번 통로 맞은편", "순살 뿌링클"),
            Fnb("우리동네 국민상회", "4층 내야 28~29번 통로 사이", "제철탕후루"),
            Fnb("PIZZA", "3층 외야 1~2번 통로 사이", "불고기피자"),
            Fnb("편의점", "2층 내야 2번 통로 맞은편, 2층 내야 11번 통로 맞은편, 4층 내야 24~25번 통로 사이, 4층 내야 28~29번 통로 사이, 3층 외야 4번 통로 맞은편, 3층 외야 1번 통로 맞은편", "편의점")
        )


        // 어댑터 설정
        val adapter = KiwoomFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_kiwoom)
        listView.adapter = adapter
    }
}