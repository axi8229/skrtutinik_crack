package com.sputnik.data.local.delegates;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.local.delegates.adapters.JsonAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PrefObjDelegate.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0096\u0002¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/sputnik/data/local/delegates/PrefObjDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Lcom/sputnik/data/local/PrefManager;", "adapter", "Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;", "customKey", "", "(Lcom/sputnik/data/local/delegates/adapters/JsonAdapter;Ljava/lang/String;)V", "_storedValue", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lcom/sputnik/data/local/PrefManager;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Lcom/sputnik/data/local/PrefManager;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrefObjDelegate<T> implements ReadWriteProperty<PrefManager, T> {
    private T _storedValue;
    private final JsonAdapter<T> adapter;
    private final String customKey;

    public PrefObjDelegate(JsonAdapter<T> adapter, String str) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        this.customKey = str;
    }

    public /* synthetic */ PrefObjDelegate(JsonAdapter jsonAdapter, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonAdapter, (i & 2) != 0 ? null : str);
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((PrefManager) obj, (KProperty<?>) kProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.properties.ReadWriteProperty
    public /* bridge */ /* synthetic */ void setValue(PrefManager prefManager, KProperty kProperty, Object obj) {
        setValue2(prefManager, (KProperty<?>) kProperty, (KProperty) obj);
    }

    public T getValue(PrefManager thisRef, final KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        if (this._storedValue == null) {
            final Flow<Preferences> data = thisRef.getDataStore().getData();
            Flow<String> flow = new Flow<String>() { // from class: com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                /* renamed from: com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ KProperty $property$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ PrefObjDelegate this$0;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2", f = "PrefObjDelegate.kt", l = {223}, m = "emit")
                    /* renamed from: com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, PrefObjDelegate prefObjDelegate, KProperty kProperty) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = prefObjDelegate;
                        this.$property$inlined = kProperty;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2$1 r0 = (com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2$1 r0 = new com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L57
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                            androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                            com.sputnik.data.local.delegates.PrefObjDelegate r2 = r4.this$0
                            java.lang.String r2 = com.sputnik.data.local.delegates.PrefObjDelegate.access$getCustomKey$p(r2)
                            if (r2 != 0) goto L46
                            kotlin.reflect.KProperty r2 = r4.$property$inlined
                            java.lang.String r2 = r2.getName()
                        L46:
                            androidx.datastore.preferences.core.Preferences$Key r2 = androidx.datastore.preferences.core.PreferencesKeys.stringKey(r2)
                            java.lang.Object r5 = r5.get(r2)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L57
                            return r1
                        L57:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.local.delegates.PrefObjDelegate$getValue$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                    Object objCollect = data.collect(new AnonymousClass2(flowCollector, this, property), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            JsonAdapter<T> jsonAdapter = this.adapter;
            String str = (String) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(flow, null));
            if (str == null) {
                str = "";
            }
            this._storedValue = jsonAdapter.fromJson(str);
        }
        return this._storedValue;
    }

    /* compiled from: PrefObjDelegate.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.local.delegates.PrefObjDelegate$getValue$1", f = "PrefObjDelegate.kt", l = {30}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.local.delegates.PrefObjDelegate$getValue$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Flow<String> $flowValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow<String> flow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flowValue = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flowValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<String> flow = this.$flowValue;
                this.label = 1;
                obj = FlowKt.first(flow, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* renamed from: setValue, reason: avoid collision after fix types in other method */
    public void setValue2(PrefManager thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        this._storedValue = value;
        BuildersKt__Builders_commonKt.launch$default(thisRef.getScope(), null, null, new C06781(thisRef, this, property, value, null), 3, null);
    }

    /* compiled from: PrefObjDelegate.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.local.delegates.PrefObjDelegate$setValue$1", f = "PrefObjDelegate.kt", l = {39}, m = "invokeSuspend")
    /* renamed from: com.sputnik.data.local.delegates.PrefObjDelegate$setValue$1, reason: invalid class name and case insensitive filesystem */
    static final class C06781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KProperty<?> $property;
        final /* synthetic */ PrefManager $thisRef;
        final /* synthetic */ T $value;
        int label;
        final /* synthetic */ PrefObjDelegate<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06781(PrefManager prefManager, PrefObjDelegate<T> prefObjDelegate, KProperty<?> kProperty, T t, Continuation<? super C06781> continuation) {
            super(2, continuation);
            this.$thisRef = prefManager;
            this.this$0 = prefObjDelegate;
            this.$property = kProperty;
            this.$value = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06781(this.$thisRef, this.this$0, this.$property, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: PrefObjDelegate.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "prefs", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.data.local.delegates.PrefObjDelegate$setValue$1$1", f = "PrefObjDelegate.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sputnik.data.local.delegates.PrefObjDelegate$setValue$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01141 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ KProperty<?> $property;
            final /* synthetic */ T $value;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PrefObjDelegate<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01141(PrefObjDelegate<T> prefObjDelegate, KProperty<?> kProperty, T t, Continuation<? super C01141> continuation) {
                super(2, continuation);
                this.this$0 = prefObjDelegate;
                this.$property = kProperty;
                this.$value = t;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01141 c01141 = new C01141(this.this$0, this.$property, this.$value, continuation);
                c01141.L$0 = obj;
                return c01141;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return ((C01141) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                    String name = ((PrefObjDelegate) this.this$0).customKey;
                    if (name == null) {
                        name = this.$property.getName();
                    }
                    mutablePreferences.set(PreferencesKeys.stringKey(name), ((PrefObjDelegate) this.this$0).adapter.toJson(this.$value));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DataStore<Preferences> dataStore = this.$thisRef.getDataStore();
                C01141 c01141 = new C01141(this.this$0, this.$property, this.$value, null);
                this.label = 1;
                if (PreferencesKt.edit(dataStore, c01141, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
