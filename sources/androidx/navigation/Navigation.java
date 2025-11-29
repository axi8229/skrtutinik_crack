package androidx.navigation;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: Navigation.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/navigation/Navigation;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "viewId", "Landroidx/navigation/NavController;", "findNavController", "(Landroid/app/Activity;I)Landroidx/navigation/NavController;", "Landroid/view/View;", "view", "(Landroid/view/View;)Landroidx/navigation/NavController;", "controller", "", "setViewNavController", "(Landroid/view/View;Landroidx/navigation/NavController;)V", "findViewNavController", "getViewNavController", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Navigation {
    public static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    @JvmStatic
    public static final NavController findNavController(Activity activity, int viewId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View viewRequireViewById = ActivityCompat.requireViewById(activity, viewId);
        Intrinsics.checkNotNullExpressionValue(viewRequireViewById, "requireViewById<View>(activity, viewId)");
        NavController navControllerFindViewNavController = INSTANCE.findViewNavController(viewRequireViewById);
        if (navControllerFindViewNavController != null) {
            return navControllerFindViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + viewId);
    }

    @JvmStatic
    public static final NavController findNavController(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController navControllerFindViewNavController = INSTANCE.findViewNavController(view);
        if (navControllerFindViewNavController != null) {
            return navControllerFindViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    @JvmStatic
    public static final void setViewNavController(View view, NavController controller) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R$id.nav_controller_view_tag, controller);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(view, new Function1<View, View>() { // from class: androidx.navigation.Navigation.findViewNavController.1
            @Override // kotlin.jvm.functions.Function1
            public final View invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object parent = it.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, NavController>() { // from class: androidx.navigation.Navigation.findViewNavController.2
            @Override // kotlin.jvm.functions.Function1
            public final NavController invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Navigation.INSTANCE.getViewNavController(it);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getViewNavController(View view) {
        Object tag = view.getTag(R$id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
