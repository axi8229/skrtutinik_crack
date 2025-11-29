package me.ibrahimsn.lib;

import android.content.Context;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.material.textfield.TextInputLayout;
import io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import me.ibrahimsn.lib.api.Country;
import me.ibrahimsn.lib.api.Phone;
import me.ibrahimsn.lib.internal.core.Proxy;
import me.ibrahimsn.lib.internal.ext.CoroutineExtKt;
import me.ibrahimsn.lib.internal.ext.CountryExtensionsKt;
import me.ibrahimsn.lib.internal.io.FileReader;
import me.ibrahimsn.lib.internal.model.State;

/* compiled from: PhoneNumberKit.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002.-B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lme/ibrahimsn/lib/PhoneNumberKit;", "", "Landroid/content/Context;", "context", "", "isIconEnabled", "", "", "excludedCountries", "admittedCountries", "<init>", "(Landroid/content/Context;ZLjava/util/List;Ljava/util/List;)V", "Lme/ibrahimsn/lib/api/Country;", "getCountries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "number", "defaultRegion", "Lme/ibrahimsn/lib/api/Phone;", "parsePhoneNumber", "(Ljava/lang/String;Ljava/lang/String;)Lme/ibrahimsn/lib/api/Phone;", "Landroid/content/Context;", "Z", "Ljava/util/List;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lme/ibrahimsn/lib/internal/core/Proxy;", "proxy$delegate", "Lkotlin/Lazy;", "getProxy", "()Lme/ibrahimsn/lib/internal/core/Proxy;", "proxy", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lme/ibrahimsn/lib/internal/model/State;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/lang/ref/WeakReference;", "Lcom/google/android/material/textfield/TextInputLayout;", "input", "Ljava/lang/ref/WeakReference;", "", "countriesCache", "Companion", "Builder", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneNumberKit {
    private final List<String> admittedCountries;
    private final Context context;
    private final List<Country> countriesCache;
    private final List<String> excludedCountries;
    private WeakReference<TextInputLayout> input;
    private final boolean isIconEnabled;

    /* renamed from: proxy$delegate, reason: from kotlin metadata */
    private final Lazy proxy;
    private final CoroutineScope scope;
    private final MutableStateFlow<State> state;
    private final CompletableJob supervisorJob;

    public /* synthetic */ PhoneNumberKit(Context context, boolean z, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, list, list2);
    }

    private PhoneNumberKit(Context context, boolean z, List<String> list, List<String> list2) {
        this.context = context;
        this.isIconEnabled = z;
        this.excludedCountries = list;
        this.admittedCountries = list2;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(Dispatchers.getMain()));
        this.scope = CoroutineScope;
        this.proxy = LazyKt.lazy(new Function0<Proxy>() { // from class: me.ibrahimsn.lib.PhoneNumberKit$proxy$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Proxy invoke() {
                return new Proxy(this.this$0.context);
            }
        });
        this.state = StateFlowKt.MutableStateFlow(State.Ready.INSTANCE);
        this.input = new WeakReference<>(null);
        this.countriesCache = new ArrayList();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    private final Proxy getProxy() {
        return (Proxy) this.proxy.getValue();
    }

    /* compiled from: PhoneNumberKit.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "me.ibrahimsn.lib.PhoneNumberKit$1", f = "PhoneNumberKit.kt", l = {57}, m = "invokeSuspend")
    /* renamed from: me.ibrahimsn.lib.PhoneNumberKit$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PhoneNumberKit.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List list2 = PhoneNumberKit.this.countriesCache;
                PhoneNumberKit phoneNumberKit = PhoneNumberKit.this;
                this.L$0 = list2;
                this.label = 1;
                Object countries = phoneNumberKit.getCountries(this);
                if (countries == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = countries;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.addAll((Collection) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PhoneNumberKit.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lme/ibrahimsn/lib/api/Country;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "me.ibrahimsn.lib.PhoneNumberKit$getCountries$2", f = "PhoneNumberKit.kt", l = {}, m = "invokeSuspend")
    /* renamed from: me.ibrahimsn.lib.PhoneNumberKit$getCountries$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super List<? extends Country>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneNumberKit.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends Country>> continuation) {
            return invoke2((Continuation<? super List<Country>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<Country>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PhoneNumberKit.this.countriesCache.isEmpty() ? CountryExtensionsKt.toCountryList(FileReader.INSTANCE.readAssetFile(PhoneNumberKit.this.context, "countries.json")) : PhoneNumberKit.this.countriesCache;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCountries(Continuation<? super List<Country>> continuation) {
        return CoroutineExtKt.io(new AnonymousClass2(null), continuation);
    }

    public final Phone parsePhoneNumber(String number, String defaultRegion) {
        Phonenumber$PhoneNumber phoneNumber = getProxy().parsePhoneNumber(number, defaultRegion);
        if (phoneNumber == null) {
            return null;
        }
        return new Phone(Long.valueOf(phoneNumber.getNationalNumber()), Integer.valueOf(phoneNumber.getCountryCode()), phoneNumber.getRawInput(), Integer.valueOf(phoneNumber.getNumberOfLeadingZeros()));
    }

    /* compiled from: PhoneNumberKit.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lme/ibrahimsn/lib/PhoneNumberKit$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lme/ibrahimsn/lib/PhoneNumberKit;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lme/ibrahimsn/lib/PhoneNumberKit;", "Landroid/content/Context;", "", "isIconEnabled", "Z", "", "", "excludedCountries", "Ljava/util/List;", "admittedCountries", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<String> admittedCountries;
        private final Context context;
        private List<String> excludedCountries;
        private boolean isIconEnabled;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.isIconEnabled = true;
        }

        public final PhoneNumberKit build() {
            Context context = this.context;
            boolean z = this.isIconEnabled;
            List<String> listEmptyList = this.excludedCountries;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<String> list = listEmptyList;
            List<String> listEmptyList2 = this.admittedCountries;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return new PhoneNumberKit(context, z, list, listEmptyList2, null);
        }
    }
}
