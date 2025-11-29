package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final String preferredAudioLanguage;
    public final String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class Builder {
        int disabledTextTrackSelectionFlags;
        String preferredAudioLanguage;
        String preferredTextLanguage;
        int preferredTextRoleFlags;
        boolean selectUndeterminedTextLanguage;

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        }

        @Deprecated
        public Builder() {
            this.preferredAudioLanguage = null;
            this.preferredTextLanguage = null;
            this.preferredTextRoleFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.disabledTextTrackSelectionFlags = 0;
        }

        Builder(TrackSelectionParameters initialValues) {
            this.preferredAudioLanguage = initialValues.preferredAudioLanguage;
            this.preferredTextLanguage = initialValues.preferredTextLanguage;
            this.preferredTextRoleFlags = initialValues.preferredTextRoleFlags;
            this.selectUndeterminedTextLanguage = initialValues.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = initialValues.disabledTextTrackSelectionFlags;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }

        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguage = Util.getLocaleLanguageTag(locale);
                }
            }
        }
    }

    static {
        TrackSelectionParameters trackSelectionParametersBuild = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = trackSelectionParametersBuild;
        DEFAULT = trackSelectionParametersBuild;
        CREATOR = new Parcelable.Creator<TrackSelectionParameters>() { // from class: com.google.android.exoplayer2.trackselection.TrackSelectionParameters.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters createFromParcel(Parcel in) {
                return new TrackSelectionParameters(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TrackSelectionParameters[] newArray(int size) {
                return new TrackSelectionParameters[size];
            }
        };
    }

    TrackSelectionParameters(String preferredAudioLanguage, String preferredTextLanguage, int preferredTextRoleFlags, boolean selectUndeterminedTextLanguage, int disabledTextTrackSelectionFlags) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(preferredAudioLanguage);
        this.preferredTextLanguage = Util.normalizeLanguageCode(preferredTextLanguage);
        this.preferredTextRoleFlags = preferredTextRoleFlags;
        this.selectUndeterminedTextLanguage = selectUndeterminedTextLanguage;
        this.disabledTextTrackSelectionFlags = disabledTextTrackSelectionFlags;
    }

    TrackSelectionParameters(Parcel in) {
        this.preferredAudioLanguage = in.readString();
        this.preferredTextLanguage = in.readString();
        this.preferredTextRoleFlags = in.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(in);
        this.disabledTextTrackSelectionFlags = in.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return TextUtils.equals(this.preferredAudioLanguage, trackSelectionParameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, trackSelectionParameters.preferredTextLanguage) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags;
    }

    public int hashCode() {
        String str = this.preferredAudioLanguage;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.preferredTextLanguage;
        return ((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.preferredAudioLanguage);
        dest.writeString(this.preferredTextLanguage);
        dest.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(dest, this.selectUndeterminedTextLanguage);
        dest.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
