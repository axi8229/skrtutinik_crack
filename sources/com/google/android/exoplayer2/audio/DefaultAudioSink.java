package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    private MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableFloatOutput;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private AudioTrack keepSessionIdAudioTrack;
    private long lastFeedElapsedRealtimeMs;
    private AudioSink.Listener listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private Configuration pendingConfiguration;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private final ConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        float applyPlaybackSpeed(float playbackSpeed);

        boolean applySkipSilenceEnabled(boolean skipSilenceEnabled);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long playoutDuration);

        long getSkippedOutputFrameCount();
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String message) {
            super(message);
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessors) {
            AudioProcessor[] audioProcessorArr = new AudioProcessor[audioProcessors.length + 2];
            this.audioProcessors = audioProcessorArr;
            System.arraycopy(audioProcessors, 0, audioProcessorArr, 0, audioProcessors.length);
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor;
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            this.sonicAudioProcessor = sonicAudioProcessor;
            audioProcessorArr[audioProcessors.length] = silenceSkippingAudioProcessor;
            audioProcessorArr[audioProcessors.length + 1] = sonicAudioProcessor;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public float applyPlaybackSpeed(float playbackSpeed) {
            return this.sonicAudioProcessor.setSpeed(playbackSpeed);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public boolean applySkipSilenceEnabled(boolean skipSilenceEnabled) {
            this.silenceSkippingAudioProcessor.setEnabled(skipSilenceEnabled);
            return skipSilenceEnabled;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long playoutDuration) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(playoutDuration);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessors) {
        this(audioCapabilities, audioProcessors, false);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessors, boolean enableFloatOutput) {
        this(audioCapabilities, new DefaultAudioProcessorChain(audioProcessors), enableFloatOutput);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessorChain audioProcessorChain, boolean enableFloatOutput) {
        this.audioCapabilities = audioCapabilities;
        this.audioProcessorChain = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain);
        this.enableFloatOutput = enableFloatOutput;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        this.mediaPositionParameters = new MediaPositionParameters(1.0f, false, 0L, 0L);
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsOutput(int channelCount, int encoding) {
        if (Util.isEncodingLinearPcm(encoding)) {
            return encoding != 4 || Util.SDK_INT >= 21;
        }
        AudioCapabilities audioCapabilities = this.audioCapabilities;
        return audioCapabilities != null && audioCapabilities.supportsEncoding(encoding) && (channelCount == -1 || channelCount <= this.audioCapabilities.getMaxChannelCount());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean sourceEnded) {
        if (isInitialized()) {
            return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(sourceEnded), this.configuration.framesToDurationUs(getWrittenFrames()))));
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(int inputEncoding, int inputChannelCount, int inputSampleRate, int specifiedBufferSize, int[] outputChannels, int trimStartFrames, int trimEndFrames) throws AudioSink.ConfigurationException {
        int[] iArr;
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (Util.SDK_INT < 21 && inputChannelCount == 8 && outputChannels == null) {
            iArr = new int[6];
            for (int i4 = 0; i4 < 6; i4++) {
                iArr[i4] = i4;
            }
        } else {
            iArr = outputChannels;
        }
        boolean zIsEncodingLinearPcm = Util.isEncodingLinearPcm(inputEncoding);
        boolean z2 = this.enableFloatOutput && supportsOutput(inputChannelCount, 4) && Util.isEncodingHighResolutionPcm(inputEncoding);
        AudioProcessor[] audioProcessorArr = z2 ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
        if (zIsEncodingLinearPcm) {
            this.trimmingAudioProcessor.setTrimFrameCount(trimStartFrames, trimEndFrames);
            this.channelMappingAudioProcessor.setChannelMap(iArr);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(inputSampleRate, inputChannelCount, inputEncoding);
            for (AudioProcessor audioProcessor : audioProcessorArr) {
                try {
                    AudioProcessor.AudioFormat audioFormatConfigure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = audioFormatConfigure;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            int i5 = audioFormat.sampleRate;
            i = audioFormat.channelCount;
            i2 = audioFormat.encoding;
            i3 = i5;
        } else {
            i = inputChannelCount;
            i2 = inputEncoding;
            i3 = inputSampleRate;
        }
        int channelConfig = getChannelConfig(i, zIsEncodingLinearPcm);
        if (channelConfig == 0) {
            throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        int pcmFrameSize = zIsEncodingLinearPcm ? Util.getPcmFrameSize(inputEncoding, inputChannelCount) : -1;
        int pcmFrameSize2 = zIsEncodingLinearPcm ? Util.getPcmFrameSize(i2, i) : -1;
        if (zIsEncodingLinearPcm && !z2) {
            z = true;
        }
        Configuration configuration = new Configuration(zIsEncodingLinearPcm, pcmFrameSize, inputSampleRate, pcmFrameSize2, i3, channelConfig, i2, specifiedBufferSize, zIsEncodingLinearPcm, z, audioProcessorArr);
        if (isInitialized()) {
            this.pendingConfiguration = configuration;
        } else {
            this.configuration = configuration;
        }
    }

    private void setupAudioProcessors() {
        AudioProcessor[] audioProcessorArr = this.configuration.availableAudioProcessors;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private void flushAudioProcessors() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i];
            audioProcessor.flush();
            this.outputBuffers[i] = audioProcessor.getOutput();
            i++;
        }
    }

    private void initialize(long presentationTimeUs) throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        AudioTrack audioTrackBuildAudioTrack = ((Configuration) Assertions.checkNotNull(this.configuration)).buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
        this.audioTrack = audioTrackBuildAudioTrack;
        int audioSessionId = audioTrackBuildAudioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId);
            }
        }
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            AudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        this.startMediaTimeUs = Math.max(0L, presentationTimeUs);
        this.startMediaTimeUsNeedsSync = false;
        applyPlaybackSpeedAndSkipSilence(presentationTimeUs);
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        AudioTrack audioTrack2 = this.audioTrack;
        Configuration configuration = this.configuration;
        audioTrackPositionTracker.setAudioTrack(audioTrack2, configuration.outputEncoding, configuration.outputPcmFrameSize, configuration.bufferSize);
        setVolumeInternal();
        int i = this.auxEffectInfo.effectId;
        if (i != 0) {
            this.audioTrack.attachAuxEffect(i);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() throws IllegalStateException {
        this.playing = true;
        if (isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer buffer, long presentationTimeUs, int encodedAccessUnitCount) throws IllegalStateException, AudioSink.WriteException, AudioSink.InitializationException {
        ByteBuffer byteBuffer = this.inputBuffer;
        Assertions.checkArgument(byteBuffer == null || buffer == byteBuffer);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
            }
            applyPlaybackSpeedAndSkipSilence(presentationTimeUs);
        }
        if (!isInitialized()) {
            initialize(presentationTimeUs);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            if (!buffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.configuration;
            if (!configuration.isInputPcm && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample = getFramesPerEncodedSample(configuration.outputEncoding, buffer);
                this.framesPerEncodedSample = framesPerEncodedSample;
                if (framesPerEncodedSample == 0) {
                    return true;
                }
            }
            if (this.afterDrainParameters != null) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                applyPlaybackSpeedAndSkipSilence(presentationTimeUs);
                this.afterDrainParameters = null;
            }
            long jInputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(jInputFramesToDurationUs - presentationTimeUs) > 200000) {
                Log.e("AudioTrack", "Discontinuity detected [expected " + jInputFramesToDurationUs + ", got " + presentationTimeUs + "]");
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j = presentationTimeUs - jInputFramesToDurationUs;
                this.startMediaTimeUs += j;
                this.startMediaTimeUsNeedsSync = false;
                applyPlaybackSpeedAndSkipSilence(presentationTimeUs);
                AudioSink.Listener listener = this.listener;
                if (listener != null && j != 0) {
                    listener.onPositionDiscontinuity();
                }
            }
            if (this.configuration.isInputPcm) {
                this.submittedPcmBytes += buffer.remaining();
            } else {
                this.submittedEncodedFrames += this.framesPerEncodedSample * encodedAccessUnitCount;
            }
            this.inputBuffer = buffer;
            this.inputBufferAccessUnitCount = encodedAccessUnitCount;
        }
        processBuffers(presentationTimeUs);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        }
        if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        }
        Log.w("AudioTrack", "Resetting stalled audio track");
        flush();
        return true;
    }

    private void processBuffers(long avSyncPresentationTimeUs) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.outputBuffers[i - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                writeBuffer(byteBuffer, avSyncPresentationTimeUs);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private void writeBuffer(ByteBuffer buffer, long avSyncPresentationTimeUs) throws AudioSink.WriteException {
        int iWriteNonBlockingV21;
        if (buffer.hasRemaining()) {
            ByteBuffer byteBuffer = this.outputBuffer;
            if (byteBuffer != null) {
                Assertions.checkArgument(byteBuffer == buffer);
            } else {
                this.outputBuffer = buffer;
                if (Util.SDK_INT < 21) {
                    int iRemaining = buffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.preV21OutputBuffer = new byte[iRemaining];
                    }
                    int iPosition = buffer.position();
                    buffer.get(this.preV21OutputBuffer, 0, iRemaining);
                    buffer.position(iPosition);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int iRemaining2 = buffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    iWriteNonBlockingV21 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(iRemaining2, availableBufferSize));
                    if (iWriteNonBlockingV21 > 0) {
                        this.preV21OutputBufferOffset += iWriteNonBlockingV21;
                        buffer.position(buffer.position() + iWriteNonBlockingV21);
                    }
                } else {
                    iWriteNonBlockingV21 = 0;
                }
            } else if (this.tunneling) {
                Assertions.checkState(avSyncPresentationTimeUs != -9223372036854775807L);
                iWriteNonBlockingV21 = writeNonBlockingWithAvSyncV21(this.audioTrack, buffer, iRemaining2, avSyncPresentationTimeUs);
            } else {
                iWriteNonBlockingV21 = writeNonBlockingV21(this.audioTrack, buffer, iRemaining2);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (iWriteNonBlockingV21 < 0) {
                throw new AudioSink.WriteException(iWriteNonBlockingV21);
            }
            boolean z = this.configuration.isInputPcm;
            if (z) {
                this.writtenPcmBytes += iWriteNonBlockingV21;
            }
            if (iWriteNonBlockingV21 == iRemaining2) {
                if (!z) {
                    Assertions.checkState(buffer == this.inputBuffer);
                    this.writtenEncodedFrames += this.framesPerEncodedSample * this.inputBufferAccessUnitCount;
                }
                this.outputBuffer = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws IllegalStateException, AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0034 -> B:9:0x0014). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean drainToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.drainingAudioProcessorIndex
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L16
            com.google.android.exoplayer2.audio.DefaultAudioSink$Configuration r0 = r9.configuration
            boolean r0 = r0.processingEnabled
            if (r0 == 0) goto Lf
            r0 = r2
            goto L12
        Lf:
            com.google.android.exoplayer2.audio.AudioProcessor[] r0 = r9.activeAudioProcessors
            int r0 = r0.length
        L12:
            r9.drainingAudioProcessorIndex = r0
        L14:
            r0 = r1
            goto L17
        L16:
            r0 = r2
        L17:
            int r4 = r9.drainingAudioProcessorIndex
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.activeAudioProcessors
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L3a
            r4 = r5[r4]
            if (r0 == 0) goto L2a
            r4.queueEndOfStream()
        L2a:
            r9.processBuffers(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L34
            return r2
        L34:
            int r0 = r9.drainingAudioProcessorIndex
            int r0 = r0 + r1
            r9.drainingAudioProcessorIndex = r0
            goto L14
        L3a:
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L46
            r9.writeBuffer(r0, r7)
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L46
            return r2
        L46:
            r9.drainingAudioProcessorIndex = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.drainToEndOfStream():boolean");
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !isInitialized() || (this.handledEndOfStream && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return isInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackSpeed(float playbackSpeed) {
        setPlaybackSpeedAndSkipSilence(playbackSpeed, getSkipSilenceEnabled());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public float getPlaybackSpeed() {
        return getMediaPositionParameters().playbackSpeed;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean skipSilenceEnabled) {
        setPlaybackSpeedAndSkipSilence(getPlaybackSpeed(), skipSilenceEnabled);
    }

    public boolean getSkipSilenceEnabled() {
        return getMediaPositionParameters().skipSilence;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalStateException {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        flush();
        this.audioSessionId = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int audioSessionId) throws IllegalStateException {
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        if (this.auxEffectInfo.equals(auxEffectInfo)) {
            return;
        }
        int i = auxEffectInfo.effectId;
        float f = auxEffectInfo.sendLevel;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            if (this.auxEffectInfo.effectId != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.audioTrack.setAuxEffectSendLevel(f);
            }
        }
        this.auxEffectInfo = auxEffectInfo;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int tunnelingAudioSessionId) throws IllegalStateException {
        Assertions.checkState(Util.SDK_INT >= 21);
        if (this.tunneling && this.audioSessionId == tunnelingAudioSessionId) {
            return;
        }
        this.tunneling = true;
        this.audioSessionId = tunnelingAudioSessionId;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() throws IllegalStateException {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float volume) {
        if (this.volume != volume) {
            this.volume = volume;
            setVolumeInternal();
        }
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() throws IllegalStateException {
        this.playing = false;
        if (isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() throws IllegalStateException {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            this.mediaPositionParameters = new MediaPositionParameters(getPlaybackSpeed(), getSkipSilenceEnabled(), 0L, 0L);
            this.startMediaTimeUs = 0L;
            this.afterDrainParameters = null;
            this.mediaPositionParametersCheckpoints.clear();
            this.trimmingAudioProcessor.resetTrimmedFrameCount();
            flushAudioProcessors();
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            this.outputBuffer = null;
            this.stoppedAudioTrack = false;
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            Configuration configuration = this.pendingConfiguration;
            if (configuration != null) {
                this.configuration = configuration;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread("ExoPlayer:AudioTrackReleaseThread") { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() throws IllegalStateException {
        flush();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor audioProcessor : this.toIntPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.toFloatPcmAvailableAudioProcessors) {
            audioProcessor2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private void setPlaybackSpeedAndSkipSilence(float playbackSpeed, boolean skipSilence) {
        MediaPositionParameters mediaPositionParameters = getMediaPositionParameters();
        if (playbackSpeed == mediaPositionParameters.playbackSpeed && skipSilence == mediaPositionParameters.skipSilence) {
            return;
        }
        MediaPositionParameters mediaPositionParameters2 = new MediaPositionParameters(playbackSpeed, skipSilence, -9223372036854775807L, -9223372036854775807L);
        if (isInitialized()) {
            this.afterDrainParameters = mediaPositionParameters2;
        } else {
            this.mediaPositionParameters = mediaPositionParameters2;
        }
    }

    private MediaPositionParameters getMediaPositionParameters() {
        MediaPositionParameters mediaPositionParameters = this.afterDrainParameters;
        return mediaPositionParameters != null ? mediaPositionParameters : !this.mediaPositionParametersCheckpoints.isEmpty() ? this.mediaPositionParametersCheckpoints.getLast() : this.mediaPositionParameters;
    }

    private void applyPlaybackSpeedAndSkipSilence(long presentationTimeUs) {
        float fApplyPlaybackSpeed = this.configuration.canApplyPlaybackParameters ? this.audioProcessorChain.applyPlaybackSpeed(getPlaybackSpeed()) : 1.0f;
        boolean zApplySkipSilenceEnabled = this.configuration.canApplyPlaybackParameters ? this.audioProcessorChain.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(fApplyPlaybackSpeed, zApplySkipSilenceEnabled, Math.max(0L, presentationTimeUs), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors();
        AudioSink.Listener listener = this.listener;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(zApplySkipSilenceEnabled);
        }
    }

    private long applyMediaPositionParameters(long positionUs) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && positionUs >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        MediaPositionParameters mediaPositionParameters = this.mediaPositionParameters;
        long mediaDurationForPlayoutDuration = positionUs - mediaPositionParameters.audioTrackPositionUs;
        if (mediaPositionParameters.playbackSpeed != 1.0f) {
            if (this.mediaPositionParametersCheckpoints.isEmpty()) {
                mediaDurationForPlayoutDuration = this.audioProcessorChain.getMediaDuration(mediaDurationForPlayoutDuration);
            } else {
                mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(mediaDurationForPlayoutDuration, this.mediaPositionParameters.playbackSpeed);
            }
        }
        return this.mediaPositionParameters.mediaTimeUs + mediaDurationForPlayoutDuration;
    }

    private long applySkipping(long positionUs) {
        return positionUs + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private boolean isInitialized() {
        return this.audioTrack != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSubmittedFrames() {
        return this.configuration.isInputPcm ? this.submittedPcmBytes / r0.inputPcmFrameSize : this.submittedEncodedFrames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getWrittenFrames() {
        return this.configuration.isInputPcm ? this.writtenPcmBytes / r0.outputPcmFrameSize : this.writtenEncodedFrames;
    }

    private static AudioTrack initializeKeepSessionIdAudioTrack(int audioSessionId) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
    }

    private static int getChannelConfig(int channelCount, boolean isInputPcm) {
        int i = Util.SDK_INT;
        if (i <= 28 && !isInputPcm) {
            if (channelCount == 7) {
                channelCount = 8;
            } else if (channelCount == 3 || channelCount == 4 || channelCount == 5) {
                channelCount = 6;
            }
        }
        if (i <= 26 && "fugu".equals(Util.DEVICE) && !isInputPcm && channelCount == 1) {
            channelCount = 2;
        }
        return Util.getAudioTrackChannelConfig(channelCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMaximumEncodedRateBytesPerSecond(int encoding) {
        switch (encoding) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return JosStatusCodes.RTN_CODE_COMMON_ERROR;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private static int getFramesPerEncodedSample(int encoding, ByteBuffer buffer) {
        switch (encoding) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.parseAc3SyncframeAudioSampleCount(buffer);
            case 7:
            case 8:
                return DtsUtil.parseDtsAudioSampleCount(buffer);
            case 9:
                return MpegAudioUtil.parseMpegAudioFrameSampleCount(buffer.get(buffer.position()));
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + encoding);
            case 14:
                int iFindTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(buffer);
                if (iFindTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(buffer, iFindTrueHdSyncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.parseAc4SyncframeAudioSampleCount(buffer);
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer buffer, int size) {
        return audioTrack.write(buffer, size, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer buffer, int size, long presentationTimeUs) {
        if (Util.SDK_INT >= 26) {
            return audioTrack.write(buffer, size, 1, presentationTimeUs * 1000);
        }
        if (this.avSyncHeader == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.avSyncHeader = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, size);
            this.avSyncHeader.putLong(8, presentationTimeUs * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = size;
        }
        int iRemaining = this.avSyncHeader.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.avSyncHeader, iRemaining, 1);
            if (iWrite < 0) {
                this.bytesUntilNextAvSync = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iWriteNonBlockingV21 = writeNonBlockingV21(audioTrack, buffer, size);
        if (iWriteNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return iWriteNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= iWriteNonBlockingV21;
        return iWriteNonBlockingV21;
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack, float volume) {
        audioTrack.setVolume(volume);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack, float volume) {
        audioTrack.setStereoVolume(volume, volume);
    }

    private void playPendingData() throws IllegalStateException {
        if (this.stoppedAudioTrack) {
            return;
        }
        this.stoppedAudioTrack = true;
        this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
        this.audioTrack.stop();
        this.bytesUntilNextAvSync = 0;
    }

    private static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public final long mediaTimeUs;
        public final float playbackSpeed;
        public final boolean skipSilence;

        private MediaPositionParameters(float playbackSpeed, boolean skipSilence, long mediaTimeUs, long audioTrackPositionUs) {
            this.playbackSpeed = playbackSpeed;
            this.skipSilence = skipSilence;
            this.mediaTimeUs = mediaTimeUs;
            this.audioTrackPositionUs = audioTrackPositionUs;
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs) {
            String str = "Spurious audio timestamp (frame position mismatch): " + audioTimestampPositionFrames + ", " + audioTimestampSystemTimeUs + ", " + systemTimeUs + ", " + playbackPositionUs + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.w("AudioTrack", str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs) {
            String str = "Spurious audio timestamp (system clock mismatch): " + audioTimestampPositionFrames + ", " + audioTimestampSystemTimeUs + ", " + systemTimeUs + ", " + playbackPositionUs + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.w("AudioTrack", str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long latencyUs) {
            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + latencyUs);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int bufferSize, long bufferSizeMs) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(bufferSize, bufferSizeMs, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    private static final class Configuration {
        public final AudioProcessor[] availableAudioProcessors;
        public final int bufferSize;
        public final boolean canApplyPlaybackParameters;
        public final int inputPcmFrameSize;
        public final int inputSampleRate;
        public final boolean isInputPcm;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;
        public final boolean processingEnabled;

        public Configuration(boolean isInputPcm, int inputPcmFrameSize, int inputSampleRate, int outputPcmFrameSize, int outputSampleRate, int outputChannelConfig, int outputEncoding, int specifiedBufferSize, boolean processingEnabled, boolean canApplyPlaybackParameters, AudioProcessor[] availableAudioProcessors) {
            this.isInputPcm = isInputPcm;
            this.inputPcmFrameSize = inputPcmFrameSize;
            this.inputSampleRate = inputSampleRate;
            this.outputPcmFrameSize = outputPcmFrameSize;
            this.outputSampleRate = outputSampleRate;
            this.outputChannelConfig = outputChannelConfig;
            this.outputEncoding = outputEncoding;
            this.bufferSize = specifiedBufferSize == 0 ? getDefaultBufferSize() : specifiedBufferSize;
            this.processingEnabled = processingEnabled;
            this.canApplyPlaybackParameters = canApplyPlaybackParameters;
            this.availableAudioProcessors = availableAudioProcessors;
        }

        public boolean canReuseAudioTrack(Configuration audioTrackConfiguration) {
            return audioTrackConfiguration.outputEncoding == this.outputEncoding && audioTrackConfiguration.outputSampleRate == this.outputSampleRate && audioTrackConfiguration.outputChannelConfig == this.outputChannelConfig;
        }

        public long inputFramesToDurationUs(long frameCount) {
            return (frameCount * 1000000) / this.inputSampleRate;
        }

        public long framesToDurationUs(long frameCount) {
            return (frameCount * 1000000) / this.outputSampleRate;
        }

        public long durationUsToFrames(long durationUs) {
            return (durationUs * this.outputSampleRate) / 1000000;
        }

        public AudioTrack buildAudioTrack(boolean tunneling, AudioAttributes audioAttributes, int audioSessionId) throws AudioSink.InitializationException {
            AudioTrack audioTrack;
            if (Util.SDK_INT >= 21) {
                audioTrack = createAudioTrackV21(tunneling, audioAttributes, audioSessionId);
            } else {
                int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
                if (audioSessionId == 0) {
                    audioTrack = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
                } else {
                    audioTrack = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, audioSessionId);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
        }

        private AudioTrack createAudioTrackV21(boolean tunneling, AudioAttributes audioAttributes, int audioSessionId) {
            android.media.AudioAttributes audioAttributesV21;
            if (tunneling) {
                audioAttributesV21 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                audioAttributesV21 = audioAttributes.getAudioAttributesV21();
            }
            android.media.AudioAttributes audioAttributes2 = audioAttributesV21;
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build();
            int i = this.bufferSize;
            if (audioSessionId == 0) {
                audioSessionId = 0;
            }
            return new AudioTrack(audioAttributes2, audioFormatBuild, i, 1, audioSessionId);
        }

        private int getDefaultBufferSize() {
            if (!this.isInputPcm) {
                int maximumEncodedRateBytesPerSecond = DefaultAudioSink.getMaximumEncodedRateBytesPerSecond(this.outputEncoding);
                if (this.outputEncoding == 5) {
                    maximumEncodedRateBytesPerSecond *= 2;
                }
                return (int) ((maximumEncodedRateBytesPerSecond * 250000) / 1000000);
            }
            int minBufferSize = AudioTrack.getMinBufferSize(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            Assertions.checkState(minBufferSize != -2);
            return Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize, (int) Math.max(minBufferSize, durationUsToFrames(750000L) * this.outputPcmFrameSize));
        }
    }
}
