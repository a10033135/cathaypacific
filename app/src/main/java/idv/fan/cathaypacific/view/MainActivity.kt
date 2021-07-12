package idv.fan.cathaypacific.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import idv.fan.cathaypacific.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_container, HomeFragment.newInstance())
        fragmentTransaction.commit()
    }
}