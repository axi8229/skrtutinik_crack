package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel in) {
            return new PlaybackStateCompat(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int size) {
            return new PlaybackStateCompat[size];
        }
    };
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private PlaybackState mStateFwk;
    final long mUpdateTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int state, long position, long bufferedPosition, float rate, long actions, int errorCode, CharSequence errorMessage, long updateTime, List<CustomAction> customActions, long activeItemId, Bundle extras) {
        this.mState = state;
        this.mPosition = position;
        this.mBufferedPosition = bufferedPosition;
        this.mSpeed = rate;
        this.mActions = actions;
        this.mErrorCode = errorCode;
        this.mErrorMessage = errorMessage;
        this.mUpdateTime = updateTime;
        this.mCustomActions = new ArrayList(customActions);
        this.mActiveItemId = activeItemId;
        this.mExtras = extras;
    }

    PlaybackStateCompat(Parcel in) {
        this.mState = in.readInt();
        this.mPosition = in.readLong();
        this.mSpeed = in.readFloat();
        this.mUpdateTime = in.readLong();
        this.mBufferedPosition = in.readLong();
        this.mActions = in.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mCustomActions = in.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = in.readLong();
        this.mExtras = in.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = in.readInt();
    }

    public String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mState);
        dest.writeLong(this.mPosition);
        dest.writeFloat(this.mSpeed);
        dest.writeLong(this.mUpdateTime);
        dest.writeLong(this.mBufferedPosition);
        dest.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, dest, flags);
        dest.writeTypedList(this.mCustomActions);
        dest.writeLong(this.mActiveItemId);
        dest.writeBundle(this.mExtras);
        dest.writeInt(this.mErrorCode);
    }

    public static PlaybackStateCompat fromPlaybackState(Object stateObj) {
        ArrayList arrayList = null;
        if (stateObj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) stateObj;
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            Iterator<PlaybackState.CustomAction> it = customActions.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.fromCustomAction(it.next()));
            }
        }
        Bundle extras = playbackState.getExtras();
        MediaSessionCompat.ensureClassLoader(extras);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), extras);
        playbackStateCompat.mStateFwk = playbackState;
        return playbackStateCompat;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel p) {
                return new CustomAction(p);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int size) {
                return new CustomAction[size];
            }
        };
        private final String mAction;
        private PlaybackState.CustomAction mCustomActionFwk;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        CustomAction(String action, CharSequence name, int icon, Bundle extras) {
            this.mAction = action;
            this.mName = name;
            this.mIcon = icon;
            this.mExtras = extras;
        }

        CustomAction(Parcel in) {
            this.mAction = in.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            this.mIcon = in.readInt();
            this.mExtras = in.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, dest, flags);
            dest.writeInt(this.mIcon);
            dest.writeBundle(this.mExtras);
        }

        public static CustomAction fromCustomAction(Object customActionObj) {
            if (customActionObj == null) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) customActionObj;
            Bundle extras = customAction.getExtras();
            MediaSessionCompat.ensureClassLoader(extras);
            CustomAction customAction2 = new CustomAction(customAction.getAction(), customAction.getName(), customAction.getIcon(), extras);
            customAction2.mCustomActionFwk = customAction;
            return customAction2;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }
    }
}
