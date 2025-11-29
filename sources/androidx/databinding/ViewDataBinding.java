package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.library.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    protected final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private WeakListener[] mLocalFieldObservers;
    private boolean mPendingRebind;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = true;
    private static final CreateWeakListener CREATE_PROPERTY_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.1
    };
    private static final CreateWeakListener CREATE_LIST_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.2
    };
    private static final CreateWeakListener CREATE_MAP_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.3
    };
    private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.4
    };
    private static final CallbackRegistry$NotifierCallback<Object, ViewDataBinding, Void> REBIND_NOTIFIER = new CallbackRegistry$NotifierCallback<Object, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
    };
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() { // from class: androidx.databinding.ViewDataBinding.6
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }
    };

    protected static class IncludedLayouts {
    }

    protected abstract void executeBindings();

    public abstract boolean hasPendingBindings();

    public abstract boolean setVariable(int i, Object obj);

    protected ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i) {
        this.mRebindRunnable = new Runnable() { // from class: androidx.databinding.ViewDataBinding.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (!ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                } else {
                    ViewDataBinding.this.executePendingBindings();
                }
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new Choreographer.FrameCallback() { // from class: androidx.databinding.ViewDataBinding.8
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    ViewDataBinding.this.mRebindRunnable.run();
                }
            };
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    protected ViewDataBinding(Object obj, View view, int i) {
        this(checkAndCastToBindingComponent(obj), view, i);
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof DataBindingComponent)) {
            throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
        }
        return (DataBindingComponent) obj;
    }

    protected void setRootTag(View view) {
        view.setTag(R$id.dataBinding, this);
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            executeBindings();
            this.mIsExecutingPendingBindings = false;
        }
    }

    static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R$id.dataBinding);
        }
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.mRoot;
    }

    protected void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                try {
                    if (this.mPendingRebind) {
                        return;
                    }
                    this.mPendingRebind = true;
                    if (USE_CHOREOGRAPHER) {
                        this.mChoreographer.postFrameCallback(this.mFrameCallback);
                    } else {
                        this.mUIThreadHandler.post(this.mRebindRunnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    protected static ViewDataBinding bind(Object obj, View view, int i) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i);
    }

    protected static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapBindings(androidx.databinding.DataBindingComponent r8, android.view.View r9, java.lang.Object[] r10, androidx.databinding.ViewDataBinding.IncludedLayouts r11, android.util.SparseIntArray r12, boolean r13) {
        /*
            androidx.databinding.ViewDataBinding r0 = getBinding(r9)
            if (r0 == 0) goto L7
            return
        L7:
            java.lang.Object r0 = r9.getTag()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L12
            java.lang.String r0 = (java.lang.String) r0
            goto L13
        L12:
            r0 = 0
        L13:
            r1 = 0
            r2 = 1
            if (r13 == 0) goto L3b
            if (r0 == 0) goto L3b
            java.lang.String r13 = "layout"
            boolean r13 = r0.startsWith(r13)
            if (r13 == 0) goto L3b
            r13 = 95
            int r13 = r0.lastIndexOf(r13)
            if (r13 <= 0) goto L52
            int r13 = r13 + r2
            boolean r3 = isNumeric(r0, r13)
            if (r3 == 0) goto L52
            int r13 = parseTagInt(r0, r13)
            r0 = r10[r13]
            if (r0 != 0) goto L53
            r10[r13] = r9
            goto L53
        L3b:
            if (r0 == 0) goto L52
            java.lang.String r13 = "binding_"
            boolean r13 = r0.startsWith(r13)
            if (r13 == 0) goto L52
            int r13 = androidx.databinding.ViewDataBinding.BINDING_NUMBER_START
            int r13 = parseTagInt(r0, r13)
            r0 = r10[r13]
            if (r0 != 0) goto L53
            r10[r13] = r9
            goto L53
        L52:
            r2 = r1
        L53:
            if (r2 != 0) goto L6a
            int r13 = r9.getId()
            if (r13 <= 0) goto L6a
            if (r12 == 0) goto L6a
            r0 = -1
            int r13 = r12.get(r13, r0)
            if (r13 < 0) goto L6a
            r0 = r10[r13]
            if (r0 != 0) goto L6a
            r10[r13] = r9
        L6a:
            boolean r13 = r9 instanceof android.view.ViewGroup
            if (r13 == 0) goto L85
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            int r13 = r9.getChildCount()
        L74:
            if (r1 >= r13) goto L85
            android.view.View r3 = r9.getChildAt(r1)
            r7 = 0
            r2 = r8
            r4 = r10
            r5 = r11
            r6 = r12
            mapBindings(r2, r3, r4, r5, r6, r7)
            int r1 = r1 + 1
            goto L74
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    private static boolean isNumeric(String str, int i) {
        int length = str.length();
        if (length == i) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static int parseTagInt(String str, int i) {
        int iCharAt = 0;
        while (i < str.length()) {
            iCharAt = (iCharAt * 10) + (str.charAt(i) - '0');
            i++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> referencePoll = sReferenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof WeakListener) {
                ((WeakListener) referencePoll).unregister();
            }
        }
    }

    protected static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, Object obj) {
        return (T) DataBindingUtil.inflate(layoutInflater, i, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    static class OnStartListener implements LifecycleObserver {
        final WeakReference<ViewDataBinding> mBinding;

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }
    }
}
