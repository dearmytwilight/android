package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class StadiumFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stadium, container, false)

        val stadiumButtons = mapOf(
            R.id.imakia to "기아",
            R.id.imalgds to "엘지두산",
            R.id.imalotte to "롯데",
            R.id.imasamsung to "삼성",
            R.id.imassg to "랜더스",
            R.id.imanc to "엔씨",
            R.id.imakt to "KT",
            R.id.imakiwoom to "키움",
            R.id.imahanhwa to "한화"
        )

        // 각 버튼에 대해 클릭 리스너 설정
        for ((buttonId, stadiumName) in stadiumButtons) {
            view.findViewById<ImageButton>(buttonId).setOnClickListener {
                val intent = when (stadiumName) {
                    "기아" -> Intent(requireContext(), StadiumKia::class.java)
                    "엘지두산" -> Intent(requireContext(), StadiumLgds::class.java)
                    "롯데" -> Intent(requireContext(), StadiumLotte::class.java)
                    "삼성" -> Intent(requireContext(), StadiumSamsung::class.java)
                    "랜더스" -> Intent(requireContext(), StadiumSsg::class.java)
                    "엔씨" -> Intent(requireContext(), StadiumNc::class.java)
                    "KT" -> Intent(requireContext(), StadiumKt::class.java)
                    "키움" -> Intent(requireContext(), StadiumKiwoom::class.java)
                    "한화" -> Intent(requireContext(), StadiumHanhwa::class.java)
                    else -> return@setOnClickListener
                }
                // 각 구장에 맞는 이름 전달
                intent.putExtra("stadium_name", stadiumName)
                startActivity(intent)
            }
        }
        return view
    }
}