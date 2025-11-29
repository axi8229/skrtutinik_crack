package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.android.SystemUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CursorUtil.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\b\u001a%\u0010\u000b\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/database/Cursor;", "c", "copyAndClose", "(Landroid/database/Cursor;)Landroid/database/Cursor;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "getColumnIndex", "(Landroid/database/Cursor;Ljava/lang/String;)I", "getColumnIndexOrThrow", "cursor", "findColumnIndexBySuffix", "", "columnNames", "([Ljava/lang/String;Ljava/lang/String;)I", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CursorUtil {
    public static final int getColumnIndex(Cursor c, String name) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex('`' + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c, name);
    }

    public static final int getColumnIndexOrThrow(Cursor c, String name) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            strJoinToString$default = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strJoinToString$default = SystemUtils.UNKNOWN;
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + strJoinToString$default);
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int findColumnIndexBySuffix(String[] columnNames, String name) {
        Intrinsics.checkNotNullParameter(columnNames, "columnNames");
        Intrinsics.checkNotNullParameter(name, "name");
        String str = '.' + name;
        String str2 = '.' + name + '`';
        int length = columnNames.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str3 = columnNames[i];
            int i3 = i2 + 1;
            if (str3.length() >= name.length() + 2) {
                if (StringsKt.endsWith$default(str3, str, false, 2, (Object) null)) {
                    return i2;
                }
                if (str3.charAt(0) == '`' && StringsKt.endsWith$default(str3, str2, false, 2, (Object) null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    public static final Cursor copyAndClose(Cursor c) {
        Intrinsics.checkNotNullParameter(c, "c");
        Cursor cursor = c;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor2.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor2.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor2.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor2.getString(i);
                    } else if (type == 4) {
                        objArr[i] = cursor2.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.closeFinally(cursor, null);
            return matrixCursor;
        } finally {
        }
    }
}
