package edu.sungshin.baseballclub

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment

class MyTeamSelectFragment : Fragment() {
    private lateinit var checkboxes: List<CheckBox> // 체크박스 리스트
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_myteamselect, container, false)
        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        // 체크박스 초기화
        val kia = view.findViewById<CheckBox>(R.id.kia)
        val dusan = view.findViewById<CheckBox>(R.id.dusan)
        val lotte = view.findViewById<CheckBox>(R.id.lotte)
        val samsung = view.findViewById<CheckBox>(R.id.samsung)
        val ssg = view.findViewById<CheckBox>(R.id.ssg)
        val nc = view.findViewById<CheckBox>(R.id.nc)
        val lg = view.findViewById<CheckBox>(R.id.lg)
        val kt = view.findViewById<CheckBox>(R.id.kt)
        val kiwoom = view.findViewById<CheckBox>(R.id.kiwoom)
        val hanhwa = view.findViewById<CheckBox>(R.id.hanhwa)

        // 체크박스 리스트 생성
        checkboxes = listOf(kia, dusan, lotte, samsung, ssg, nc, lg, kt, kiwoom, hanhwa)
        loadCheckBoxStates()

        for (checkbox in checkboxes) {
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // 다른 체크박스 해제
                    uncheckAllExcept(checkbox)

                    // 상태 저장
                    saveCheckBoxState(checkbox)

                    // CalendarFragment를 표시
                    (parentFragment as? MyTeamFragment)?.showCalendarFragment()
                }
            }
        }

        return view
    }

    // 상태 저장
    private fun saveCheckBoxState(selectedCheckBox: CheckBox) {
        val editor = sharedPreferences.edit()
        editor.putString("selected_team", selectedCheckBox.text.toString())
        editor.apply()
    }

    // 상태 로드
    private fun loadCheckBoxStates() {
        val selectedTeam = sharedPreferences.getString("selected_team", null)
        checkboxes.forEach { checkbox ->
            checkbox.isChecked = checkbox.text.toString() == selectedTeam
        }
    }

    // 선택된 체크박스를 제외한 모든 체크박스 해제
    private fun uncheckAllExcept(selectedCheckBox: CheckBox) {
        for (checkbox in checkboxes) {
            if (checkbox != selectedCheckBox) {
                checkbox.isChecked = false
            }
        }
    }
}
