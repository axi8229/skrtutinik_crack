package com.sputnik.common.entities.alerts;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB1\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/alerts/Button;", "", "", "type", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "Lcom/sputnik/common/entities/alerts/Button$Styles;", "style", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/alerts/Button$Styles;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "getTitle", "getDeeplink", "Lcom/sputnik/common/entities/alerts/Button$Styles;", "getStyle", "()Lcom/sputnik/common/entities/alerts/Button$Styles;", "Styles", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Button {
    private final String deeplink;
    private final Styles style;
    private final String title;
    private final String type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Button)) {
            return false;
        }
        Button button = (Button) other;
        return Intrinsics.areEqual(this.type, button.type) && Intrinsics.areEqual(this.title, button.title) && Intrinsics.areEqual(this.deeplink, button.deeplink) && this.style == button.style;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deeplink;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Styles styles = this.style;
        return iHashCode3 + (styles != null ? styles.hashCode() : 0);
    }

    public String toString() {
        return "Button(type=" + this.type + ", title=" + this.title + ", deeplink=" + this.deeplink + ", style=" + this.style + ")";
    }

    public Button(String str, String str2, String str3, Styles styles) {
        this.type = str;
        this.title = str2;
        this.deeplink = str3;
        this.style = styles;
    }

    public /* synthetic */ Button(String str, String str2, String str3, Styles styles, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : styles);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Button.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/entities/alerts/Button$Styles;", "", "(Ljava/lang/String;I)V", "main", "text", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Styles {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Styles[] $VALUES;
        public static final Styles main = new Styles("main", 0);
        public static final Styles text = new Styles("text", 1);

        private static final /* synthetic */ Styles[] $values() {
            return new Styles[]{main, text};
        }

        public static Styles valueOf(String str) {
            return (Styles) Enum.valueOf(Styles.class, str);
        }

        public static Styles[] values() {
            return (Styles[]) $VALUES.clone();
        }

        private Styles(String str, int i) {
        }

        static {
            Styles[] stylesArr$values = $values();
            $VALUES = stylesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stylesArr$values);
        }
    }
}
