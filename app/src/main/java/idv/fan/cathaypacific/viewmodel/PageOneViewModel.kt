package idv.fan.cathaypacific.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import idv.fan.cathaypacific.model.ItemBean

class PageOneViewModel : ViewModel() {

    var alItem = liveData<MutableList<ItemBean>> { emit(mutableListOf()) }

}