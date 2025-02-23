package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBSsg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_ssg)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("버거원더스", "1층 1루/지하 gate3", "88스테이크버거"),
            Fnb("드림마켓(BHC)", "gate2 근처", "순살뿌링클"),
            Fnb("우리동네미미네", "gate2 근처", "떡볶이"),
            Fnb("국대떡볶이", "gate3 근처", "떡튀순"),
            Fnb("픽미31", "gate1 근처", "나초플래터"),
            Fnb("스타벅스", "gate2 근처", "스타벅스 슬래머"),
            Fnb("알로하커피앤바", "스카이박스 게이트 근처", "빙수"),
            Fnb("민영활어공장", "1층 3루", "컵물회"),
            Fnb("오사카야키", "gate5 근처", "오사카야키"),
            Fnb("오레오츄러스", "gate6 근처", "아이스크림츄러스"),
            Fnb("북촌손만두", "gate4 근처", "튀김만두"),
            Fnb("교촌치킨", "gate4 근처", "허니순살"),
            Fnb("노브랜드버거", "2층 1루 gate1 근처", "NBB 시그니처"),
            Fnb("허갈닭강정", "gate1 근처", "허브달콤닭강정"),
            Fnb("노랑통닭", "외부 1루 방향", "반반치킨"),
            Fnb("몬칩팩토리", "gate2 근처", "닭강정"),
            Fnb("씬난다 스테이크 & 마라새우", "gate2 근처", "스테이크"),
            Fnb("스테이션", "gate3 근처", "크림새우"),
            Fnb("패밀리푸드존(BHC)", "gate3 근처", "순살뿌링클"),
            Fnb("스타벅스", "gate1 근처", "스타벅스 슬래머"),
            Fnb("커빙", "gate1 근처", "딸기우유빙수"),
            Fnb("쌈빠치킨", "2층 3루 gate6 근처", "찹쌀치킨"),
            Fnb("킹콩떡볶이", "2층 3루 gate6 근처", "떡볶이"),
            Fnb("먹거리", "2층 3루 gate6 근처", "크림새"),
            Fnb("이마트24", "2층 3루 gate6 근처", "편의점"),
            Fnb("우리동네미미네", "4층 3루 방향", "떡볶이"),
            Fnb("파파존스", "4층 3루 방향", "수퍼파파스피자"),
            Fnb("순살싸다리", "외야 바베큐존 근처", "순살치킨"),
            Fnb("디딤푸드코트", "외야 바베큐존 근처", "삼겹컵밥"),
            Fnb("야구사랑(BHC)", "외야 바베큐존 근처", "순살뿌링클"),
            Fnb("명인만두", "로케트베터리 외야파티덱 근처", "고기만두"),
            Fnb("노랑통닭", "초가정자 근처", "반반치킨")
        )

        // 어댑터 설정
        val adapter = SsgFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_ssg)
        listView.adapter = adapter
    }
}