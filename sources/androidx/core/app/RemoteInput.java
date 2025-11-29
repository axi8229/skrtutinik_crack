package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class RemoteInput {
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    public String getResultKey() {
        return this.mResultKey;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = fromCompat(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        return Api20Impl.fromCompat(remoteInput);
    }

    static class Api26Impl {
        static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }

        static Set<String> getAllowedDataTypes(Object obj) {
            return ((android.app.RemoteInput) obj).getAllowedDataTypes();
        }

        static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(remoteInput), intent, map);
        }

        static RemoteInput.Builder setAllowDataType(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }
    }

    static class Api20Impl {
        static Bundle getResultsFromIntent(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }

        static void addResultsToIntent(Object obj, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
            Set<String> allowedDataTypes;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = remoteInput.getAllowedDataTypes()) != null) {
                Iterator<String> it = allowedDataTypes.iterator();
                while (it.hasNext()) {
                    Api26Impl.setAllowDataType(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setEditChoicesBeforeSending(builderAddExtras, remoteInput.getEditChoicesBeforeSending());
            }
            return builderAddExtras.build();
        }
    }

    static class Api29Impl {
        static int getEditChoicesBeforeSending(Object obj) {
            return ((android.app.RemoteInput) obj).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }
    }
}
