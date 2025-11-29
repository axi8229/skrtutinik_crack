package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B}\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;", "interactor", "Lru/yoomoney/sdk/auth/Config;", "config", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;Lru/yoomoney/sdk/auth/Config;)V", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$Content;Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$ProgressRegistration;", "handleProgressRegistrationState", "(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$ProgressRegistration;Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$ProgressLogin;", "handleProgressLoginState", "(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State$ProgressLogin;Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State;Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;", "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthNotFoundBusinessLogic implements Function2<OauthNotFound.State, OauthNotFound.Action, Out<? extends OauthNotFound.State, ? extends OauthNotFound.Action>> {
    private final Config config;
    private final OauthNotFoundInteractor interactor;
    private final Function2<OauthNotFound.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<OauthNotFound.State, Continuation<? super OauthNotFound.Action>, Object> showState;
    private final Function1<Continuation<? super OauthNotFound.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.ProgressRegistration, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.ProgressRegistration, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.ProgressRegistration, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.a(OauthNotFoundBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.b(OauthNotFoundBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.ProgressLogin, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.ProgressLogin, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.ProgressLogin, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.c(OauthNotFoundBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.d(OauthNotFoundBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.e(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.f(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.g(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.oauth.notFound.impl.h(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new i(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new j(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new k(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new l(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new m(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new n(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action>, Unit> {
        public final /* synthetic */ OauthNotFound.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(OauthNotFound.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> builder) {
            Out.Builder<? extends OauthNotFound.State.Content, OauthNotFound.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new o(OauthNotFoundBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new p(OauthNotFoundBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OauthNotFoundBusinessLogic(Function2<? super OauthNotFound.State, ? super Continuation<? super OauthNotFound.Action>, ? extends Object> showState, Function2<? super OauthNotFound.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super OauthNotFound.Action>, ? extends Object> source, OauthNotFoundInteractor interactor, Config config) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        Intrinsics.checkNotNullParameter(config, "config");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.config = config;
    }

    private final Out<OauthNotFound.State, OauthNotFound.Action> handleContentState(OauthNotFound.State.Content state, OauthNotFound.Action action) {
        Out.Companion companion;
        Object obj;
        Function bVar;
        if (action instanceof OauthNotFound.Action.StartRegistration) {
            companion = Out.INSTANCE;
            obj = OauthNotFound.State.ProgressRegistration.INSTANCE;
            bVar = new a(action);
        } else {
            if (!(action instanceof OauthNotFound.Action.StartLogin)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            obj = OauthNotFound.State.ProgressLogin.INSTANCE;
            bVar = new b(action);
        }
        return companion.invoke(obj, bVar);
    }

    private final Out<OauthNotFound.State, OauthNotFound.Action> handleProgressLoginState(OauthNotFound.State.ProgressLogin state, OauthNotFound.Action action) {
        Out.Companion companion;
        OauthNotFound.State.Content content;
        Function dVar;
        if (action instanceof OauthNotFound.Action.LoginSuccess) {
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            dVar = new c(action);
        } else {
            if (!(action instanceof OauthNotFound.Action.LoginFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            dVar = new d(action);
        }
        return companion.invoke(content, dVar);
    }

    private final Out<OauthNotFound.State, OauthNotFound.Action> handleProgressRegistrationState(OauthNotFound.State.ProgressRegistration state, OauthNotFound.Action action) {
        Out.Companion companion;
        OauthNotFound.State.Content content;
        Function hVar;
        if (action instanceof OauthNotFound.Action.RegistrationSuccess) {
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            hVar = new e(action);
        } else if (action instanceof OauthNotFound.Action.RegistrationFailure) {
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            hVar = new f(action);
        } else if (action instanceof OauthNotFound.Action.EnrollmentSuccess) {
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            hVar = new g(action);
        } else {
            if (!(action instanceof OauthNotFound.Action.EnrollmentFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = OauthNotFound.State.Content.INSTANCE;
            hVar = new h(action);
        }
        return companion.invoke(content, hVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<OauthNotFound.State, OauthNotFound.Action> invoke(OauthNotFound.State state, OauthNotFound.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof OauthNotFound.State.Content) {
            return handleContentState((OauthNotFound.State.Content) state, action);
        }
        if (state instanceof OauthNotFound.State.ProgressRegistration) {
            return handleProgressRegistrationState((OauthNotFound.State.ProgressRegistration) state, action);
        }
        if (state instanceof OauthNotFound.State.ProgressLogin) {
            return handleProgressLoginState((OauthNotFound.State.ProgressLogin) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
