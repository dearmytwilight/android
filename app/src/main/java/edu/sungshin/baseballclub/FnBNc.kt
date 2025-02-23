package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBNc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_nc)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("쉬프림 쉐프", "1층 외부 gate1 근처", "크림새우"),
            Fnb("제일버거", "1층 외부 gate2 근처", "제일버거"),
            Fnb("코아양과", "1층 내부 gate4 근처", "밀크쉐이크"),
            Fnb("홍대칼국수와 족발", "gate1 근처", "칼국수"),
            Fnb("D피자", "gate1 근처", "화덕피자"),
            Fnb("bhc", "gate1 근처", "후라이드치킨"),
            Fnb("공룡상회", "gate1 근처", "편의점"),
            Fnb("죠스떡볶이", "gate2 근처, gate4 근처, 2층 내부 다이노스몰 근처", "떡볶이"),
            Fnb("탐앤탐스커피", "gate2 근처, gate4 근처", "솔티드캬라멜라떼"),
            Fnb("핵스테이크", "gate2 근처", "스테이크"),
            Fnb("싸움의고수", "gate2 근처", "1인보쌈"),
            Fnb("BBQ", "gate3 근처, gate4 근처, 2층 내부 다이노스몰 근처", "황금올리브치킨"),
            Fnb("알통떡강정", "gate3 근처, gate4 근처", "떡강정"),
            Fnb("NY HOTDOG", "gate4 근처", "뉴욕핫도그"),
            Fnb("투다리", "gate5 근처", "김치우동"),
            Fnb("편밀밀", "gate5 근처", "만두라자냐"),
            Fnb("맘스터치", "2층 내부 다이노스몰 근처", "싸이버거"),
            Fnb("반올림피자샵", "2층 내부 다이노스몰 근처", "엔팍홈런볼피자"),
            Fnb("스타벅스", "2층 내부 다이노스몰 근처", "아메리카노")
        )

        // 어댑터 설정
        val adapter = NcFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_nc)
        listView.adapter = adapter
    }
}