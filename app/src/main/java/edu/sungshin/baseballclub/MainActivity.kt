package edu.sungshin.baseballclub

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.os.Bundle
import android.widget.*
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.view.ContextMenu
import android.view.MenuItem
import android.content.SharedPreferences
import android.content.Context



@Suppress("deprecation")
class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var title: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("ThemePrefs", Context.MODE_PRIVATE)

        val title: TextView = findViewById(R.id.mypagetoolbar_title)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val menuButton: Button = findViewById(R.id.themebutton) // 새로 추가된 버튼

        // ViewPager에 Adapter 연결
        val adapter = MainPagerAdapter(this)
        viewPager.adapter = adapter

        // TabLayout과 ViewPager 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "마이 팀"
                1 -> tab.text = "경기장"
                2 -> tab.text = "마이 페이지"
            }
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 선택된 탭에 따라 타이틀 변경
                title.text = when (position) {
                    0 -> "마이 팀"
                    1 -> "경기장"
                    2 -> "마이 페이지"
                    else -> "baseballclub"
                }
            }
        })

        // 컨텍스트 메뉴 등록 및 표시
        registerForContextMenu(menuButton)
        menuButton.setOnClickListener { openContextMenu(menuButton) }

        // 앱이 시작될 때 저장된 테마 적용
        applySavedTheme()
    }

    // 컨텍스트 메뉴 생성
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("테마 변경")
        menu.add(0, v.id, 0, "모노")
        menu.add(0, v.id, 1, "핑크")
        menu.add(0, v.id, 2, "하늘")
        menu.add(0, v.id, 3, "빨강")  // 빨강 색상 추가
    }

    // 컨텍스트 메뉴 선택 처리
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val toolbar1: androidx.appcompat.widget.Toolbar = findViewById(R.id.mypagetoolbar)
        val themeButton: Button = findViewById(R.id.themebutton)

        return when (item.title) {
            "모노" -> {
                toolbar1.setBackgroundColor(Color.parseColor("#ADADAD"))
                themeButton.setBackgroundColor(Color.parseColor("#ADADAD"))
                saveThemeColor("#ADADAD") // 색상 저장
                Toast.makeText(this, "모노 테마로 변경!", Toast.LENGTH_SHORT).show()
                true
            }
            "핑크" -> {
                toolbar1.setBackgroundColor(Color.parseColor("#FFB5DE"))
                themeButton.setBackgroundColor(Color.parseColor("#FFB5DE"))
                saveThemeColor("#FFB5DE") // 색상 저장
                Toast.makeText(this, "핑크 테마로 변경!", Toast.LENGTH_SHORT).show()
                true
            }
            "하늘" -> {
                toolbar1.setBackgroundColor(Color.parseColor("#A5F4FF"))
                themeButton.setBackgroundColor(Color.parseColor("#A5F4FF"))
                saveThemeColor("#A5F4FF") // 색상 저장
                Toast.makeText(this, "하늘 테마로 변경!", Toast.LENGTH_SHORT).show()
                true
            }
            "빨강" -> {
                toolbar1.setBackgroundColor(Color.parseColor("#DA2836"))
                themeButton.setBackgroundColor(Color.parseColor("#DA2836"))
                saveThemeColor("#DA2836") // 색상 저장
                Toast.makeText(this, "빨강 테마로 변경!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // 선택한 색상을 SharedPreferences에 저장
    private fun saveThemeColor(color: String) {
        val editor = sharedPreferences.edit()
        editor.putString("theme_color", color)
        editor.apply()
    }

    // 앱 시작 시 저장된 색상을 적용
    private fun applySavedTheme() {
        val savedColor = sharedPreferences.getString("theme_color", "#DA2836") // 기본값은 빨강
        val toolbar1: androidx.appcompat.widget.Toolbar = findViewById(R.id.mypagetoolbar)
        val themeButton: Button = findViewById(R.id.themebutton)

        toolbar1.setBackgroundColor(Color.parseColor(savedColor))
        themeButton.setBackgroundColor(Color.parseColor(savedColor))
    }

    override fun onBackPressed() {
        // AlertDialog 생성
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("앱 종료")
        builder.setMessage("진짜 종료하시겠습니까?")
        builder.setPositiveButton("예") { _, _ ->
            // 앱 종료
            super.onBackPressed()
        }
        builder.setNegativeButton("아니오") { dialog, _ ->
            // 대화상자 닫기
            dialog.dismiss()
        }
        // 대화상자 띄우기
        builder.create().show()
    }
}
