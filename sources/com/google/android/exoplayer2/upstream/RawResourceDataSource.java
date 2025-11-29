package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class RawResourceDataSource extends BaseDataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String message) {
            super(message);
        }

        public RawResourceDataSourceException(IOException e) {
            super(e);
        }
    }

    public static Uri buildRawResourceUri(int rawResourceId) {
        return Uri.parse("rawresource:///" + rawResourceId);
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.resources = context.getResources();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws Resources.NotFoundException, NumberFormatException, IOException {
        try {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            if (!TextUtils.equals("rawresource", uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must use scheme rawresource");
            }
            try {
                int i = Integer.parseInt((String) Assertions.checkNotNull(uri.getLastPathSegment()));
                transferInitializing(dataSpec);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.resources.openRawResourceFd(i);
                this.assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                if (assetFileDescriptorOpenRawResourceFd == null) {
                    throw new RawResourceDataSourceException("Resource is compressed: " + uri);
                }
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
                this.inputStream = fileInputStream;
                fileInputStream.skip(assetFileDescriptorOpenRawResourceFd.getStartOffset());
                if (fileInputStream.skip(dataSpec.position) < dataSpec.position) {
                    throw new EOFException();
                }
                long j = dataSpec.length;
                long j2 = -1;
                if (j != -1) {
                    this.bytesRemaining = j;
                } else {
                    long length = assetFileDescriptorOpenRawResourceFd.getLength();
                    if (length != -1) {
                        j2 = length - dataSpec.position;
                    }
                    this.bytesRemaining = j2;
                }
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } catch (IOException e) {
            throw new RawResourceDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        if (readLength == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                readLength = (int) Math.min(j, readLength);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            }
        }
        int i = ((InputStream) Util.castNonNull(this.inputStream)).read(buffer, offset, readLength);
        if (i == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException(new EOFException());
        }
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - i;
        }
        bytesTransferred(i);
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            try {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.inputStream = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(e3);
                }
            } finally {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            }
        }
    }
}
