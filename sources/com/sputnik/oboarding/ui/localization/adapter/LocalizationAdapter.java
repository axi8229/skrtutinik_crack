package com.sputnik.oboarding.ui.localization.adapter;

import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.oboarding.BR;
import com.sputnik.oboarding.R$layout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/ui/localization/adapter/LocalizationAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/localization/Localization;", "onItemClicked", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalizationAdapter extends BaseAdapter<Localization> {
    public LocalizationAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LocalizationAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<Localization, Unit>() { // from class: com.sputnik.oboarding.ui.localization.adapter.LocalizationAdapter.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Localization it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Localization localization) {
                invoke2(localization);
                return Unit.INSTANCE;
            }
        } : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalizationAdapter(Function1<? super Localization, Unit> onItemClicked) {
        super(R$layout.item_select_langiage, onItemClicked, BR.item, new LanguageDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
    }
}
