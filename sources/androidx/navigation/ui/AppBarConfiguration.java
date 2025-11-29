package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBarConfiguration.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB+\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration;", "", "", "", "topLevelDestinations", "Landroidx/customview/widget/Openable;", "openableLayout", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "fallbackOnNavigateUpListener", "<init>", "(Ljava/util/Set;Landroidx/customview/widget/Openable;Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;)V", "Landroidx/navigation/NavDestination;", "destination", "", "isTopLevelDestination", "(Landroidx/navigation/NavDestination;)Z", "Ljava/util/Set;", "getTopLevelDestinations", "()Ljava/util/Set;", "Landroidx/customview/widget/Openable;", "getOpenableLayout", "()Landroidx/customview/widget/Openable;", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "getFallbackOnNavigateUpListener", "()Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "Builder", "OnNavigateUpListener", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarConfiguration {
    private final OnNavigateUpListener fallbackOnNavigateUpListener;
    private final Openable openableLayout;
    private final Set<Integer> topLevelDestinations;

    /* compiled from: AppBarConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "", "onNavigateUp", "", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    public /* synthetic */ AppBarConfiguration(Set set, Openable openable, OnNavigateUpListener onNavigateUpListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, openable, onNavigateUpListener);
    }

    private AppBarConfiguration(Set<Integer> set, Openable openable, OnNavigateUpListener onNavigateUpListener) {
        this.topLevelDestinations = set;
        this.openableLayout = openable;
        this.fallbackOnNavigateUpListener = onNavigateUpListener;
    }

    public final Openable getOpenableLayout() {
        return this.openableLayout;
    }

    public final OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.fallbackOnNavigateUpListener;
    }

    public final boolean isTopLevelDestination(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (NavDestination navDestination : NavDestination.INSTANCE.getHierarchy(destination)) {
            if (this.topLevelDestinations.contains(Integer.valueOf(navDestination.getId())) && (!(navDestination instanceof NavGraph) || destination.getId() == NavGraph.INSTANCE.findStartDestination((NavGraph) navDestination).getId())) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: AppBarConfiguration.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/navigation/ui/AppBarConfiguration$Builder;", "", "Landroidx/navigation/NavGraph;", "navGraph", "<init>", "(Landroidx/navigation/NavGraph;)V", "Landroidx/customview/widget/Openable;", "openableLayout", "setOpenableLayout", "(Landroidx/customview/widget/Openable;)Landroidx/navigation/ui/AppBarConfiguration$Builder;", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "fallbackOnNavigateUpListener", "setFallbackOnNavigateUpListener", "(Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;)Landroidx/navigation/ui/AppBarConfiguration$Builder;", "Landroidx/navigation/ui/AppBarConfiguration;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/navigation/ui/AppBarConfiguration;", "", "", "topLevelDestinations", "Ljava/util/Set;", "Landroidx/customview/widget/Openable;", "Landroidx/navigation/ui/AppBarConfiguration$OnNavigateUpListener;", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private OnNavigateUpListener fallbackOnNavigateUpListener;
        private Openable openableLayout;
        private final Set<Integer> topLevelDestinations;

        public Builder(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "navGraph");
            HashSet hashSet = new HashSet();
            this.topLevelDestinations = hashSet;
            hashSet.add(Integer.valueOf(NavGraph.INSTANCE.findStartDestination(navGraph).getId()));
        }

        public final Builder setOpenableLayout(Openable openableLayout) {
            this.openableLayout = openableLayout;
            return this;
        }

        public final Builder setFallbackOnNavigateUpListener(OnNavigateUpListener fallbackOnNavigateUpListener) {
            this.fallbackOnNavigateUpListener = fallbackOnNavigateUpListener;
            return this;
        }

        public final AppBarConfiguration build() {
            return new AppBarConfiguration(this.topLevelDestinations, this.openableLayout, this.fallbackOnNavigateUpListener, null);
        }
    }
}
