package ru.yoomoney.sdk.auth.email.select.impl;

import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\"\u0010#R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;", "interactor", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$AnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;Lru/yoomoney/sdk/auth/email/select/EmailSelect$AnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Initial;", "state", "action", "handleInitial", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Initial;Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$SelectionDialog;", "handleSelectionDialog", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$SelectionDialog;Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Progress;", "handleProgress", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Progress;Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;", "handleContent", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$AnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailSelectBusinessLogic implements Function2<EmailSelect.State, EmailSelect.Action, Out<? extends EmailSelect.State, ? extends EmailSelect.Action>> {
    private final EmailSelect.AnalyticsLogger analyticsLogger;
    private final EmailSelectInteractor interactor;
    private final Function2<EmailSelect.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<EmailSelect.State, Continuation<? super EmailSelect.Action>, Object> showState;
    private final Function1<Continuation<? super EmailSelect.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.SelectionDialog, EmailSelect.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.SelectionDialog, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.SelectionDialog, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.a(EmailSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.select.impl.b(EmailSelectBusinessLogic.this, null));
            CoreKt.input(invoke, EmailSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public final /* synthetic */ EmailSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmailSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.c(EmailSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.select.impl.d(EmailSelectBusinessLogic.this, null));
            CoreKt.input(invoke, EmailSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Progress, EmailSelect.Action>, Unit> {
        public final /* synthetic */ EmailSelect.Action b;
        public final /* synthetic */ EmailSelect.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(EmailSelect.Action action, EmailSelect.State.Content content) {
            super(1);
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Progress, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Progress, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.e(EmailSelectBusinessLogic.this, this.b, this.c, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.f(EmailSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.g(EmailSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public final /* synthetic */ EmailSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(EmailSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.select.impl.h(EmailSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public final /* synthetic */ EmailSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(EmailSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.email.select.impl.i(EmailSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, EmailSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.email.select.impl.j(EmailSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action>, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> builder) {
            Out.Builder<? extends EmailSelect.State.Content, EmailSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new k(EmailSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmailSelectBusinessLogic(Function2<? super EmailSelect.State, ? super Continuation<? super EmailSelect.Action>, ? extends Object> showState, Function2<? super EmailSelect.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super EmailSelect.Action>, ? extends Object> source, EmailSelectInteractor interactor, EmailSelect.AnalyticsLogger analyticsLogger) {
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

    private final Out<EmailSelect.State, EmailSelect.Action> handleContent(EmailSelect.State.Content state, EmailSelect.Action action) {
        Out.Companion companion;
        Function dVar;
        if (action instanceof EmailSelect.Action.OpenEmailSelectorDialog) {
            return Out.INSTANCE.invoke(new EmailSelect.State.SelectionDialog(state.getSuggestions(), state.getSelectedSuggestion(), state.getError()), new a());
        }
        if (action instanceof EmailSelect.Action.RestartProcess) {
            companion = Out.INSTANCE;
            dVar = new b();
        } else {
            if (action instanceof EmailSelect.Action.CheckExpiration) {
                return Out.INSTANCE.invoke(state, new c(action));
            }
            if (!(action instanceof EmailSelect.Action.Expired)) {
                return action instanceof EmailSelect.Action.SendEmail ? Out.INSTANCE.invoke(new EmailSelect.State.Progress(state), new e(action, state)) : Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            dVar = new d();
        }
        return companion.invoke(state, dVar);
    }

    private final Out<EmailSelect.State, EmailSelect.Action> handleInitial(EmailSelect.State.Initial state, EmailSelect.Action action) {
        if (!(action instanceof EmailSelect.Action.InitData)) {
            return Out.INSTANCE.skip(state, this.source);
        }
        EmailSelect.Action.InitData initData = (EmailSelect.Action.InitData) action;
        return Out.INSTANCE.invoke(new EmailSelect.State.Content(initData.getSuggestions(), (Suggestion) CollectionsKt.first((List) initData.getSuggestions()), null, 4, null), new f());
    }

    private final Out<EmailSelect.State, EmailSelect.Action> handleProgress(EmailSelect.State.Progress state, EmailSelect.Action action) {
        Out.Companion companion;
        EmailSelect.State.Content content;
        Function hVar;
        if (action instanceof EmailSelect.Action.SendEmailSuccess) {
            companion = Out.INSTANCE;
            content = state.getContent();
            hVar = new g(action);
        } else {
            if (!(action instanceof EmailSelect.Action.SendEmailFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = state.getContent();
            hVar = new h(action);
        }
        return companion.invoke(content, hVar);
    }

    private final Out<EmailSelect.State, EmailSelect.Action> handleSelectionDialog(EmailSelect.State.SelectionDialog state, EmailSelect.Action action) {
        return action instanceof EmailSelect.Action.SelectEmail ? Out.INSTANCE.invoke(new EmailSelect.State.Content(state.getSuggestions(), ((EmailSelect.Action.SelectEmail) action).getEmail(), null, 4, null), new i()) : action instanceof EmailSelect.Action.CloseSelectorDialog ? Out.INSTANCE.invoke(new EmailSelect.State.Content(state.getSuggestions(), state.getSelectedSuggestion(), state.getError()), new j()) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<EmailSelect.State, EmailSelect.Action> invoke(EmailSelect.State state, EmailSelect.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        EmailSelect.AnalyticsLogger analyticsLogger = this.analyticsLogger;
        if (analyticsLogger != null) {
            analyticsLogger.invoke(state, action);
        }
        if (state instanceof EmailSelect.State.Initial) {
            return handleInitial((EmailSelect.State.Initial) state, action);
        }
        if (state instanceof EmailSelect.State.Content) {
            return handleContent((EmailSelect.State.Content) state, action);
        }
        if (state instanceof EmailSelect.State.SelectionDialog) {
            return handleSelectionDialog((EmailSelect.State.SelectionDialog) state, action);
        }
        if (state instanceof EmailSelect.State.Progress) {
            return handleProgress((EmailSelect.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
