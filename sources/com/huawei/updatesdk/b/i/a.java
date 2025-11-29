package com.huawei.updatesdk.b.i;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class a {
    private com.huawei.updatesdk.b.i.b a;
    private Context b;
    private String c;
    private CharSequence d;
    private AlertDialog e;
    private AlertDialog.Builder f;
    private DialogInterface.OnShowListener g;
    private DialogInterface.OnDismissListener h;

    /* renamed from: com.huawei.updatesdk.b.i.a$a, reason: collision with other inner class name */
    class DialogInterfaceOnShowListenerC0106a implements DialogInterface.OnShowListener {

        /* renamed from: com.huawei.updatesdk.b.i.a$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0107a implements View.OnClickListener {
            ViewOnClickListenerC0107a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.a();
                }
            }
        }

        /* renamed from: com.huawei.updatesdk.b.i.a$a$b */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.b();
                }
            }
        }

        DialogInterfaceOnShowListenerC0106a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            AlertDialog alertDialog = (AlertDialog) dialogInterface;
            alertDialog.getButton(-1).setOnClickListener(new ViewOnClickListenerC0107a());
            Button button = alertDialog.getButton(-2);
            if (button != null) {
                button.setOnClickListener(new b());
            }
            if (a.this.g != null) {
                a.this.g.onShow(dialogInterface);
            }
        }
    }

    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.h != null) {
                a.this.h.onDismiss(dialogInterface);
            }
        }
    }

    public enum c {
        CONFIRM,
        CANCEL
    }

    public interface d {
        void a();
    }

    protected a(Context context, String str, CharSequence charSequence) {
        this.b = context;
        this.c = str;
        this.d = charSequence;
        this.f = com.huawei.updatesdk.a.a.d.h.c.i() ? new AlertDialog.Builder(context) : ((context.getResources().getConfiguration().uiMode & 48) != 32 || Build.VERSION.SDK_INT < 29) ? new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Light.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Dialog.Alert);
        this.f.setTitle(this.c);
        this.f.setPositiveButton(com.huawei.updatesdk.b.h.c.c(context, "upsdk_third_app_dl_sure_cancel_download"), (DialogInterface.OnClickListener) null);
        this.f.setNegativeButton(com.huawei.updatesdk.b.h.c.c(context, "upsdk_cancel"), (DialogInterface.OnClickListener) null);
        this.f.setMessage(this.d);
    }

    public static a a(Context context, String str, CharSequence charSequence) {
        return new a(context, str, charSequence);
    }

    public void a() {
        try {
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.e = null;
            }
        } catch (IllegalArgumentException unused) {
            com.huawei.updatesdk.a.a.a.b("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    public void a(DialogInterface.OnKeyListener onKeyListener) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(onKeyListener);
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        this.g = onShowListener;
    }

    public void a(View view) {
        ImageView imageView;
        if (this.f != null) {
            if (com.huawei.updatesdk.b.h.a.d().a() >= 17 && (imageView = (ImageView) view.findViewById(com.huawei.updatesdk.b.h.c.a(view.getContext(), "divider"))) != null) {
                imageView.setVisibility(8);
            }
            this.f.setMessage((CharSequence) null);
            this.f.setView(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0018 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.huawei.updatesdk.b.i.a.c r3, java.lang.String r4) {
        /*
            r2 = this;
            android.app.AlertDialog r0 = r2.e
            if (r0 != 0) goto L5
            return
        L5:
            com.huawei.updatesdk.b.i.a$c r1 = com.huawei.updatesdk.b.i.a.c.CONFIRM
            if (r3 != r1) goto Lf
            r3 = -1
        La:
            android.widget.Button r3 = r0.getButton(r3)
            goto L16
        Lf:
            com.huawei.updatesdk.b.i.a$c r1 = com.huawei.updatesdk.b.i.a.c.CANCEL
            if (r3 != r1) goto L15
            r3 = -2
            goto La
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L19
            return
        L19:
            r3.setText(r4)
            r4 = 1
            r3.setAllCaps(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.b.i.a.a(com.huawei.updatesdk.b.i.a$c, java.lang.String):void");
    }

    public void a(d dVar) {
        StringBuilder sb;
        Context context = this.b;
        if (context == null || ((Activity) context).isFinishing()) {
            com.huawei.updatesdk.a.a.a.b("BaseAlertDialog", "context == null or activity isFinishing");
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (b()) {
            sb = new StringBuilder();
            sb.append("show dlg error, mContext = ");
            sb.append(this.b);
            sb.append(", mContext.isFinishing is ");
            Context context2 = this.b;
            sb.append(context2 == null ? "mContext == null" : Boolean.valueOf(((Activity) context2).isFinishing()));
        } else {
            try {
                AlertDialog alertDialogCreate = this.f.create();
                this.e = alertDialogCreate;
                alertDialogCreate.setCanceledOnTouchOutside(false);
                this.e.setOnShowListener(new DialogInterfaceOnShowListenerC0106a());
                this.e.setOnDismissListener(new b());
                this.e.show();
                this.e.getButton(-1).requestFocus();
                return;
            } catch (Exception e) {
                if (dVar != null) {
                    dVar.a();
                }
                sb = new StringBuilder();
                sb.append("show dlg error, e: ");
                sb.append(e.toString());
            }
        }
        com.huawei.updatesdk.a.a.a.a("BaseAlertDialog", sb.toString());
    }

    public void a(com.huawei.updatesdk.b.i.b bVar) {
        this.a = bVar;
    }

    public void a(boolean z) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public boolean b() {
        AlertDialog alertDialog = this.e;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void c() {
        AlertDialog.Builder builder = this.f;
        if (builder == null) {
            return;
        }
        builder.setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }
}
