package androidx.browser.customtabs;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import ru.yoomoney.sdk.auth.net.HttpHeaders;

/* loaded from: classes.dex */
public final class CustomTabsIntent {
    public final Intent intent;
    public final Bundle startAnimationBundle;

    public void launchUrl(Context context, Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }

    CustomTabsIntent(Intent intent, Bundle bundle) {
        this.intent = intent;
        this.startAnimationBundle = bundle;
    }

    public static final class Builder {
        private ArrayList<Bundle> mActionButtons;
        private ActivityOptions mActivityOptions;
        private SparseArray<Bundle> mColorSchemeParamBundles;
        private Bundle mDefaultColorSchemeBundle;
        private ArrayList<Bundle> mMenuItems;
        private boolean mShareIdentity;
        private final Intent mIntent = new Intent("android.intent.action.VIEW");
        private final CustomTabColorSchemeParams.Builder mDefaultColorSchemeBuilder = new CustomTabColorSchemeParams.Builder();
        private int mShareState = 0;
        private boolean mInstantAppsEnabled = true;

        private void setSessionParameters(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.mIntent.putExtras(bundle);
        }

        public Builder setShowTitle(boolean z) {
            this.mIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        public Builder setDefaultColorSchemeParams(CustomTabColorSchemeParams customTabColorSchemeParams) {
            this.mDefaultColorSchemeBundle = customTabColorSchemeParams.toBundle();
            return this;
        }

        public CustomTabsIntent build() {
            if (!this.mIntent.hasExtra("android.support.customtabs.extra.SESSION")) {
                setSessionParameters(null, null);
            }
            ArrayList<Bundle> arrayList = this.mMenuItems;
            if (arrayList != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.mActionButtons;
            if (arrayList2 != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.mInstantAppsEnabled);
            this.mIntent.putExtras(this.mDefaultColorSchemeBuilder.build().toBundle());
            Bundle bundle = this.mDefaultColorSchemeBundle;
            if (bundle != null) {
                this.mIntent.putExtras(bundle);
            }
            if (this.mColorSchemeParamBundles != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.mColorSchemeParamBundles);
                this.mIntent.putExtras(bundle2);
            }
            this.mIntent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.mShareState);
            int i = Build.VERSION.SDK_INT;
            setCurrentLocaleAsDefaultAcceptLanguage();
            if (i >= 34) {
                setShareIdentityEnabled();
            }
            ActivityOptions activityOptions = this.mActivityOptions;
            return new CustomTabsIntent(this.mIntent, activityOptions != null ? activityOptions.toBundle() : null);
        }

        private void setCurrentLocaleAsDefaultAcceptLanguage() {
            String defaultLocale = Api24Impl.getDefaultLocale();
            if (TextUtils.isEmpty(defaultLocale)) {
                return;
            }
            Bundle bundleExtra = this.mIntent.hasExtra("com.android.browser.headers") ? this.mIntent.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey(HttpHeaders.ACCEPT_LANGUAGE)) {
                return;
            }
            bundleExtra.putString(HttpHeaders.ACCEPT_LANGUAGE, defaultLocale);
            this.mIntent.putExtra("com.android.browser.headers", bundleExtra);
        }

        private void setShareIdentityEnabled() {
            if (this.mActivityOptions == null) {
                this.mActivityOptions = Api23Impl.makeBasicActivityOptions();
            }
            Api34Impl.setShareIdentityEnabled(this.mActivityOptions, this.mShareIdentity);
        }
    }

    private static class Api23Impl {
        static ActivityOptions makeBasicActivityOptions() {
            return ActivityOptions.makeBasic();
        }
    }

    private static class Api24Impl {
        static String getDefaultLocale() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    private static class Api34Impl {
        static void setShareIdentityEnabled(ActivityOptions activityOptions, boolean z) {
            activityOptions.setShareIdentityEnabled(z);
        }
    }
}
