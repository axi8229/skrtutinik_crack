package ru.yoomoney.sdk.kassa.payments.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2333q;

/* loaded from: classes5.dex */
public abstract class b {
    public static final int a = R$drawable.ym_ic_unknown_list;
    public static final Lazy b = LazyKt.lazy(a.a);

    public static final int a(String pan) {
        Object next;
        Intrinsics.checkNotNullParameter(pan, "pan");
        String strTake = StringsKt.take(StringsKt.replace$default(pan, " ", "", false, 4, (Object) null), 2);
        int i = a;
        for (i iVar : (List) b.getValue()) {
            Iterator it = iVar.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual((String) next, strTake)) {
                    break;
                }
            }
            if (((String) next) != null) {
                i = iVar.c;
            }
        }
        return i;
    }

    public static final int a(String pan, EnumC2333q brand) {
        Intrinsics.checkNotNullParameter(pan, "pan");
        Intrinsics.checkNotNullParameter(brand, "brand");
        int iA = a(pan);
        Integer numValueOf = Integer.valueOf(iA);
        if (iA == a) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        Intrinsics.checkNotNullParameter(brand, "<this>");
        switch (brand.ordinal()) {
            case 0:
                return R$drawable.ym_ic_card_type_mc_l;
            case 1:
                return R$drawable.ym_ic_card_type_visa_l;
            case 2:
                return R$drawable.ym_ic_cardbrand_mir;
            case 3:
                return R$drawable.ym_ic_cardbrand_american_express;
            case 4:
                return R$drawable.ym_ic_cardbrand_jcb;
            case 5:
                return R$drawable.ym_ic_cardbrand_cup;
            case 6:
                return R$drawable.ym_ic_cardbrand_diners_club;
            case 7:
                return R$drawable.ym_ic_cardbrand_bank_card;
            case 8:
                return R$drawable.ym_ic_cardbrand_discover_card;
            case 9:
            case 10:
                return R$drawable.ym_ic_cardbrand_instapay;
            case 11:
                return R$drawable.ym_ic_cardbrand_laser;
            case 12:
                return R$drawable.ym_ic_cardbrand_dankort;
            case 13:
                return R$drawable.ym_ic_cardbrand_solo;
            case 14:
                return R$drawable.ym_ic_cardbrand_switch;
            case 15:
                return R$drawable.ym_ic_unknown_list;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
