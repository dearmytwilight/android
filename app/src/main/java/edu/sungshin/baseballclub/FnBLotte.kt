package edu.sungshin.baseballclub


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FnBLotte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fnb_lotte)

        // 샘플 데이터 생성

        val fnbList = listOf(
            Fnb("엔제리너스", "1층 광장 (외부)", "아메리치노"),
            Fnb("롯데리아", "1층 광장 (외부), 4층 중앙상단석", "핫크리스피버거"),
            Fnb("세븐일레븐", "2층 321블럭, 2층 323블럭, 2층 122블럭, 2층 125블럭, 2층 923블럭, 3층 332블럭, 3층 131블럭", "편의점"),
            Fnb("33떡볶이", "2층 324블럭, 2층 124블럭, 3층 132블럭", "떡볶이"),
            Fnb("남도푸드앤", "2층 327블럭, 2층 125블럭, 3층 332블럭, 3층 132블럭, 4층 중앙상단석", "삼겹살세트"),
            Fnb("봉구비어", "2층 122블럭", "크림생맥주"),
            Fnb("BBQ", "2층 122블럭, 3층 131블럭", "황금올리브치킨"),
            Fnb("자이언트푸드", "2층 126블럭", "핫도그"),
            Fnb("아리아리닭강정", "3층 132블럭", "닭강정"),
            Fnb("롯데리아", "4층 중앙상단석", "핫크리스피버거"),
            Fnb("세븐일레븐", "4층 중앙상단석", "편의점"),
            Fnb("남도푸드앤", "4층 중앙상단석", "삼겹살세트")
        )



        // 어댑터 설정
        val adapter = LotteFnbAdapter(this, fnbList)

        // ListView 연결
        val listView = findViewById<ListView>(R.id.list_fnb_lotte)
        listView.adapter = adapter
    }
}