package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class SntpClient {
    private static long elapsedRealtimeOffsetMs;
    private static boolean isInitialized;
    private static final Object loaderLock = new Object();
    private static final Object valueLock = new Object();

    public interface InitializationCallback {
        void onInitializationFailed(IOException error);

        void onInitialized();
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (valueLock) {
            z = isInitialized;
        }
        return z;
    }

    public static long getElapsedRealtimeOffsetMs() {
        long j;
        synchronized (valueLock) {
            try {
                j = isInitialized ? elapsedRealtimeOffsetMs : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static void initialize(Loader loader, InitializationCallback callback) {
        if (isInitialized()) {
            if (callback != null) {
                callback.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.startLoading(new NtpTimeLoadable(), new NtpTimeCallback(callback), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long loadNtpTimeOffsetMs() throws IOException {
        InetAddress byName = InetAddress.getByName("pool.ntp.org");
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            writeTimestamp(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            long j = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
            byte b = bArr[0];
            int i = bArr[1] & 255;
            long timestamp = readTimestamp(bArr, 24);
            long timestamp2 = readTimestamp(bArr, 32);
            long timestamp3 = readTimestamp(bArr, 40);
            checkValidServerReply((byte) ((b >> 6) & 3), (byte) (b & 7), i, timestamp3);
            long j2 = (j + (((timestamp2 - timestamp) + (timestamp3 - j)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    datagramSocket.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private static long readTimestamp(byte[] buffer, int offset) {
        long j = read32(buffer, offset);
        long j2 = read32(buffer, offset + 4);
        if (j == 0 && j2 == 0) {
            return 0L;
        }
        return ((j - 2208988800L) * 1000) + ((j2 * 1000) / 4294967296L);
    }

    private static void writeTimestamp(byte[] buffer, int offset, long time) {
        if (time == 0) {
            Arrays.fill(buffer, offset, offset + 8, (byte) 0);
            return;
        }
        long j = time / 1000;
        long j2 = time - (j * 1000);
        buffer[offset] = (byte) (r2 >> 24);
        buffer[offset + 1] = (byte) (r2 >> 16);
        buffer[offset + 2] = (byte) (r2 >> 8);
        buffer[offset + 3] = (byte) (j + 2208988800L);
        long j3 = (j2 * 4294967296L) / 1000;
        buffer[offset + 4] = (byte) (j3 >> 24);
        buffer[offset + 5] = (byte) (j3 >> 16);
        buffer[offset + 6] = (byte) (j3 >> 8);
        buffer[offset + 7] = (byte) (Math.random() * 255.0d);
    }

    private static long read32(byte[] buffer, int offset) {
        int i = buffer[offset];
        int i2 = buffer[offset + 1];
        int i3 = buffer[offset + 2];
        int i4 = buffer[offset + 3];
        if ((i & 128) == 128) {
            i = (i & 127) + 128;
        }
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
    }

    private static void checkValidServerReply(byte leap, byte mode, int stratum, long transmitTime) throws IOException {
        if (leap == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (mode != 4 && mode != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) mode));
        }
        if (stratum != 0 && stratum <= 15) {
            if (transmitTime == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + stratum);
        }
    }

    private static final class NtpTimeLoadable implements Loader.Loadable {
        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        private NtpTimeLoadable() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            synchronized (SntpClient.loaderLock) {
                synchronized (SntpClient.valueLock) {
                    if (SntpClient.isInitialized) {
                        return;
                    }
                    long jLoadNtpTimeOffsetMs = SntpClient.loadNtpTimeOffsetMs();
                    synchronized (SntpClient.valueLock) {
                        long unused = SntpClient.elapsedRealtimeOffsetMs = jLoadNtpTimeOffsetMs;
                        boolean unused2 = SntpClient.isInitialized = true;
                    }
                }
            }
        }
    }

    private static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {
        private final InitializationCallback callback;

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(Loader.Loadable loadable, long elapsedRealtimeMs, long loadDurationMs, boolean released) {
        }

        public NtpTimeCallback(InitializationCallback callback) {
            this.callback = callback;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(Loader.Loadable loadable, long elapsedRealtimeMs, long loadDurationMs) {
            Assertions.checkState(SntpClient.isInitialized());
            InitializationCallback initializationCallback = this.callback;
            if (initializationCallback != null) {
                initializationCallback.onInitialized();
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long elapsedRealtimeMs, long loadDurationMs, IOException error, int errorCount) {
            InitializationCallback initializationCallback = this.callback;
            if (initializationCallback != null) {
                initializationCallback.onInitializationFailed(error);
            }
            return Loader.DONT_RETRY;
        }
    }
}
