package idv.fan.cathaypacific.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import idv.fan.cathaypacific.R
import idv.fan.cathaypacific.Utils.VIEWTYPE_ITEM
import idv.fan.cathaypacific.model.ItemBean
import idv.fan.cathaypacific.view.RecyclerListener

class PageOneItemAdapter(val rvListener: RecyclerListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mAlItem: List<ItemBean> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEWTYPE_ITEM) {
            PageOneViewHolder(inflater.inflate(R.layout.adapter_item, parent, false))
        } else {
            SmoothTopViewHolder(inflater.inflate(R.layout.adapter_top, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = mAlItem[position]
        when (holder) {
            is PageOneViewHolder -> {
                holder.tvIndex.text = context.getString(R.string.item_index, item.position)
                holder.tvDate.text = context.getString(R.string.item_date, item.date.monthValue, item.date.dayOfMonth)
                holder.tvWeekday.text = context.resources.getStringArray(R.array.weekday)[item.date.dayOfWeek.value - 1]
            }
            is SmoothTopViewHolder -> {
                holder.ivTop.setOnClickListener { rvListener.onTopBackClick() }
            }
        }
    }

    override fun getItemCount(): Int {
        return mAlItem.size
    }

    override fun getItemViewType(position: Int): Int {
        return mAlItem[position].viewtype
    }

    class PageOneViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvIndex = itemview.findViewById<TextView>(R.id.tv_index)
        val tvDate = itemview.findViewById<TextView>(R.id.tv_date)
        val tvWeekday = itemview.findViewById<TextView>(R.id.tv_weekday)
    }

    class SmoothTopViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ivTop = itemview.findViewById<ImageView>(R.id.iv_top)
    }

}