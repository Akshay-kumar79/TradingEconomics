package com.example.tradingeconomics.calendarPage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Insets
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradingeconomics.models.CalendarModel
import android.view.WindowInsets

import android.view.WindowMetrics

class HeaderItemDecoration(
    private val context: Context,
    private val getItemList: () -> List<CalendarModel>
): RecyclerView.ItemDecoration(){

    private val headerItemWidth by lazy {
        getScreenWidth(context)
    }

    private val headerItemHeight by lazy {
        dipToPx(context, 25f)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val layoutManager = parent.layoutManager
        val list = getItemList()

        if(layoutManager !is LinearLayoutManager || layoutManager.orientation != LinearLayoutManager.VERTICAL || list.isEmpty()){
            return
        }

        val position = parent.getChildAdapterPosition(view)
        if(position == 0){
            outRect.top = headerItemHeight
            return
        }

        val currentModel = list[position]
        val previousModel = list[position-1]
        if(currentModel.date != previousModel.date){
            outRect.top = headerItemHeight
        }

    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val childCount = parent.childCount
        for(i in 0 until childCount){
            val childView = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(childView)
            val listItem = getItemList()[position]

            if(getItemList().isNotEmpty() && position == 0 || listItem.date != getItemList()[position-1].date){
                val top = childView.top - headerItemHeight
                drawHeaderView(c, listItem.date, top)
            }

        }
    }

    private fun drawHeaderView(canvas: Canvas, dateString: String, top: Int)    {
        val view = CalendarAdapter.HeaderViewHolder(context)
        view.setDate(dateString)

        val bitmap = getViewGroupBitmap(view)
        val bitmapCanvas = Canvas(bitmap)
        view.draw(bitmapCanvas)

        canvas.drawBitmap(bitmap, 0f, top.toFloat(), null)
    }

    private fun getViewGroupBitmap(viewGroup: ViewGroup): Bitmap{
        val layoutParams = ViewGroup.LayoutParams(headerItemWidth, headerItemHeight)
        viewGroup.layoutParams = layoutParams

        viewGroup.measure(
            View.MeasureSpec.makeMeasureSpec(headerItemWidth, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(headerItemHeight, View.MeasureSpec.EXACTLY)
        )

        viewGroup.layout(0, 0, headerItemWidth, headerItemHeight)

        val bitmap = Bitmap.createBitmap(viewGroup.width, viewGroup.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        viewGroup.draw(canvas)

        return bitmap
    }

    private fun dipToPx(context: Context, dipValue: Float): Int{
        return (dipValue * context.resources.displayMetrics.density).toInt()
    }

    private fun getScreenWidth(context: Context): Int {
//        val displayMetrics = DisplayMetrics()
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            context.display?.getRealMetrics(displayMetrics)
//        } else {
//            val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
//        }

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics: WindowMetrics = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            val displayMetrics = DisplayMetrics()
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }

//        return displayMetrics.widthPixels
    }
}