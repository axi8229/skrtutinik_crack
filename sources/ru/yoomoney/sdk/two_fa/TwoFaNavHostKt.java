package ru.yoomoney.sdk.two_fa;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpControllerKt;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmControllerKt;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointControllerKt;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallControllerKt;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmAnalyticsLogger;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;
import ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmControllerKt;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: TwoFaNavHost.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ac\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0001¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"DEFAULT_SLIDE_ANIMATION_DURATION", "", "TwoFaNavHost", "", "entryPointInteractor", "Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;", "smsConfirmInteractor", "Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;", "phoneCallInteractor", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "emailConfirmInteractor", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "config", "Lru/yoomoney/sdk/two_fa/Config;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "onConfirmSuccess", "Lkotlin/Function0;", "onConfirmClosed", "(Lru/yoomoney/sdk/two_fa/entryPoint/impl/EntryPointInteractor;Lru/yoomoney/sdk/two_fa/smsConfirm/impl/SmsConfirmInteractor;Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;Lru/yoomoney/sdk/two_fa/Config;Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoFaNavHostKt {
    private static final int DEFAULT_SLIDE_ANIMATION_DURATION = 250;

    /* compiled from: TwoFaNavHost.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionType.values().length];
            try {
                iArr[SessionType.SMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionType.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionType.PHONE_CALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void TwoFaNavHost(final EntryPointInteractor entryPointInteractor, final SmsConfirmInteractor smsConfirmInteractor, final PhoneCallInteractor phoneCallInteractor, final EmailConfirmInteractor emailConfirmInteractor, final Config config, final ResourceMapper resourceMapper, final AnalyticsLogger analyticsLogger, final Function0<Unit> onConfirmSuccess, final Function0<Unit> onConfirmClosed, Composer composer, final int i) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(entryPointInteractor, "entryPointInteractor");
        Intrinsics.checkNotNullParameter(smsConfirmInteractor, "smsConfirmInteractor");
        Intrinsics.checkNotNullParameter(phoneCallInteractor, "phoneCallInteractor");
        Intrinsics.checkNotNullParameter(emailConfirmInteractor, "emailConfirmInteractor");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(onConfirmSuccess, "onConfirmSuccess");
        Intrinsics.checkNotNullParameter(onConfirmClosed, "onConfirmClosed");
        Composer composerStartRestartGroup = composer.startRestartGroup(133270160);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(133270160, i, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost (TwoFaNavHost.kt:48)");
        }
        final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 8);
        composerStartRestartGroup.startReplaceableGroup(211471453);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ArrayList();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final List list = (List) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        NavHostKt.NavHost(navHostControllerRememberNavController, "EntryPoint", null, null, null, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> NavHost) {
                Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                return EnterTransition.INSTANCE.getNone();
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> NavHost) {
                Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                return EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(TwoFaNavHostKt.DEFAULT_SLIDE_ANIMATION_DURATION, 0, null, 6, null), new Function1<Integer, Integer>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int i2) {
                        return Integer.valueOf(-i2);
                    }
                });
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> NavHost) {
                Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                return EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(TwoFaNavHostKt.DEFAULT_SLIDE_ANIMATION_DURATION, 0, null, 6, null), new Function1<Integer, Integer>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int i2) {
                        return Integer.valueOf(-i2);
                    }
                });
            }
        }, null, new Function1<NavGraphBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavGraphBuilder navGraphBuilder) {
                invoke2(navGraphBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavGraphBuilder NavHost) {
                Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                final Config config2 = config;
                final EntryPointInteractor entryPointInteractor2 = entryPointInteractor;
                final ResourceMapper resourceMapper2 = resourceMapper;
                final Function0<Unit> function0 = onConfirmClosed;
                final List<SessionType> list2 = list;
                final NavHostController navHostController = navHostControllerRememberNavController;
                final Function0<Unit> function02 = onConfirmSuccess;
                NavGraphBuilderKt.composable$default(NavHost, "EntryPoint", null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1011289842, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer2, Integer num) {
                        invoke(animatedContentScope, navBackStackEntry, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1011289842, i2, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost.<anonymous>.<anonymous> (TwoFaNavHost.kt:85)");
                        }
                        Config config3 = config2;
                        EntryPointInteractor entryPointInteractor3 = entryPointInteractor2;
                        ResourceMapper resourceMapper3 = resourceMapper2;
                        final List<SessionType> list3 = list2;
                        final NavHostController navHostController2 = navHostController;
                        final Function0<Unit> function03 = function02;
                        Function1<List<? extends SessionType>, Unit> function1 = new Function1<List<? extends SessionType>, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SessionType> list4) throws Resources.NotFoundException {
                                invoke2(list4);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(List<? extends SessionType> sessionOptions) throws Resources.NotFoundException {
                                Intrinsics.checkNotNullParameter(sessionOptions, "sessionOptions");
                                List<? extends SessionType> list4 = sessionOptions;
                                if (!list4.isEmpty()) {
                                    list3.addAll(list4);
                                    String strTwoFaNavHost$navigateTo = TwoFaNavHostKt.TwoFaNavHost$navigateTo(TwoFaNavHostKt.TwoFaNavHost$getNextAvailableSession(list3));
                                    NavHostController navHostController3 = navHostController2;
                                    String str = strTwoFaNavHost$navigateTo + "/" + TwoFaNavHostKt.TwoFaNavHost$getNextAvailableSession(list3);
                                    final NavHostController navHostController4 = navHostController2;
                                    navHostController3.navigate(str, new Function1<NavOptionsBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                            invoke2(navOptionsBuilder);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(NavOptionsBuilder navigate) {
                                            Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                            navigate.popUpTo(navHostController4.getGraph().getId(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.1.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                                    invoke2(popUpToBuilder);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(PopUpToBuilder popUpTo) {
                                                    Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                                    popUpTo.setInclusive(true);
                                                }
                                            });
                                        }
                                    });
                                    return;
                                }
                                function03.invoke();
                            }
                        };
                        composer2.startReplaceableGroup(-875493313);
                        boolean zChangedInstance = composer2.changedInstance(function0);
                        final Function0<Unit> function04 = function0;
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function04.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        EntryPointControllerKt.EntryPointController(config3, entryPointInteractor3, resourceMapper3, function1, (Function0) objRememberedValue2, composer2, 520);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 126, null);
                List listListOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument(Routes.sessionTypeArg, new Function1<NavArgumentBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                        invoke2(navArgumentBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavArgumentBuilder navArgument) {
                        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                        navArgument.setType(new NavType.EnumType(SessionType.class));
                    }
                }));
                final Config config3 = config;
                final SmsConfirmInteractor smsConfirmInteractor2 = smsConfirmInteractor;
                final ResourceMapper resourceMapper3 = resourceMapper;
                final AnalyticsLogger analyticsLogger2 = analyticsLogger;
                final Function0<Unit> function03 = onConfirmClosed;
                final Function0<Unit> function04 = onConfirmSuccess;
                final NavHostController navHostController2 = navHostControllerRememberNavController;
                NavGraphBuilderKt.composable$default(NavHost, "SmsConfirm/{sessionType}", listListOf, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1597137001, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer2, Integer num) {
                        invoke(animatedContentScope, navBackStackEntry, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1597137001, i2, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost.<anonymous>.<anonymous> (TwoFaNavHost.kt:108)");
                        }
                        Config config4 = config3;
                        SmsConfirmInteractor smsConfirmInteractor3 = smsConfirmInteractor2;
                        ResourceMapper resourceMapper4 = resourceMapper3;
                        AnalyticsLogger analyticsLogger3 = analyticsLogger2;
                        SmsConfirmAnalyticsLogger smsConfirmAnalyticsLogger = analyticsLogger3 != null ? new SmsConfirmAnalyticsLogger(analyticsLogger3) : null;
                        composer2.startReplaceableGroup(-875492195);
                        boolean zChangedInstance = composer2.changedInstance(function03);
                        final Function0<Unit> function05 = function03;
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function05.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function06 = (Function0) objRememberedValue2;
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-875492137);
                        boolean zChangedInstance2 = composer2.changedInstance(function04);
                        final Function0<Unit> function07 = function04;
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$3$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function07.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        final NavHostController navHostController3 = navHostController2;
                        SmsConfirmControllerKt.SmsConfirmController(config4, smsConfirmInteractor3, resourceMapper4, smsConfirmAnalyticsLogger, function06, (Function0) objRememberedValue3, new Function1<SessionType, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SessionType sessionType) throws Resources.NotFoundException {
                                invoke2(sessionType);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SessionType sessionType) throws Resources.NotFoundException {
                                Intrinsics.checkNotNullParameter(sessionType, "sessionType");
                                NavController.navigate$default(navHostController3, "ConfirmationHelp/" + sessionType, null, null, 6, null);
                            }
                        }, composer2, 520);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 124, null);
                List listListOf2 = CollectionsKt.listOf(NamedNavArgumentKt.navArgument(Routes.sessionTypeArg, new Function1<NavArgumentBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                        invoke2(navArgumentBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavArgumentBuilder navArgument) {
                        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                        navArgument.setType(new NavType.EnumType(SessionType.class));
                    }
                }));
                final AnalyticsLogger analyticsLogger3 = analyticsLogger;
                final Config config4 = config;
                final EmailConfirmInteractor emailConfirmInteractor2 = emailConfirmInteractor;
                final ResourceMapper resourceMapper4 = resourceMapper;
                final Function0<Unit> function05 = onConfirmClosed;
                final Function0<Unit> function06 = onConfirmSuccess;
                final NavHostController navHostController3 = navHostControllerRememberNavController;
                NavGraphBuilderKt.composable$default(NavHost, "EmailConfirm/{sessionType}", listListOf2, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(2143529642, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer2, Integer num) {
                        invoke(animatedContentScope, navBackStackEntry, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2143529642, i2, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost.<anonymous>.<anonymous> (TwoFaNavHost.kt:127)");
                        }
                        AnalyticsLogger analyticsLogger4 = analyticsLogger3;
                        EmailConfirmAnalyticsLogger emailConfirmAnalyticsLogger = analyticsLogger4 != null ? new EmailConfirmAnalyticsLogger(analyticsLogger4) : null;
                        Config config5 = config4;
                        EmailConfirmInteractor emailConfirmInteractor3 = emailConfirmInteractor2;
                        ResourceMapper resourceMapper5 = resourceMapper4;
                        final NavHostController navHostController4 = navHostController3;
                        Function1<SessionType, Unit> function1 = new Function1<SessionType, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SessionType sessionType) throws Resources.NotFoundException {
                                invoke2(sessionType);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SessionType sessionType) throws Resources.NotFoundException {
                                Intrinsics.checkNotNullParameter(sessionType, "sessionType");
                                NavController.navigate$default(navHostController4, "ConfirmationHelp/" + sessionType, null, null, 6, null);
                            }
                        };
                        composer2.startReplaceableGroup(-875491409);
                        boolean zChangedInstance = composer2.changedInstance(function05);
                        final Function0<Unit> function07 = function05;
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$5$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function07.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function08 = (Function0) objRememberedValue2;
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-875491351);
                        boolean zChangedInstance2 = composer2.changedInstance(function06);
                        final Function0<Unit> function09 = function06;
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$5$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function09.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        EmailConfirmControllerKt.EmailConfirmController(config5, emailConfirmInteractor3, resourceMapper5, emailConfirmAnalyticsLogger, function1, function08, (Function0) objRememberedValue3, composer2, 520);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 124, null);
                List listListOf3 = CollectionsKt.listOf(NamedNavArgumentKt.navArgument(Routes.sessionTypeArg, new Function1<NavArgumentBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                        invoke2(navArgumentBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavArgumentBuilder navArgument) {
                        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                        navArgument.setType(new NavType.EnumType(SessionType.class));
                    }
                }));
                final Config config5 = config;
                final PhoneCallInteractor phoneCallInteractor2 = phoneCallInteractor;
                final ResourceMapper resourceMapper5 = resourceMapper;
                final AnalyticsLogger analyticsLogger4 = analyticsLogger;
                final Function0<Unit> function07 = onConfirmClosed;
                final Function0<Unit> function08 = onConfirmSuccess;
                final NavHostController navHostController4 = navHostControllerRememberNavController;
                final List<SessionType> list3 = list;
                NavGraphBuilderKt.composable$default(NavHost, "PhoneCall/{sessionType}", listListOf3, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1605045013, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer2, Integer num) {
                        invoke(animatedContentScope, navBackStackEntry, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1605045013, i2, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost.<anonymous>.<anonymous> (TwoFaNavHost.kt:147)");
                        }
                        Config config6 = config5;
                        PhoneCallInteractor phoneCallInteractor3 = phoneCallInteractor2;
                        ResourceMapper resourceMapper6 = resourceMapper5;
                        Bundle arguments = backStackEntry.getArguments();
                        SessionType sessionType = arguments != null ? (SessionType) arguments.getParcelable(Routes.sessionTypeArg) : null;
                        SessionType sessionType2 = sessionType != null ? sessionType : null;
                        AnalyticsLogger analyticsLogger5 = analyticsLogger4;
                        PhoneCallAnalyticsLogger phoneCallAnalyticsLogger = analyticsLogger5 != null ? new PhoneCallAnalyticsLogger(analyticsLogger5) : null;
                        composer2.startReplaceableGroup(-875490495);
                        boolean zChangedInstance = composer2.changedInstance(function07);
                        final Function0<Unit> function09 = function07;
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$7$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function09.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function010 = (Function0) objRememberedValue2;
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-875490437);
                        boolean zChangedInstance2 = composer2.changedInstance(function08);
                        final Function0<Unit> function011 = function08;
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$7$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function011.invoke();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        final NavHostController navHostController5 = navHostController4;
                        final List<SessionType> list4 = list3;
                        PhoneCallControllerKt.PhoneCallController(config6, phoneCallInteractor3, resourceMapper6, sessionType2, phoneCallAnalyticsLogger, function010, (Function0) objRememberedValue3, new Function1<SessionType, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.7.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SessionType sessionType3) throws Resources.NotFoundException {
                                invoke2(sessionType3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SessionType sessionType3) throws Resources.NotFoundException {
                                NavHostController navHostController6 = navHostController5;
                                String str = TwoFaNavHostKt.TwoFaNavHost$navigateTo(sessionType3) + "/" + TwoFaNavHostKt.TwoFaNavHost$getNextAvailableSession(list4);
                                final NavHostController navHostController7 = navHostController5;
                                navHostController6.navigate(str, new Function1<NavOptionsBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.7.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                        invoke2(navOptionsBuilder);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(NavOptionsBuilder navigate) {
                                        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                        navigate.popUpTo(navHostController7.getGraph().getId(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.7.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                                invoke2(popUpToBuilder);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PopUpToBuilder popUpTo) {
                                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                                popUpTo.setInclusive(true);
                                            }
                                        });
                                    }
                                });
                            }
                        }, composer2, 520);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 124, null);
                List listListOf4 = CollectionsKt.listOf(NamedNavArgumentKt.navArgument(Routes.sessionTypeArg, new Function1<NavArgumentBuilder, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.8
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                        invoke2(navArgumentBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavArgumentBuilder navArgument) {
                        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
                        navArgument.setType(new NavType.EnumType(SessionType.class));
                    }
                }));
                AnonymousClass9 anonymousClass9 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.9
                    @Override // kotlin.jvm.functions.Function1
                    public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        return EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(TwoFaNavHostKt.DEFAULT_SLIDE_ANIMATION_DURATION, 0, null, 6, null), new Function1<Integer, Integer>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.9.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            public final Integer invoke(int i2) {
                                return Integer.valueOf(i2);
                            }
                        });
                    }
                };
                AnonymousClass10 anonymousClass10 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.10
                    @Override // kotlin.jvm.functions.Function1
                    public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        return EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(TwoFaNavHostKt.DEFAULT_SLIDE_ANIMATION_DURATION, 0, null, 6, null), new Function1<Integer, Integer>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.10.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            public final Integer invoke(int i2) {
                                return Integer.valueOf(i2);
                            }
                        });
                    }
                };
                final Config config6 = config;
                final NavHostController navHostController5 = navHostControllerRememberNavController;
                NavGraphBuilderKt.composable$default(NavHost, "ConfirmationHelp/{sessionType}", listListOf4, null, anonymousClass9, null, null, anonymousClass10, ComposableLambdaKt.composableLambdaInstance(-1058652372, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.4.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer2, Integer num) {
                        invoke(animatedContentScope, navBackStackEntry, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(composable, "$this$composable");
                        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1058652372, i2, -1, "ru.yoomoney.sdk.two_fa.TwoFaNavHost.<anonymous>.<anonymous> (TwoFaNavHost.kt:180)");
                        }
                        Bundle arguments = backStackEntry.getArguments();
                        SessionType sessionType = arguments != null ? (SessionType) arguments.getParcelable(Routes.sessionTypeArg) : null;
                        SessionType sessionType2 = sessionType != null ? sessionType : null;
                        if (sessionType2 != null) {
                            Config config7 = config6;
                            final NavHostController navHostController6 = navHostController5;
                            ConfirmationHelpControllerKt.ConfirmationHelpController(sessionType2, config7.getConfirmationHelpActionVisible(), new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt$TwoFaNavHost$4$11$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    navHostController6.popBackStack();
                                }
                            }, composer2, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 52, null);
            }
        }, composerStartRestartGroup, 14352440, 284);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.TwoFaNavHostKt.TwoFaNavHost.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) throws Resources.NotFoundException {
                    TwoFaNavHostKt.TwoFaNavHost(entryPointInteractor, smsConfirmInteractor, phoneCallInteractor, emailConfirmInteractor, config, resourceMapper, analyticsLogger, onConfirmSuccess, onConfirmClosed, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionType TwoFaNavHost$getNextAvailableSession(List<SessionType> list) {
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        return SessionType.UNKNOWN_ENUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TwoFaNavHost$navigateTo(SessionType sessionType) {
        int i = sessionType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
        if (i == 1) {
            return "SmsConfirm";
        }
        if (i == 2) {
            return "EmailConfirm";
        }
        if (i == 3) {
            return "PhoneCall";
        }
        return "";
    }
}
