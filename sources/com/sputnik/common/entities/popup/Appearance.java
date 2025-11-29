package com.sputnik.common.entities.popup;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupStory.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/sputnik/common/entities/popup/Appearance;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/popup/Bar;", "bar", "Lcom/sputnik/common/entities/popup/Image;", "image", "Lcom/sputnik/common/entities/popup/Title;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/common/entities/popup/Button;", "buttons", "Lcom/sputnik/common/entities/popup/Subtitle;", "subtitle", "Lcom/sputnik/common/entities/popup/Background;", "background", "<init>", "(Lcom/sputnik/common/entities/popup/Bar;Lcom/sputnik/common/entities/popup/Image;Lcom/sputnik/common/entities/popup/Title;Ljava/util/List;Lcom/sputnik/common/entities/popup/Subtitle;Lcom/sputnik/common/entities/popup/Background;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/popup/Bar;", "getBar", "()Lcom/sputnik/common/entities/popup/Bar;", "Lcom/sputnik/common/entities/popup/Image;", "getImage", "()Lcom/sputnik/common/entities/popup/Image;", "Lcom/sputnik/common/entities/popup/Title;", "getTitle", "()Lcom/sputnik/common/entities/popup/Title;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "Lcom/sputnik/common/entities/popup/Subtitle;", "getSubtitle", "()Lcom/sputnik/common/entities/popup/Subtitle;", "Lcom/sputnik/common/entities/popup/Background;", "getBackground", "()Lcom/sputnik/common/entities/popup/Background;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Appearance implements Parcelable {
    public static final Parcelable.Creator<Appearance> CREATOR = new Creator();
    private final Background background;
    private final Bar bar;
    private final List<Button> buttons;
    private final Image image;
    private final Subtitle subtitle;
    private final Title title;

    /* compiled from: PopupStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Appearance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Appearance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Bar barCreateFromParcel = Bar.CREATOR.createFromParcel(parcel);
            Image imageCreateFromParcel = Image.CREATOR.createFromParcel(parcel);
            Title titleCreateFromParcel = Title.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Button.CREATOR.createFromParcel(parcel));
            }
            return new Appearance(barCreateFromParcel, imageCreateFromParcel, titleCreateFromParcel, arrayList, Subtitle.CREATOR.createFromParcel(parcel), Background.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Appearance[] newArray(int i) {
            return new Appearance[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Appearance)) {
            return false;
        }
        Appearance appearance = (Appearance) other;
        return Intrinsics.areEqual(this.bar, appearance.bar) && Intrinsics.areEqual(this.image, appearance.image) && Intrinsics.areEqual(this.title, appearance.title) && Intrinsics.areEqual(this.buttons, appearance.buttons) && Intrinsics.areEqual(this.subtitle, appearance.subtitle) && Intrinsics.areEqual(this.background, appearance.background);
    }

    public int hashCode() {
        return (((((((((this.bar.hashCode() * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + this.buttons.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.background.hashCode();
    }

    public String toString() {
        return "Appearance(bar=" + this.bar + ", image=" + this.image + ", title=" + this.title + ", buttons=" + this.buttons + ", subtitle=" + this.subtitle + ", background=" + this.background + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.bar.writeToParcel(parcel, flags);
        this.image.writeToParcel(parcel, flags);
        this.title.writeToParcel(parcel, flags);
        List<Button> list = this.buttons;
        parcel.writeInt(list.size());
        Iterator<Button> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        this.subtitle.writeToParcel(parcel, flags);
        this.background.writeToParcel(parcel, flags);
    }

    public Appearance(Bar bar, Image image, Title title, List<Button> buttons, Subtitle subtitle, Background background) {
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

    public final Bar getBar() {
        return this.bar;
    }

    public final Image getImage() {
        return this.image;
    }

    public final Title getTitle() {
        return this.title;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final Subtitle getSubtitle() {
        return this.subtitle;
    }

    public final Background getBackground() {
        return this.background;
    }
}
