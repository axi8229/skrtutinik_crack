package ru.yoomoney.sdk.kassa.payments.ui.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.core.widget.ContentLoadingProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/YmProgressBar;", "Landroidx/core/widget/ContentLoadingProgressBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YmProgressBar extends ContentLoadingProgressBar {
    public static final int $stable = 0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YmProgressBar(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YmProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        getIndeterminateDrawable().setColorFilter(InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
    }

    public /* synthetic */ YmProgressBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
