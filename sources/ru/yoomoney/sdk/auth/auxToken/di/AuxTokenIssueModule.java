package ru.yoomoney.sdk.auth.auxToken.di;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationApi;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment;
import ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractor;
import ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractorImpl;
import ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueViewModelFactory;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001a\u001a\u00020\u00192\u001c\u0010\u0018\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00170\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/di/AuxTokenIssueModule;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "provideFailureMapper", "(Landroid/content/Context;)Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "interactor", "resourceMapper", "Landroidx/fragment/app/Fragment;", "providePasswordCreateFragment", "(Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)Landroidx/fragment/app/Fragment;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "auxAuthorizationRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "accountRepository", "provideAuxTokenIssueInteractor", "(Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;Lru/yoomoney/sdk/auth/api/account/AccountRepository;)Lru/yoomoney/sdk/auth/auxToken/impl/AuxTokenIssueInteractor;", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "fragments", "Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "providesAuxTokenIssueActivityFragmentFactory", "(Ljava/util/Map;)Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;", "api", "provideAuxAuthorizationRepository", "(Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;)Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssueModule {

    public static final class a extends Lambda implements Function3<String, String, Throwable, Unit> {
        public static final a a = new a();

        public a() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(String str, String str2, Throwable th) {
            String tag = str;
            String message = str2;
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Log.w(tag, message, th);
            return Unit.INSTANCE;
        }
    }

    public final AuxAuthorizationRepository provideAuxAuthorizationRepository(AuxAuthorizationApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        return new AuxAuthorizationRepositoryImpl(api);
    }

    public final AuxTokenIssueInteractor provideAuxTokenIssueInteractor(AuxAuthorizationRepository auxAuthorizationRepository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(auxAuthorizationRepository, "auxAuthorizationRepository");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        return new AuxTokenIssueInteractorImpl(auxAuthorizationRepository, accountRepository);
    }

    public final ResourceMapper provideFailureMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ResourceMapper(context);
    }

    public final Fragment providePasswordCreateFragment(AuxTokenIssueInteractor interactor, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        return new AuxTokenIssueFragment(new AuxTokenIssueViewModelFactory(interactor), resourceMapper);
    }

    public final ActivityFragmentFactory providesAuxTokenIssueActivityFragmentFactory(Map<Class<?>, Provider<Fragment>> fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        return new ActivityFragmentFactory(fragments, SetsKt.setOf(NavHostFragment.class), a.a);
    }
}
