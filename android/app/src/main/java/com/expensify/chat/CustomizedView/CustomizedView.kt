package com.expensify.chat.CustomizedView

import android.content.Context
import android.util.Log
import com.facebook.react.bridge.Arguments
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.views.view.ReactViewGroup
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap

class CustomizedView(context: Context): ReactViewGroup(context){

    private val measureAndLayout = Runnable {
    Log.d("CustomizedView measureAndLayout", " measureAndLayout onLayout called")
        measure(
            MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY)
        )
        layout(left, top, right, bottom)
    }

    override fun requestLayout() {
        super.requestLayout()
        Log.d("CustomizedView requestLayout", "requestLayout onLayout called")
        post(measureAndLayout)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("CustomizedView onLayout ", "onLayout - onLayout called - Changed: $changed")
//        Even after calling post(measureAndLayout) in requestLayout() the  
        if (changed) {
            sendOnLayoutEvent()  // Send layout event to JS
        }
    }

    private fun sendOnLayoutEvent() {
        val reactContext = context as ReactContext
        val width = measuredWidth
        val height = measuredHeight
        val x = left
        val y = top

        reactContext
            .getJSModule(RCTEventEmitter::class.java)
            .receiveEvent(id, "topChange", layoutEventMap(x, y, width, height))
    }

    private fun layoutEventMap(x: Int, y: Int, width: Int, height: Int): WritableMap {
        val event = Arguments.createMap()
        val layout = Arguments.createMap()
        layout.putDouble("x", x.toDouble())
        layout.putDouble("y", y.toDouble())
        layout.putDouble("width", width.toDouble())
        layout.putDouble("height", height.toDouble())
        event.putMap("layout", layout)
        return event
    }
}

class CustomizedViewManager: ViewGroupManager<CustomizedView>() {
    override fun getName() = "CustomizedView"

    override fun createViewInstance(reactContext: ThemedReactContext): CustomizedView {
        return CustomizedView(reactContext)
    }
}