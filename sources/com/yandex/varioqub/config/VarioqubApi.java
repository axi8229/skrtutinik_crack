package com.yandex.varioqub.config;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH&J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\fH&J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fH&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\fH&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH&J$\u0010\"\u001a\u00020\u00032\b\b\u0001\u0010#\u001a\u00020$2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\u001c\u0010\"\u001a\u00020\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010&H&¨\u0006'"}, d2 = {"Lcom/yandex/varioqub/config/VarioqubApi;", "", "activateConfig", "", "onComplete", "Lkotlin/Function0;", "clearClientFeatures", "fetchConfig", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yandex/varioqub/config/OnFetchCompleteListener;", "getAllKeys", "", "", "getBoolean", "", "key", "default", "getDouble", "", "getId", "getLong", "", "getString", "getValue", "Lcom/yandex/varioqub/config/model/ConfigValue;", "init", "settings", "Lcom/yandex/varioqub/config/VarioqubSettings;", "adapter", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigAdapter;", "context", "Landroid/content/Context;", "putClientFeature", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setDefaults", "resId", "", "defaults", "", "config_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface VarioqubApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void activateConfig$default(VarioqubApi varioqubApi, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: activateConfig");
            }
            if ((i & 1) != 0) {
                function0 = null;
            }
            varioqubApi.activateConfig(function0);
        }

        public static /* synthetic */ boolean getBoolean$default(VarioqubApi varioqubApi, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return varioqubApi.getBoolean(str, z);
        }

        public static /* synthetic */ double getDouble$default(VarioqubApi varioqubApi, String str, double d, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDouble");
            }
            if ((i & 2) != 0) {
                d = ConfigValue.DOUBLE_DEFAULT_VALUE;
            }
            return varioqubApi.getDouble(str, d);
        }

        public static /* synthetic */ long getLong$default(VarioqubApi varioqubApi, String str, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i & 2) != 0) {
                j = 0;
            }
            return varioqubApi.getLong(str, j);
        }

        public static /* synthetic */ String getString$default(VarioqubApi varioqubApi, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 2) != 0) {
                str2 = "";
            }
            return varioqubApi.getString(str, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setDefaults$default(VarioqubApi varioqubApi, int i, Function0 function0, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaults");
            }
            if ((i2 & 2) != 0) {
                function0 = null;
            }
            varioqubApi.setDefaults(i, function0);
        }
    }

    void activateConfig(Function0<Unit> onComplete);

    void clearClientFeatures();

    void fetchConfig(OnFetchCompleteListener listener);

    Set<String> getAllKeys();

    boolean getBoolean(String key, boolean z);

    double getDouble(String key, double d);

    String getId();

    long getLong(String key, long j);

    String getString(String key, String str);

    ConfigValue getValue(String key);

    void init(VarioqubSettings settings, VarioqubConfigAdapter adapter, Context context);

    void putClientFeature(String key, String value);

    void setDefaults(int resId, Function0<Unit> onComplete);

    void setDefaults(Map<String, ? extends Object> defaults);
}
