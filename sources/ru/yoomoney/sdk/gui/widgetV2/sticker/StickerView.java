package ru.yoomoney.sdk.gui.widgetV2.sticker;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.ConfigurationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$styleable;

/* compiled from: StickerView.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/sticker/StickerView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLocaledImageResForStickerType", "stickerType", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StickerView extends AppCompatImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StickerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setImageResource(getLocaledImageResForStickerType(context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_StickerView, i, 0).getInt(R$styleable.ym_StickerView_ym_sticker_type, 0)));
    }

    private final int getLocaledImageResForStickerType(int stickerType) {
        String language = ConfigurationCompat.getLocales(getResources().getConfiguration()).get(0).getLanguage();
        return stickerType == StickerViewType.CASHBACK.ordinal() ? Intrinsics.areEqual(language, "en") ? R$drawable.ic_sticker_cashback_en : Intrinsics.areEqual(language, "ru") ? R$drawable.ic_sticker_cashback_ru : R$drawable.ic_sticker_cashback_en : stickerType == StickerViewType.OFFER.ordinal() ? Intrinsics.areEqual(language, "en") ? R$drawable.ic_sticker_offer_en : Intrinsics.areEqual(language, "ru") ? R$drawable.ic_sticker_offer_ru : R$drawable.ic_sticker_offer_en : stickerType == StickerViewType.CREDIT.ordinal() ? R$drawable.ic_sticker_credit : stickerType == StickerViewType.PERCENT.ordinal() ? R$drawable.ic_sticker_percent : R$drawable.ic_sticker_cashback_en;
    }
}
