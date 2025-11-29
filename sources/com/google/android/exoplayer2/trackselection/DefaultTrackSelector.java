package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] NO_TRACKS = new int[0];
    private boolean allowMultipleAdaptiveSelections;
    private final AtomicReference<Parameters> parametersReference;
    private final TrackSelection.Factory trackSelectionFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareFormatValues(int first, int second) {
        if (first == -1) {
            return second == -1 ? 0 : -1;
        }
        if (second == -1) {
            return 1;
        }
        return first - second;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareInts(int first, int second) {
        if (first > second) {
            return 1;
        }
        return second > first ? -1 : 0;
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private boolean allowAudioMixedChannelCountAdaptiveness;
        private boolean allowAudioMixedMimeTypeAdaptiveness;
        private boolean allowAudioMixedSampleRateAdaptiveness;
        private boolean allowVideoMixedMimeTypeAdaptiveness;
        private boolean allowVideoNonSeamlessAdaptiveness;
        private boolean exceedAudioConstraintsIfNecessary;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @Deprecated
        public ParametersBuilder() {
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
        }

        public ParametersBuilder(Context context) {
            super(context);
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        private ParametersBuilder(Parameters initialValues) {
            super(initialValues);
            this.maxVideoWidth = initialValues.maxVideoWidth;
            this.maxVideoHeight = initialValues.maxVideoHeight;
            this.maxVideoFrameRate = initialValues.maxVideoFrameRate;
            this.maxVideoBitrate = initialValues.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = initialValues.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = initialValues.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = initialValues.allowVideoNonSeamlessAdaptiveness;
            this.viewportWidth = initialValues.viewportWidth;
            this.viewportHeight = initialValues.viewportHeight;
            this.viewportOrientationMayChange = initialValues.viewportOrientationMayChange;
            this.maxAudioChannelCount = initialValues.maxAudioChannelCount;
            this.maxAudioBitrate = initialValues.maxAudioBitrate;
            this.exceedAudioConstraintsIfNecessary = initialValues.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = initialValues.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = initialValues.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = initialValues.allowAudioMixedChannelCountAdaptiveness;
            this.forceLowestBitrate = initialValues.forceLowestBitrate;
            this.forceHighestSupportedBitrate = initialValues.forceHighestSupportedBitrate;
            this.exceedRendererCapabilitiesIfNecessary = initialValues.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingAudioSessionId = initialValues.tunnelingAudioSessionId;
            this.selectionOverrides = cloneSelectionOverrides(initialValues.selectionOverrides);
            this.rendererDisabledFlags = initialValues.rendererDisabledFlags.clone();
        }

        public ParametersBuilder setMaxVideoFrameRate(int maxVideoFrameRate) {
            this.maxVideoFrameRate = maxVideoFrameRate;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean viewportOrientationMayChange) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, viewportOrientationMayChange);
        }

        public ParametersBuilder setViewportSize(int viewportWidth, int viewportHeight, boolean viewportOrientationMayChange) {
            this.viewportWidth = viewportWidth;
            this.viewportHeight = viewportHeight;
            this.viewportOrientationMayChange = viewportOrientationMayChange;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int rendererIndex, boolean disabled) {
            if (this.rendererDisabledFlags.get(rendererIndex) == disabled) {
                return this;
            }
            if (disabled) {
                this.rendererDisabledFlags.put(rendererIndex, true);
            } else {
                this.rendererDisabledFlags.delete(rendererIndex);
            }
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int rendererIndex, TrackGroupArray groups, SelectionOverride override) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(rendererIndex);
            if (map == null) {
                map = new HashMap<>();
                this.selectionOverrides.put(rendererIndex, map);
            }
            if (map.containsKey(groups) && Util.areEqual(map.get(groups), override)) {
                return this;
            }
            map.put(groups, override);
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredAudioLanguage, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingAudioSessionId, this.selectionOverrides, this.rendererDisabledFlags);
        }

        private void setInitialValuesWithoutContext() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingAudioSessionId = 0;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>();
            for (int i = 0; i < selectionOverrides.size(); i++) {
                sparseArray.put(selectionOverrides.keyAt(i), new HashMap(selectionOverrides.valueAt(i)));
            }
            return sparseArray;
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Parameters createFromParcel(Parcel in) {
                return new Parameters(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Parameters[] newArray(int size) {
                return new Parameters[size];
            }
        };

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        Parameters(int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, boolean exceedVideoConstraintsIfNecessary, boolean allowVideoMixedMimeTypeAdaptiveness, boolean allowVideoNonSeamlessAdaptiveness, int viewportWidth, int viewportHeight, boolean viewportOrientationMayChange, String preferredAudioLanguage, int maxAudioChannelCount, int maxAudioBitrate, boolean exceedAudioConstraintsIfNecessary, boolean allowAudioMixedMimeTypeAdaptiveness, boolean allowAudioMixedSampleRateAdaptiveness, boolean allowAudioMixedChannelCountAdaptiveness, String preferredTextLanguage, int preferredTextRoleFlags, boolean selectUndeterminedTextLanguage, int disabledTextTrackSelectionFlags, boolean forceLowestBitrate, boolean forceHighestSupportedBitrate, boolean exceedRendererCapabilitiesIfNecessary, int tunnelingAudioSessionId, SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides, SparseBooleanArray rendererDisabledFlags) {
            super(preferredAudioLanguage, preferredTextLanguage, preferredTextRoleFlags, selectUndeterminedTextLanguage, disabledTextTrackSelectionFlags);
            this.maxVideoWidth = maxVideoWidth;
            this.maxVideoHeight = maxVideoHeight;
            this.maxVideoFrameRate = maxVideoFrameRate;
            this.maxVideoBitrate = maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = allowVideoNonSeamlessAdaptiveness;
            this.viewportWidth = viewportWidth;
            this.viewportHeight = viewportHeight;
            this.viewportOrientationMayChange = viewportOrientationMayChange;
            this.maxAudioChannelCount = maxAudioChannelCount;
            this.maxAudioBitrate = maxAudioBitrate;
            this.exceedAudioConstraintsIfNecessary = exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = allowAudioMixedChannelCountAdaptiveness;
            this.forceLowestBitrate = forceLowestBitrate;
            this.forceHighestSupportedBitrate = forceHighestSupportedBitrate;
            this.exceedRendererCapabilitiesIfNecessary = exceedRendererCapabilitiesIfNecessary;
            this.tunnelingAudioSessionId = tunnelingAudioSessionId;
            this.selectionOverrides = selectionOverrides;
            this.rendererDisabledFlags = rendererDisabledFlags;
        }

        Parameters(Parcel in) {
            super(in);
            this.maxVideoWidth = in.readInt();
            this.maxVideoHeight = in.readInt();
            this.maxVideoFrameRate = in.readInt();
            this.maxVideoBitrate = in.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(in);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(in);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(in);
            this.viewportWidth = in.readInt();
            this.viewportHeight = in.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(in);
            this.maxAudioChannelCount = in.readInt();
            this.maxAudioBitrate = in.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(in);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(in);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(in);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(in);
            this.forceLowestBitrate = Util.readBoolean(in);
            this.forceHighestSupportedBitrate = Util.readBoolean(in);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(in);
            this.tunnelingAudioSessionId = in.readInt();
            this.selectionOverrides = readSelectionOverrides(in);
            this.rendererDisabledFlags = (SparseBooleanArray) Util.castNonNull(in.readSparseBooleanArray());
        }

        public final boolean getRendererDisabled(int rendererIndex) {
            return this.rendererDisabledFlags.get(rendererIndex);
        }

        public final boolean hasSelectionOverride(int rendererIndex, TrackGroupArray groups) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(rendererIndex);
            return map != null && map.containsKey(groups);
        }

        public final SelectionOverride getSelectionOverride(int rendererIndex, TrackGroupArray groups) {
            Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(rendererIndex);
            if (map != null) {
                return map.get(groups);
            }
            return null;
        }

        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.maxVideoWidth);
            dest.writeInt(this.maxVideoHeight);
            dest.writeInt(this.maxVideoFrameRate);
            dest.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(dest, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(dest, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(dest, this.allowVideoNonSeamlessAdaptiveness);
            dest.writeInt(this.viewportWidth);
            dest.writeInt(this.viewportHeight);
            Util.writeBoolean(dest, this.viewportOrientationMayChange);
            dest.writeInt(this.maxAudioChannelCount);
            dest.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(dest, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(dest, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(dest, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(dest, this.allowAudioMixedChannelCountAdaptiveness);
            Util.writeBoolean(dest, this.forceLowestBitrate);
            Util.writeBoolean(dest, this.forceHighestSupportedBitrate);
            Util.writeBoolean(dest, this.exceedRendererCapabilitiesIfNecessary);
            dest.writeInt(this.tunnelingAudioSessionId);
            writeSelectionOverridesToParcel(dest, this.selectionOverrides);
            dest.writeSparseBooleanArray(this.rendererDisabledFlags);
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel in) {
            int i = in.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = in.readInt();
                int i4 = in.readInt();
                HashMap map = new HashMap(i4);
                for (int i5 = 0; i5 < i4; i5++) {
                    map.put((TrackGroupArray) Assertions.checkNotNull(in.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) in.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(i3, map);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel dest, SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides) {
            int size = selectionOverrides.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                int iKeyAt = selectionOverrides.keyAt(i);
                Map<TrackGroupArray, SelectionOverride> mapValueAt = selectionOverrides.valueAt(i);
                int size2 = mapValueAt.size();
                dest.writeInt(iKeyAt);
                dest.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : mapValueAt.entrySet()) {
                    dest.writeParcelable(entry.getKey(), 0);
                    dest.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray first, SparseBooleanArray second) {
            int size = first.size();
            if (second.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (second.indexOfKey(first.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> first, SparseArray<Map<TrackGroupArray, SelectionOverride>> second) {
            int size = first.size();
            if (second.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = second.indexOfKey(first.keyAt(i));
                if (iIndexOfKey < 0 || !areSelectionOverridesEqual(first.valueAt(i), second.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(Map<TrackGroupArray, SelectionOverride> first, Map<TrackGroupArray, SelectionOverride> second) {
            if (second.size() != first.size()) {
                return false;
            }
            for (Map.Entry<TrackGroupArray, SelectionOverride> entry : first.entrySet()) {
                TrackGroupArray key = entry.getKey();
                if (!second.containsKey(key) || !Util.areEqual(entry.getValue(), second.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() { // from class: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride createFromParcel(Parcel in) {
                return new SelectionOverride(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride[] newArray(int size) {
                return new SelectionOverride[size];
            }
        };
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SelectionOverride(int groupIndex, int... tracks) {
            this(groupIndex, tracks, 2, 0);
        }

        public SelectionOverride(int groupIndex, int[] tracks, int reason, int data) {
            this.groupIndex = groupIndex;
            int[] iArrCopyOf = Arrays.copyOf(tracks, tracks.length);
            this.tracks = iArrCopyOf;
            this.length = tracks.length;
            this.reason = reason;
            this.data = data;
            Arrays.sort(iArrCopyOf);
        }

        SelectionOverride(Parcel in) {
            this.groupIndex = in.readInt();
            int i = in.readByte();
            this.length = i;
            int[] iArr = new int[i];
            this.tracks = iArr;
            in.readIntArray(iArr);
            this.reason = in.readInt();
            this.data = in.readInt();
        }

        public boolean containsTrack(int track) {
            for (int i : this.tracks) {
                if (i == track) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.reason) * 31) + this.data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.reason == selectionOverride.reason && this.data == selectionOverride.data;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.groupIndex);
            dest.writeInt(this.tracks.length);
            dest.writeIntArray(this.tracks);
            dest.writeInt(this.reason);
            dest.writeInt(this.data);
        }
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, TrackSelection.Factory trackSelectionFactory) {
        this(Parameters.getDefaults(context), trackSelectionFactory);
    }

    public DefaultTrackSelector(Parameters parameters, TrackSelection.Factory trackSelectionFactory) {
        this.trackSelectionFactory = trackSelectionFactory;
        this.parametersReference = new AtomicReference<>(parameters);
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (this.parametersReference.getAndSet(parameters).equals(parameters)) {
            return;
        }
        invalidate();
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    protected final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupports) throws ExoPlaybackException {
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArrSelectAllTracks = selectAllTracks(mappedTrackInfo, rendererFormatSupports, rendererMixedMimeTypeAdaptationSupports, parameters);
        int i = 0;
        while (true) {
            if (i >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i)) {
                definitionArrSelectAllTracks[i] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                if (parameters.hasSelectionOverride(i, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
                    definitionArrSelectAllTracks[i] = selectionOverride != null ? new TrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.reason, Integer.valueOf(selectionOverride.data)) : null;
                }
            }
            i++;
        }
        TrackSelection[] trackSelectionArrCreateTrackSelections = this.trackSelectionFactory.createTrackSelections(definitionArrSelectAllTracks, getBandwidthMeter());
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurationArr[i2] = (parameters.getRendererDisabled(i2) || (mappedTrackInfo.getRendererType(i2) != 6 && trackSelectionArrCreateTrackSelections[i2] == null)) ? null : RendererConfiguration.DEFAULT;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, rendererFormatSupports, rendererConfigurationArr, trackSelectionArrCreateTrackSelections, parameters.tunnelingAudioSessionId);
        return Pair.create(rendererConfigurationArr, trackSelectionArrCreateTrackSelections);
    }

    protected TrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] rendererFormatSupports, int[] rendererMixedMimeTypeAdaptationSupports, Parameters params) throws ExoPlaybackException {
        boolean z;
        String str;
        int i;
        AudioTrackScore audioTrackScore;
        String str2;
        int i2;
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArr = new TrackSelection.Definition[rendererCount];
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            if (i4 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo.getRendererType(i4)) {
                if (!z2) {
                    TrackSelection.Definition definitionSelectVideoTrack = selectVideoTrack(mappedTrackInfo.getTrackGroups(i4), rendererFormatSupports[i4], rendererMixedMimeTypeAdaptationSupports[i4], params, true);
                    definitionArr[i4] = definitionSelectVideoTrack;
                    z2 = definitionSelectVideoTrack != null;
                }
                z3 |= mappedTrackInfo.getTrackGroups(i4).length > 0;
            }
            i4++;
        }
        int i5 = 0;
        int i6 = -1;
        AudioTrackScore audioTrackScore2 = null;
        String str3 = null;
        while (i5 < rendererCount) {
            if (z == mappedTrackInfo.getRendererType(i5)) {
                boolean z4 = (this.allowMultipleAdaptiveSelections || !z3) ? z : false;
                i = i6;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i2 = i5;
                Pair<TrackSelection.Definition, AudioTrackScore> pairSelectAudioTrack = selectAudioTrack(mappedTrackInfo.getTrackGroups(i5), rendererFormatSupports[i5], rendererMixedMimeTypeAdaptationSupports[i5], params, z4);
                if (pairSelectAudioTrack != null && (audioTrackScore == null || ((AudioTrackScore) pairSelectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i != -1) {
                        definitionArr[i] = null;
                    }
                    TrackSelection.Definition definition = (TrackSelection.Definition) pairSelectAudioTrack.first;
                    definitionArr[i2] = definition;
                    str3 = definition.group.getFormat(definition.tracks[0]).language;
                    audioTrackScore2 = (AudioTrackScore) pairSelectAudioTrack.second;
                    i6 = i2;
                }
                i5 = i2 + 1;
                z = true;
            } else {
                i = i6;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i2 = i5;
            }
            i6 = i;
            audioTrackScore2 = audioTrackScore;
            str3 = str2;
            i5 = i2 + 1;
            z = true;
        }
        String str4 = str3;
        int i7 = -1;
        TextTrackScore textTrackScore = null;
        while (i3 < rendererCount) {
            int rendererType = mappedTrackInfo.getRendererType(i3);
            if (rendererType == 1) {
                str = str4;
            } else if (rendererType == 2) {
                str = str4;
            } else if (rendererType == 3) {
                str = str4;
                Pair<TrackSelection.Definition, TextTrackScore> pairSelectTextTrack = selectTextTrack(mappedTrackInfo.getTrackGroups(i3), rendererFormatSupports[i3], params, str);
                if (pairSelectTextTrack != null && (textTrackScore == null || ((TextTrackScore) pairSelectTextTrack.second).compareTo(textTrackScore) > 0)) {
                    if (i7 != -1) {
                        definitionArr[i7] = null;
                    }
                    definitionArr[i3] = (TrackSelection.Definition) pairSelectTextTrack.first;
                    textTrackScore = (TextTrackScore) pairSelectTextTrack.second;
                    i7 = i3;
                }
            } else {
                definitionArr[i3] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i3), rendererFormatSupports[i3], params);
                str = str4;
            }
            i3++;
            str4 = str;
        }
        return definitionArr;
    }

    protected TrackSelection.Definition selectVideoTrack(TrackGroupArray groups, int[][] formatSupports, int mixedMimeTypeAdaptationSupports, Parameters params, boolean enableAdaptiveTrackSelection) {
        TrackSelection.Definition definitionSelectAdaptiveVideoTrack = (params.forceHighestSupportedBitrate || params.forceLowestBitrate || !enableAdaptiveTrackSelection) ? null : selectAdaptiveVideoTrack(groups, formatSupports, mixedMimeTypeAdaptationSupports, params);
        return definitionSelectAdaptiveVideoTrack == null ? selectFixedVideoTrack(groups, formatSupports, params) : definitionSelectAdaptiveVideoTrack;
    }

    private static TrackSelection.Definition selectAdaptiveVideoTrack(TrackGroupArray groups, int[][] formatSupport, int mixedMimeTypeAdaptationSupports, Parameters params) {
        TrackGroupArray trackGroupArray = groups;
        int i = params.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = params.allowVideoMixedMimeTypeAdaptiveness && (mixedMimeTypeAdaptationSupports & i) != 0;
        int i2 = 0;
        while (i2 < trackGroupArray.length) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, formatSupport[i2], z, i, params.maxVideoWidth, params.maxVideoHeight, params.maxVideoFrameRate, params.maxVideoBitrate, params.viewportWidth, params.viewportHeight, params.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new TrackSelection.Definition(trackGroup, adaptiveVideoTracksForGroup);
            }
            i2++;
            trackGroupArray = groups;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup group, int[] formatSupport, boolean allowMixedMimeTypes, int requiredAdaptiveSupport, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, int viewportWidth, int viewportHeight, boolean viewportOrientationMayChange) {
        String str;
        int adaptiveVideoTrackCountForMimeType;
        if (group.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(group, viewportWidth, viewportHeight, viewportOrientationMayChange);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (allowMixedMimeTypes) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i = 0;
            for (int i2 = 0; i2 < viewportFilteredTrackIndices.size(); i2++) {
                String str3 = group.getFormat(viewportFilteredTrackIndices.get(i2).intValue()).sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(group, formatSupport, requiredAdaptiveSupport, str3, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate, viewportFilteredTrackIndices)) > i) {
                    i = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        }
        filterAdaptiveVideoTrackCountForMimeType(group, formatSupport, requiredAdaptiveSupport, str, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup group, int[] formatSupport, int requiredAdaptiveSupport, String mimeType, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, List<Integer> selectedTrackIndices) {
        int i = 0;
        for (int i2 = 0; i2 < selectedTrackIndices.size(); i2++) {
            int iIntValue = selectedTrackIndices.get(i2).intValue();
            if (isSupportedAdaptiveVideoTrack(group.getFormat(iIntValue), mimeType, formatSupport[iIntValue], requiredAdaptiveSupport, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate)) {
                i++;
            }
        }
        return i;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup group, int[] formatSupport, int requiredAdaptiveSupport, String mimeType, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate, List<Integer> selectedTrackIndices) {
        for (int size = selectedTrackIndices.size() - 1; size >= 0; size--) {
            int iIntValue = selectedTrackIndices.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(group.getFormat(iIntValue), mimeType, formatSupport[iIntValue], requiredAdaptiveSupport, maxVideoWidth, maxVideoHeight, maxVideoFrameRate, maxVideoBitrate)) {
                selectedTrackIndices.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String mimeType, int formatSupport, int requiredAdaptiveSupport, int maxVideoWidth, int maxVideoHeight, int maxVideoFrameRate, int maxVideoBitrate) {
        if ((format.roleFlags & 16384) != 0 || !isSupported(formatSupport, false) || (formatSupport & requiredAdaptiveSupport) == 0) {
            return false;
        }
        if (mimeType != null && !Util.areEqual(format.sampleMimeType, mimeType)) {
            return false;
        }
        int i = format.width;
        if (i != -1 && i > maxVideoWidth) {
            return false;
        }
        int i2 = format.height;
        if (i2 != -1 && i2 > maxVideoHeight) {
            return false;
        }
        float f = format.frameRate;
        if (f != -1.0f && f > maxVideoFrameRate) {
            return false;
        }
        int i3 = format.bitrate;
        return i3 == -1 || i3 <= maxVideoBitrate;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.trackselection.TrackSelection.Definition selectFixedVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray r18, int[][] r19, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r20) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.TrackSelection$Definition");
    }

    protected Pair<TrackSelection.Definition, AudioTrackScore> selectAudioTrack(TrackGroupArray groups, int[][] formatSupports, int mixedMimeTypeAdaptationSupports, Parameters params, boolean enableAdaptiveTrackSelection) {
        TrackSelection.Definition definition = null;
        int i = -1;
        int i2 = -1;
        AudioTrackScore audioTrackScore = null;
        for (int i3 = 0; i3 < groups.length; i3++) {
            TrackGroup trackGroup = groups.get(i3);
            int[] iArr = formatSupports[i3];
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                if (isSupported(iArr[i4], params.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i4), params, iArr[i4]);
                    if ((audioTrackScore2.isWithinConstraints || params.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i = i3;
                        i2 = i4;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        TrackGroup trackGroup2 = groups.get(i);
        if (!params.forceHighestSupportedBitrate && !params.forceLowestBitrate && enableAdaptiveTrackSelection) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, formatSupports[i], i2, params.maxAudioBitrate, params.allowAudioMixedMimeTypeAdaptiveness, params.allowAudioMixedSampleRateAdaptiveness, params.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 1) {
                definition = new TrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new TrackSelection.Definition(trackGroup2, i2);
        }
        return Pair.create(definition, Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup group, int[] formatSupport, int primaryTrackIndex, int maxAudioBitrate, boolean allowMixedMimeTypeAdaptiveness, boolean allowMixedSampleRateAdaptiveness, boolean allowAudioMixedChannelCountAdaptiveness) {
        Format format = group.getFormat(primaryTrackIndex);
        int[] iArr = new int[group.length];
        int i = 0;
        for (int i2 = 0; i2 < group.length; i2++) {
            if (i2 == primaryTrackIndex || isSupportedAdaptiveAudioTrack(group.getFormat(i2), formatSupport[i2], format, maxAudioBitrate, allowMixedMimeTypeAdaptiveness, allowMixedSampleRateAdaptiveness, allowAudioMixedChannelCountAdaptiveness)) {
                iArr[i] = i2;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int formatSupport, Format primaryFormat, int maxAudioBitrate, boolean allowMixedMimeTypeAdaptiveness, boolean allowMixedSampleRateAdaptiveness, boolean allowAudioMixedChannelCountAdaptiveness) {
        int i;
        String str;
        int i2;
        if (!isSupported(formatSupport, false)) {
            return false;
        }
        int i3 = format.bitrate;
        if (i3 != -1 && i3 > maxAudioBitrate) {
            return false;
        }
        if (!allowAudioMixedChannelCountAdaptiveness && ((i2 = format.channelCount) == -1 || i2 != primaryFormat.channelCount)) {
            return false;
        }
        if (allowMixedMimeTypeAdaptiveness || ((str = format.sampleMimeType) != null && TextUtils.equals(str, primaryFormat.sampleMimeType))) {
            return allowMixedSampleRateAdaptiveness || ((i = format.sampleRate) != -1 && i == primaryFormat.sampleRate);
        }
        return false;
    }

    protected Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray groups, int[][] formatSupport, Parameters params, String selectedAudioLanguage) {
        int i = -1;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        for (int i2 = 0; i2 < groups.length; i2++) {
            TrackGroup trackGroup2 = groups.get(i2);
            int[] iArr = formatSupport[i2];
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                if (isSupported(iArr[i3], params.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore2 = new TextTrackScore(trackGroup2.getFormat(i3), params, iArr[i3], selectedAudioLanguage);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i = i3;
                        textTrackScore = textTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new TrackSelection.Definition(trackGroup, i), Assertions.checkNotNull(textTrackScore));
    }

    protected TrackSelection.Definition selectOtherTrack(int trackType, TrackGroupArray groups, int[][] formatSupport, Parameters params) {
        TrackGroup trackGroup = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < groups.length; i3++) {
            TrackGroup trackGroup2 = groups.get(i3);
            int[] iArr = formatSupport[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr[i4], params.exceedRendererCapabilitiesIfNecessary)) {
                    int i5 = (trackGroup2.getFormat(i4).selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr[i4], false)) {
                        i5 += 1000;
                    }
                    if (i5 > i2) {
                        trackGroup = trackGroup2;
                        i = i4;
                        i2 = i5;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i);
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] renderererFormatSupports, RendererConfiguration[] rendererConfigurations, TrackSelection[] trackSelections, int tunnelingAudioSessionId) {
        boolean z;
        if (tunnelingAudioSessionId == 0) {
            return;
        }
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < mappedTrackInfo.getRendererCount(); i3++) {
            int rendererType = mappedTrackInfo.getRendererType(i3);
            TrackSelection trackSelection = trackSelections[i3];
            if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(renderererFormatSupports[i3], mappedTrackInfo.getTrackGroups(i3), trackSelection)) {
                if (rendererType == 1) {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i3;
                } else {
                    if (i != -1) {
                        z = false;
                        break;
                    }
                    i = i3;
                }
            }
        }
        z = true;
        if (i2 != -1 && i != -1) {
            z2 = true;
        }
        if (z && z2) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(tunnelingAudioSessionId);
            rendererConfigurations[i2] = rendererConfiguration;
            rendererConfigurations[i] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] formatSupports, TrackGroupArray trackGroups, TrackSelection selection) {
        if (selection == null) {
            return false;
        }
        int iIndexOf = trackGroups.indexOf(selection.getTrackGroup());
        for (int i = 0; i < selection.length(); i++) {
            if (RendererCapabilities.getTunnelingSupport(formatSupports[iIndexOf][selection.getIndexInTrackGroup(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSupported(int formatSupport, boolean allowExceedsCapabilities) {
        int formatSupport2 = RendererCapabilities.getFormatSupport(formatSupport);
        return formatSupport2 == 4 || (allowExceedsCapabilities && formatSupport2 == 3);
    }

    protected static String normalizeUndeterminedLanguageToNull(String language) {
        if (TextUtils.isEmpty(language) || TextUtils.equals(language, "und")) {
            return null;
        }
        return language;
    }

    protected static int getFormatLanguageScore(Format format, String language, boolean allowUndeterminedFormatLanguage) {
        if (!TextUtils.isEmpty(language) && language.equals(format.language)) {
            return 4;
        }
        String strNormalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(language);
        String strNormalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (strNormalizeUndeterminedLanguageToNull2 == null || strNormalizeUndeterminedLanguageToNull == null) {
            return (allowUndeterminedFormatLanguage && strNormalizeUndeterminedLanguageToNull2 == null) ? 1 : 0;
        }
        if (strNormalizeUndeterminedLanguageToNull2.startsWith(strNormalizeUndeterminedLanguageToNull) || strNormalizeUndeterminedLanguageToNull.startsWith(strNormalizeUndeterminedLanguageToNull2)) {
            return 3;
        }
        return Util.splitAtFirst(strNormalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(strNormalizeUndeterminedLanguageToNull, "-")[0]) ? 2 : 0;
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup group, int viewportWidth, int viewportHeight, boolean orientationMayChange) {
        int i;
        ArrayList arrayList = new ArrayList(group.length);
        for (int i2 = 0; i2 < group.length; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (viewportWidth != Integer.MAX_VALUE && viewportHeight != Integer.MAX_VALUE) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < group.length; i4++) {
                Format format = group.getFormat(i4);
                int i5 = format.width;
                if (i5 > 0 && (i = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(orientationMayChange, viewportWidth, viewportHeight, i5, i);
                    int i6 = format.width;
                    int i7 = format.height;
                    int i8 = i6 * i7;
                    if (i6 >= ((int) (maxVideoSizeInViewport.x * 0.98f)) && i7 >= ((int) (maxVideoSizeInViewport.y * 0.98f)) && i8 < i3) {
                        i3 = i8;
                    }
                }
            }
            if (i3 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = group.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i3) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageScore;
        private final int sampleRate;

        public AudioTrackScore(Format format, Parameters parameters, int formatSupport) {
            this.parameters = parameters;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(formatSupport, false);
            this.preferredLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredAudioLanguage, false);
            boolean z = true;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            int i2 = format.channelCount;
            this.channelCount = i2;
            this.sampleRate = format.sampleRate;
            int i3 = format.bitrate;
            this.bitrate = i3;
            if ((i3 != -1 && i3 > parameters.maxAudioBitrate) || (i2 != -1 && i2 > parameters.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i4 = 0;
            while (true) {
                if (i4 >= systemLanguageCodes.length) {
                    i4 = Integer.MAX_VALUE;
                    break;
                }
                int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i4], false);
                if (formatLanguageScore > 0) {
                    i = formatLanguageScore;
                    break;
                }
                i4++;
            }
            this.localeLanguageMatchIndex = i4;
            this.localeLanguageScore = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(AudioTrackScore other) {
            int iCompareInts;
            int iCompareFormatValues;
            boolean z = this.isWithinRendererCapabilities;
            int i = -1;
            if (z != other.isWithinRendererCapabilities) {
                return z ? 1 : -1;
            }
            int i2 = this.preferredLanguageScore;
            int i3 = other.preferredLanguageScore;
            if (i2 != i3) {
                return DefaultTrackSelector.compareInts(i2, i3);
            }
            boolean z2 = this.isWithinConstraints;
            if (z2 != other.isWithinConstraints) {
                return z2 ? 1 : -1;
            }
            if (this.parameters.forceLowestBitrate && (iCompareFormatValues = DefaultTrackSelector.compareFormatValues(this.bitrate, other.bitrate)) != 0) {
                return iCompareFormatValues > 0 ? -1 : 1;
            }
            boolean z3 = this.isDefaultSelectionFlag;
            if (z3 != other.isDefaultSelectionFlag) {
                return z3 ? 1 : -1;
            }
            int i4 = this.localeLanguageMatchIndex;
            int i5 = other.localeLanguageMatchIndex;
            if (i4 != i5) {
                return -DefaultTrackSelector.compareInts(i4, i5);
            }
            int i6 = this.localeLanguageScore;
            int i7 = other.localeLanguageScore;
            if (i6 != i7) {
                return DefaultTrackSelector.compareInts(i6, i7);
            }
            if (this.isWithinConstraints && this.isWithinRendererCapabilities) {
                i = 1;
            }
            int i8 = this.channelCount;
            int i9 = other.channelCount;
            if (i8 != i9) {
                iCompareInts = DefaultTrackSelector.compareInts(i8, i9);
            } else {
                int i10 = this.sampleRate;
                int i11 = other.sampleRate;
                if (i10 != i11) {
                    iCompareInts = DefaultTrackSelector.compareInts(i10, i11);
                } else {
                    if (!Util.areEqual(this.language, other.language)) {
                        return 0;
                    }
                    iCompareInts = DefaultTrackSelector.compareInts(this.bitrate, other.bitrate);
                }
            }
            return i * iCompareInts;
        }
    }

    protected static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean hasPreferredIsForcedFlag;
        private final boolean isDefault;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format, Parameters parameters, int trackFormatSupport, String selectedAudioLanguage) {
            boolean z = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(trackFormatSupport, false);
            int i = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
            boolean z2 = (i & 1) != 0;
            this.isDefault = z2;
            boolean z3 = (i & 2) != 0;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.preferredLanguageScore = formatLanguageScore;
            int iBitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = iBitCount;
            this.hasCaptionRoleFlags = (format.roleFlags & 1088) != 0;
            this.hasPreferredIsForcedFlag = (formatLanguageScore > 0 && !z3) || (formatLanguageScore == 0 && z3);
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(format, selectedAudioLanguage, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(selectedAudioLanguage) == null);
            this.selectedAudioLanguageScore = formatLanguageScore2;
            if (formatLanguageScore > 0 || ((parameters.preferredTextLanguage == null && iBitCount > 0) || z2 || (z3 && formatLanguageScore2 > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(TextTrackScore other) {
            boolean z;
            boolean z2 = this.isWithinRendererCapabilities;
            if (z2 != other.isWithinRendererCapabilities) {
                return z2 ? 1 : -1;
            }
            int i = this.preferredLanguageScore;
            int i2 = other.preferredLanguageScore;
            if (i != i2) {
                return DefaultTrackSelector.compareInts(i, i2);
            }
            int i3 = this.preferredRoleFlagsScore;
            int i4 = other.preferredRoleFlagsScore;
            if (i3 != i4) {
                return DefaultTrackSelector.compareInts(i3, i4);
            }
            boolean z3 = this.isDefault;
            if (z3 != other.isDefault) {
                return z3 ? 1 : -1;
            }
            boolean z4 = this.hasPreferredIsForcedFlag;
            if (z4 != other.hasPreferredIsForcedFlag) {
                return z4 ? 1 : -1;
            }
            int i5 = this.selectedAudioLanguageScore;
            int i6 = other.selectedAudioLanguageScore;
            if (i5 != i6) {
                return DefaultTrackSelector.compareInts(i5, i6);
            }
            if (i3 != 0 || (z = this.hasCaptionRoleFlags) == other.hasCaptionRoleFlags) {
                return 0;
            }
            return z ? -1 : 1;
        }
    }
}
