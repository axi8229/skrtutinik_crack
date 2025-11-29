package androidx.compose.ui.text;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinkAnnotation.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation;", "", "<init>", "()V", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "linkInteractionListener", "Clickable", "Url", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LinkAnnotation {
    public /* synthetic */ LinkAnnotation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LinkInteractionListener getLinkInteractionListener();

    private LinkAnnotation() {
    }

    /* compiled from: LinkAnnotation.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "", "url", "Landroidx/compose/ui/text/TextLinkStyles;", "styles", "Landroidx/compose/ui/text/LinkInteractionListener;", "linkInteractionListener", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getUrl", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Url extends LinkAnnotation {
        private final TextLinkStyles styles;
        private final String url;

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return null;
        }

        public /* synthetic */ Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : textLinkStyles, (i & 4) != 0 ? null : linkInteractionListener);
        }

        public final String getUrl() {
            return this.url;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.url = str;
            this.styles = textLinkStyles;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            Url url = (Url) other;
            if (!Intrinsics.areEqual(this.url, url.url) || !Intrinsics.areEqual(getStyles(), url.getStyles())) {
                return false;
            }
            getLinkInteractionListener();
            url.getLinkInteractionListener();
            return Intrinsics.areEqual(null, null);
        }

        public int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            TextLinkStyles styles = getStyles();
            int iHashCode2 = (iHashCode + (styles != null ? styles.hashCode() : 0)) * 31;
            getLinkInteractionListener();
            return iHashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.url + ')';
        }
    }

    /* compiled from: LinkAnnotation.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "", RemoteMessageConst.Notification.TAG, "Landroidx/compose/ui/text/TextLinkStyles;", "styles", "Landroidx/compose/ui/text/LinkInteractionListener;", "linkInteractionListener", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getTag", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Clickable extends LinkAnnotation {
        private final TextLinkStyles styles;
        private final String tag;

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener getLinkInteractionListener() {
            return null;
        }

        public final String getTag() {
            return this.tag;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.tag = str;
            this.styles = textLinkStyles;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Clickable)) {
                return false;
            }
            Clickable clickable = (Clickable) other;
            if (!Intrinsics.areEqual(this.tag, clickable.tag) || !Intrinsics.areEqual(getStyles(), clickable.getStyles())) {
                return false;
            }
            getLinkInteractionListener();
            clickable.getLinkInteractionListener();
            return Intrinsics.areEqual(null, null);
        }

        public int hashCode() {
            int iHashCode = this.tag.hashCode() * 31;
            TextLinkStyles styles = getStyles();
            int iHashCode2 = (iHashCode + (styles != null ? styles.hashCode() : 0)) * 31;
            getLinkInteractionListener();
            return iHashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.tag + ')';
        }
    }
}
