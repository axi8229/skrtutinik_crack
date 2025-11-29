package com.group_ib.sdk;

import android.app.Activity;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class U extends C {
    public U(Activity activity, MotionEvent motionEvent) {
        HashMap map;
        List<Fragment> fragments;
        super(activity);
        if (!(activity instanceof FragmentActivity) || (fragments = ((FragmentActivity) activity).getSupportFragmentManager().getFragments()) == null || fragments.isEmpty()) {
            map = null;
        } else {
            map = new HashMap();
            a(fragments, map);
        }
        a(activity, motionEvent, map);
    }

    public static void a(List list, HashMap map) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment.isVisible() && fragment.isResumed() && fragment.getUserVisibleHint()) {
                if (fragment.getView() != null) {
                    map.put(fragment.getView(), new O(fragment));
                }
                a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    public U(FragmentActivity fragmentActivity, Fragment fragment) {
        super(fragmentActivity);
        while (fragment != null) {
            a(new O(fragment));
            fragment = fragment.getParentFragment();
        }
    }
}
