package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {
    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) throws IOException {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(str));
    }

    private static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private final MediaCodec mediaCodec;

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            this.mediaCodec = mediaCodec;
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
            this.mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public int dequeueInputBuffer(long j) {
            return this.mediaCodec.dequeueInputBuffer(j);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void queueInputBuffer(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
            this.mediaCodec.queueInputBuffer(i, i2, i3, j, i4);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j) {
            return this.mediaCodec.dequeueOutputBuffer(bufferInfo, j);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void releaseOutputBuffer(int i, boolean z) {
            this.mediaCodec.releaseOutputBuffer(i, z);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public MediaFormat getInputFormat() {
            return this.mediaCodec.getInputFormat();
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public ByteBuffer getInputBuffer(int i) {
            return this.mediaCodec.getInputBuffer(i);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public ByteBuffer getOutputBuffer(int i) {
            return this.mediaCodec.getOutputBuffer(i);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper
        public void setParameters(Bundle bundle) {
            this.mediaCodec.setParameters(bundle);
        }
    }
}
