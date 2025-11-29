package com.sputnik.common.payments;

import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;

/* compiled from: IYoomoneyPaymentsModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/sputnik/common/payments/IYoomoneyPaymentsModule;", "", "Lcom/sputnik/data/local/PrefManager;", "prefs", "", "isDebug", "", "getClientApplicationKey", "(Lcom/sputnik/data/local/PrefManager;Z)Ljava/lang/String;", "getShopId", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IYoomoneyPaymentsModule {
    String getClientApplicationKey(PrefManager prefs, boolean isDebug);

    String getShopId(PrefManager prefs, boolean isDebug);
}
