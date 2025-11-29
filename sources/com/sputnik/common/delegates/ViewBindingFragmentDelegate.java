package com.sputnik.common.delegates;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* compiled from: ViewBindingDelegate.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0005B!\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\nJ\"\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0007R\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "T", "Landroidx/viewbinding/ViewBinding;", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LifecycleObserver;", "fragment", "initializer", "Lkotlin/Function1;", "Landroid/view/View;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "_value", "Landroidx/viewbinding/ViewBinding;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Landroidx/viewbinding/ViewBinding;", "onCreate", "", "onDestroy", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewBindingFragmentDelegate<T extends ViewBinding> implements ReadOnlyProperty<Fragment, T>, LifecycleObserver {
    private T _value;
    private final Fragment fragment;
    private final Function1<View, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewBindingFragmentDelegate(Fragment fragment, Function1<? super View, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.fragment = fragment;
        this.initializer = initializer;
        fragment.getViewLifecycleOwnerLiveData().observe(fragment, new ViewBindingDelegateKt$sam$androidx_lifecycle_Observer$0(new Function1<LifecycleOwner, Unit>(this) { // from class: com.sputnik.common.delegates.ViewBindingFragmentDelegate.1
            final /* synthetic */ ViewBindingFragmentDelegate<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LifecycleOwner lifecycleOwner) {
                invoke2(lifecycleOwner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LifecycleOwner lifecycleOwner) {
                lifecycleOwner.getLifecycle().addObserver(this.this$0);
            }
        }));
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Fragment fragment, KProperty kProperty) {
        return getValue2(fragment, (KProperty<?>) kProperty);
    }

    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public T getValue2(Fragment thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        T t = this._value;
        if (t != null) {
            return t;
        }
        try {
            if (!thisRef.getViewLifecycleOwner().getLifecycle().getState().isAtLeast(Lifecycle.State.INITIALIZED)) {
                throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed");
            }
            Function1<View, T> function1 = this.initializer;
            View viewRequireView = thisRef.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
            T tInvoke = function1.invoke(viewRequireView);
            this._value = tInvoke;
            return tInvoke;
        } catch (Exception unused) {
            Function1<View, T> function12 = this.initializer;
            View viewRequireView2 = thisRef.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView2, "requireView(...)");
            T tInvoke2 = function12.invoke(viewRequireView2);
            this._value = tInvoke2;
            return tInvoke2;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        if (this._value == null) {
            Function1<View, T> function1 = this.initializer;
            View viewRequireView = this.fragment.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
            this._value = function1.invoke(viewRequireView);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this._value = null;
    }
}
