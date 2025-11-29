package com.sputnik.data.entities.popups;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPopupStory.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/sputnik/data/entities/popups/DataAppearance;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/popups/DataBar;", "bar", "Lcom/sputnik/data/entities/popups/DataImage;", "image", "Lcom/sputnik/data/entities/popups/DataTitle;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/data/entities/popups/DataButton;", "buttons", "Lcom/sputnik/data/entities/popups/DataSubtitle;", "subtitle", "Lcom/sputnik/data/entities/popups/DataBackground;", "background", "<init>", "(Lcom/sputnik/data/entities/popups/DataBar;Lcom/sputnik/data/entities/popups/DataImage;Lcom/sputnik/data/entities/popups/DataTitle;Ljava/util/List;Lcom/sputnik/data/entities/popups/DataSubtitle;Lcom/sputnik/data/entities/popups/DataBackground;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/popups/DataBar;", "getBar", "()Lcom/sputnik/data/entities/popups/DataBar;", "Lcom/sputnik/data/entities/popups/DataImage;", "getImage", "()Lcom/sputnik/data/entities/popups/DataImage;", "Lcom/sputnik/data/entities/popups/DataTitle;", "getTitle", "()Lcom/sputnik/data/entities/popups/DataTitle;", "Ljava/util/List;", "getButtons", "()Ljava/util/List;", "Lcom/sputnik/data/entities/popups/DataSubtitle;", "getSubtitle", "()Lcom/sputnik/data/entities/popups/DataSubtitle;", "Lcom/sputnik/data/entities/popups/DataBackground;", "getBackground", "()Lcom/sputnik/data/entities/popups/DataBackground;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataAppearance implements Parcelable {
    public static final Parcelable.Creator<DataAppearance> CREATOR = new Creator();
    private final DataBackground background;
    private final DataBar bar;
    private final List<DataButton> buttons;
    private final DataImage image;
    private final DataSubtitle subtitle;
    private final DataTitle title;

    /* compiled from: DataPopupStory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataAppearance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataAppearance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            DataBar dataBarCreateFromParcel = DataBar.CREATOR.createFromParcel(parcel);
            DataImage dataImageCreateFromParcel = DataImage.CREATOR.createFromParcel(parcel);
            DataTitle dataTitleCreateFromParcel = DataTitle.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(DataButton.CREATOR.createFromParcel(parcel));
            }
            return new DataAppearance(dataBarCreateFromParcel, dataImageCreateFromParcel, dataTitleCreateFromParcel, arrayList, DataSubtitle.CREATOR.createFromParcel(parcel), DataBackground.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataAppearance[] newArray(int i) {
            return new DataAppearance[i];
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
        if (!(other instanceof DataAppearance)) {
            return false;
        }
        DataAppearance dataAppearance = (DataAppearance) other;
        return Intrinsics.areEqual(this.bar, dataAppearance.bar) && Intrinsics.areEqual(this.image, dataAppearance.image) && Intrinsics.areEqual(this.title, dataAppearance.title) && Intrinsics.areEqual(this.buttons, dataAppearance.buttons) && Intrinsics.areEqual(this.subtitle, dataAppearance.subtitle) && Intrinsics.areEqual(this.background, dataAppearance.background);
    }

    public int hashCode() {
        return (((((((((this.bar.hashCode() * 31) + this.image.hashCode()) * 31) + this.title.hashCode()) * 31) + this.buttons.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.background.hashCode();
    }

    public String toString() {
        return "DataAppearance(bar=" + this.bar + ", image=" + this.image + ", title=" + this.title + ", buttons=" + this.buttons + ", subtitle=" + this.subtitle + ", background=" + this.background + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.bar.writeToParcel(parcel, flags);
        this.image.writeToParcel(parcel, flags);
        this.title.writeToParcel(parcel, flags);
        List<DataButton> list = this.buttons;
        parcel.writeInt(list.size());
        Iterator<DataButton> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        this.subtitle.writeToParcel(parcel, flags);
        this.background.writeToParcel(parcel, flags);
    }

    public DataAppearance(DataBar bar, DataImage image, DataTitle title, List<DataButton> buttons, DataSubtitle subtitle, DataBackground background) {
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

    public final DataBar getBar() {
        return this.bar;
    }

    public final DataImage getImage() {
        return this.image;
    }

    public final DataTitle getTitle() {
        return this.title;
    }

    public final List<DataButton> getButtons() {
        return this.buttons;
    }

    public final DataSubtitle getSubtitle() {
        return this.subtitle;
    }

    public final DataBackground getBackground() {
        return this.background;
    }
}
