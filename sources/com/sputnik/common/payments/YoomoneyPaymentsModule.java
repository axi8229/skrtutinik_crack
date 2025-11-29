package com.sputnik.common.payments;

import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YoomoneyPaymentsModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/sputnik/common/payments/YoomoneyPaymentsModule;", "Lcom/sputnik/common/payments/IYoomoneyPaymentsModule;", "<init>", "()V", "Lcom/sputnik/data/local/PrefManager;", "prefs", "", "isDebug", "", "getClientApplicationKey", "(Lcom/sputnik/data/local/PrefManager;Z)Ljava/lang/String;", "getShopId", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YoomoneyPaymentsModule implements IYoomoneyPaymentsModule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static IYoomoneyPaymentsModule instance;

    @Override // com.sputnik.common.payments.IYoomoneyPaymentsModule
    public String getClientApplicationKey(PrefManager prefs, boolean isDebug) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        return (isDebug && prefs.getIsTestEnvironmentForPaymentsEnabled()) ? "test_NjEyNTEzp5gjirMEJNQRmCG7kaIxCREQb09Akf6SPMs" : "live_NjM1NTgwZEOnFT_k1s3U0puSjPvaYOIlYvL15lxO2nA";
    }

    @Override // com.sputnik.common.payments.IYoomoneyPaymentsModule
    public String getShopId(PrefManager prefs, boolean isDebug) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        return (isDebug && prefs.getIsTestEnvironmentForPaymentsEnabled()) ? "612513" : "635580";
    }

    /* compiled from: YoomoneyPaymentsModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/payments/YoomoneyPaymentsModule$Companion;", "", "()V", "instance", "Lcom/sputnik/common/payments/IYoomoneyPaymentsModule;", "getInstance", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IYoomoneyPaymentsModule getInstance() {
            if (YoomoneyPaymentsModule.instance == null) {
                YoomoneyPaymentsModule.instance = new YoomoneyPaymentsModule();
            }
            IYoomoneyPaymentsModule iYoomoneyPaymentsModule = YoomoneyPaymentsModule.instance;
            Intrinsics.checkNotNull(iYoomoneyPaymentsModule);
            return iYoomoneyPaymentsModule;
        }
    }
}
