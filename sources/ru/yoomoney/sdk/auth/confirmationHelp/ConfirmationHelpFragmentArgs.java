package ru.yoomoney.sdk.auth.confirmationHelp;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.acceptTerms.a;

/* loaded from: classes4.dex */
public class ConfirmationHelpFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, String str2) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
            }
            map.put(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, str);
            if (str2 == null) {
                throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
            }
            map.put("description", str2);
        }

        public ConfirmationHelpFragmentArgs build() {
            return new ConfirmationHelpFragmentArgs(this.arguments);
        }

        public String getDescription() {
            return (String) this.arguments.get("description");
        }

        public String getTitle() {
            return (String) this.arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
        }

        public Builder setDescription(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("description", str);
            return this;
        }

        public Builder setTitle(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, str);
            return this;
        }

        public Builder(ConfirmationHelpFragmentArgs confirmationHelpFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(confirmationHelpFragmentArgs.arguments);
        }
    }

    private ConfirmationHelpFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static ConfirmationHelpFragmentArgs fromBundle(Bundle bundle) {
        ConfirmationHelpFragmentArgs confirmationHelpFragmentArgs = new ConfirmationHelpFragmentArgs();
        if (!a.a(ConfirmationHelpFragmentArgs.class, bundle, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
            throw new IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
        if (string == null) {
            throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        }
        confirmationHelpFragmentArgs.arguments.put(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, string);
        if (!bundle.containsKey("description")) {
            throw new IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString("description");
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
        }
        confirmationHelpFragmentArgs.arguments.put("description", string2);
        return confirmationHelpFragmentArgs;
    }

    public static ConfirmationHelpFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        ConfirmationHelpFragmentArgs confirmationHelpFragmentArgs = new ConfirmationHelpFragmentArgs();
        if (!savedStateHandle.contains(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
            throw new IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue");
        }
        String str = (String) savedStateHandle.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
        if (str == null) {
            throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
        }
        confirmationHelpFragmentArgs.arguments.put(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, str);
        if (!savedStateHandle.contains("description")) {
            throw new IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get("description");
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
        }
        confirmationHelpFragmentArgs.arguments.put("description", str2);
        return confirmationHelpFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfirmationHelpFragmentArgs confirmationHelpFragmentArgs = (ConfirmationHelpFragmentArgs) obj;
        if (this.arguments.containsKey(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) != confirmationHelpFragmentArgs.arguments.containsKey(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
            return false;
        }
        if (getTitle() == null ? confirmationHelpFragmentArgs.getTitle() != null : !getTitle().equals(confirmationHelpFragmentArgs.getTitle())) {
            return false;
        }
        if (this.arguments.containsKey("description") != confirmationHelpFragmentArgs.arguments.containsKey("description")) {
            return false;
        }
        return getDescription() == null ? confirmationHelpFragmentArgs.getDescription() == null : getDescription().equals(confirmationHelpFragmentArgs.getDescription());
    }

    public String getDescription() {
        return (String) this.arguments.get("description");
    }

    public String getTitle() {
        return (String) this.arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
    }

    public int hashCode() {
        return (((getTitle() != null ? getTitle().hashCode() : 0) + 31) * 31) + (getDescription() != null ? getDescription().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
            bundle.putString(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, (String) this.arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE));
        }
        if (this.arguments.containsKey("description")) {
            bundle.putString("description", (String) this.arguments.get("description"));
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)) {
            savedStateHandle.set(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, (String) this.arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE));
        }
        if (this.arguments.containsKey("description")) {
            savedStateHandle.set("description", (String) this.arguments.get("description"));
        }
        return savedStateHandle;
    }

    public String toString() {
        return "ConfirmationHelpFragmentArgs{title=" + getTitle() + ", description=" + getDescription() + "}";
    }

    private ConfirmationHelpFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
