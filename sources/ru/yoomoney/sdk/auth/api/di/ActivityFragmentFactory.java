package ru.yoomoney.sdk.auth.api.di;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.api.di.account.AccountEntryActivityComponent;
import ru.yoomoney.sdk.auth.api.di.auth.AuthEntryActivityComponent;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u001c\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00040\b\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J*\u0010\u0017\u001a\u00020\r2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002R$\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/auth/api/di/ActivityFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "fragments", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Landroidx/fragment/app/Fragment;", "ignoreWarningFor", "", "log", "Lkotlin/Function3;", "", "", "", "(Ljava/util/Map;Ljava/util/Set;Lkotlin/jvm/functions/Function3;)V", "instantiate", "classLoader", "Ljava/lang/ClassLoader;", "className", "logClasNotFound", "e", "logFragmentNotProvided", "logProviderNotFound", "logWarning", "fragmentProvider", "fragment", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActivityFragmentFactory extends FragmentFactory {
    private final Map<Class<?>, Provider<Fragment>> fragments;
    private final Set<Class<? extends Fragment>> ignoreWarningFor;
    private final Function3<String, String, Throwable, Unit> log;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityFragmentFactory(Map<Class<?>, ? extends Provider<Fragment>> fragments, Set<? extends Class<? extends Fragment>> ignoreWarningFor, Function3<? super String, ? super String, ? super Throwable, Unit> log) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        Intrinsics.checkNotNullParameter(ignoreWarningFor, "ignoreWarningFor");
        Intrinsics.checkNotNullParameter(log, "log");
        this.fragments = fragments;
        this.ignoreWarningFor = ignoreWarningFor;
        this.log = log;
    }

    private final void logClasNotFound(String className, Throwable e) {
        Function3<String, String, Throwable, Unit> function3 = this.log;
        String name = ActivityFragmentFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        function3.invoke(name, "Class for fragment " + className + " not found in classloader", e);
    }

    private final void logFragmentNotProvided(String className) {
        Function3<String, String, Throwable, Unit> function3 = this.log;
        String name = ActivityFragmentFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        function3.invoke(name, "Provider for fragment " + className + " return null, something unexpected happens", null);
    }

    private final void logProviderNotFound(String className) {
        Function3<String, String, Throwable, Unit> function3 = this.log;
        String name = ActivityFragmentFactory.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        function3.invoke(name, StringsKt.trimIndent("\n        Provider for fragment " + className + " not found, you may forget one of those things:\n            - create module or method with: @[Provides IntoMap ClassKey(" + className + "::class)]\n            - add your module to " + Reflection.getOrCreateKotlinClass(AuthEntryActivityComponent.class).getQualifiedName() + "/" + Reflection.getOrCreateKotlinClass(AccountEntryActivityComponent.class).getQualifiedName() + "\n            - add your fragment class to " + Reflection.getOrCreateKotlinClass(ActivityFragmentFactory.class).getQualifiedName() + ".ignoreWarningFor\n        "), null);
    }

    private final void logWarning(Provider<Fragment> fragmentProvider, String className, Fragment fragment) {
        if (fragmentProvider == null) {
            logProviderNotFound(className);
        } else if (fragment == null) {
            logFragmentNotProvided(className);
        }
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Object objM2628constructorimpl;
        Object objM2628constructorimpl2;
        Fragment fragmentInstantiate;
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(Class.forName(className, true, classLoader));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2634isSuccessimpl(objM2628constructorimpl)) {
            try {
                Class cls = (Class) objM2628constructorimpl;
                if (cls == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                objM2628constructorimpl2 = Result.m2628constructorimpl(cls);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objM2628constructorimpl = ResultKt.createFailure(th2);
            }
        } else {
            objM2628constructorimpl2 = Result.m2628constructorimpl(objM2628constructorimpl);
        }
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(objM2628constructorimpl2);
        if (thM2631exceptionOrNullimpl != null) {
            logClasNotFound(className, thM2631exceptionOrNullimpl);
        }
        if (Result.m2631exceptionOrNullimpl(objM2628constructorimpl2) == null) {
            Class cls2 = (Class) objM2628constructorimpl2;
            Provider<Fragment> provider = this.fragments.get(cls2);
            fragmentInstantiate = provider != null ? provider.get() : null;
            if (!CollectionsKt.contains(this.ignoreWarningFor, cls2)) {
                logWarning(provider, className, fragmentInstantiate);
            }
            if (fragmentInstantiate == null) {
                fragmentInstantiate = super.instantiate(classLoader, className);
                Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "instantiate(...)");
            }
        } else {
            fragmentInstantiate = super.instantiate(classLoader, className);
        }
        Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "fold(...)");
        return fragmentInstantiate;
    }
}
