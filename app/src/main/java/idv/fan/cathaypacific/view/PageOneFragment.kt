package idv.fan.cathaypacific.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import idv.fan.cathaypacific.Utils
import idv.fan.cathaypacific.databinding.FragmentPageOneBinding
import idv.fan.cathaypacific.view.adapter.PageOneItemAdapter
import idv.fan.cathaypacific.viewmodel.PageOneViewModel
import kotlinx.android.synthetic.main.fragment_page_one.*

class PageOneFragment : Fragment(), RecyclerListener {

    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return PageOneFragment()
        }
    }

    var binding: FragmentPageOneBinding? = null
    var viewmodel: PageOneViewModel? = null
    var itemItemAdapter: PageOneItemAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPageOneBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(PageOneViewModel::class.java)
        binding?.viewmodel = viewmodel
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel?.let { viewmodel ->
            rv_item.layoutManager = LinearLayoutManager(context)
            if (itemItemAdapter == null) {
                itemItemAdapter = PageOneItemAdapter(this)
            }
            rv_item.adapter = itemItemAdapter
            viewmodel.alItem.observe(viewLifecycleOwner, {
                itemItemAdapter?.mAlItem = Utils.createTestData()
            })
        }
    }

    override fun onTopBackClick() {
        rv_item?.smoothScrollToPosition(0)
    }
}