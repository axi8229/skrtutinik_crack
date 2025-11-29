package sputnik.axmor.com.sputnik.entities.gorserv;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: GorservCategories.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getIconForCategory", "", "category", "", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GorservCategoriesKt {
    public static final int getIconForCategory(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return Intrinsics.areEqual(category, GorservCategories.br.toString()) ? R.drawable.ic_gorserv_tools : Intrinsics.areEqual(category, GorservCategories.el.toString()) ? R.drawable.ic_gorserv_energy : Intrinsics.areEqual(category, GorservCategories.st.toString()) ? R.drawable.ic_gorserv_plumbing : Intrinsics.areEqual(category, GorservCategories.po.toString()) ? R.drawable.ic_gorserv_window : Intrinsics.areEqual(category, GorservCategories.bt.toString()) ? R.drawable.ic_gorserv_electric_appliance : Intrinsics.areEqual(category, GorservCategories.tel.toString()) ? R.drawable.ic_gorserv_television : Intrinsics.areEqual(category, GorservCategories.kp.toString()) ? R.drawable.ic_gorserv_repair : Intrinsics.areEqual(category, GorservCategories.sm.toString()) ? R.drawable.ic_gorserv_furniture : Intrinsics.areEqual(category, GorservCategories.pf.toString()) ? R.drawable.ic_gorserv_pipes : R.drawable.ic_gorserv_tools;
    }
}
