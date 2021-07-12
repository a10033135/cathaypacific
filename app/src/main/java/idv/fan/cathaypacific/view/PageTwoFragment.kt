package idv.fan.cathaypacific.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import idv.fan.cathaypacific.databinding.FragmentPageTwoBinding
import idv.fan.cathaypacific.viewmodel.PageTwoViewModel

class PageTwoFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return PageTwoFragment()
        }
    }

    var binding: FragmentPageTwoBinding? = null
    var viewmodel: PageTwoViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPageTwoBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(PageTwoViewModel::class.java)
        binding?.viewmodel = viewmodel
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

}