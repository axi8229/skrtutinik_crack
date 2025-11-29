package sputnik.axmor.com.sputnik.core.updates;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IUpdatesManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lsputnik/axmor/com/sputnik/core/updates/IUpdatesManager;", "", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isUpdateAvailable", "(Lkotlin/jvm/functions/Function1;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IUpdatesManager {
    void isUpdateAvailable(Function1<? super Boolean, Unit> listener);
}
