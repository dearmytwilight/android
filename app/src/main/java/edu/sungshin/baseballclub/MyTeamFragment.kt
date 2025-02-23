package edu.sungshin.baseballclub

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MyTeamFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmentmyteam, container, false)

        // SharedPreferences 초기화
        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        // SharedPreferences에서 캘린더 화면 표시 여부 확인
        val isCalendarShown = sharedPreferences.getBoolean("calendar_shown", false)

        // 화면 표시 결정
        if (isCalendarShown) {
            // 캘린더 프래그먼트 표시
            showCalendarFragment()
        } else {
            // MyTeamSelectFragment 표시
            showMyTeamSelectFragment()
        }

        return view
    }

    // 캘린더 프래그먼트 표시
    fun showCalendarFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.myteam_fragment_container, CalendarFragment())
            .commit()

        // 캘린더 화면 표시 상태를 SharedPreferences에 저장
        val editor = sharedPreferences.edit()
        editor.putBoolean("calendar_shown", true)
        editor.apply()
    }

    // MyTeamSelectFragment 표시
    fun showMyTeamSelectFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.myteam_fragment_container, MyTeamSelectFragment())
            .commit()

        // MyTeamSelectFragment 화면 상태를 SharedPreferences에 저장
        val editor = sharedPreferences.edit()
        editor.putBoolean("calendar_shown", false)
        editor.apply()
    }
}
