package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_kt)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("정지영 커피 로스터즈", "2층 외야 1루 방향", "코코넛"),
            Fnb("BHC", "2층 내야 1루 방향 2게이트 근처, 2층 내야 3루 방향 2게이트 근처", "뿌링순살"),
            Fnb("푸드코트&분식", "2층 내야 3루 방향", "김밥"),
            Fnb("길푸드", "2층 내야 3루 방향 2게이트 근처", "플레인 핫도그"),
            Fnb("청년닭갈비", "2층 내야 3루 방향 보영만두 매장 위", "청년닭갈비"),
            Fnb("가비&커피", "2층 내야 3루 방향 2게이트 근처", "아메리카노"),
            Fnb("전설의 곱창", "2층 내야 3루 방향 보영만두 매장 위", "막창소금구이"),
            Fnb("진미통닭", "2층 내야 3루 방향 2게이트 근처", "후라이드치킨"),
            Fnb("보영만두", "2층 내야 3루 방향 2게이트 근처", "군만두"),
            Fnb("이대로 통삼겹", "2층 중앙 게이트 근처", "이대로 통삼겹살"),
            Fnb("롯데리아", "2층 내야 1루 방향 BHC매장 위", "불고기버거"),
            Fnb("파파존스", "2층 내야 1루 방향 BHC매장 위", "수퍼 파파스"),
            Fnb("버터구이", "2층 내야 1루 방향 2게이트 근처", "오징어 버터구이"),
            Fnb("끼부리또", "2층 내야 1루 방향 2게이트 근처", "브리또"),
            Fnb("까비 휴게소", "2층 내야 3루 방향 2게이트 근처", "소시지 감자튀김"),
            Fnb("생맥주", "2층 내야 3루 방향 1게이트 근처", "켈리생맥주"),
            Fnb("세븐일레븐", "2층 내야 3루 방향 2게이트 근처", "편의점")
        )


        // 어댑터 설정
        val adapter = KtFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_kt)
        listView.adapter = adapter
    }
}