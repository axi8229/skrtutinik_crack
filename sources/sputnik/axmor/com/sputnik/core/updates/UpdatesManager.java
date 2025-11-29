package sputnik.axmor.com.sputnik.core.updates;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.jos.AppUpdateClient;
import com.huawei.hms.jos.JosApps;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.common.utils.LogUtilsKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatesManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lsputnik/axmor/com/sputnik/core/updates/UpdatesManager;", "Lsputnik/axmor/com/sputnik/core/updates/IUpdatesManager;", "Landroid/app/Activity;", "context", "<init>", "(Landroid/app/Activity;)V", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isUpdateAvailable", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Lcom/huawei/hms/jos/AppUpdateClient;", "client", "Lcom/huawei/hms/jos/AppUpdateClient;", "Ljava/io/Serializable;", "updateInfo", "Ljava/io/Serializable;", "Companion", "UpdateCallBack", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdatesManager implements IUpdatesManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppUpdateClient client;
    private final Activity context;
    private Serializable updateInfo;

    public /* synthetic */ UpdatesManager(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    private UpdatesManager(Activity activity) {
        this.context = activity;
        AppUpdateClient appUpdateClient = JosApps.getAppUpdateClient(activity);
        Intrinsics.checkNotNullExpressionValue(appUpdateClient, "getAppUpdateClient(...)");
        this.client = appUpdateClient;
    }

    @Override // sputnik.axmor.com.sputnik.core.updates.IUpdatesManager
    public void isUpdateAvailable(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.client.checkAppUpdate(this.context, new UpdateCallBack(this, listener));
    }

    /* compiled from: UpdatesManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lsputnik/axmor/com/sputnik/core/updates/UpdatesManager$UpdateCallBack;", "Lcom/huawei/updatesdk/service/otaupdate/CheckUpdateCallBack;", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lsputnik/axmor/com/sputnik/core/updates/UpdatesManager;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onUpdateInfo", "(Landroid/content/Intent;)V", "onMarketInstallInfo", "", "errorCode", "onMarketStoreError", "(I)V", "onUpdateStoreError", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class UpdateCallBack implements CheckUpdateCallBack {
        private final Function1<Boolean, Unit> listener;
        final /* synthetic */ UpdatesManager this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateCallBack(UpdatesManager updatesManager, Function1<? super Boolean, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0 = updatesManager;
            this.listener = listener;
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateInfo(Intent intent) {
            if (intent != null) {
                UpdatesManager updatesManager = this.this$0;
                LogUtilsKt.writeLog("HMS Update: " + intent.getExtras());
                int intExtra = intent.getIntExtra(UpdateKey.STATUS, -1);
                intent.getIntExtra(UpdateKey.FAIL_CODE, -1);
                intent.getStringExtra(UpdateKey.FAIL_REASON);
                Serializable serializableExtra = intent.getSerializableExtra(UpdateKey.INFO);
                if (serializableExtra != null && (serializableExtra instanceof ApkUpgradeInfo)) {
                    updatesManager.updateInfo = serializableExtra;
                }
                if (intExtra != -99) {
                    switch (intExtra) {
                        case 7:
                            this.listener.invoke(Boolean.TRUE);
                            break;
                    }
                }
                this.listener.invoke(Boolean.FALSE);
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketInstallInfo(Intent intent) {
            LogUtilsKt.writeLog(String.valueOf(intent));
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketStoreError(int errorCode) {
            LogUtilsKt.writeLog(String.valueOf(errorCode));
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateStoreError(int errorCode) {
            LogUtilsKt.writeLog(String.valueOf(errorCode));
        }
    }

    /* compiled from: UpdatesManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/core/updates/UpdatesManager$Companion;", "", "()V", "getInstance", "Lsputnik/axmor/com/sputnik/core/updates/IUpdatesManager;", "context", "Landroid/app/Activity;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IUpdatesManager getInstance(Activity context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new UpdatesManager(context, null);
        }
    }
}
