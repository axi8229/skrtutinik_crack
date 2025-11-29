package com.sputnik.domain.entities.popups;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPopupStory.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/sputnik/domain/entities/popups/DomainAppearance;", "", "Lcom/sputnik/domain/entities/popups/DomainBar;", "bar", "Lcom/sputnik/domain/entities/popups/DomainImage;", "image", "Lcom/sputnik/domain/entities/popups/DomainTitle;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/domain/entities/popups/DomainButton;", "buttons", "Lcom/sputnik/domain/entities/popups/DomainSubtitle;", "subtitle", "Lcom/sputnik/domain/entities/popups/DomainBackground;", "background", "<init>", "(Lcom/sputnik/domain/entities/popups/DomainBar;Lcom/sputnik/domain/entities/popups/DomainImage;Lcom/sputnik/domain/entities/popups/DomainTitle;Ljava/util/List;Lcom/sputnik/domain/entities/popups/DomainSubtitle;Lcom/sputnik/domain/entities/popups/DomainBackground;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/popups/DomainBar;", "getBar", "()Lcom/sputnik/domain/entities/popups/DomainBar;", "Lcom/sputnik/domain/entities/popups/DomainImage;", "getImage", "()Lcom/sputnik/domain/entities/popups/DomainImage;", "Lcom/sputnik/domain/entities/popups/DomainTitle;", "getTitle", "()Lcom/sputnik/domain/entities/popups/DomainTitle;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/popups/DomainSubtitle;", "getSubtitle", "()Lcom/sputnik/domain/entities/popups/DomainSubtitle;", "Lcom/sputnik/domain/entities/popups/DomainBackground;", "getBackground", "()Lcom/sputnik/domain/entities/popups/DomainBackground;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainAppearance {
    private final DomainBackground background;
    private final DomainBar bar;
    private final List<DomainButton> buttons;
    private final DomainImage image;
    private final DomainSubtitle subtitle;
    private final DomainTitle title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainAppearance)) {
            return false;
        }
        DomainAppearance domainAppearance = (DomainAppearance) other;
        return Intrinsics.areEqual(this.bar, domainAppearance.bar) && Intrinsics.areEqual(this.image, domainAppearance.image) && Intrinsics.areEqual(this.title, domainAppearance.title) && Intrinsics.areEqual(this.buttons, domainAppearance.buttons) && Intrinsics.areEqual(this.subtitle, domainAppearance.subtitle) && Intrinsics.areEqual(this.background, domainAppearance.background);
    }

    public int hashCode() {
        return (((((((((this.bar.hashCode() * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + this.buttons.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.background.hashCode();
    }

    public String toString() {
        return "DomainAppearance(bar=" + this.bar + ", image=" + this.image + ", title=" + this.title + ", buttons=" + this.buttons + ", subtitle=" + this.subtitle + ", background=" + this.background + ")";
    }

    public DomainAppearance(DomainBar bar, DomainImage image, DomainTitle title, List<DomainButton> buttons, DomainSubtitle subtitle, DomainBackground background) {
        Intrinsics.checkNotNullParameter(bar, "bar");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(background, "background");
        this.bar = bar;
        this.image = image;
        this.title = title;
        this.buttons = buttons;
        this.subtitle = subtitle;
        this.background = background;
    }

    public final DomainBar getBar() {
        return this.bar;
    }

    public final DomainImage getImage() {
        return this.image;
    }

    public final DomainTitle getTitle() {
        return this.title;
    }

    public final List<DomainButton> getButtons() {
        return this.buttons;
    }

    public final DomainSubtitle getSubtitle() {
        return this.subtitle;
    }

    public final DomainBackground getBackground() {
        return this.background;
    }
}
