package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemsData.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;", "", "()V", "Default", "Large", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Default;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Large;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ContentElement {
    public /* synthetic */ ContentElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Default;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "titleType", "<init>", "(Ljava/lang/String;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "getTitleType", "()Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Default extends ContentElement {
        private final String title;
        private final TextType titleType;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Default)) {
                return false;
            }
            Default r5 = (Default) other;
            return Intrinsics.areEqual(this.title, r5.title) && this.titleType == r5.titleType;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.titleType.hashCode();
        }

        public String toString() {
            return "Default(title=" + this.title + ", titleType=" + this.titleType + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Default(String title, TextType titleType) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(titleType, "titleType");
            this.title = title;
            this.titleType = titleType;
        }

        public /* synthetic */ Default(String str, TextType textType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? TextType.PRIMARY : textType);
        }

        public final String getTitle() {
            return this.title;
        }

        public final TextType getTitleType() {
            return this.titleType;
        }
    }

    private ContentElement() {
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Large;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Ljava/lang/String;", "getTitle", "subtitle", "getSubtitle", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "titleType", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "getTitleType", "()Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/TextType;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Large extends ContentElement {
        private final String subtitle;
        private final String title;
        private final TextType titleType;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Large)) {
                return false;
            }
            Large large = (Large) other;
            return Intrinsics.areEqual(this.title, large.title) && Intrinsics.areEqual(this.subtitle, large.subtitle) && this.titleType == large.titleType;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.titleType.hashCode();
        }

        public String toString() {
            return "Large(title=" + this.title + ", subtitle=" + this.subtitle + ", titleType=" + this.titleType + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextType getTitleType() {
            return this.titleType;
        }
    }
}
