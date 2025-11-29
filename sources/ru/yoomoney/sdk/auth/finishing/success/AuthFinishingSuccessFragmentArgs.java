package ru.yoomoney.sdk.auth.finishing.success;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

/* loaded from: classes4.dex */
public class AuthFinishingSuccessFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder(String str, ProcessType processType) {
            HashMap map = new HashMap();
            this.arguments = map;
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            map.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            map.put("processType", processType);
        }

        public AuthFinishingSuccessFragmentArgs build() {
            return new AuthFinishingSuccessFragmentArgs(this.arguments);
        }

        public String getAccessToken() {
            return (String) this.arguments.get(YooMoneyAuth.KEY_ACCESS_TOKEN);
        }

        public ApplicationInfo getApplicationInfo() {
            return (ApplicationInfo) this.arguments.get("applicationInfo");
        }

        public BindSocialAccountResult getBindSocialAccountResult() {
            return (BindSocialAccountResult) this.arguments.get("bindSocialAccountResult");
        }

        public String getProcessId() {
            return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        }

        public ProcessType getProcessType() {
            return (ProcessType) this.arguments.get("processType");
        }

        public Builder setAccessToken(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"accessToken\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(YooMoneyAuth.KEY_ACCESS_TOKEN, str);
            return this;
        }

        public Builder setApplicationInfo(ApplicationInfo applicationInfo) {
            this.arguments.put("applicationInfo", applicationInfo);
            return this;
        }

        public Builder setBindSocialAccountResult(BindSocialAccountResult bindSocialAccountResult) {
            this.arguments.put("bindSocialAccountResult", bindSocialAccountResult);
            return this;
        }

        public Builder setProcessId(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str);
            return this;
        }

        public Builder setProcessType(ProcessType processType) {
            if (processType == null) {
                throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("processType", processType);
            return this;
        }

        public Builder(AuthFinishingSuccessFragmentArgs authFinishingSuccessFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(authFinishingSuccessFragmentArgs.arguments);
        }
    }

    private AuthFinishingSuccessFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static AuthFinishingSuccessFragmentArgs fromBundle(Bundle bundle) {
        AuthFinishingSuccessFragmentArgs authFinishingSuccessFragmentArgs = new AuthFinishingSuccessFragmentArgs();
        if (a.a(AuthFinishingSuccessFragmentArgs.class, bundle, YooMoneyAuth.KEY_ACCESS_TOKEN)) {
            String string = bundle.getString(YooMoneyAuth.KEY_ACCESS_TOKEN);
            if (string == null) {
                throw new IllegalArgumentException("Argument \"accessToken\" is marked as non-null but was passed a null value.");
            }
            authFinishingSuccessFragmentArgs.arguments.put(YooMoneyAuth.KEY_ACCESS_TOKEN, string);
        } else {
            authFinishingSuccessFragmentArgs.arguments.put(YooMoneyAuth.KEY_ACCESS_TOKEN, "");
        }
        if (!bundle.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        authFinishingSuccessFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, string2);
        if (!bundle.containsKey("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        if (!Parcelable.class.isAssignableFrom(ProcessType.class) && !Serializable.class.isAssignableFrom(ProcessType.class)) {
            throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
        }
        ProcessType processType = (ProcessType) bundle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        authFinishingSuccessFragmentArgs.arguments.put("processType", processType);
        if (!bundle.containsKey("bindSocialAccountResult")) {
            authFinishingSuccessFragmentArgs.arguments.put("bindSocialAccountResult", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(BindSocialAccountResult.class) && !Serializable.class.isAssignableFrom(BindSocialAccountResult.class)) {
                throw new UnsupportedOperationException(BindSocialAccountResult.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            authFinishingSuccessFragmentArgs.arguments.put("bindSocialAccountResult", (BindSocialAccountResult) bundle.get("bindSocialAccountResult"));
        }
        if (!bundle.containsKey("applicationInfo")) {
            authFinishingSuccessFragmentArgs.arguments.put("applicationInfo", null);
        } else {
            if (!Parcelable.class.isAssignableFrom(ApplicationInfo.class) && !Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            authFinishingSuccessFragmentArgs.arguments.put("applicationInfo", (ApplicationInfo) bundle.get("applicationInfo"));
        }
        return authFinishingSuccessFragmentArgs;
    }

    public static AuthFinishingSuccessFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        AuthFinishingSuccessFragmentArgs authFinishingSuccessFragmentArgs = new AuthFinishingSuccessFragmentArgs();
        if (savedStateHandle.contains(YooMoneyAuth.KEY_ACCESS_TOKEN)) {
            String str = (String) savedStateHandle.get(YooMoneyAuth.KEY_ACCESS_TOKEN);
            if (str == null) {
                throw new IllegalArgumentException("Argument \"accessToken\" is marked as non-null but was passed a null value.");
            }
            authFinishingSuccessFragmentArgs.arguments.put(YooMoneyAuth.KEY_ACCESS_TOKEN, str);
        } else {
            authFinishingSuccessFragmentArgs.arguments.put(YooMoneyAuth.KEY_ACCESS_TOKEN, "");
        }
        if (!savedStateHandle.contains(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            throw new IllegalArgumentException("Required argument \"processId\" is missing and does not have an android:defaultValue");
        }
        String str2 = (String) savedStateHandle.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"processId\" is marked as non-null but was passed a null value.");
        }
        authFinishingSuccessFragmentArgs.arguments.put(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, str2);
        if (!savedStateHandle.contains("processType")) {
            throw new IllegalArgumentException("Required argument \"processType\" is missing and does not have an android:defaultValue");
        }
        ProcessType processType = (ProcessType) savedStateHandle.get("processType");
        if (processType == null) {
            throw new IllegalArgumentException("Argument \"processType\" is marked as non-null but was passed a null value.");
        }
        authFinishingSuccessFragmentArgs.arguments.put("processType", processType);
        if (savedStateHandle.contains("bindSocialAccountResult")) {
            authFinishingSuccessFragmentArgs.arguments.put("bindSocialAccountResult", (BindSocialAccountResult) savedStateHandle.get("bindSocialAccountResult"));
        } else {
            authFinishingSuccessFragmentArgs.arguments.put("bindSocialAccountResult", null);
        }
        if (savedStateHandle.contains("applicationInfo")) {
            authFinishingSuccessFragmentArgs.arguments.put("applicationInfo", (ApplicationInfo) savedStateHandle.get("applicationInfo"));
        } else {
            authFinishingSuccessFragmentArgs.arguments.put("applicationInfo", null);
        }
        return authFinishingSuccessFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthFinishingSuccessFragmentArgs authFinishingSuccessFragmentArgs = (AuthFinishingSuccessFragmentArgs) obj;
        if (this.arguments.containsKey(YooMoneyAuth.KEY_ACCESS_TOKEN) != authFinishingSuccessFragmentArgs.arguments.containsKey(YooMoneyAuth.KEY_ACCESS_TOKEN)) {
            return false;
        }
        if (getAccessToken() == null ? authFinishingSuccessFragmentArgs.getAccessToken() != null : !getAccessToken().equals(authFinishingSuccessFragmentArgs.getAccessToken())) {
            return false;
        }
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID) != authFinishingSuccessFragmentArgs.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            return false;
        }
        if (getProcessId() == null ? authFinishingSuccessFragmentArgs.getProcessId() != null : !getProcessId().equals(authFinishingSuccessFragmentArgs.getProcessId())) {
            return false;
        }
        if (this.arguments.containsKey("processType") != authFinishingSuccessFragmentArgs.arguments.containsKey("processType")) {
            return false;
        }
        if (getProcessType() == null ? authFinishingSuccessFragmentArgs.getProcessType() != null : !getProcessType().equals(authFinishingSuccessFragmentArgs.getProcessType())) {
            return false;
        }
        if (this.arguments.containsKey("bindSocialAccountResult") != authFinishingSuccessFragmentArgs.arguments.containsKey("bindSocialAccountResult")) {
            return false;
        }
        if (getBindSocialAccountResult() == null ? authFinishingSuccessFragmentArgs.getBindSocialAccountResult() != null : !getBindSocialAccountResult().equals(authFinishingSuccessFragmentArgs.getBindSocialAccountResult())) {
            return false;
        }
        if (this.arguments.containsKey("applicationInfo") != authFinishingSuccessFragmentArgs.arguments.containsKey("applicationInfo")) {
            return false;
        }
        return getApplicationInfo() == null ? authFinishingSuccessFragmentArgs.getApplicationInfo() == null : getApplicationInfo().equals(authFinishingSuccessFragmentArgs.getApplicationInfo());
    }

    public String getAccessToken() {
        return (String) this.arguments.get(YooMoneyAuth.KEY_ACCESS_TOKEN);
    }

    public ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo) this.arguments.get("applicationInfo");
    }

    public BindSocialAccountResult getBindSocialAccountResult() {
        return (BindSocialAccountResult) this.arguments.get("bindSocialAccountResult");
    }

    public String getProcessId() {
        return (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID);
    }

    public ProcessType getProcessType() {
        return (ProcessType) this.arguments.get("processType");
    }

    public int hashCode() {
        return (((((((((getAccessToken() != null ? getAccessToken().hashCode() : 0) + 31) * 31) + (getProcessId() != null ? getProcessId().hashCode() : 0)) * 31) + (getProcessType() != null ? getProcessType().hashCode() : 0)) * 31) + (getBindSocialAccountResult() != null ? getBindSocialAccountResult().hashCode() : 0)) * 31) + (getApplicationInfo() != null ? getApplicationInfo().hashCode() : 0);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(YooMoneyAuth.KEY_ACCESS_TOKEN, this.arguments.containsKey(YooMoneyAuth.KEY_ACCESS_TOKEN) ? (String) this.arguments.get(YooMoneyAuth.KEY_ACCESS_TOKEN) : "");
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            bundle.putString(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                bundle.putParcelable("processType", (Parcelable) Parcelable.class.cast(processType));
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("processType", (Serializable) Serializable.class.cast(processType));
            }
        }
        if (this.arguments.containsKey("bindSocialAccountResult")) {
            BindSocialAccountResult bindSocialAccountResult = (BindSocialAccountResult) this.arguments.get("bindSocialAccountResult");
            if (Parcelable.class.isAssignableFrom(BindSocialAccountResult.class) || bindSocialAccountResult == null) {
                bundle.putParcelable("bindSocialAccountResult", (Parcelable) Parcelable.class.cast(bindSocialAccountResult));
            } else {
                if (!Serializable.class.isAssignableFrom(BindSocialAccountResult.class)) {
                    throw new UnsupportedOperationException(BindSocialAccountResult.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("bindSocialAccountResult", (Serializable) Serializable.class.cast(bindSocialAccountResult));
            }
        } else {
            bundle.putSerializable("bindSocialAccountResult", null);
        }
        if (this.arguments.containsKey("applicationInfo")) {
            ApplicationInfo applicationInfo = (ApplicationInfo) this.arguments.get("applicationInfo");
            if (Parcelable.class.isAssignableFrom(ApplicationInfo.class) || applicationInfo == null) {
                bundle.putParcelable("applicationInfo", (Parcelable) Parcelable.class.cast(applicationInfo));
            } else {
                if (!Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                    throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                bundle.putSerializable("applicationInfo", (Serializable) Serializable.class.cast(applicationInfo));
            }
        } else {
            bundle.putSerializable("applicationInfo", null);
        }
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        Object obj2;
        Object obj3;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set(YooMoneyAuth.KEY_ACCESS_TOKEN, this.arguments.containsKey(YooMoneyAuth.KEY_ACCESS_TOKEN) ? (String) this.arguments.get(YooMoneyAuth.KEY_ACCESS_TOKEN) : "");
        if (this.arguments.containsKey(QrAuthDeclineWorkerKt.KEY_PROCESS_ID)) {
            savedStateHandle.set(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, (String) this.arguments.get(QrAuthDeclineWorkerKt.KEY_PROCESS_ID));
        }
        if (this.arguments.containsKey("processType")) {
            ProcessType processType = (ProcessType) this.arguments.get("processType");
            if (Parcelable.class.isAssignableFrom(ProcessType.class) || processType == null) {
                obj3 = (Parcelable) Parcelable.class.cast(processType);
            } else {
                if (!Serializable.class.isAssignableFrom(ProcessType.class)) {
                    throw new UnsupportedOperationException(ProcessType.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj3 = (Serializable) Serializable.class.cast(processType);
            }
            savedStateHandle.set("processType", obj3);
        }
        if (this.arguments.containsKey("bindSocialAccountResult")) {
            BindSocialAccountResult bindSocialAccountResult = (BindSocialAccountResult) this.arguments.get("bindSocialAccountResult");
            if (Parcelable.class.isAssignableFrom(BindSocialAccountResult.class) || bindSocialAccountResult == null) {
                obj2 = (Parcelable) Parcelable.class.cast(bindSocialAccountResult);
            } else {
                if (!Serializable.class.isAssignableFrom(BindSocialAccountResult.class)) {
                    throw new UnsupportedOperationException(BindSocialAccountResult.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj2 = (Serializable) Serializable.class.cast(bindSocialAccountResult);
            }
            savedStateHandle.set("bindSocialAccountResult", obj2);
        } else {
            savedStateHandle.set("bindSocialAccountResult", null);
        }
        if (this.arguments.containsKey("applicationInfo")) {
            ApplicationInfo applicationInfo = (ApplicationInfo) this.arguments.get("applicationInfo");
            if (Parcelable.class.isAssignableFrom(ApplicationInfo.class) || applicationInfo == null) {
                obj = (Parcelable) Parcelable.class.cast(applicationInfo);
            } else {
                if (!Serializable.class.isAssignableFrom(ApplicationInfo.class)) {
                    throw new UnsupportedOperationException(ApplicationInfo.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(applicationInfo);
            }
            savedStateHandle.set("applicationInfo", obj);
        } else {
            savedStateHandle.set("applicationInfo", null);
        }
        return savedStateHandle;
    }

    public String toString() {
        return "AuthFinishingSuccessFragmentArgs{accessToken=" + getAccessToken() + ", processId=" + getProcessId() + ", processType=" + getProcessType() + ", bindSocialAccountResult=" + getBindSocialAccountResult() + ", applicationInfo=" + getApplicationInfo() + "}";
    }

    private AuthFinishingSuccessFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
