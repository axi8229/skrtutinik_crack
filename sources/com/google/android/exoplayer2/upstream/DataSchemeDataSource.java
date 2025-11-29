package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public final class DataSchemeDataSource extends BaseDataSource {
    private byte[] data;
    private DataSpec dataSpec;
    private int endPosition;
    private int readPosition;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        transferInitializing(dataSpec);
        this.dataSpec = dataSpec;
        this.readPosition = (int) dataSpec.position;
        Uri uri = dataSpec.uri;
        String scheme = uri.getScheme();
        if (!RemoteMessageConst.DATA.equals(scheme)) {
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        String[] strArrSplit = Util.split(uri.getSchemeSpecificPart(), ",");
        if (strArrSplit.length != 2) {
            throw new ParserException("Unexpected URI format: " + uri);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.data = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new ParserException("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.data = Util.getUtf8Bytes(URLDecoder.decode(str, "US-ASCII"));
        }
        long j = dataSpec.length;
        int length = j != -1 ? ((int) j) + this.readPosition : this.data.length;
        this.endPosition = length;
        if (length > this.data.length || this.readPosition > length) {
            this.data = null;
            throw new DataSourceException(0);
        }
        transferStarted(dataSpec);
        return this.endPosition - this.readPosition;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] buffer, int offset, int readLength) {
        if (readLength == 0) {
            return 0;
        }
        int i = this.endPosition - this.readPosition;
        if (i == 0) {
            return -1;
        }
        int iMin = Math.min(readLength, i);
        System.arraycopy(Util.castNonNull(this.data), this.readPosition, buffer, offset, iMin);
        this.readPosition += iMin;
        bytesTransferred(iMin);
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.data != null) {
            this.data = null;
            transferEnded();
        }
        this.dataSpec = null;
    }
}
