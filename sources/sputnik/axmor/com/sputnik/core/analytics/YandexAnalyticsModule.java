package sputnik.axmor.com.sputnik.core.analytics;

import android.app.Application;
import android.content.Context;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.domain.Constants;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.varioqub.appmetricaadapter.AppMetricaAdapter;
import com.yandex.varioqub.config.FetchError;
import com.yandex.varioqub.config.OnFetchCompleteListener;
import com.yandex.varioqub.config.Varioqub;
import com.yandex.varioqub.config.VarioqubSettings;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: YandexAnalyticsModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/core/analytics/YandexAnalyticsModule;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "initializeVarioqub", "(Landroid/content/Context;)V", "syncVarioqub", "Landroid/app/Application;", "application", "init", "(Landroid/app/Application;)V", "", "category", "action", "label", "send", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YandexAnalyticsModule {
    public void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        YandexMetricaConfig.Builder builderNewConfigBuilder = YandexMetricaConfig.newConfigBuilder(Constants.INSTANCE.getYandexApiKey(false));
        Intrinsics.checkNotNullExpressionValue(builderNewConfigBuilder, "newConfigBuilder(...)");
        YandexMetrica.activate(application, builderNewConfigBuilder.build());
        YandexMetrica.enableActivityAutoTracking(application);
        initializeVarioqub(application);
        syncVarioqub();
    }

    public void send(String category, String action, String label) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap map = new HashMap();
        map.put(action, label);
        YandexMetrica.reportEvent(category, map);
    }

    private final void initializeVarioqub(Context context) {
        Varioqub.init(new VarioqubSettings.Builder("appmetrica.2914312").build(), new AppMetricaAdapter(context), context);
        Varioqub.activateConfig$default(null, 1, null);
    }

    /* compiled from: YandexAnalyticsModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.core.analytics.YandexAnalyticsModule$syncVarioqub$1", f = "YandexAnalyticsModule.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.core.analytics.YandexAnalyticsModule$syncVarioqub$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Varioqub.fetchConfig(new OnFetchCompleteListener() { // from class: sputnik.axmor.com.sputnik.core.analytics.YandexAnalyticsModule.syncVarioqub.1.1
                @Override // com.yandex.varioqub.config.OnFetchCompleteListener
                public void onError(String message, FetchError error) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Intrinsics.checkNotNullParameter(error, "error");
                    LogUtilsKt.writeLog("Varioqub", "Fetch error " + message);
                }

                @Override // com.yandex.varioqub.config.OnFetchCompleteListener
                public void onSuccess() {
                    LogUtilsKt.writeLog("Varioqub", "Fetch success");
                    Varioqub.activateConfig$default(null, 1, null);
                }
            });
            return Unit.INSTANCE;
        }
    }

    private final void syncVarioqub() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }
}
