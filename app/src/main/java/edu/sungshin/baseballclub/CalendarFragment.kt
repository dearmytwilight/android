package edu.sungshin.baseballclub

import android.content.Context
import android.content.SharedPreferences
import android.widget.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalendarFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var selectedTeamTextView: TextView
    private lateinit var calendarView: CalendarView
    private lateinit var mainTextView: TextView
    private lateinit var subTextView: TextView

    private val eventDetailsMap = mapOf(
        "2024-10-02" to Pair("Kt vs 두산", "잠실, 18:30"),
        "2024-10-03" to Pair("Kt vs 두산", "잠실, 14:00"),
        "2024-10-05" to Pair("Kt vs LG", "잠실, 14:00"),
        "2024-10-06" to Pair("Kt vs LG", "잠실, 14:00"),
        "2024-10-08" to Pair("LG vs Kt", "수원, 18:30"),
        "2024-10-09" to Pair("LG vs Kt", "수원, 14:00"),
        "2024-10-11" to Pair("Kt vs LG", "잠실, 18:30"),
        "2024-10-13" to Pair("LG vs 삼성", "대구, 14:00"),
        "2024-10-15" to Pair("LG vs 삼성", "대구, 18:30"),
        "2024-10-17" to Pair("삼성 vs LG", "잠실, 18:30"),
        "2024-10-19" to Pair("삼성 vs LG", "잠실, 14:00"),
        "2024-10-21" to Pair("삼성 vs 기아", "광주, 18:30"),
        "2024-10-22" to Pair("삼성 vs 기아", "광주, 16:00"),
        "2024-10-23" to Pair("삼성 vs 기아", "광주, 18:30"),
        "2024-10-25" to Pair("기아 vs 삼성", "대구, 18:30"),
        "2024-10-26" to Pair("기아 vs 삼성", "대구, 14:00"),
        "2024-10-28" to Pair("삼성 vs 기아", "광주, 18:30")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.calendar, container, false)

        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        calendarView = view.findViewById(R.id.calendar1)
        mainTextView = view.findViewById(R.id.maintextview)
        subTextView = view.findViewById(R.id.subtextview)


        subTextView.visibility = View.INVISIBLE

        // 텍스트뷰 초기화
        val selectedTeamTextView = view.findViewById<TextView>(R.id.selectedTeamTextView)

        // SharedPreferences에서 선택된 팀 로드
        val selectedTeam = sharedPreferences.getString("selected_team", "선택된 팀 없음")

        // 텍스트뷰에 선택된 팀 표시
        selectedTeamTextView.text = "선택된 팀: $selectedTeam"

        // 캘린더 날짜 선택 이벤트
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)

            // 선택한 날짜에 해당하는 이벤트 표시
            if (eventDetailsMap.containsKey(selectedDate)) {
                val eventDetails = eventDetailsMap[selectedDate]
                subTextView.visibility = View.VISIBLE
                mainTextView.text = eventDetails?.first // "Kt vs 두산"
                subTextView.text = eventDetails?.second // "잠실, 18:30"
            } else {
                mainTextView.text = "경기 일정이 없습니다."
                subTextView.visibility = View.INVISIBLE
            }
        }

        // 뒤로 가기 버튼 처리
        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            (parentFragment as? MyTeamFragment)?.showMyTeamSelectFragment()
        }

        return view
    }
}
