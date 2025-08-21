package com.mygtd.inboxwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class GtdInboxWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    companion object {
        internal fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {
            // 1. 위젯 레이아웃을 가져옵니다.
            val views = RemoteViews(context.packageName, R.layout.gtd_inbox_widget_layout)

            // 2. 위젯을 클릭했을 때 InputActivity를 실행하라는 Intent를 만듭니다.
            val intent = Intent(context, InputActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // 3. 위젯의 루트 레이아웃(전체 영역)에 클릭 이벤트를 연결합니다.
            views.setOnClickPendingIntent(R.id.widget_root_layout, pendingIntent)

            // 4. 위젯을 업데이트합니다.
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}