package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: Transformations.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Transformations {
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function1<X, Y> transform) {
        final MediatorLiveData mediatorLiveData;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (liveData.isInitialized()) {
            mediatorLiveData = new MediatorLiveData(transform.invoke(liveData.getValue()));
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, Unit>() { // from class: androidx.lifecycle.Transformations.map.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((C04721<X>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                mediatorLiveData.setValue(transform.invoke(x));
            }
        }));
        return mediatorLiveData;
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        if (liveData.isInitialized()) {
            ref$BooleanRef.element = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<X, Unit>() { // from class: androidx.lifecycle.Transformations.distinctUntilChanged.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((AnonymousClass1<X>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(X x) {
                X value = mediatorLiveData.getValue();
                if (ref$BooleanRef.element || ((value == null && x != null) || !(value == null || Intrinsics.areEqual(value, x)))) {
                    ref$BooleanRef.element = false;
                    mediatorLiveData.setValue(x);
                }
            }
        }));
        return mediatorLiveData;
    }
}
