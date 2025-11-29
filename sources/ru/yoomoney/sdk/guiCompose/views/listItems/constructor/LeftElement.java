package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemsData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "()V", "Image", "ImageRound", "Value", "ValueFade", "ValuePrimary", "Vector", "VectorFade", "VectorPrimary", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Image;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ImageRound;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Value;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ValueFade;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ValuePrimary;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Vector;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$VectorFade;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$VectorPrimary;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class LeftElement {
    public /* synthetic */ LeftElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Image;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Image extends LeftElement {
        private final Painter painter;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Image) && Intrinsics.areEqual(this.painter, ((Image) other).painter);
        }

        public int hashCode() {
            return this.painter.hashCode();
        }

        public String toString() {
            return "Image(painter=" + this.painter + ")";
        }

        public final Painter getPainter() {
            return this.painter;
        }
    }

    private LeftElement() {
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ImageRound;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ImageRound extends LeftElement {
        private final Painter painter;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ImageRound) && Intrinsics.areEqual(this.painter, ((ImageRound) other).painter);
        }

        public int hashCode() {
            return this.painter.hashCode();
        }

        public String toString() {
            return "ImageRound(painter=" + this.painter + ")";
        }

        public final Painter getPainter() {
            return this.painter;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Vector;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Vector extends LeftElement {
        private final Painter painter;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Vector) && Intrinsics.areEqual(this.painter, ((Vector) other).painter);
        }

        public int hashCode() {
            return this.painter.hashCode();
        }

        public String toString() {
            return "Vector(painter=" + this.painter + ")";
        }

        public final Painter getPainter() {
            return this.painter;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$VectorFade;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class VectorFade extends LeftElement {
        private final Painter painter;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VectorFade) && Intrinsics.areEqual(this.painter, ((VectorFade) other).painter);
        }

        public int hashCode() {
            return this.painter.hashCode();
        }

        public String toString() {
            return "VectorFade(painter=" + this.painter + ")";
        }

        public final Painter getPainter() {
            return this.painter;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$VectorPrimary;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class VectorPrimary extends LeftElement {
        private final Painter painter;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VectorPrimary) && Intrinsics.areEqual(this.painter, ((VectorPrimary) other).painter);
        }

        public int hashCode() {
            return this.painter.hashCode();
        }

        public String toString() {
            return "VectorPrimary(painter=" + this.painter + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VectorPrimary(Painter painter) {
            super(null);
            Intrinsics.checkNotNullParameter(painter, "painter");
            this.painter = painter;
        }

        public final Painter getPainter() {
            return this.painter;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$Value;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "text", "Ljava/lang/String;", "getText", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Value extends LeftElement {
        private final String text;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Value) && Intrinsics.areEqual(this.text, ((Value) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Value(text=" + this.text + ")";
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ValueFade;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "text", "Ljava/lang/String;", "getText", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ValueFade extends LeftElement {
        private final String text;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ValueFade) && Intrinsics.areEqual(this.text, ((ValueFade) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "ValueFade(text=" + this.text + ")";
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement$ValuePrimary;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "text", "Ljava/lang/String;", "getText", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ValuePrimary extends LeftElement {
        private final String text;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ValuePrimary) && Intrinsics.areEqual(this.text, ((ValuePrimary) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "ValuePrimary(text=" + this.text + ")";
        }

        public final String getText() {
            return this.text;
        }
    }
}
