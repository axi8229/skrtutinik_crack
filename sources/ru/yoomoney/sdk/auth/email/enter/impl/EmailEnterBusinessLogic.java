package ru.yoomoney.sdk.auth.email.enter.impl;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010!¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/EmailEnterBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractor;", "interactor", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractor;Lru/yoomoney/sdk/auth/email/enter/EmailEnter$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Content;Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Loading;", "handleLoadingState", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State$Loading;Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractor;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailEnterBusinessLogic implements Function2<EmailEnter.State, EmailEnter.Action, Out<? extends EmailEnter.State, ? extends EmailEnter.Action>> {
    private final EmailEnter.AnalyticsLogger analyticsLogger;
    private final BaseEmailEnterInteractor interactor;
    private final Function2<EmailEnter.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<EmailEnter.State, Continuation<? super EmailEnter.Action>, Object> showState;
    private final Function1<Continuation<? super EmailEnter.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.a(EmailEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.b(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.c(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, EmailEnterBusinessLogic.this.source);
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.d(EmailEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;
        public final /* synthetic */ EmailEnter.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(EmailEnter.Action action, EmailEnter.State.Content content) {
            super(1);
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.e(EmailEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.f(EmailEnterBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Loading, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.g(EmailEnterBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.h(EmailEnterBusinessLogic.this, this.b, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.i(EmailEnterBusinessLogic.this, null));
            CoreKt.input(invoke, EmailEnterBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.j(EmailEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.enter.impl.k(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new l(EmailEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new m(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new n(EmailEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new o(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action>, Unit> {
        public final /* synthetic */ EmailEnter.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(EmailEnter.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> builder) {
            Out.Builder<? extends EmailEnter.State.Content, EmailEnter.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new p(EmailEnterBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new q(EmailEnterBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmailEnterBusinessLogic(Function2<? super EmailEnter.State, ? super Continuation<? super EmailEnter.Action>, ? extends Object> showState, Function2<? super EmailEnter.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super EmailEnter.Action>, ? extends Object> source, BaseEmailEnterInteractor interactor, EmailEnter.AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.analyticsLogger = analyticsLogger;
    }

    private final Out<EmailEnter.State, EmailEnter.Action> handleContentState(EmailEnter.State.Content state, EmailEnter.Action action) {
        Out.Companion companion;
        Function dVar;
        Out.Companion companion2;
        EmailEnter.State.Content contentCopy$default;
        Function cVar;
        if (!(action instanceof EmailEnter.Action.ChangeEmail)) {
            if (action instanceof EmailEnter.Action.EmailChanged) {
                companion2 = Out.INSTANCE;
                EmailEnter.Action.EmailChanged emailChanged = (EmailEnter.Action.EmailChanged) action;
                contentCopy$default = EmailEnter.State.Content.copy$default(state, emailChanged.getEmail(), emailChanged.isValidEmail(), false, null, 12, null);
                cVar = new b();
            } else if (action instanceof EmailEnter.Action.OffersChecked) {
                companion2 = Out.INSTANCE;
                contentCopy$default = EmailEnter.State.Content.copy$default(state, null, false, ((EmailEnter.Action.OffersChecked) action).isChecked(), null, 11, null);
                cVar = new c();
            } else {
                if (!(action instanceof EmailEnter.Action.CheckExpiration)) {
                    return action instanceof EmailEnter.Action.SendEmail ? Out.INSTANCE.invoke(new EmailEnter.State.Loading(state), new e(action, state)) : action instanceof EmailEnter.Action.ConfirmEmail ? Out.INSTANCE.invoke(new EmailEnter.State.Loading(state), new f(action)) : action instanceof EmailEnter.Action.RestartProcess ? Out.INSTANCE.invoke(state, new g()) : Out.INSTANCE.skip(state, this.source);
                }
                companion = Out.INSTANCE;
                dVar = new d(action);
            }
            return companion2.invoke(contentCopy$default, cVar);
        }
        companion = Out.INSTANCE;
        dVar = new a(action);
        return companion.invoke(state, dVar);
    }

    private final Out<EmailEnter.State, EmailEnter.Action> handleLoadingState(EmailEnter.State.Loading state, EmailEnter.Action action) {
        Out.Companion companion;
        EmailEnter.State.Content content;
        Function kVar;
        if (action instanceof EmailEnter.Action.SendEmailSuccess) {
            companion = Out.INSTANCE;
            content = state.getContent();
            kVar = new h(action);
        } else if (action instanceof EmailEnter.Action.SendEmailRegistrationSuccess) {
            companion = Out.INSTANCE;
            content = state.getContent();
            kVar = new i(action);
        } else if (action instanceof EmailEnter.Action.ConfirmEmailSuccess) {
            companion = Out.INSTANCE;
            content = state.getContent();
            kVar = new j(action);
        } else {
            if (!(action instanceof EmailEnter.Action.ShowFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = state.getContent();
            kVar = new k(action);
        }
        return companion.invoke(content, kVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<EmailEnter.State, EmailEnter.Action> invoke(EmailEnter.State state, EmailEnter.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        EmailEnter.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof EmailEnter.State.Content) {
            return handleContentState((EmailEnter.State.Content) state, action);
        }
        if (state instanceof EmailEnter.State.Loading) {
            return handleLoadingState((EmailEnter.State.Loading) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
