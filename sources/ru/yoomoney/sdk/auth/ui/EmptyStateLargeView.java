package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "Lru/yoomoney/sdk/gui/widget/state_screen/EmptyStateLargeView;", "Lru/yoomoney/sdk/auth/ui/UiLibEmptyStateLargeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmptyStateLargeView extends ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateLargeView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateLargeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        setIconTint(ColorStateList.valueOf(colorScheme.getThirdAccentColorForIcon(context)));
        setIconBackgroundTint(ColorStateList.valueOf(colorScheme.getSecondaryGhostColor(context)));
        setActionTextColor(colorScheme.getSecondaryAccentColor(context));
        Integer thirdAccentColor = colorScheme.getThirdAccentColor();
        if (thirdAccentColor != null) {
            int iIntValue = thirdAccentColor.intValue();
            TextTitle3View textTitle3View = (TextTitle3View) findViewById(R$id.title);
            if (textTitle3View != null) {
                textTitle3View.setTextColor(iIntValue);
            }
        }
    }

    public /* synthetic */ EmptyStateLargeView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
