package com.sputnik.data.local.delegates;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: PrefDelegate.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0086\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/sputnik/data/local/delegates/PrefDelegate;", "T", "", "defaultValue", "customKey", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/Object;", "createKey", "Landroidx/datastore/preferences/core/Preferences$Key;", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/datastore/preferences/core/Preferences$Key;", "provideDelegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/sputnik/data/local/PrefManager;", "thisRef", "prop", "Lkotlin/reflect/KProperty;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrefDelegate<T> {
    private final String customKey;
    private final T defaultValue;

    public PrefDelegate(T t, String str) {
        this.defaultValue = t;
        this.customKey = str;
    }

    public /* synthetic */ PrefDelegate(Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : str);
    }

    public final ReadWriteProperty<PrefManager, T> provideDelegate(PrefManager thisRef, KProperty<?> prop) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(prop, "prop");
        String name = this.customKey;
        if (name == null) {
            name = prop.getName();
        }
        final Preferences.Key<T> keyCreateKey = createKey(name, this.defaultValue);
        return new ReadWriteProperty<PrefManager, T>() { // from class: com.sputnik.data.local.delegates.PrefDelegate.provideDelegate.1
            private T _storedValue;

            @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
            public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
                return getValue((PrefManager) obj, (KProperty<?>) kProperty);
            }

            @Override // kotlin.properties.ReadWriteProperty
            public /* bridge */ /* synthetic */ void setValue(PrefManager prefManager, KProperty kProperty, Object obj) {
                setValue2(prefManager, (KProperty<?>) kProperty, (KProperty) obj);
            }

            public T getValue(PrefManager thisRef2, KProperty<?> property) {
                Intrinsics.checkNotNullParameter(thisRef2, "thisRef");
                Intrinsics.checkNotNullParameter(property, "property");
                if (this._storedValue == null) {
                    final Flow<Preferences> data = thisRef2.getDataStore().getData();
                    final Preferences.Key<T> key = keyCreateKey;
                    final PrefDelegate<T> prefDelegate = this;
                    this._storedValue = (T) BuildersKt.runBlocking(Dispatchers.getIO(), new PrefDelegate$provideDelegate$1$getValue$1(new Flow<T>() { // from class: com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                        /* renamed from: com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2, reason: invalid class name */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ Preferences.Key $key$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow;
                            final /* synthetic */ PrefDelegate this$0;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2", f = "PrefDelegate.kt", l = {223}, m = "emit")
                            /* renamed from: com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2$1, reason: invalid class name */
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

                            public AnonymousClass2(FlowCollector flowCollector, Preferences.Key key, PrefDelegate prefDelegate) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$key$inlined = key;
                                this.this$0 = prefDelegate;
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
                                    boolean r0 = r6 instanceof com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                    if (r0 == 0) goto L13
                                    r0 = r6
                                    com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2$1 r0 = (com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                    int r1 = r0.label
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.label = r1
                                    goto L18
                                L13:
                                    com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2$1 r0 = new com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1$2$1
                                    r0.<init>(r6)
                                L18:
                                    java.lang.Object r6 = r0.result
                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r2 = r0.label
                                    r3 = 1
                                    if (r2 == 0) goto L31
                                    if (r2 != r3) goto L29
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    goto L4f
                                L29:
                                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                    r5.<init>(r6)
                                    throw r5
                                L31:
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                    androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                                    androidx.datastore.preferences.core.Preferences$Key r2 = r4.$key$inlined
                                    java.lang.Object r5 = r5.get(r2)
                                    if (r5 != 0) goto L46
                                    com.sputnik.data.local.delegates.PrefDelegate r5 = r4.this$0
                                    java.lang.Object r5 = com.sputnik.data.local.delegates.PrefDelegate.access$getDefaultValue$p(r5)
                                L46:
                                    r0.label = r3
                                    java.lang.Object r5 = r6.emit(r5, r0)
                                    if (r5 != r1) goto L4f
                                    return r1
                                L4f:
                                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                    return r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.local.delegates.PrefDelegate$provideDelegate$1$getValue$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector flowCollector, Continuation continuation) {
                            Object objCollect = data.collect(new AnonymousClass2(flowCollector, key, prefDelegate), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    }, null));
                }
                T t = this._storedValue;
                Intrinsics.checkNotNull(t);
                return t;
            }

            /* renamed from: setValue, reason: avoid collision after fix types in other method */
            public void setValue2(PrefManager thisRef2, KProperty<?> property, T value) {
                Intrinsics.checkNotNullParameter(thisRef2, "thisRef");
                Intrinsics.checkNotNullParameter(property, "property");
                this._storedValue = value;
                BuildersKt__Builders_commonKt.launch$default(thisRef2.getScope(), null, null, new PrefDelegate$provideDelegate$1$setValue$1(thisRef2, keyCreateKey, value, null), 3, null);
            }
        };
    }

    public final Preferences.Key<T> createKey(String name, T value) {
        Preferences.Key<T> key;
        Intrinsics.checkNotNullParameter(name, "name");
        if (value instanceof Integer) {
            key = (Preferences.Key<T>) PreferencesKeys.intKey(name);
        } else if (value instanceof Long) {
            key = (Preferences.Key<T>) PreferencesKeys.longKey(name);
        } else if (value instanceof Double) {
            key = (Preferences.Key<T>) PreferencesKeys.doubleKey(name);
        } else if (value instanceof Float) {
            key = (Preferences.Key<T>) PreferencesKeys.floatKey(name);
        } else if (value instanceof String) {
            key = (Preferences.Key<T>) PreferencesKeys.stringKey(name);
        } else {
            if (!(value instanceof Boolean)) {
                throw new IllegalStateException("This type can not be stored into Preferences");
            }
            key = (Preferences.Key<T>) PreferencesKeys.booleanKey(name);
        }
        Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences.Key<T of com.sputnik.data.local.delegates.PrefDelegate.createKey$lambda$0>");
        return key;
    }
}
