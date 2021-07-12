package idv.fan.cathaypacific.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import idv.fan.cathaypacific.R
import java.lang.ref.WeakReference

class PageTwoViewModel(application: Application) : AndroidViewModel(application) {

    val _context: WeakReference<Context> = WeakReference(application.applicationContext)


    fun getTitle(): String {
        return _context.get()?.getString(R.string.page_title, 2) ?: ""
    }

}