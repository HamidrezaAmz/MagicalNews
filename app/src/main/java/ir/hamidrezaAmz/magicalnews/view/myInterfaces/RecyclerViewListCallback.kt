package ir.hamidrezaAmz.magicalnews.view.myInterfaces

interface RecyclerViewListCallback {
    fun onItemClicked(item: Any?) {}
    fun onItemClicked(item: Any?, position: Int) {}
}