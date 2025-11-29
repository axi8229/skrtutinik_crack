package com.huawei.updatesdk.service.otaupdate;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.updatesdk.b.h.b;
import com.huawei.updatesdk.b.i.a;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.c;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class AppUpdateActivity extends Activity implements com.huawei.updatesdk.service.otaupdate.b, com.huawei.updatesdk.b.f.b {
    private String a;
    private AlertDialog b;
    private com.huawei.updatesdk.b.i.a c;
    private com.huawei.updatesdk.b.i.a d;
    private ProgressBar e;
    private TextView f;
    private com.huawei.updatesdk.b.d.c l;
    private q q;
    private boolean g = false;
    private boolean h = false;
    private ApkUpgradeInfo i = null;
    private boolean j = false;
    private boolean k = false;
    private int m = -99;
    private int n = -99;
    private int o = -99;
    private Intent p = null;
    private boolean r = false;

    class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            AppUpdateActivity.this.m = 4;
            AppUpdateActivity.this.finish();
            return true;
        }
    }

    class b implements com.huawei.updatesdk.b.i.b {
        final /* synthetic */ com.huawei.updatesdk.service.appmgr.bean.c a;
        final /* synthetic */ com.huawei.updatesdk.b.i.a b;

        b(com.huawei.updatesdk.service.appmgr.bean.c cVar, com.huawei.updatesdk.b.i.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void a() {
            AppUpdateActivity.this.d(this.a);
            this.b.a();
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void b() {
            this.b.a();
            if (AppUpdateActivity.this.j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.b(appUpdateActivity.i);
            } else {
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
            }
        }
    }

    class c implements a.d {
        c() {
        }

        @Override // com.huawei.updatesdk.b.i.a.d
        public void a() {
            AppUpdateActivity.this.finish();
        }
    }

    class d implements DialogInterface.OnKeyListener {
        final /* synthetic */ com.huawei.updatesdk.b.i.a a;

        d(com.huawei.updatesdk.b.i.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (!AppUpdateActivity.this.j) {
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
                return true;
            }
            this.a.a();
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            appUpdateActivity.b(appUpdateActivity.i);
            return true;
        }
    }

    class e implements Runnable {
        final /* synthetic */ com.huawei.updatesdk.a.b.b.b a;

        e(com.huawei.updatesdk.a.b.b.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundleB = this.a.b();
            if (bundleB == null) {
                return;
            }
            int i = bundleB.getInt("INSTALL_STATE");
            com.huawei.updatesdk.service.otaupdate.d.a().a(AppUpdateActivity.this.a(i, bundleB.getInt("INSTALL_TYPE"), -1));
            AppUpdateActivity.this.c(i);
        }
    }

    class f implements com.huawei.updatesdk.b.i.b {
        f() {
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void a() {
            AppUpdateActivity.this.e.setProgress(0);
            AppUpdateActivity.this.e.setMax(0);
            AppUpdateActivity.this.f.setText("");
            AppUpdateActivity.this.a();
            if (AppUpdateActivity.this.l != null) {
                AppUpdateActivity.this.l.a();
            }
            AppUpdateActivity.this.c.a();
            if (AppUpdateActivity.this.j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.b(appUpdateActivity.i);
            } else {
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
            }
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void b() {
            AppUpdateActivity.this.c.a();
        }
    }

    class g implements a.d {
        g() {
        }

        @Override // com.huawei.updatesdk.b.i.a.d
        public void a() {
            AppUpdateActivity.this.finish();
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppUpdateActivity.this.c(this.a);
        }
    }

    class i implements com.huawei.updatesdk.b.i.b {
        final /* synthetic */ com.huawei.updatesdk.service.appmgr.bean.c a;
        final /* synthetic */ com.huawei.updatesdk.b.i.a b;

        i(com.huawei.updatesdk.service.appmgr.bean.c cVar, com.huawei.updatesdk.b.i.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void a() {
            if (!com.huawei.updatesdk.a.a.d.i.a.d(AppUpdateActivity.this)) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                Toast.makeText(appUpdateActivity, com.huawei.updatesdk.b.h.c.c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                AppUpdateActivity.this.finish();
            } else if (com.huawei.updatesdk.a.a.d.i.a.c(AppUpdateActivity.this) != 1) {
                AppUpdateActivity.this.c(this.a);
            } else {
                AppUpdateActivity.this.d(this.a);
                this.b.a();
            }
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void b() {
            this.b.a();
            if (AppUpdateActivity.this.j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.b(appUpdateActivity.i);
            } else {
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
            }
        }
    }

    class j implements a.d {
        j() {
        }

        @Override // com.huawei.updatesdk.b.i.a.d
        public void a() {
            AppUpdateActivity.this.finish();
        }
    }

    class k implements DialogInterface.OnKeyListener {
        final /* synthetic */ com.huawei.updatesdk.b.i.a a;

        k(com.huawei.updatesdk.b.i.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (!AppUpdateActivity.this.j) {
                AppUpdateActivity.this.m = 4;
                AppUpdateActivity.this.finish();
                return true;
            }
            this.a.a();
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            appUpdateActivity.b(appUpdateActivity.i);
            return true;
        }
    }

    class l implements com.huawei.updatesdk.b.i.b {
        l() {
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void a() {
            AppUpdateActivity.this.o = 101;
            if (com.huawei.updatesdk.a.a.d.i.a.d(AppUpdateActivity.this)) {
                AppUpdateActivity.this.e();
                return;
            }
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            Toast.makeText(appUpdateActivity, com.huawei.updatesdk.b.h.c.c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
            AppUpdateActivity.this.m = 2;
            AppUpdateActivity.this.finish();
        }

        @Override // com.huawei.updatesdk.b.i.b
        public void b() throws ExecutionException, InterruptedException, TimeoutException {
            AppUpdateActivity.this.d.a();
            AppUpdateActivity.this.m = 4;
            AppUpdateActivity.this.o = 100;
            if (AppUpdateActivity.this.j) {
                AppUpdateActivity.this.finish();
                return;
            }
            com.huawei.updatesdk.service.otaupdate.c cVar = new com.huawei.updatesdk.service.otaupdate.c();
            AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
            cVar.a(appUpdateActivity, appUpdateActivity.a, AppUpdateActivity.this.new n(), AppUpdateActivity.this.r);
        }
    }

    class m implements a.d {
        m() {
        }

        @Override // com.huawei.updatesdk.b.i.a.d
        public void a() {
            AppUpdateActivity.this.finish();
        }
    }

    public class n implements c.a {
        public n() {
        }

        @Override // com.huawei.updatesdk.service.otaupdate.c.a
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                try {
                    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
                    intent.setPackage(AppUpdateActivity.this.a);
                    AppUpdateActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    com.huawei.updatesdk.a.a.c.a.a.a.b("AppUpdateActivity", "goHiappUpgrade error: " + e.toString());
                }
            }
            AppUpdateActivity.this.finish();
        }
    }

    private static class o implements DialogInterface.OnDismissListener {
        private o() {
        }

        /* synthetic */ o(e eVar) {
            this();
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, 10001);
            com.huawei.updatesdk.service.otaupdate.d.a().b(intent);
        }
    }

    private static class p implements DialogInterface.OnShowListener {
        private p() {
        }

        /* synthetic */ p(e eVar) {
            this();
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, 10002);
            com.huawei.updatesdk.service.otaupdate.d.a().b(intent);
        }
    }

    private class q extends com.huawei.updatesdk.a.b.b.a {
        private q() {
        }

        /* synthetic */ q(AppUpdateActivity appUpdateActivity, e eVar) {
            this();
        }

        @Override // com.huawei.updatesdk.a.b.b.a
        public void a(Context context, com.huawei.updatesdk.a.b.b.b bVar) {
            if (bVar.d()) {
                if (AppUpdateActivity.this.c != null) {
                    AppUpdateActivity.this.c.a();
                }
                AppUpdateActivity.this.a();
                String strA = bVar.a();
                String dataString = bVar.c().getDataString();
                if (dataString == null || dataString.length() < 9) {
                    return;
                }
                String strSubstring = dataString.substring(8);
                if ("android.intent.action.PACKAGE_ADDED".equals(strA) && TextUtils.equals(AppUpdateActivity.this.a, strSubstring)) {
                    com.huawei.updatesdk.service.otaupdate.d.a().a(AppUpdateActivity.this.a(6, 0, -1));
                    com.huawei.updatesdk.b.h.b.a();
                    AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                    appUpdateActivity.a(appUpdateActivity.i.getPackage_(), AppUpdateActivity.this.i.getDetailId_());
                    if (AppUpdateActivity.this.j) {
                        AppUpdateActivity appUpdateActivity2 = AppUpdateActivity.this;
                        appUpdateActivity2.b(appUpdateActivity2.i);
                    }
                }
            }
        }
    }

    private long a(ApkUpgradeInfo apkUpgradeInfo) {
        long longSize_ = apkUpgradeInfo.getLongSize_();
        if (apkUpgradeInfo.getPackingType_() == 1 && apkUpgradeInfo.getBundleSize_() > 0) {
            return apkUpgradeInfo.getBundleSize_();
        }
        if (apkUpgradeInfo.getPackingType_() == 3 && apkUpgradeInfo.getObbSize_() > 0) {
            longSize_ += apkUpgradeInfo.getObbSize_();
        }
        if (apkUpgradeInfo.getDiffSize_() <= 0) {
            return longSize_;
        }
        long diffSize_ = apkUpgradeInfo.getDiffSize_();
        return (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? diffSize_ : diffSize_ + apkUpgradeInfo.getObbSize_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i2, int i3, int i4) {
        Intent intent = new Intent();
        intent.putExtra(UpdateKey.MARKET_DLD_STATUS, i4);
        intent.putExtra(UpdateKey.MARKET_INSTALL_STATE, i2);
        intent.putExtra(UpdateKey.MARKET_INSTALL_TYPE, i3);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.b.dismiss();
            this.b = null;
        } catch (IllegalArgumentException unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
        }
    }

    private void a(View view) {
        if (com.huawei.updatesdk.a.a.d.h.c.i()) {
            try {
                ScrollView scrollView = (ScrollView) view.findViewById(com.huawei.updatesdk.b.h.c.a(this, "scroll_layout"));
                TypedValue typedValue = new TypedValue();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getTheme().resolveAttribute(R.attr.dialogPreferredPadding, typedValue, true);
                ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int iComplexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, displayMetrics);
                scrollView.setPadding(iComplexToDimensionPixelSize, 0, iComplexToDimensionPixelSize, 0);
            } catch (Exception e2) {
                com.huawei.updatesdk.a.a.c.a.a.a.b("AppUpdateActivity", e2.toString());
            }
        }
    }

    private void a(com.huawei.updatesdk.a.b.b.b bVar) {
        Bundle bundleB = bVar.b();
        if (bundleB != null) {
            int i2 = bundleB.getInt("download_status_param", -1);
            com.huawei.updatesdk.service.otaupdate.d.a().a(a(-1, -1, i2));
            if (com.huawei.updatesdk.b.d.a.a(i2)) {
                return;
            }
            a();
            if (com.huawei.updatesdk.b.d.a.b(i2)) {
                Toast.makeText(this, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_third_app_dl_install_failed")), 0).show();
                finish();
            }
        }
    }

    private void a(ApkUpgradeInfo apkUpgradeInfo, TextView textView) {
        if (textView == null) {
            return;
        }
        if (apkUpgradeInfo.getDiffSize_() <= 0) {
            textView.setVisibility(8);
            return;
        }
        String strA = com.huawei.updatesdk.b.h.d.a(this, (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? apkUpgradeInfo.getLongSize_() : apkUpgradeInfo.getLongSize_() + apkUpgradeInfo.getObbSize_());
        SpannableString spannableString = new SpannableString(strA);
        spannableString.setSpan(new StrikethroughSpan(), 0, strA.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, (int) textView.getTextSize(), null, null), 0, spannableString.length(), 33);
        textView.setText(spannableString);
    }

    private void a(String str) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(this.a);
        intent.putExtra("APP_PACKAGENAME", str);
        intent.putExtra("APP_MUST_UPDATE_BTN", this.k);
        try {
            this.h = false;
            startActivityForResult(intent, 1002);
        } catch (ActivityNotFoundException e2) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("AppUpdateActivity", "goHiappUpgrade error: " + e2.toString());
            this.h = true;
            Intent intent2 = new Intent();
            intent2.putExtra(UpdateKey.STATUS, 8);
            com.huawei.updatesdk.service.otaupdate.d.a().b(intent2);
            b(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.m = 1;
            finish();
            return;
        }
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
        intent.setPackage(this.a);
        intent.putExtra("appDetailId", str2);
        intent.putExtra("thirdId", str);
        intent.addFlags(268468224);
        try {
            startActivity(intent);
            if (this.j) {
                return;
            }
            finish();
        } catch (Exception e2) {
            com.huawei.updatesdk.a.a.a.a("AppUpdateActivity", "openMarketUpdateDetail error: " + e2.toString());
            com.huawei.updatesdk.b.d.f.a(this);
            com.huawei.updatesdk.b.d.f.a(this.r);
            Intent intent2 = new Intent();
            intent2.putExtra(UpdateKey.STATUS, 8);
            com.huawei.updatesdk.service.otaupdate.d.a().b(intent2);
            com.huawei.updatesdk.b.i.a aVar = this.d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        q qVar = new q(this, null);
        this.q = qVar;
        com.huawei.updatesdk.service.otaupdate.a.a(this, intentFilter, qVar);
    }

    private void b(com.huawei.updatesdk.a.b.b.b bVar) {
        if (this.e == null) {
            return;
        }
        this.e.setProgress(com.huawei.updatesdk.b.h.d.a(bVar.b("download_apk_already", 0), bVar.b("download_apk_size", 0)));
        this.f.setText(com.huawei.updatesdk.b.h.d.a((int) ((this.e.getProgress() / this.e.getMax()) * 100.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ApkUpgradeInfo apkUpgradeInfo) {
        com.huawei.updatesdk.a.a.a.b("AppUpdateActivity", "showOtaDialog");
        if (apkUpgradeInfo == null) {
            finish();
            return;
        }
        String string = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_ota_title"));
        String string2 = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_ota_notify_updatebtn"));
        String string3 = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_ota_cancel"));
        b(string);
        if (1 == apkUpgradeInfo.getIsCompulsoryUpdate_()) {
            string3 = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_ota_force_cancel_new"));
            if (this.k) {
                this.d.c();
            }
            this.g = true;
        }
        this.d.a(new l());
        c();
        this.d.a(new m());
        if (this.g) {
            this.d.a(false);
        } else {
            this.d.a(new a());
        }
        this.d.a(a.c.CONFIRM, string2);
        this.d.a(a.c.CANCEL, string3);
    }

    private void b(com.huawei.updatesdk.service.appmgr.bean.c cVar) {
        com.huawei.updatesdk.b.i.a aVarA = com.huawei.updatesdk.b.i.a.a(this, null, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_appstore_install"), cVar.a()));
        aVarA.a(new i(cVar, aVarA));
        String string = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_app_download_info_new"));
        aVarA.a(new j());
        aVarA.a(a.c.CONFIRM, string);
        aVarA.a(new k(aVarA));
    }

    private void b(String str) {
        View viewInflate = LayoutInflater.from(this).inflate(com.huawei.updatesdk.b.h.c.b(this, "upsdk_ota_update_view"), (ViewGroup) null);
        ((TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "content_textview"))).setText(TextUtils.isEmpty(this.i.getNewFeatures_()) ? getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_choice_update")) : this.i.getNewFeatures_());
        ((TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "version_textview"))).setText(this.i.getVersion_());
        ((TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "appsize_textview"))).setText(com.huawei.updatesdk.b.h.d.a(this, a(this.i)));
        ((TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "name_textview"))).setText(this.i.getName_());
        a(this.i, (TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "allsize_textview")));
        a(viewInflate);
        com.huawei.updatesdk.b.i.a aVarA = com.huawei.updatesdk.b.i.a.a(this, str, null);
        this.d = aVarA;
        aVarA.a(viewInflate);
    }

    private void b(String str, String str2) {
        AlertDialog alertDialog = this.b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.b = (com.huawei.updatesdk.a.a.d.h.c.i() ? new AlertDialog.Builder(this) : ((getResources().getConfiguration().uiMode & 48) != 32 || Build.VERSION.SDK_INT < 29) ? new AlertDialog.Builder(this, R.style.Theme.DeviceDefault.Light.Dialog.Alert) : new AlertDialog.Builder(this, R.style.Theme.DeviceDefault.Dialog.Alert)).create();
            View viewInflate = LayoutInflater.from(this).inflate(com.huawei.updatesdk.b.h.c.b(this, "upsdk_app_dl_progress_dialog"), (ViewGroup) null);
            ((TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "third_app_warn_text"))).setText(getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_app_download_installing"), str2));
            ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "third_app_dl_progressbar"));
            this.e = progressBar;
            progressBar.setMax(100);
            this.f = (TextView) viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "third_app_dl_progress_text"));
            viewInflate.findViewById(com.huawei.updatesdk.b.h.c.a(this, "cancel_bg")).setOnClickListener(new h(str));
            this.b.setView(viewInflate);
            this.b.setCancelable(false);
            this.b.setCanceledOnTouchOutside(false);
            if (!com.huawei.updatesdk.service.otaupdate.a.a(this)) {
                this.b.show();
            }
            this.f.setText(com.huawei.updatesdk.b.h.d.a(0));
        }
    }

    private void c() {
        com.huawei.updatesdk.b.i.a aVar = this.d;
        if (aVar != null) {
            e eVar = null;
            aVar.a(new o(eVar));
            this.d.a(new p(eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (i2 == 5 || i2 == 4) {
            Toast.makeText(this, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_third_app_dl_install_failed")), 0).show();
            com.huawei.updatesdk.b.h.b.a();
            finish();
        }
        if (i2 == 7) {
            com.huawei.updatesdk.b.h.b.a();
            if (this.g) {
                b(this.i);
            } else {
                finish();
            }
        }
    }

    private void c(com.huawei.updatesdk.a.b.b.b bVar) {
        new Handler(Looper.getMainLooper()).post(new e(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.huawei.updatesdk.service.appmgr.bean.c cVar) {
        com.huawei.updatesdk.b.i.a aVarA = com.huawei.updatesdk.b.i.a.a(this, null, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_mobile_dld_warn"), com.huawei.updatesdk.b.h.d.a(this, cVar.c())));
        aVarA.a(new b(cVar, aVarA));
        String string = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_app_download_info_new"));
        aVarA.a(new c());
        aVarA.a(a.c.CONFIRM, string);
        aVarA.a(new d(aVarA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.huawei.updatesdk.b.i.a aVarA = com.huawei.updatesdk.b.i.a.a(this, null, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
        this.c = aVarA;
        aVarA.a(new f());
        String string = getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_third_app_dl_sure_cancel_download"));
        this.c.a(new g());
        this.c.a(a.c.CONFIRM, string);
    }

    private void d() {
        com.huawei.updatesdk.service.otaupdate.a.a(this, this.q);
        com.huawei.updatesdk.b.f.c.a().b(this);
        com.huawei.updatesdk.b.d.c cVar = this.l;
        if (cVar != null) {
            cVar.b();
        }
        com.huawei.updatesdk.b.d.f.a((com.huawei.updatesdk.service.otaupdate.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.huawei.updatesdk.service.appmgr.bean.c cVar) {
        b();
        b(cVar.d(), cVar.a());
        com.huawei.updatesdk.b.d.b bVar = new com.huawei.updatesdk.b.d.b(cVar.b(), cVar.c(), cVar.e());
        bVar.a(cVar.d());
        com.huawei.updatesdk.b.d.c cVar2 = new com.huawei.updatesdk.b.d.c(bVar);
        this.l = cVar2;
        cVar2.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.huawei.updatesdk.b.h.b.d(this, this.a)) {
            a(this.i.getPackage_(), this.i.getDetailId_());
            return;
        }
        com.huawei.updatesdk.b.d.f.a(this);
        com.huawei.updatesdk.b.d.f.a(this.r);
        this.d.a();
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void a(int i2) {
        Toast.makeText(this, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        com.huawei.updatesdk.service.otaupdate.d.a().a(i2);
        finish();
    }

    @Override // com.huawei.updatesdk.b.f.b
    public void a(int i2, com.huawei.updatesdk.a.b.b.b bVar) {
        if (bVar == null) {
            return;
        }
        if (i2 == 0) {
            a(bVar);
        } else if (1 == i2) {
            b(bVar);
        } else if (2 == i2) {
            c(bVar);
        }
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void a(com.huawei.updatesdk.service.appmgr.bean.c cVar) {
        if (cVar == null || !cVar.f()) {
            Toast.makeText(this, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
            finish();
        } else {
            com.huawei.updatesdk.b.f.c.a().a(this);
            this.a = cVar.d();
            b(cVar);
        }
    }

    @Override // com.huawei.updatesdk.service.otaupdate.b
    public void b(int i2) {
        Toast.makeText(this, getString(com.huawei.updatesdk.b.h.c.c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        com.huawei.updatesdk.service.otaupdate.d.a().a(i2);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.g) {
            overridePendingTransition(0, 0);
        }
        Intent intent = new Intent();
        this.p = intent;
        intent.putExtra(UpdateKey.STATUS, this.m);
        this.p.putExtra(UpdateKey.FAIL_CODE, this.n);
        this.p.putExtra(UpdateKey.MUST_UPDATE, this.g);
        this.p.putExtra(UpdateKey.BUTTON_STATUS, this.o);
        com.huawei.updatesdk.service.otaupdate.d.a().b(this.p);
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1002) {
            if (intent != null) {
                com.huawei.updatesdk.a.b.b.b bVarA = com.huawei.updatesdk.a.b.b.b.a(intent);
                this.m = i3;
                this.n = bVarA.a("installResultCode", -99);
                this.g = bVarA.a(UpdateKey.MUST_UPDATE, false);
            }
            this.o = i3 == 4 ? 100 : 101;
            if (this.h) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Serializable serializable;
        requestWindowFeature(1);
        com.huawei.updatesdk.a.a.d.h.c.d().a(getWindow());
        super.onCreate(bundle);
        Bundle bundleB = com.huawei.updatesdk.a.b.b.b.a(getIntent()).b();
        com.huawei.updatesdk.a.b.a.a.a(this);
        if (bundleB != null) {
            try {
                serializable = bundleB.getSerializable("app_update_parm");
                this.r = bundleB.getBoolean("is_apptouch", false);
            } catch (Exception e2) {
                com.huawei.updatesdk.a.a.a.a("AppUpdateActivity", "Type Conversion Error: " + e2.toString());
                super.finish();
                return;
            }
        } else {
            serializable = null;
        }
        String strB = com.huawei.updatesdk.b.e.e.a(this.r ? "apptouch" : "default").b();
        this.a = strB;
        if (TextUtils.isEmpty(strB)) {
            com.huawei.updatesdk.a.a.a.a("AppUpdateActivity", "finish activity and appStorePkgName is: " + this.a);
            super.finish();
            return;
        }
        if (!(serializable instanceof ApkUpgradeInfo)) {
            this.m = 3;
            finish();
            return;
        }
        this.i = (ApkUpgradeInfo) serializable;
        this.k = bundleB.getBoolean("app_must_btn", false);
        if (this.i.getIsCompulsoryUpdate_() == 1) {
            this.j = true;
        }
        if (this.i.getDevType_() == 1 && com.huawei.updatesdk.b.h.b.a(this, this.a) == b.EnumC0105b.INSTALLED) {
            a(this.i.getPackage_());
        } else {
            b(this.i);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.huawei.updatesdk.b.i.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
            this.c = null;
        }
        com.huawei.updatesdk.b.i.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.a();
            this.d = null;
        }
        a();
        d();
        super.onDestroy();
        finishActivity(1002);
    }
}
