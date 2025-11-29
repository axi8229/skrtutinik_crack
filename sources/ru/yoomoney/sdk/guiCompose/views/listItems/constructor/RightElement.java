package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "", "<init>", "()V", "Action", "Detail", "Icon", "Link", "Tag", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Action;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Detail;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Icon;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Link;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Tag;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RightElement {
    public /* synthetic */ RightElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Detail;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/String;", "getValue", "subvalue", "getSubvalue", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Detail extends RightElement {
        private final String subvalue;
        private final String value;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Detail)) {
                return false;
            }
            Detail detail = (Detail) other;
            return Intrinsics.areEqual(this.value, detail.value) && Intrinsics.areEqual(this.subvalue, detail.subvalue);
        }

        public int hashCode() {
            int iHashCode = this.value.hashCode() * 31;
            String str = this.subvalue;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Detail(value=" + this.value + ", subvalue=" + this.subvalue + ")";
        }

        public final String getSubvalue() {
            return this.subvalue;
        }

        public final String getValue() {
            return this.value;
        }
    }

    private RightElement() {
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Link;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/String;", "getValue", "Landroidx/compose/ui/graphics/Color;", "valueColor", "Landroidx/compose/ui/graphics/Color;", "getValueColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Link extends RightElement {
        private final String value;
        private final Color valueColor;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Link)) {
                return false;
            }
            Link link = (Link) other;
            return Intrinsics.areEqual(this.value, link.value) && Intrinsics.areEqual(this.valueColor, link.valueColor);
        }

        public int hashCode() {
            int iHashCode = this.value.hashCode() * 31;
            Color color = this.valueColor;
            return iHashCode + (color == null ? 0 : Color.m983hashCodeimpl(color.getValue()));
        }

        public String toString() {
            return "Link(value=" + this.value + ", valueColor=" + this.valueColor + ")";
        }

        public final String getValue() {
            return this.value;
        }

        /* renamed from: getValueColor-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getValueColor() {
            return this.valueColor;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Tag;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Ljava/lang/String;", "getValue", "enabled", "Z", "getEnabled", "()Z", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Tag extends RightElement {
        private final boolean enabled;
        private final String value;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tag)) {
                return false;
            }
            Tag tag = (Tag) other;
            return Intrinsics.areEqual(this.value, tag.value) && this.enabled == tag.enabled;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + Boolean.hashCode(this.enabled);
        }

        public String toString() {
            return "Tag(value=" + this.value + ", enabled=" + this.enabled + ")";
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Icon;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/Color;", "tint", "Landroidx/compose/ui/graphics/Color;", "getTint-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Icon extends RightElement {
        private final Painter painter;
        private final Color tint;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Icon)) {
                return false;
            }
            Icon icon = (Icon) other;
            return Intrinsics.areEqual(this.painter, icon.painter) && Intrinsics.areEqual(this.tint, icon.tint);
        }

        public int hashCode() {
            int iHashCode = this.painter.hashCode() * 31;
            Color color = this.tint;
            return iHashCode + (color == null ? 0 : Color.m983hashCodeimpl(color.getValue()));
        }

        public String toString() {
            return "Icon(painter=" + this.painter + ", tint=" + this.tint + ")";
        }

        public final Painter getPainter() {
            return this.painter;
        }

        /* renamed from: getTint-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getTint() {
            return this.tint;
        }
    }

    /* compiled from: ListItemsData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Action;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "()V", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Action extends RightElement {
        public static final Action INSTANCE = new Action();

        private Action() {
            super(null);
        }
    }
}
