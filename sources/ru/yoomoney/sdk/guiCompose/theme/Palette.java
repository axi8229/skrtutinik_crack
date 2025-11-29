package ru.yoomoney.sdk.guiCompose.theme;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Colors.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/Palette;", "", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "light", "dark", "<init>", "(Lru/yoomoney/sdk/guiCompose/theme/YooColors;Lru/yoomoney/sdk/guiCompose/theme/YooColors;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "getLight", "()Lru/yoomoney/sdk/guiCompose/theme/YooColors;", "getDark", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Palette {
    public static final int $stable = 0;
    private final YooColors dark;
    private final YooColors light;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Palette)) {
            return false;
        }
        Palette palette = (Palette) other;
        return Intrinsics.areEqual(this.light, palette.light) && Intrinsics.areEqual(this.dark, palette.dark);
    }

    public int hashCode() {
        return (this.light.hashCode() * 31) + this.dark.hashCode();
    }

    public String toString() {
        return "Palette(light=" + this.light + ", dark=" + this.dark + ")";
    }

    public Palette(YooColors light, YooColors dark) {
        Intrinsics.checkNotNullParameter(light, "light");
        Intrinsics.checkNotNullParameter(dark, "dark");
        this.light = light;
        this.dark = dark;
    }

    public final YooColors getDark() {
        return this.dark;
    }

    public final YooColors getLight() {
        return this.light;
    }
}
