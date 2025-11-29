package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public abstract boolean isEmpty();

    static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op() {
        }

        Op(int i, Fragment fragment) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mFromExpandedOp = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.mOldMaxState = state;
            this.mCurrentMaxState = state;
        }

        Op(int i, Fragment fragment, boolean z) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mFromExpandedOp = z;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.mOldMaxState = state;
            this.mCurrentMaxState = state;
        }

        Op(int i, Fragment fragment, Lifecycle.State state) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mFromExpandedOp = false;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }

        Op(Op op) {
            this.mCmd = op.mCmd;
            this.mFragment = op.mFragment;
            this.mFromExpandedOp = op.mFromExpandedOp;
            this.mEnterAnim = op.mEnterAnim;
            this.mExitAnim = op.mExitAnim;
            this.mPopEnterAnim = op.mPopEnterAnim;
            this.mPopExitAnim = op.mPopExitAnim;
            this.mOldMaxState = op.mOldMaxState;
            this.mCurrentMaxState = op.mCurrentMaxState;
        }
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader, FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        Iterator<Op> it = fragmentTransaction.mOps.iterator();
        while (it.hasNext()) {
            this.mOps.add(new Op(it.next()));
        }
        this.mEnterAnim = fragmentTransaction.mEnterAnim;
        this.mExitAnim = fragmentTransaction.mExitAnim;
        this.mPopEnterAnim = fragmentTransaction.mPopEnterAnim;
        this.mPopExitAnim = fragmentTransaction.mPopExitAnim;
        this.mTransition = fragmentTransaction.mTransition;
        this.mAddToBackStack = fragmentTransaction.mAddToBackStack;
        this.mAllowAddToBackStack = fragmentTransaction.mAllowAddToBackStack;
        this.mName = fragmentTransaction.mName;
        this.mBreadCrumbShortTitleRes = fragmentTransaction.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = fragmentTransaction.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = fragmentTransaction.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = fragmentTransaction.mBreadCrumbTitleText;
        if (fragmentTransaction.mSharedElementSourceNames != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mSharedElementSourceNames = arrayList;
            arrayList.addAll(fragmentTransaction.mSharedElementSourceNames);
        }
        if (fragmentTransaction.mSharedElementTargetNames != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.mSharedElementTargetNames = arrayList2;
            arrayList2.addAll(fragmentTransaction.mSharedElementTargetNames);
        }
        this.mReorderingAllowed = fragmentTransaction.mReorderingAllowed;
    }

    void addOp(Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction add(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        fragment.mInDynamicContainer = true;
        return add(viewGroup.getId(), fragment, str);
    }

    void doAddOp(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        addOp(new Op(i2, fragment));
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    public FragmentTransaction remove(Fragment fragment) {
        addOp(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        addOp(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        addOp(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        if (FragmentTransition.supportsTransition()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<>();
                this.mSharedElementTargetNames = new ArrayList<>();
            } else {
                if (this.mSharedElementTargetNames.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.mReorderingAllowed = z;
        return this;
    }

    FragmentTransaction runOnCommitInternal(boolean z, Runnable runnable) {
        if (!z) {
            disallowAddToBackStack();
        }
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }
}
