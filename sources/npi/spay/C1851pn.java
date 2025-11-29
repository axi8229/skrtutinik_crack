package npi.spay;

import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.pn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1851pn extends Lambda implements Function1 {
    public final /* synthetic */ RedirectActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1851pn(RedirectActivity redirectActivity) {
        super(1);
        this.a = redirectActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        RedirectActivity redirectActivity = this.a;
        int i = RedirectActivity.g;
        synchronized (redirectActivity) {
            try {
                if (zBooleanValue) {
                    List<Fragment> fragments = redirectActivity.getSupportFragmentManager().getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
                    Iterator<T> it = fragments.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            redirectActivity.getSupportFragmentManager().beginTransaction().add(new mo(), "SdkFlowBottomSheetDialogFragment").commitNow();
                            break;
                        }
                        if (((Fragment) it.next()) instanceof mo) {
                            break;
                        }
                    }
                } else {
                    List<Fragment> fragments2 = redirectActivity.getSupportFragmentManager().getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments2, "supportFragmentManager.fragments");
                    Object orNull = CollectionsKt.getOrNull(fragments2, 0);
                    mo moVar = orNull instanceof mo ? (mo) orNull : null;
                    if (moVar != null) {
                        moVar.dismiss();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return Unit.INSTANCE;
    }
}
