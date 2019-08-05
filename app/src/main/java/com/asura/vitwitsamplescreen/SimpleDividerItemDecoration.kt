package com.asura.vitwitsamplescreen

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import android.opengl.ETC1.getWidth
import android.os.Build


class SimpleDividerItemDecoration(context : Context) : RecyclerView.ItemDecoration() {

    private val mDivider : Drawable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        context.getDrawable(R.drawable.line_divider)
    } else {
        context.resources.getDrawable(R.drawable.line_divider)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.getIntrinsicHeight()

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}