package com.yandex.varioqub.config;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter;
import com.yandex.varioqub.config.impl.A;
import com.yandex.varioqub.config.impl.B;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0011\u001a\u00020\n2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0007J\u001c\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012H\u0007J$\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u0017\u001a\u00020\u00162\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001eH\u0007J\u001a\u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u0013H\u0007J\u001a\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020!H\u0007J\b\u0010#\u001a\u00020\u0013H\u0007J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0007J\b\u0010&\u001a\u00020\nH\u0007J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0007¨\u0006)"}, d2 = {"Lcom/yandex/varioqub/config/Varioqub;", "", "Lcom/yandex/varioqub/config/VarioqubApi;", "getInstance", "Lcom/yandex/varioqub/config/VarioqubSettings;", "settings", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigAdapter;", "adapter", "Landroid/content/Context;", "context", "", "init", "Lcom/yandex/varioqub/config/OnFetchCompleteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "fetchConfig", "Lkotlin/Function0;", "onComplete", "activateConfig", "", "", "defaults", "setDefaults", "", "resId", "key", "Lcom/yandex/varioqub/config/model/ConfigValue;", "getValue", "", "default", "getDouble", "", "getLong", "getString", "", "getBoolean", "getId", AppMeasurementSdk.ConditionalUserProperty.VALUE, "putClientFeature", "clearClientFeatures", "", "getAllKeys", "config_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class Varioqub {
    public static final Varioqub INSTANCE = new Varioqub();
    private static final Lazy a = LazyKt.lazy(A.a);

    private Varioqub() {
    }

    @JvmStatic
    public static final void activateConfig(Function0<Unit> onComplete) {
        getInstance().activateConfig(onComplete);
    }

    public static /* synthetic */ void activateConfig$default(Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        activateConfig(function0);
    }

    @JvmStatic
    public static final void clearClientFeatures() {
        getInstance().clearClientFeatures();
    }

    @JvmStatic
    public static final void fetchConfig(OnFetchCompleteListener listener) {
        getInstance().fetchConfig(listener);
    }

    @JvmStatic
    public static final Set<String> getAllKeys() {
        return getInstance().getAllKeys();
    }

    @JvmStatic
    public static final boolean getBoolean(String key, boolean z) {
        return getInstance().getBoolean(key, z);
    }

    public static /* synthetic */ boolean getBoolean$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getBoolean(str, z);
    }

    @JvmStatic
    public static final double getDouble(String key, double d) {
        return getInstance().getDouble(key, d);
    }

    public static /* synthetic */ double getDouble$default(String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = ConfigValue.DOUBLE_DEFAULT_VALUE;
        }
        return getDouble(str, d);
    }

    @JvmStatic
    public static final String getId() {
        return getInstance().getId();
    }

    @JvmStatic
    public static final VarioqubApi getInstance() {
        INSTANCE.getClass();
        return (B) a.getValue();
    }

    @JvmStatic
    public static final long getLong(String key, long j) {
        return getInstance().getLong(key, j);
    }

    public static /* synthetic */ long getLong$default(String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(str, j);
    }

    @JvmStatic
    public static final String getString(String key, String str) {
        return getInstance().getString(key, str);
    }

    public static /* synthetic */ String getString$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getString(str, str2);
    }

    @JvmStatic
    public static final ConfigValue getValue(String key) {
        return getInstance().getValue(key);
    }

    @JvmStatic
    public static final void init(VarioqubSettings settings, VarioqubConfigAdapter adapter, Context context) {
        getInstance().init(settings, adapter, context);
    }

    @JvmStatic
    public static final void putClientFeature(String key, String value) {
        getInstance().putClientFeature(key, value);
    }

    @JvmStatic
    public static final void setDefaults(Map<String, ? extends Object> defaults) {
        getInstance().setDefaults(defaults);
    }

    public static /* synthetic */ void setDefaults$default(int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        setDefaults(i, function0);
    }

    @JvmStatic
    public static final void setDefaults(int resId, Function0<Unit> onComplete) {
        getInstance().setDefaults(resId, onComplete);
    }
}
