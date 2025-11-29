package ru.yoomoney.sdk.kassa.payments.utils;

import com.huawei.hms.android.SystemUtils;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$drawable;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {
    public static final a a = new a();

    public a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return CollectionsKt.listOf((Object[]) new i[]{new i("visa", CollectionsKt.listOf((Object[]) new String[]{"40", "41", "42", "43", "44", "45", "46", "47", "48", "49"}), R$drawable.ym_ic_card_type_visa_l), new i("union_pay", CollectionsKt.listOf((Object[]) new String[]{"62", "81"}), R$drawable.ym_ic_cardbrand_cup), new i("mir", CollectionsKt.listOf((Object[]) new String[]{"22", "35", "94", "90", "91", "99"}), R$drawable.ym_ic_cardbrand_mir), new i("mastercard", CollectionsKt.listOf((Object[]) new String[]{"67", "50", "51", "52", "53", "54", "55", "56", "58", "63"}), R$drawable.ym_ic_card_type_mc_l), new i(SystemUtils.UNKNOWN, CollectionsKt.emptyList(), R$drawable.ym_ic_unknown_list)});
    }
}
