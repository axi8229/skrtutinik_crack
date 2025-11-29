package ru.yoomoney.sdk.auth.phone.countries.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountries;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u000020\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0005Bm\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R0\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R0\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/impl/PhoneCountriesBusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "Lkotlin/coroutines/Continuation;", "", "showState", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect;", "", "showEffect", "Lkotlin/Function1;", "source", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State$Content;", "state", "action", "handleContentState", "(Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State$Content;Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;)Lru/yoomoney/sdk/march/Out;", "invoke", "(Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;)Lru/yoomoney/sdk/march/Out;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountriesBusinessLogic implements Function2<PhoneCountries.State, PhoneCountries.Action, Out<? extends PhoneCountries.State, ? extends PhoneCountries.Action>> {
    private final Function2<PhoneCountries.Effect, Continuation<? super Unit>, Object> showEffect;
    private final Function2<PhoneCountries.State, Continuation<? super PhoneCountries.Action>, Object> showState;
    private final Function1<Continuation<? super PhoneCountries.Action>, Object> source;

    public static final class a extends Lambda implements Function1<Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action>, Unit> {
        public final /* synthetic */ PhoneCountries.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PhoneCountries.Action action) {
            super(1);
            this.b = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action> builder) {
            Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action> invoke = builder;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            CoreKt.output(invoke, new ru.yoomoney.sdk.auth.phone.countries.impl.a(PhoneCountriesBusinessLogic.this, this.b, null));
            CoreKt.input(invoke, PhoneCountriesBusinessLogic.this.source);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneCountriesBusinessLogic(Function2<? super PhoneCountries.State, ? super Continuation<? super PhoneCountries.Action>, ? extends Object> showState, Function2<? super PhoneCountries.Effect, ? super Continuation<? super Unit>, ? extends Object> showEffect, Function1<? super Continuation<? super PhoneCountries.Action>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    private final Out<PhoneCountries.State, PhoneCountries.Action> handleContentState(PhoneCountries.State.Content state, PhoneCountries.Action action) {
        if (action instanceof PhoneCountries.Action.PhoneCountrySelected) {
            return Out.INSTANCE.invoke(state, new a(action));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function2
    public Out<PhoneCountries.State, PhoneCountries.Action> invoke(PhoneCountries.State state, PhoneCountries.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof PhoneCountries.State.Content) {
            return handleContentState((PhoneCountries.State.Content) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
