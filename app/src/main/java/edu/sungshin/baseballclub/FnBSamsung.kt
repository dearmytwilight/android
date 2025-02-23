package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBSamsung : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_samsung)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("CU", "1층 외야 GATE 근처, 2층 푸드스트리트", "편의점"),
            Fnb("버터우드", "1층 외야 GATE 근처, 2층 3GATE 근처", "피넛버터쉐이크"),
            Fnb("알통떡강정", "1층 외야 GATE 근처, 3층 내야석, 5층 스카이프리", "순살강정치킨세트"),
            Fnb("블루팡팡", "1층 외야 GATE 근처, 5층 스카이프리", "블루팡팡 츄러스"),
            Fnb("웍스터", "2층 3GATE 근처", "차오미엔"),
            Fnb("땅땅치킨", "2층 3GATE 근처, 3층 내야석", "불갈비 치킨"),
            Fnb("해피치즈스마일", "2층 3GATE 근처, 2층 푸드스트리트, 5층 스카이프리", "해피당볶이세트"),
            Fnb("전설스낵", "2층 외야 GATE 근처, 2층 푸드스트리트, 3층 내야석", "문어어묵바"),
            Fnb("리얼키친더홍", "2층 외야 GATE 근처, 4층 스윗박스", "석쇠불고기 우동세트"),
            Fnb("파파존스", "2층 푸드스트리트", "존스 페이보릿 피자"),
            Fnb("리얼피그", "3층 내야석", "돼지양념후라이드"),
            Fnb("한만두", "3층 내야석", "짬뽕만두"),
            Fnb("전설꼬치", "3층 내야석", "파닭꼬치"),
            Fnb("5직떡볶이", "3층 내야석", "민호세트"),
            Fnb("경주 십원빵", "5층 스카이프리", "십원빵"),
            Fnb("스테이션", "5층 스카이프리", "크림새우")
        )

        // 어댑터 설정
        val adapter = SamsungFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_samsung)
        listView.adapter = adapter
    }
}