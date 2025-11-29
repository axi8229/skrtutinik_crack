package sputnik.axmor.com.sputnik.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.domain.entities.prefs.CamerasWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: NewBigAppWidget.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/widgets/NewBigAppWidget;", "Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget;", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "setNeedAuthView", "views", "Landroid/widget/RemoteViews;", "updateViews", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewBigAppWidget extends BaseOpenDoorWidget {
    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        for (int i : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_big_app_widget);
            updateViews(remoteViews);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }

    private final void updateViews(RemoteViews views) {
        Unit unit;
        WidgetsLocale widgets;
        String title;
        if (views != null) {
            CamerasWidget camerasWidget = (CamerasWidget) CollectionsKt.firstOrNull((List) getPrefManager().getCamerasInWidget());
            LocalizationLocalModel data = getLocalizationScreen().getData();
            if (data != null && (widgets = data.getWidgets()) != null && (title = widgets.getTitle()) != null) {
                setText(views, R.id.title_widget, title);
            }
            if (camerasWidget != null) {
                if (camerasWidget.getUuid() == null) {
                    views.setViewVisibility(R.id.open_door_widget, 4);
                    BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
                    Intent intent = new Intent(companion.getContext(), (Class<?>) BigWidgetCameras.class);
                    intent.setAction("ACTION_OPEN_APP");
                    intent.putExtra("Random", Math.random() * 1000);
                    PendingIntent broadcast = PendingIntent.getBroadcast(companion.getContext(), 0, intent, 67108864);
                    Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
                    views.setOnClickPendingIntent(R.id.open_door_widget, broadcast);
                } else {
                    views.setViewVisibility(R.id.open_door_widget, 0);
                    views.setInt(R.id.open_door_widget, "setBackgroundResource", R.drawable.ic_buttonclose);
                    String str = "ACTION_OPEN_DOOR" + camerasWidget.getUuid();
                    BaseOpenDoorWidget.Companion companion2 = BaseOpenDoorWidget.INSTANCE;
                    Intent intent2 = new Intent(companion2.getContext(), (Class<?>) NewBigAppWidget.class);
                    intent2.setAction(str);
                    intent2.putExtra("Random", Math.random() * 1000);
                    PendingIntent broadcast2 = PendingIntent.getBroadcast(companion2.getContext(), 0, intent2, 67108864);
                    Intrinsics.checkNotNullExpressionValue(broadcast2, "getBroadcast(...)");
                    views.setOnClickPendingIntent(R.id.open_door_widget, broadcast2);
                }
                views.setCharSequence(R.id.door_title_widget, "setText", camerasWidget.getTitle());
                views.setCharSequence(R.id.address_widget, "setText", camerasWidget.getAddress());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                setNeedAuthView(views);
            }
            BaseOpenDoorWidget.Companion companion3 = BaseOpenDoorWidget.INSTANCE;
            Intent intent3 = new Intent(companion3.getContext(), (Class<?>) NewBigAppWidget.class);
            intent3.setAction("ACTION_OPEN_APP");
            intent3.putExtra("Random", Math.random() * 1000);
            PendingIntent broadcast3 = PendingIntent.getBroadcast(companion3.getContext(), 0, intent3, 67108864);
            Intrinsics.checkNotNullExpressionValue(broadcast3, "getBroadcast(...)");
            views.setOnClickPendingIntent(R.id.root_layout, broadcast3);
        }
    }

    private final void setNeedAuthView(RemoteViews views) {
        WidgetsLocale widgets;
        WidgetsLocale widgets2;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String noAddress = null;
        setText(views, R.id.door_title_widget, (data == null || (widgets2 = data.getWidgets()) == null) ? null : widgets2.getSettings());
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (widgets = data2.getWidgets()) != null) {
            noAddress = widgets.getNoAddress();
        }
        setText(views, R.id.address_widget, noAddress);
        views.setInt(R.id.open_door_widget, "setBackgroundResource", R.drawable.ic_button_acount);
        views.setViewVisibility(R.id.open_door_widget, 0);
    }
}
