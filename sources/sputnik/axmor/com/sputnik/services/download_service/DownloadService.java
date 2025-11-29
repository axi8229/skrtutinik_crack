package sputnik.axmor.com.sputnik.services.download_service;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.common.entities.localization.ArchiveDownloadLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.SputnikApp;

/* compiled from: DownloadService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0015\b\u0007\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lsputnik/axmor/com/sputnik/services/download_service/DownloadService;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "", "url", FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, "", "tryDownload", "(Ljava/lang/String;Ljava/lang/String;)V", "fileName", "beginDownload", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "mydownloadid", "J", "Landroid/app/DownloadManager;", "dm", "Landroid/app/DownloadManager;", "Landroid/content/BroadcastReceiver;", "archiveBroadcast", "Landroid/content/BroadcastReceiver;", "getArchiveBroadcast", "()Landroid/content/BroadcastReceiver;", "setArchiveBroadcast", "(Landroid/content/BroadcastReceiver;)V", "Companion", "Factory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int STORAGE_PERMISSIONS_CODE = 1000;
    private static boolean isDownloading;
    private final AppCompatActivity activity;
    public LocalizationStorage localizationScreen;
    private long mydownloadid;
    private final DownloadManager dm = (DownloadManager) SputnikApp.INSTANCE.applicationContext().getSystemService("download");
    private BroadcastReceiver archiveBroadcast = new BroadcastReceiver() { // from class: sputnik.axmor.com.sputnik.services.download_service.DownloadService$archiveBroadcast$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ArchiveDownloadLocale archiveDownloader;
            List<String> errors;
            ArchiveDownloadLocale archiveDownloader2;
            List<String> errors2;
            String str = null;
            Long lValueOf = intent != null ? Long.valueOf(intent.getLongExtra("extra_download_id", -1L)) : null;
            long j = this.this$0.mydownloadid;
            if (lValueOf != null && lValueOf.longValue() == j) {
                DownloadService.INSTANCE.setDownloading(false);
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(lValueOf.longValue());
                DownloadManager downloadManager = this.this$0.dm;
                Cursor cursorQuery = downloadManager != null ? downloadManager.query(query) : null;
                if (cursorQuery != null) {
                    DownloadService downloadService = this.this$0;
                    if (cursorQuery.moveToFirst()) {
                        cursorQuery.getInt(cursorQuery.getColumnIndex("reason"));
                        int columnIndex = cursorQuery.getColumnIndex(UpdateKey.STATUS);
                        if (8 == cursorQuery.getInt(columnIndex)) {
                            LocalizationLocalModel data = downloadService.getLocalizationScreen().getData();
                            if (data != null && (archiveDownloader2 = data.getArchiveDownloader()) != null && (errors2 = archiveDownloader2.getErrors()) != null) {
                                str = (String) CollectionsKt.first((List) errors2);
                            }
                            Toast.makeText(context, str, 0).show();
                            return;
                        }
                        if (16 == cursorQuery.getInt(columnIndex)) {
                            LocalizationLocalModel data2 = downloadService.getLocalizationScreen().getData();
                            if (data2 != null && (archiveDownloader = data2.getArchiveDownloader()) != null && (errors = archiveDownloader.getErrors()) != null) {
                                str = errors.get(1);
                            }
                            Toast.makeText(context, str, 0).show();
                        }
                    }
                }
            }
        }
    };

    /* compiled from: DownloadService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Factory;", "", "create", "Lsputnik/axmor/com/sputnik/services/download_service/DownloadService;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Factory {
        DownloadService create(AppCompatActivity activity);
    }

    public DownloadService(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    /* compiled from: DownloadService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/services/download_service/DownloadService$Companion;", "", "()V", "STORAGE_PERMISSIONS_CODE", "", "getSTORAGE_PERMISSIONS_CODE", "()I", "isDownloading", "", "()Z", "setDownloading", "(Z)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSTORAGE_PERMISSIONS_CODE() {
            return DownloadService.STORAGE_PERMISSIONS_CODE;
        }

        public final boolean isDownloading() {
            return DownloadService.isDownloading;
        }

        public final void setDownloading(boolean z) {
            DownloadService.isDownloading = z;
        }
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final void tryDownload(String url, String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                beginDownload(url, filename);
                return;
            }
            if (ContextCompat.checkSelfPermission(appCompatActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                appCompatActivity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, STORAGE_PERMISSIONS_CODE);
            } else {
                beginDownload(url, filename);
            }
            appCompatActivity.registerReceiver(this.archiveBroadcast, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    public final void beginDownload(String url, String fileName) {
        Unit unit;
        ArchiveDownloadLocale archiveDownloader;
        List<String> errors;
        ArchiveDownloadLocale archiveDownloader2;
        List<String> errors2;
        ArchiveDownloadLocale archiveDownloader3;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        AppCompatActivity appCompatActivity = this.activity;
        isDownloading = false;
        String str = null;
        if (url != null) {
            Log.e("archive url", url);
            DownloadManager.Request title = new DownloadManager.Request(Uri.parse(url)).setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName).setTitle(fileName);
            LocalizationLocalModel data = getLocalizationScreen().getData();
            DownloadManager.Request allowedOverRoaming = title.setDescription((data == null || (archiveDownloader3 = data.getArchiveDownloader()) == null) ? null : archiveDownloader3.getDownloading()).setAllowedOverMetered(true).setAllowedOverRoaming(true);
            try {
                AppCompatActivity appCompatActivity2 = this.activity;
                DownloadManager downloadManager = (DownloadManager) (appCompatActivity2 != null ? appCompatActivity2.getSystemService("download") : null);
                Long lValueOf = downloadManager != null ? Long.valueOf(downloadManager.enqueue(allowedOverRoaming)) : null;
                Intrinsics.checkNotNull(lValueOf);
                this.mydownloadid = lValueOf.longValue();
                LocalizationLocalModel data2 = getLocalizationScreen().getData();
                Toast.makeText(appCompatActivity, (data2 == null || (archiveDownloader2 = data2.getArchiveDownloader()) == null || (errors2 = archiveDownloader2.getErrors()) == null) ? null : (String) CollectionsKt.last((List) errors2), 0).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            if (data3 != null && (archiveDownloader = data3.getArchiveDownloader()) != null && (errors = archiveDownloader.getErrors()) != null) {
                str = errors.get(2);
            }
            Toast.makeText(appCompatActivity, str, 0).show();
        }
    }
}
