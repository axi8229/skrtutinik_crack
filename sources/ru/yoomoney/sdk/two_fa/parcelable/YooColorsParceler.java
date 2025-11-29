package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import ru.yoomoney.sdk.guiCompose.theme.YooColors;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/parcelable/YooColorsParceler;", "Lkotlinx/parcelize/Parceler;", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YooColorsParceler implements Parceler<YooColors> {
    public static final int $stable = 0;
    public static final YooColorsParceler INSTANCE = new YooColorsParceler();

    private YooColorsParceler() {
    }

    public YooColors[] newArray(int i) {
        return (YooColors[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public YooColors create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new YooColors(TypeColorsParceler.INSTANCE.create(parcel), BackgroundColorsParceler.INSTANCE.create(parcel), ThemeColorsParceler.INSTANCE.create(parcel));
    }

    public void write(YooColors yooColors, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(yooColors, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        TypeColorsParceler.INSTANCE.write(yooColors.getType(), parcel, i);
        BackgroundColorsParceler.INSTANCE.write(yooColors.getBackground(), parcel, i);
        ThemeColorsParceler.INSTANCE.write(yooColors.getTheme(), parcel, i);
    }
}
