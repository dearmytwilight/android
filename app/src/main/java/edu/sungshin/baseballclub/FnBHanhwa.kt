package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBHanhwa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_hanhwa)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("빅찹핫도그", "3루, 외야", "빅찹핫도그"),
            Fnb("친절한스낵바", "3루, 외야", "순대곱창볶음"),
            Fnb("세븐일레븐", "3루, 외야", "편의점"),
            Fnb("멕시카나치킨", "3루, 외야", "후라이드치킨"),
            Fnb("스트릿츄러스", "3루, 외야", "수리츄"),
            Fnb("허니빈스", "3루, 외야", "파인애플샤베트"),
            Fnb("농심가락", "3루, 외야", "농심메밀열무냉면"),
            Fnb("이글스 브루어리", "3루, 외야, 중앙", "이글스 막걸리"),
            Fnb("스테프핫도그", "중앙", "칠리덕"),
            Fnb("세븐일레븐", "중앙", "편의점"),
            Fnb("고피자", "중앙", "나는행복합니다세트"),
            Fnb("오수리", "중앙", "홈런(몸통+다리)"),
            Fnb("신전떡볶이", "중앙", "신전떡볶이"),
            Fnb("보영만두", "1루, 외야", "군만두+쫄면 세트"),
            Fnb("멕시카나치킨", "1루, 외야", "후라이드치킨"),
            Fnb("세븐일레븐", "1루, 외야", "편의점"),
            Fnb("장충동왕족발", "1루, 외야", "불족보쌈세트"),
            Fnb("푸드공감", "1루, 외야", "떡볶이"),
            Fnb("수리마카롱", "1루, 외야", "딸기이뻐마카롱")
        )


        // 어댑터 설정
        val adapter = HanhwaFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_hanhwa)
        listView.adapter = adapter
    }
}