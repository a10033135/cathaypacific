package idv.fan.cathaypacific.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import idv.fan.cathaypacific.R
import idv.fan.cathaypacific.view.adapter.FragmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = arrayListOf<Fragment>()
        fragments.add(PageOneFragment.newInstance())
        fragments.add(PageTwoFragment.newInstance())

        val pagerAdapter = FragmentPagerAdapter(childFragmentManager, lifecycle, fragments)
        vp.adapter = pagerAdapter
        TabLayoutMediator(tl_tab, vp) { tab, position -> tab.text = getString(R.string.page_title, position+1) }.attach()

    }

}