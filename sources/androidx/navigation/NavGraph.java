package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* compiled from: NavGraph.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 U2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001UB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u000b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010%\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b&\u0010*J!\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0010H\u0007¢\u0006\u0004\b&\u0010,J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010-H\u0086\u0002¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020$¢\u0006\u0004\b1\u00102J\u0015\u00101\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000e¢\u0006\u0004\b1\u00104J\u001f\u00101\u001a\u00020\u000b\"\b\b\u0000\u00106*\u0002052\u0006\u00103\u001a\u00028\u0000¢\u0006\u0004\b1\u00107J7\u00101\u001a\u00020\u000b\"\u0004\b\u0000\u001062\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0:H\u0007¢\u0006\u0004\b1\u0010<J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010>J\u001a\u0010@\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u000105H\u0096\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020$H\u0016¢\u0006\u0004\bB\u0010CR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010D8G¢\u0006\f\n\u0004\b!\u0010E\u001a\u0004\bF\u0010GR\u0016\u00100\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR.\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010J\u001a\u0004\bL\u0010>\"\u0004\bM\u00104R$\u0010P\u001a\u00020$2\u0006\u00100\u001a\u00020$8G@BX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010C\"\u0004\bO\u00102R\u0014\u0010R\u001a\u00020\u000e8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010>R\u0011\u0010T\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\bS\u0010>¨\u0006V"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/Navigator;", "navGraphNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "route", "", "searchChildren", "searchParent", "lastVisited", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchRouteComprehensive", "(Ljava/lang/String;ZZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "Landroidx/navigation/NavDeepLinkRequest;", "navDeepLinkRequest", "matchDeepLinkComprehensive", "(Landroidx/navigation/NavDeepLinkRequest;ZZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "node", "addDestination", "(Landroidx/navigation/NavDestination;)V", "", "nodes", "addDestinations", "(Ljava/util/Collection;)V", "", "resId", "findNode", "(I)Landroidx/navigation/NavDestination;", "findNodeComprehensive", "(ILandroidx/navigation/NavDestination;Z)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "searchParents", "(Ljava/lang/String;Z)Landroidx/navigation/NavDestination;", "", "iterator", "()Ljava/util/Iterator;", "startDestId", "setStartDestination", "(I)V", "startDestRoute", "(Ljava/lang/String;)V", "", "T", "(Ljava/lang/Object;)V", "Lkotlinx/serialization/KSerializer;", "serializer", "Lkotlin/Function1;", "parseRoute", "(Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;)V", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "I", "startDestIdName", "Ljava/lang/String;", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "getStartDestinationId", "setStartDestinationId", "startDestinationId", "getDisplayName", "displayName", "getStartDestDisplayName", "startDestDisplayName", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.checkNotNullParameter(navGraphNavigator, "navGraphNavigator");
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.onInflate(context, attrs);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R$styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "context.resources.obtain…leable.NavGraphNavigator)");
        setStartDestinationId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R$styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.INSTANCE.getDisplayName(context, this.startDestId);
        Unit unit = Unit.INSTANCE;
        typedArrayObtainAttributes.recycle();
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String route, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute2 = matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                if (Intrinsics.areEqual(navDestination, lastVisited)) {
                    deepLinkMatchMatchRoute = null;
                } else if (navDestination instanceof NavGraph) {
                    deepLinkMatchMatchRoute = ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this);
                } else {
                    deepLinkMatchMatchRoute = navDestination.matchRoute(route);
                }
                if (deepLinkMatchMatchRoute != null) {
                    arrayList.add(deepLinkMatchMatchRoute);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatchMatchRouteComprehensive = parent.matchRouteComprehensive(route, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchRoute2, deepLinkMatch, deepLinkMatchMatchRouteComprehensive}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(NavDeepLinkRequest navDeepLinkRequest, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink2 = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.matchDeepLink(navDeepLinkRequest) : null;
                if (deepLinkMatchMatchDeepLink2 != null) {
                    arrayList.add(deepLinkMatchMatchDeepLink2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatchMatchDeepLinkComprehensive = parent.matchDeepLinkComprehensive(navDeepLinkRequest, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchDeepLink, deepLinkMatch, deepLinkMatchMatchDeepLinkComprehensive}));
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive(navDeepLinkRequest, true, false, this);
    }

    public final void addDestination(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (getRoute() != null && Intrinsics.areEqual(route, getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (id == getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations(Collection<? extends NavDestination> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final NavDestination findNode(int resId) {
        return findNodeComprehensive(resId, this, false);
    }

    public final NavDestination findNodeComprehensive(int resId, NavDestination lastVisited, boolean searchChildren) {
        NavDestination navDestination = this.nodes.get(resId);
        if (navDestination != null) {
            return navDestination;
        }
        if (searchChildren) {
            Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    navDestination = null;
                    break;
                }
                NavDestination navDestination2 = (NavDestination) it.next();
                NavDestination navDestinationFindNodeComprehensive = (!(navDestination2 instanceof NavGraph) || Intrinsics.areEqual(navDestination2, lastVisited)) ? null : ((NavGraph) navDestination2).findNodeComprehensive(resId, this, true);
                if (navDestinationFindNodeComprehensive != null) {
                    navDestination = navDestinationFindNodeComprehensive;
                    break;
                }
            }
        }
        if (navDestination != null) {
            return navDestination;
        }
        if (getParent() == null || Intrinsics.areEqual(getParent(), lastVisited)) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNodeComprehensive(resId, this, searchChildren);
    }

    public final NavDestination findNode(String route) {
        if (route == null || StringsKt.isBlank(route)) {
            return null;
        }
        return findNode(route, true);
    }

    public final NavDestination findNode(String route, boolean searchParents) {
        Object next;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            NavDestination navDestination = (NavDestination) next;
            if (StringsKt.equals$default(navDestination.getRoute(), route, false, 2, null) || navDestination.matchRoute(route) != null) {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) next;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!searchParents || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(route);
    }

    /* compiled from: NavGraph.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "index", "", "wentToNext", "", "hasNext", "next", "remove", "", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.navigation.NavGraph$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<NavDestination>, KMappedMarker {
        private int index = -1;
        private boolean wentToNext;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index + 1 < NavGraph.this.getNodes().size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NavDestination next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> nodes = NavGraph.this.getNodes();
            int i = this.index + 1;
            this.index = i;
            return nodes.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.wentToNext) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            SparseArrayCompat<NavDestination> nodes = NavGraph.this.getNodes();
            nodes.valueAt(this.index).setParent(null);
            nodes.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new AnonymousClass1();
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    /* renamed from: getStartDestinationId, reason: from getter */
    public final int getStartDestId() {
        return this.startDestId;
    }

    private final void setStartDestinationId(int i) {
        if (i == getId()) {
            throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
        }
        if (this.startDestinationRoute != null) {
            setStartDestinationRoute(null);
        }
        this.startDestId = i;
        this.startDestIdName = null;
    }

    public final void setStartDestination(int startDestId) {
        setStartDestinationId(startDestId);
    }

    public final void setStartDestination(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestinationRoute(startDestRoute);
    }

    public final <T> void setStartDestination(final T startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(startDestRoute.getClass())), new Function1<NavDestination, String>() { // from class: androidx.navigation.NavGraph.setStartDestination.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(NavDestination startDestination) {
                Intrinsics.checkNotNullParameter(startDestination, "startDestination");
                Map<String, NavArgument> arguments = startDestination.getArguments();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
                Iterator<T> it = arguments.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
                }
                return RouteSerializerKt.generateRouteWithArgs(startDestRoute, linkedHashMap);
            }
        });
    }

    public final <T> void setStartDestination(KSerializer<T> serializer, Function1<? super NavDestination, String> parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int iGenerateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination navDestinationFindNode = findNode(iGenerateHashCode);
        if (navDestinationFindNode == null) {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
        setStartDestinationRoute(parseRoute.invoke(navDestinationFindNode));
        this.startDestId = iGenerateHashCode;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    private final void setStartDestinationRoute(String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (Intrinsics.areEqual(str, getRoute())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
            }
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            iHashCode = NavDestination.INSTANCE.createRoute(str).hashCode();
        }
        this.startDestId = iHashCode;
        this.startDestinationRoute = str;
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String strValueOf = this.startDestinationRoute;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.startDestId);
            }
            this.startDestIdName = strValueOf;
        }
        String str = this.startDestIdName;
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination navDestinationFindNode = findNode(this.startDestinationRoute);
        if (navDestinationFindNode == null) {
            navDestinationFindNode = findNode(getStartDestId());
        }
        sb.append(" startDestination=");
        if (navDestinationFindNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(navDestinationFindNode.toString());
            sb.append("}");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavGraph)) {
            return false;
        }
        if (super.equals(other)) {
            NavGraph navGraph = (NavGraph) other;
            if (this.nodes.size() == navGraph.nodes.size() && getStartDestId() == navGraph.getStartDestId()) {
                for (NavDestination navDestination : SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes))) {
                    if (!Intrinsics.areEqual(navDestination, navGraph.nodes.get(navDestination.getId()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int startDestId = getStartDestId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            startDestId = (((startDestId * 31) + sparseArrayCompat.keyAt(i)) * 31) + sparseArrayCompat.valueAt(i).hashCode();
        }
        return startDestId;
    }

    /* compiled from: NavGraph.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0007J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "childHierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "findStartDestination", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NavDestination findStartDestination(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.last(childHierarchy(navGraph));
        }

        public final Sequence<NavDestination> childHierarchy(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return SequencesKt.generateSequence(navGraph, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$childHierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.findNode(navGraph2.getStartDestId());
                }
            });
        }
    }
}
