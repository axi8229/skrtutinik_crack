package sputnik.axmor.com.sputnik.widgets;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: BaseOpenDoorWidget.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u0006*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "", "uuid", "", "openDoor", "(Ljava/lang/String;)V", "openApp", "Landroid/content/Context;", "context", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/widget/RemoteViews;", "", "id", "text", "setText", "(Landroid/widget/RemoteViews;ILjava/lang/String;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "openDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "getOpenDoorUseCase", "()Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "setOpenDoorUseCase", "(Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "errHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getErrHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "setErrHandler", "(Lkotlinx/coroutines/CoroutineExceptionHandler;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BaseOpenDoorWidget extends AppWidgetProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SputnikApp context = SputnikApp.INSTANCE.applicationContext();
    public Analytics analytics;
    public CoroutineExceptionHandler errHandler;
    public LocalizationStorage localizationScreen;
    public OpenDoorUseCase openDoorUseCase;
    public PrefManager prefManager;
    public CoroutineScope scope;

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final OpenDoorUseCase getOpenDoorUseCase() {
        OpenDoorUseCase openDoorUseCase = this.openDoorUseCase;
        if (openDoorUseCase != null) {
            return openDoorUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openDoorUseCase");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final CoroutineScope getScope() {
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scope");
        return null;
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context2, Intent intent) {
        String action;
        Intrinsics.checkNotNullParameter(context2, "context");
        ContextKt.getAppComponent(context2).inject(this);
        super.onReceive(context2, intent);
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (StringsKt.startsWith(action, "ACTION_OPEN_DOOR", true)) {
            String strSubstring = action.substring(16);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            openDoor(strSubstring);
        } else if (StringsKt.equals(action, "ACTION_OPEN_APP", true)) {
            openApp();
        }
    }

    @SuppressLint({"CheckResult"})
    private final void openDoor(String uuid) {
        WidgetsLocale widgets;
        String wrongWidget = null;
        if (uuid.length() == 0) {
            SputnikApp sputnikApp = context;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            if (data != null && (widgets = data.getWidgets()) != null) {
                wrongWidget = widgets.getWrongWidget();
            }
            Toast.makeText(sputnikApp, wrongWidget, 0).show();
            return;
        }
        getAnalytics().trackLogEvent(new GeneralEvents.ClickWidgetOpen());
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new AnonymousClass1(uuid, null), 3, null);
    }

    /* compiled from: BaseOpenDoorWidget.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1", f = "BaseOpenDoorWidget.kt", l = {102}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseOpenDoorWidget.this.new AnonymousClass1(this.$uuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BaseOpenDoorWidget.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/sputnik/domain/common/Resource;", "emit", "(Lcom/sputnik/domain/common/Resource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03721<T> implements FlowCollector {
            final /* synthetic */ BaseOpenDoorWidget this$0;

            /* compiled from: BaseOpenDoorWidget.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            C03721(BaseOpenDoorWidget baseOpenDoorWidget) {
                this.this$0 = baseOpenDoorWidget;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Resource<Unit>) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final Resource<Unit> resource, Continuation<? super Unit> continuation) {
                WidgetsLocale widgets;
                final String successTitle;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                    if (data != null && (widgets = data.getWidgets()) != null && (successTitle = widgets.getSuccessTitle()) != null && !StringsKt.isBlank(successTitle)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                BaseOpenDoorWidget.AnonymousClass1.C03721.emit$lambda$1$lambda$0(successTitle);
                            }
                        });
                    }
                } else if (i == 2) {
                    if (resource.getErrorMsg() != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1$1$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BaseOpenDoorWidget.AnonymousClass1.C03721.emit$lambda$2(resource);
                            }
                        });
                    } else {
                        Handler handler = new Handler(Looper.getMainLooper());
                        final BaseOpenDoorWidget baseOpenDoorWidget = this.this$0;
                        handler.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget$openDoor$1$1$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                BaseOpenDoorWidget.AnonymousClass1.C03721.emit$lambda$3(baseOpenDoorWidget);
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$1$lambda$0(String it) {
                Intrinsics.checkNotNullParameter(it, "$it");
                Toast.makeText(BaseOpenDoorWidget.INSTANCE.getContext(), it, 0).show();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$2(Resource it) {
                String message;
                Intrinsics.checkNotNullParameter(it, "$it");
                SputnikApp context = BaseOpenDoorWidget.INSTANCE.getContext();
                DomainEmpty errorMsg = it.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    message = "Unknown error";
                }
                Toast.makeText(context, message, 0).show();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$3(BaseOpenDoorWidget this$0) {
                String failureTitle;
                WidgetsLocale widgets;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                SputnikApp context = BaseOpenDoorWidget.INSTANCE.getContext();
                LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
                if (data == null || (widgets = data.getWidgets()) == null || (failureTitle = widgets.getFailureTitle()) == null) {
                    failureTitle = "Unknown error";
                }
                Toast.makeText(context, failureTitle, 0).show();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowInvoke$default = OpenDoorUseCase.invoke$default(BaseOpenDoorWidget.this.getOpenDoorUseCase(), this.$uuid, true, OpenDoorProducers.widget, null, 8, null);
                C03721 c03721 = new C03721(BaseOpenDoorWidget.this);
                this.label = 1;
                if (flowInvoke$default.collect(c03721, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void openApp() {
        SputnikApp sputnikApp = context;
        Intent intent = new Intent(sputnikApp, (Class<?>) SputnikRootActivity.class);
        intent.addFlags(872415232);
        new ActivityNavigator(sputnikApp).navigate(new ActivityNavigator(sputnikApp).createDestination().setIntent(intent), (Bundle) null, (NavOptions) null, (Navigator.Extras) null);
    }

    public final void setText(RemoteViews remoteViews, int i, String str) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setCharSequence(i, "setText", str);
    }

    /* compiled from: BaseOpenDoorWidget.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget$Companion;", "", "<init>", "()V", "", "updateWidgets", "Lsputnik/axmor/com/sputnik/SputnikApp;", "context", "Lsputnik/axmor/com/sputnik/SputnikApp;", "getContext", "()Lsputnik/axmor/com/sputnik/SputnikApp;", "", "ACTION_OPEN_APP", "Ljava/lang/String;", "ACTION_OPEN_DOOR", "METHOD_SET_BACKGROUND_RESOURCE", "METHOD_SET_TEXT", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SputnikApp getContext() {
            return BaseOpenDoorWidget.context;
        }

        public final void updateWidgets() {
            Intent intent = new Intent(getContext(), (Class<?>) NewBigAppWidget.class);
            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(getContext()).getAppWidgetIds(new ComponentName(getContext(), (Class<?>) NewBigAppWidget.class)));
            getContext().sendBroadcast(intent);
            Intent intent2 = new Intent(getContext(), (Class<?>) NewAppSmallWidget.class);
            intent2.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent2.putExtra("appWidgetIds", AppWidgetManager.getInstance(getContext()).getAppWidgetIds(new ComponentName(getContext(), (Class<?>) NewAppSmallWidget.class)));
            getContext().sendBroadcast(intent2);
            Intent intent3 = new Intent(getContext(), (Class<?>) BigWidgetCameras.class);
            intent3.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent3.putExtra("appWidgetIds", AppWidgetManager.getInstance(getContext()).getAppWidgetIds(new ComponentName(getContext(), (Class<?>) BigWidgetCameras.class)));
            getContext().sendBroadcast(intent3);
            Intent intent4 = new Intent(getContext(), (Class<?>) SmallOpenDoorWidget.class);
            intent4.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent4.putExtra("appWidgetIds", AppWidgetManager.getInstance(getContext()).getAppWidgetIds(new ComponentName(getContext(), (Class<?>) SmallOpenDoorWidget.class)));
            getContext().sendBroadcast(intent4);
        }
    }
}
