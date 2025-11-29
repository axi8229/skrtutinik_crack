package com.yandex.metrica.impl.ob;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes3.dex */
class Rk {
    private static final List<Class> l;
    private static final List<Class> m;
    private final TreeSet<Float> a = new TreeSet<>();
    private final List<C0832bl> b = new ArrayList();
    private final Ak c;
    private final List<InterfaceC0857cl> d;
    private final List<InterfaceC1204qk> e;
    private final Fl f;
    private final C1251sk g;
    private final C1348wl h;
    private final C1396yl i;
    private final C1252sl j;
    private final Hl k;

    static {
        ArrayList arrayList = new ArrayList();
        l = arrayList;
        ArrayList arrayList2 = new ArrayList();
        m = arrayList2;
        arrayList.add(ListView.class);
        arrayList.add(GridView.class);
        a(arrayList, "androidx.recyclerview.widget.RecyclerView");
        a(arrayList, "androidx.viewpager.widget.ViewPager");
        a(arrayList, "androidx.viewpager2.widget.ViewPager2");
        a(arrayList2, "androidx.coordinatorlayout.widget.CoordinatorLayout");
        a(arrayList2, "androidx.drawerlayout.widget.DrawerLayout");
        a(arrayList2, "androidx.slidingpanelayout.widget.SlidingPaneLayout");
        a(arrayList2, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        a(arrayList2, "androidx.core.widget.NestedScrollView");
        a(arrayList2, "androidx.constraintlayout.widget.ConstraintLayout");
        a(arrayList2, "androidx.appcompat.widget.ContentFrameLayout");
        arrayList2.add(AbsoluteLayout.class);
        arrayList2.add(FrameLayout.class);
        arrayList2.add(LinearLayout.class);
        arrayList2.add(RelativeLayout.class);
        arrayList2.add(TableLayout.class);
        arrayList2.add(ScrollView.class);
        arrayList2.add(GridLayout.class);
    }

    Rk(C1348wl c1348wl, Fl fl, C1251sk c1251sk, Ak ak, List<InterfaceC0857cl> list, List<InterfaceC1204qk> list2, C1396yl c1396yl, C1252sl c1252sl, Hl hl) {
        this.h = c1348wl;
        this.f = fl;
        this.g = c1251sk;
        this.c = ak;
        this.d = list;
        this.e = list2;
        this.i = c1396yl;
        this.j = c1252sl;
        this.k = hl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b7, code lost:
    
        r1 = r1.a();
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.yandex.metrica.impl.ob.Pk a(com.yandex.metrica.impl.ob.C1228rl r22, android.view.View r23, int r24) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Rk.a(com.yandex.metrica.impl.ob.rl, android.view.View, int):com.yandex.metrica.impl.ob.Pk");
    }

    Pk b(C1228rl c1228rl, View view, int i) {
        try {
            if (this.j.a(view)) {
                return null;
            }
            return a(c1228rl, view, i);
        } catch (Throwable th) {
            this.i.a("ui_parsing_view", th);
            return null;
        }
    }

    final List<C0832bl> b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de A[LOOP:0: B:50:0x00d8->B:52:0x00de, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.yandex.metrica.impl.ob.C1228rl a(android.widget.TextView r20, java.lang.String r21, java.lang.String r22, int r23, boolean r24, com.yandex.metrica.impl.ob.C1228rl.a r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Rk.a(android.widget.TextView, java.lang.String, java.lang.String, int, boolean, com.yandex.metrica.impl.ob.rl$a):com.yandex.metrica.impl.ob.rl");
    }

    TreeSet<Float> a() {
        return this.a;
    }

    List<View> a(View view, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int iMin = Math.min(this.g.a(i), viewGroup.getChildCount());
                for (int i2 = 0; i2 < iMin; i2++) {
                    arrayList.add(viewGroup.getChildAt(i2));
                }
            }
        } catch (Throwable th) {
            this.i.a("ui_parsing_children", th);
        }
        return arrayList;
    }

    private boolean a(List<Class> list, View view) {
        Iterator<Class> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    private static void a(List<Class> list, String str) {
        Class clsB = C0963h2.b(str);
        if (clsB != null) {
            list.add(clsB);
        }
    }
}
