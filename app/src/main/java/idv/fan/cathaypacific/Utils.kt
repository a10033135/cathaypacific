package idv.fan.cathaypacific

import idv.fan.cathaypacific.model.ItemBean
import java.time.LocalDate

object Utils {
    val VIEWTYPE_TOPBACK = 0
    val VIEWTYPE_ITEM = 1


    fun createTestData(): ArrayList<ItemBean> {
        val alItem = arrayListOf<ItemBean>()

        /* 新增十筆項目 */
        for (i in 1..10) {
            val plusDay = (i - 1).toLong()
            alItem.add(ItemBean(i, LocalDate.now().plusDays(plusDay), VIEWTYPE_ITEM))
        }

        /* 最後一筆為回到頂端的按鈕 */
        alItem.add(ItemBean(0, LocalDate.now(), VIEWTYPE_TOPBACK))

        return alItem
    }

}