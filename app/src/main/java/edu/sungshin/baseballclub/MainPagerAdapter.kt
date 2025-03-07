package edu.sungshin.baseballclub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3 // 탭 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyTeamFragment()
            1 -> StadiumFragment()
            2 -> MyPageFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
