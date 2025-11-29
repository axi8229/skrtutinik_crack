package com.sputnik.common.entities.stories;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.stories.ButtonStoryType;
import com.sputnik.domain.entities.stories.DeepLinks;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryButton.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/sputnik/common/entities/stories/StoryButton;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "type", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/stories/ColorsButton;", RemoteMessageConst.Notification.COLOR, "Lcom/sputnik/domain/entities/stories/DeepLinks;", "deeplink", "<init>", "(Lcom/sputnik/domain/entities/stories/ButtonStoryType;Ljava/lang/String;Lcom/sputnik/common/entities/stories/ColorsButton;Lcom/sputnik/domain/entities/stories/DeepLinks;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "getType", "()Lcom/sputnik/domain/entities/stories/ButtonStoryType;", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/stories/ColorsButton;", "getColor", "()Lcom/sputnik/common/entities/stories/ColorsButton;", "Lcom/sputnik/domain/entities/stories/DeepLinks;", "getDeeplink", "()Lcom/sputnik/domain/entities/stories/DeepLinks;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StoryButton implements Parcelable {
    public static final Parcelable.Creator<StoryButton> CREATOR = new Creator();
    private final ColorsButton color;
    private final DeepLinks deeplink;
    private final String title;
    private final ButtonStoryType type;

    /* compiled from: StoryButton.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StoryButton> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryButton createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StoryButton(parcel.readInt() == 0 ? null : ButtonStoryType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : ColorsButton.valueOf(parcel.readString()), parcel.readInt() != 0 ? DeepLinks.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryButton[] newArray(int i) {
            return new StoryButton[i];
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
        if (!(other instanceof StoryButton)) {
            return false;
        }
        StoryButton storyButton = (StoryButton) other;
        return this.type == storyButton.type && Intrinsics.areEqual(this.title, storyButton.title) && this.color == storyButton.color && this.deeplink == storyButton.deeplink;
    }

    public int hashCode() {
        ButtonStoryType buttonStoryType = this.type;
        int iHashCode = (buttonStoryType == null ? 0 : buttonStoryType.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ColorsButton colorsButton = this.color;
        int iHashCode3 = (iHashCode2 + (colorsButton == null ? 0 : colorsButton.hashCode())) * 31;
        DeepLinks deepLinks = this.deeplink;
        return iHashCode3 + (deepLinks != null ? deepLinks.hashCode() : 0);
    }

    public String toString() {
        return "StoryButton(type=" + this.type + ", title=" + this.title + ", color=" + this.color + ", deeplink=" + this.deeplink + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ButtonStoryType buttonStoryType = this.type;
        if (buttonStoryType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(buttonStoryType.name());
        }
        parcel.writeString(this.title);
        ColorsButton colorsButton = this.color;
        if (colorsButton == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(colorsButton.name());
        }
        DeepLinks deepLinks = this.deeplink;
        if (deepLinks == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(deepLinks.name());
        }
    }

    public StoryButton(ButtonStoryType buttonStoryType, String str, ColorsButton colorsButton, DeepLinks deepLinks) {
        this.type = buttonStoryType;
        this.title = str;
        this.color = colorsButton;
        this.deeplink = deepLinks;
    }

    public final ButtonStoryType getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ColorsButton getColor() {
        return this.color;
    }

    public final DeepLinks getDeeplink() {
        return this.deeplink;
    }
}
