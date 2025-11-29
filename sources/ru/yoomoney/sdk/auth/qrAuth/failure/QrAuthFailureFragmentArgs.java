package ru.yoomoney.sdk.auth.qrAuth.failure;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.HashMap;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.acceptTerms.a;
import ru.yoomoney.sdk.auth.api.model.Failure;

/* loaded from: classes4.dex */
public class QrAuthFailureFragmentArgs {
    private final HashMap arguments;

    public static final class Builder {
        private final HashMap arguments;

        public Builder() {
            this.arguments = new HashMap();
        }

        public QrAuthFailureFragmentArgs build() {
            return new QrAuthFailureFragmentArgs(this.arguments);
        }

        public Failure getFailure() {
            return (Failure) this.arguments.get(YooMoneyAuth.KEY_FAILURE);
        }

        public Builder setFailure(Failure failure) {
            this.arguments.put(YooMoneyAuth.KEY_FAILURE, failure);
            return this;
        }

        public Builder(QrAuthFailureFragmentArgs qrAuthFailureFragmentArgs) {
            HashMap map = new HashMap();
            this.arguments = map;
            map.putAll(qrAuthFailureFragmentArgs.arguments);
        }
    }

    private QrAuthFailureFragmentArgs() {
        this.arguments = new HashMap();
    }

    public static QrAuthFailureFragmentArgs fromBundle(Bundle bundle) {
        QrAuthFailureFragmentArgs qrAuthFailureFragmentArgs = new QrAuthFailureFragmentArgs();
        if (!a.a(QrAuthFailureFragmentArgs.class, bundle, YooMoneyAuth.KEY_FAILURE)) {
            qrAuthFailureFragmentArgs.arguments.put(YooMoneyAuth.KEY_FAILURE, null);
        } else {
            if (!Parcelable.class.isAssignableFrom(Failure.class) && !Serializable.class.isAssignableFrom(Failure.class)) {
                throw new UnsupportedOperationException(Failure.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            qrAuthFailureFragmentArgs.arguments.put(YooMoneyAuth.KEY_FAILURE, (Failure) bundle.get(YooMoneyAuth.KEY_FAILURE));
        }
        return qrAuthFailureFragmentArgs;
    }

    public static QrAuthFailureFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        QrAuthFailureFragmentArgs qrAuthFailureFragmentArgs = new QrAuthFailureFragmentArgs();
        if (savedStateHandle.contains(YooMoneyAuth.KEY_FAILURE)) {
            qrAuthFailureFragmentArgs.arguments.put(YooMoneyAuth.KEY_FAILURE, (Failure) savedStateHandle.get(YooMoneyAuth.KEY_FAILURE));
        } else {
            qrAuthFailureFragmentArgs.arguments.put(YooMoneyAuth.KEY_FAILURE, null);
        }
        return qrAuthFailureFragmentArgs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QrAuthFailureFragmentArgs qrAuthFailureFragmentArgs = (QrAuthFailureFragmentArgs) obj;
        if (this.arguments.containsKey(YooMoneyAuth.KEY_FAILURE) != qrAuthFailureFragmentArgs.arguments.containsKey(YooMoneyAuth.KEY_FAILURE)) {
            return false;
        }
        return getFailure() == null ? qrAuthFailureFragmentArgs.getFailure() == null : getFailure().equals(qrAuthFailureFragmentArgs.getFailure());
    }

    public Failure getFailure() {
        return (Failure) this.arguments.get(YooMoneyAuth.KEY_FAILURE);
    }

    public int hashCode() {
        return (getFailure() != null ? getFailure().hashCode() : 0) + 31;
    }

    public Bundle toBundle() {
        Serializable serializable;
        Bundle bundle = new Bundle();
        if (this.arguments.containsKey(YooMoneyAuth.KEY_FAILURE)) {
            Failure failure = (Failure) this.arguments.get(YooMoneyAuth.KEY_FAILURE);
            if (Parcelable.class.isAssignableFrom(Failure.class) || failure == null) {
                bundle.putParcelable(YooMoneyAuth.KEY_FAILURE, (Parcelable) Parcelable.class.cast(failure));
                return bundle;
            }
            if (!Serializable.class.isAssignableFrom(Failure.class)) {
                throw new UnsupportedOperationException(Failure.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
            }
            serializable = (Serializable) Serializable.class.cast(failure);
        } else {
            serializable = null;
        }
        bundle.putSerializable(YooMoneyAuth.KEY_FAILURE, serializable);
        return bundle;
    }

    public SavedStateHandle toSavedStateHandle() {
        Object obj;
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (this.arguments.containsKey(YooMoneyAuth.KEY_FAILURE)) {
            Failure failure = (Failure) this.arguments.get(YooMoneyAuth.KEY_FAILURE);
            if (Parcelable.class.isAssignableFrom(Failure.class) || failure == null) {
                obj = (Parcelable) Parcelable.class.cast(failure);
            } else {
                if (!Serializable.class.isAssignableFrom(Failure.class)) {
                    throw new UnsupportedOperationException(Failure.class.getName().concat(" must implement Parcelable or Serializable or must be an Enum."));
                }
                obj = (Serializable) Serializable.class.cast(failure);
            }
        } else {
            obj = null;
        }
        savedStateHandle.set(YooMoneyAuth.KEY_FAILURE, obj);
        return savedStateHandle;
    }

    public String toString() {
        return "QrAuthFailureFragmentArgs{failure=" + getFailure() + "}";
    }

    private QrAuthFailureFragmentArgs(HashMap map) {
        HashMap map2 = new HashMap();
        this.arguments = map2;
        map2.putAll(map);
    }
}
