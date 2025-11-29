package sputnik.axmor.com.sputnik.ui.splash;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sputnik.axmor.com.R;

/* compiled from: CustomSplashFragmentDirections.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/CustomSplashFragmentDirections;", "", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomSplashFragmentDirections {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CustomSplashFragmentDirections.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/splash/CustomSplashFragmentDirections$Companion;", "", "<init>", "()V", "Landroidx/navigation/NavDirections;", "actionSplashToAuth", "()Landroidx/navigation/NavDirections;", "actionSplashFragmentToMainHostFragment", "actionSplashFragmentToFirstSignNavigation", "actionSplashFragmentToOnBoarding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections actionSplashToAuth() {
            return new ActionOnlyNavDirections(R.id.action_splash_to_auth);
        }

        public final NavDirections actionSplashFragmentToMainHostFragment() {
            return new ActionOnlyNavDirections(R.id.action_splashFragment_to_mainHostFragment);
        }

        public final NavDirections actionSplashFragmentToFirstSignNavigation() {
            return new ActionOnlyNavDirections(R.id.action_splashFragment_to_first_sign_navigation);
        }

        public final NavDirections actionSplashFragmentToOnBoarding() {
            return new ActionOnlyNavDirections(R.id.action_splashFragment_to_onBoarding);
        }
    }
}
