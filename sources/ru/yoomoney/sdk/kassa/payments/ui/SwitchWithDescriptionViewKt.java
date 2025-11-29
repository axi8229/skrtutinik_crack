package ru.yoomoney.sdk.kassa.payments.ui;

import android.widget.CompoundButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H\u0000¨\u0006\u0006"}, d2 = {"onCheckedChangedListener", "", "Lru/yoomoney/sdk/kassa/payments/ui/SwitchWithDescriptionView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwitchWithDescriptionViewKt {
    public static final void onCheckedChangedListener(SwitchWithDescriptionView switchWithDescriptionView, final Function1<? super Boolean, Unit> function1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(switchWithDescriptionView, "<this>");
        if (function1 != null) {
            switchWithDescriptionView.getSwitchView().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.SwitchWithDescriptionViewKt$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SwitchWithDescriptionViewKt.onCheckedChangedListener$lambda$1$lambda$0(function1, compoundButton, z);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            switchWithDescriptionView.getSwitchView().setOnCheckedChangeListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCheckedChangedListener$lambda$1$lambda$0(Function1 function1, CompoundButton compoundButton, boolean z) {
        function1.invoke(Boolean.valueOf(z));
    }
}
