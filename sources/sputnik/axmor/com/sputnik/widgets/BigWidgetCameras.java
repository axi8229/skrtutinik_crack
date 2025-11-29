package sputnik.axmor.com.sputnik.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.domain.entities.prefs.CamerasWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: BigWidgetCameras.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J0\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0015"}, d2 = {"Lsputnik/axmor/com/sputnik/widgets/BigWidgetCameras;", "Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget;", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "setCameraInWidget", "index", "", "views", "Landroid/widget/RemoteViews;", "titleView", "buttonView", "addressView", "setDefaultView", "updateViews", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BigWidgetCameras extends BaseOpenDoorWidget {
    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        for (int i : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.big_cameras_widget);
            updateViews(context, remoteViews);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }

    private final void updateViews(Context context, RemoteViews views) {
        WidgetsLocale widgets;
        WidgetsLocale widgets2;
        if (views != null) {
            if (getPrefManager().getCamerasInWidget().isEmpty()) {
                LocalizationLocalModel data = getLocalizationScreen().getData();
                String noAddress = null;
                setText(views, R.id.door_title_widget1, (data == null || (widgets2 = data.getWidgets()) == null) ? null : widgets2.getSettings());
                LocalizationLocalModel data2 = getLocalizationScreen().getData();
                if (data2 != null && (widgets = data2.getWidgets()) != null) {
                    noAddress = widgets.getNoAddress();
                }
                setText(views, R.id.address_widget1, noAddress);
                views.setViewVisibility(R.id.address_widget1, 0);
                views.setInt(R.id.open_door_widget1, "setBackgroundResource", R.drawable.ic_button_acount);
                views.setViewVisibility(R.id.open_door_widget1, 0);
                setDefaultView(views, R.id.address_widget2, R.id.door_title_widget2, R.id.open_door_widget2);
                setDefaultView(views, R.id.address_widget3, R.id.door_title_widget3, R.id.open_door_widget3);
            } else {
                setCameraInWidget(0, views, R.id.door_title_widget1, R.id.open_door_widget1, R.id.address_widget1);
                setCameraInWidget(1, views, R.id.door_title_widget2, R.id.open_door_widget2, R.id.address_widget2);
                setCameraInWidget(2, views, R.id.door_title_widget3, R.id.open_door_widget3, R.id.address_widget3);
            }
        }
        BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
        Intent intent = new Intent(companion.getContext(), (Class<?>) BigWidgetCameras.class);
        intent.setAction("ACTION_OPEN_APP");
        intent.putExtra("Random", Math.random() * 1000);
        PendingIntent broadcast = PendingIntent.getBroadcast(companion.getContext(), 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        if (views != null) {
            views.setOnClickPendingIntent(R.id.root_layout, broadcast);
        }
    }

    private final void setCameraInWidget(int index, RemoteViews views, int titleView, int buttonView, int addressView) {
        Unit unit;
        String str;
        int i;
        CamerasWidget camerasWidget = (CamerasWidget) CollectionsKt.getOrNull(getPrefManager().getCamerasInWidget(), index);
        if (camerasWidget != null) {
            if (camerasWidget.getUuid() == null) {
                views.setInt(buttonView, "setBackgroundResource", R.drawable.ic_button);
                BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
                Intent intent = new Intent(companion.getContext(), (Class<?>) BigWidgetCameras.class);
                intent.setAction("ACTION_OPEN_APP");
                intent.putExtra("Random", Math.random() * 1000);
                PendingIntent broadcast = PendingIntent.getBroadcast(companion.getContext(), 0, intent, 67108864);
                Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
                views.setOnClickPendingIntent(buttonView, broadcast);
                i = 0;
                str = "setBackgroundResource";
            } else {
                views.setInt(buttonView, "setBackgroundResource", R.drawable.ic_button_close_circle);
                String str2 = "ACTION_OPEN_DOOR" + camerasWidget.getUuid();
                BaseOpenDoorWidget.Companion companion2 = BaseOpenDoorWidget.INSTANCE;
                Intent intent2 = new Intent(companion2.getContext(), (Class<?>) BigWidgetCameras.class);
                intent2.setAction(str2);
                str = "setBackgroundResource";
                intent2.putExtra("Random", Math.random() * 1000);
                i = 0;
                PendingIntent broadcast2 = PendingIntent.getBroadcast(companion2.getContext(), 0, intent2, 67108864);
                Intrinsics.checkNotNullExpressionValue(broadcast2, "getBroadcast(...)");
                views.setOnClickPendingIntent(buttonView, broadcast2);
            }
            views.setCharSequence(addressView, "setText", camerasWidget.getAddress());
            views.setCharSequence(titleView, "setText", camerasWidget.getTitle());
            String str3 = str;
            views.setInt(addressView, str3, i);
            views.setInt(titleView, str3, i);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setDefaultView(views, addressView, titleView, buttonView);
        }
    }

    private final void setDefaultView(RemoteViews views, int addressView, int titleView, int buttonView) {
        views.setInt(addressView, "setBackgroundResource", R.drawable.ic_text_placeholder);
        views.setInt(titleView, "setBackgroundResource", R.drawable.ic_title_placeholder);
        views.setInt(buttonView, "setBackgroundResource", R.drawable.ic_button_placeholder);
        views.setCharSequence(titleView, "setText", "");
        views.setCharSequence(addressView, "setText", "");
        views.setViewVisibility(buttonView, 0);
        BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
        Intent intent = new Intent(companion.getContext(), (Class<?>) BigWidgetCameras.class);
        intent.setAction("ACTION_OPEN_APP");
        intent.putExtra("Random", Math.random() * 1000);
        PendingIntent broadcast = PendingIntent.getBroadcast(companion.getContext(), 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        views.setOnClickPendingIntent(buttonView, broadcast);
    }
}
