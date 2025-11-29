package ru.yoomoney.sdk.auth.select.adapter;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/HeaderItem;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItem;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "(Ljava/lang/CharSequence;)V", "getTitle", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HeaderItem extends SelectAccountItem {
    private final CharSequence title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderItem(CharSequence title) {
        super(null);
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }

    public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = headerItem.title;
        }
        return headerItem.copy(charSequence);
    }

    /* renamed from: component1, reason: from getter */
    public final CharSequence getTitle() {
        return this.title;
    }

    public final HeaderItem copy(CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new HeaderItem(title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HeaderItem) && Intrinsics.areEqual(this.title, ((HeaderItem) other).title);
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    public String toString() {
        return "HeaderItem(title=" + ((Object) this.title) + ")";
    }
}
