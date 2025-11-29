package ru.yoomoney.sdk.auth.phone.select.impl;

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
import ru.yoomoney.sdk.auth.phone.select.PhoneSelect;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005B\u007f\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\"\u0010#R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'¨\u0006("}, d2 = {"Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectInteractor;", "interactor", "Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectAnalyticsLogger;", "analyticsLogger", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectInteractor;Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectAnalyticsLogger;)V", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Initial;", "state", "action", "handleInitialState", "(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Initial;Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Content;", "handleContentState", "(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Content;Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Progress;", "handleProgressState", "(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Progress;Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Suggestions;", "handleSuggestionsState", "(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State$Suggestions;Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$State;Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectInteractor;", "Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectAnalyticsLogger;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneSelectBusinessLogic implements Function2<PhoneSelect.State, PhoneSelect.Action, Out<? extends PhoneSelect.State, ? extends PhoneSelect.Action>> {
    private final PhoneSelectAnalyticsLogger analyticsLogger;
    private final PhoneSelectInteractor interactor;
    private final Function2<PhoneSelect.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PhoneSelect.State, Continuation<? super PhoneSelect.Action>, Object> showState;
    private final Function1<Continuation<? super PhoneSelect.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Suggestions, PhoneSelect.Action>, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Suggestions, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Suggestions, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.a(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public final /* synthetic */ PhoneSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PhoneSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.b(PhoneSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PhoneSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Progress, PhoneSelect.Action>, Unit> {
        public final /* synthetic */ PhoneSelect.Action b;
        public final /* synthetic */ PhoneSelect.State.Content c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PhoneSelect.Action action, PhoneSelect.State.Content content) {
            super(1);
            this.b = action;
            this.c = content;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Progress, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Progress, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.c(PhoneSelectBusinessLogic.this, invoke, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.d(PhoneSelectBusinessLogic.this, this.b, this.c, null));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.e(PhoneSelectBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.f(PhoneSelectBusinessLogic.this, null));
            CoreKt.input(invoke, PhoneSelectBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.g(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public final /* synthetic */ PhoneSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PhoneSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.h(PhoneSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.i(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public final /* synthetic */ PhoneSelect.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PhoneSelect.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.select.impl.j(PhoneSelectBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, new k(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new l(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action>, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> builder) {
            Out.Builder<? extends PhoneSelect.State.Content, PhoneSelect.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.input(invoke, new m(PhoneSelectBusinessLogic.this, invoke, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneSelectBusinessLogic(Function2<? super PhoneSelect.State, ? super Continuation<? super PhoneSelect.Action>, ? extends Object> showState, Function2<? super PhoneSelect.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PhoneSelect.Action>, ? extends Object> source, PhoneSelectInteractor interactor, PhoneSelectAnalyticsLogger phoneSelectAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
        this.interactor = interactor;
        this.analyticsLogger = phoneSelectAnalyticsLogger;
    }

    private final Out<PhoneSelect.State, PhoneSelect.Action> handleContentState(PhoneSelect.State.Content state, PhoneSelect.Action action) {
        Out.Companion companion;
        Function eVar;
        if (action instanceof PhoneSelect.Action.OpenSuggestions) {
            return Out.INSTANCE.invoke(new PhoneSelect.State.Suggestions(state.getSuggestions(), state.getSelected()), new a());
        }
        if (action instanceof PhoneSelect.Action.CheckExpiration) {
            return Out.INSTANCE.invoke(state, new b(action));
        }
        if (action instanceof PhoneSelect.Action.Submit) {
            return Out.INSTANCE.invoke(new PhoneSelect.State.Progress(state.getSuggestions(), state.getSelected()), new c(action, state));
        }
        if (action instanceof PhoneSelect.Action.RestartProcess) {
            companion = Out.INSTANCE;
            eVar = new d();
        } else {
            if (!(action instanceof PhoneSelect.Action.Expired)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            eVar = new e();
        }
        return companion.invoke(state, eVar);
    }

    private final Out<PhoneSelect.State, PhoneSelect.Action> handleInitialState(PhoneSelect.State.Initial state, PhoneSelect.Action action) {
        if (!(action instanceof PhoneSelect.Action.InitData)) {
            return Out.INSTANCE.skip(state, this.source);
        }
        PhoneSelect.Action.InitData initData = (PhoneSelect.Action.InitData) action;
        return Out.INSTANCE.invoke(new PhoneSelect.State.Content(initData.getSuggestions(), (Suggestion) CollectionsKt.first((List) initData.getSuggestions()), null, 4, null), new f());
    }

    private final Out<PhoneSelect.State, PhoneSelect.Action> handleProgressState(PhoneSelect.State.Progress state, PhoneSelect.Action action) {
        Out.Companion companion;
        PhoneSelect.State.Content content;
        Function hVar;
        if (action instanceof PhoneSelect.Action.SetPhoneSuccess) {
            companion = Out.INSTANCE;
            content = new PhoneSelect.State.Content(state.getSuggestions(), state.getSelected(), null, 4, null);
            hVar = new g(action);
        } else {
            if (!(action instanceof PhoneSelect.Action.ShowFailure)) {
                return Out.INSTANCE.skip(state, this.source);
            }
            companion = Out.INSTANCE;
            content = new PhoneSelect.State.Content(state.getSuggestions(), state.getSelected(), null, 4, null);
            hVar = new h(action);
        }
        return companion.invoke(content, hVar);
    }

    private final Out<PhoneSelect.State, PhoneSelect.Action> handleSuggestionsState(PhoneSelect.State.Suggestions state, PhoneSelect.Action action) {
        return action instanceof PhoneSelect.Action.SelectPhone ? Out.INSTANCE.invoke(new PhoneSelect.State.Content(state.getSuggestions(), ((PhoneSelect.Action.SelectPhone) action).getSuggestion(), null, 4, null), new i()) : action instanceof PhoneSelect.Action.DialogClosed ? Out.INSTANCE.invoke(new PhoneSelect.State.Content(state.getSuggestions(), state.getSelected(), null, 4, null), new j()) : Out.INSTANCE.skip(state, this.source);
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PhoneSelect.State, PhoneSelect.Action> invoke(PhoneSelect.State state, PhoneSelect.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        PhoneSelectAnalyticsLogger phoneSelectAnalyticsLogger = this.analyticsLogger;
        if (phoneSelectAnalyticsLogger != null) {
            phoneSelectAnalyticsLogger.invoke(state, action);
        }
        if (state instanceof PhoneSelect.State.Initial) {
            return handleInitialState((PhoneSelect.State.Initial) state, action);
        }
        if (state instanceof PhoneSelect.State.Content) {
            return handleContentState((PhoneSelect.State.Content) state, action);
        }
        if (state instanceof PhoneSelect.State.Progress) {
            return handleProgressState((PhoneSelect.State.Progress) state, action);
        }
        if (state instanceof PhoneSelect.State.Suggestions) {
            return handleSuggestionsState((PhoneSelect.State.Suggestions) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
