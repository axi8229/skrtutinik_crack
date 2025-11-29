package com.sputnik.oboarding.ui.registration.adapter;

import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.oboarding.BR;
import com.sputnik.oboarding.R$layout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryCodeAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/adapter/CountryCodeAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/country_code/CountryCode;", "onItemClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CountryCodeAdapter extends BaseAdapter<CountryCode> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryCodeAdapter(Function1<? super CountryCode, Unit> onItemClick) {
        super(R$layout.item_country_phone_code, onItemClick, BR.item, new CountryCodeDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
    }
}
