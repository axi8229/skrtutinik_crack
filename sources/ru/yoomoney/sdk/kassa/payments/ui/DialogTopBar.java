package ru.yoomoney.sdk.kassa.payments.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.transition.TransitionManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.kassa.payments.databinding.a;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J#\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R(\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/DialogTopBar;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onBackButton", "(Lkotlin/jvm/functions/Function1;)V", "", "withAnimation", "(Lkotlin/jvm/functions/Function1;Z)V", "Lru/yoomoney/sdk/kassa/payments/databinding/a;", "binding", "Lru/yoomoney/sdk/kassa/payments/databinding/a;", "Landroid/widget/ImageView;", "backButton", "Landroid/widget/ImageView;", "getBackButton", "()Landroid/widget/ImageView;", "logo", "getLogo", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "isLogoVisible", "()Z", "setLogoVisible", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class DialogTopBar extends FrameLayout {
    public static final int $stable = 8;
    private final ImageView backButton;
    private final a binding;
    private final ImageView logo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogTopBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ImageView getBackButton() {
        return this.backButton;
    }

    public final ImageView getLogo() {
        return this.logo;
    }

    public final CharSequence getTitle() {
        return this.binding.e.getText();
    }

    public final boolean isLogoVisible() {
        ImageView logo = this.binding.d;
        Intrinsics.checkNotNullExpressionValue(logo, "logo");
        return logo.getVisibility() == 0;
    }

    public final void onBackButton(final Function1<? super View, Unit> listener) {
        ImageView backButton = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        backButton.setVisibility(listener != null ? 0 : 8);
        this.binding.b.setOnClickListener(listener != null ? new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                listener.invoke(view);
            }
        } : null);
    }

    public final void setLogoVisible(boolean z) {
        ImageView logo = this.binding.d;
        Intrinsics.checkNotNullExpressionValue(logo, "logo");
        logo.setVisibility(z ? 0 : 8);
    }

    public final void setTitle(CharSequence charSequence) {
        this.binding.e.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void onBackButton(final Function1<? super View, Unit> listener, boolean withAnimation) {
        ImageView backButton = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        backButton.setVisibility(listener != null ? 0 : 8);
        if (withAnimation) {
            TransitionManager.beginDelayedTransition(this.binding.c);
        }
        this.binding.b.setOnClickListener(listener != null ? new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                listener.invoke(view);
            }
        } : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogTopBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVarA = a.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(aVarA, "inflate(...)");
        this.binding = aVarA;
        ImageView backButton = aVarA.b;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        this.backButton = backButton;
        ImageView logo = aVarA.d;
        Intrinsics.checkNotNullExpressionValue(logo, "logo");
        this.logo = logo;
        int primaryColor = InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor();
        ImageView imageView = aVarA.b;
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        imageView.setImageDrawable(DrawableExtensions.tint(drawable, primaryColor));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.text});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setTitle(typedArrayObtainStyledAttributes.getText(0));
    }

    public /* synthetic */ DialogTopBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
