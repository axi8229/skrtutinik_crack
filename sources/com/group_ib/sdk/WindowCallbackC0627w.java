package com.group_ib.sdk;

import android.app.Activity;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.group_ib.sdk.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class WindowCallbackC0627w implements Window.Callback {
    public static final C0587b e = new C0587b();
    public final V a;
    public final Window.Callback b;
    public final Activity c;
    public C0606k0 d;

    public WindowCallbackC0627w(V v, Activity activity, Window.Callback callback) {
        this.a = v;
        this.c = activity;
        this.b = callback;
        activity.getWindow().getDecorView().setAccessibilityDelegate(e);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.b;
        return callback != null && callback.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.b;
        return callback != null && callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.b;
        return callback != null && callback.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        V v;
        if (accessibilityEvent.getEventType() == 32 && (v = this.a) != null) {
            ((HandlerC0598g0) v).a(new C0619s(D.accessibility_window_state_changed, new C(this.c), accessibilityEvent));
        }
        Window.Callback callback = this.b;
        return callback != null && callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            com.group_ib.sdk.V r0 = r3.a
            if (r0 == 0) goto L27
            int r0 = r4.getAction()
            if (r0 != 0) goto L1a
            com.group_ib.sdk.U r0 = new com.group_ib.sdk.U
            android.app.Activity r1 = r3.c
            r0.<init>(r1, r4)
            com.group_ib.sdk.k0 r1 = new com.group_ib.sdk.k0
            com.group_ib.sdk.V r2 = r3.a
            r1.<init>(r2, r0)
            r3.d = r1
        L1a:
            com.group_ib.sdk.k0 r0 = r3.d
            if (r0 == 0) goto L2a
            r0.a(r4)
            com.group_ib.sdk.k0 r0 = r3.d
            boolean r0 = r0.g
            if (r0 == 0) goto L2a
        L27:
            r0 = 0
            r3.d = r0
        L2a:
            android.view.Window$Callback r0 = r3.b
            if (r0 == 0) goto L36
            boolean r4 = r0.dispatchTouchEvent(r4)
            if (r4 == 0) goto L36
            r4 = 1
            goto L37
        L36:
            r4 = 0
        L37:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.WindowCallbackC0627w.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.b;
        return callback != null && callback.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        Window.Callback callback = this.b;
        return callback != null && callback.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        Window.Callback callback = this.b;
        if (callback != null) {
            return callback.onCreatePanelView(i);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Window.Callback callback = this.b;
        return callback != null && callback.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        Window.Callback callback = this.b;
        return callback != null && callback.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onPanelClosed(i, menu);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        Window.Callback callback = this.b;
        return callback != null && callback.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        Window.Callback callback = this.b;
        return callback != null && callback.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Window.Callback callback = this.b;
        if (callback != null) {
            callback.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.b;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.b;
        return callback != null && callback.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Window.Callback callback2 = this.b;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback, i);
        }
        return null;
    }
}
