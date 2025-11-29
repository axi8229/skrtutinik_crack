package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;
    private long subsampleOffsetUs;

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public MetadataRenderer(MetadataOutput output, Looper outputLooper) {
        this(output, outputLooper, MetadataDecoderFactory.DEFAULT);
    }

    public MetadataRenderer(MetadataOutput output, Looper outputLooper, MetadataDecoderFactory decoderFactory) {
        super(4);
        this.output = (MetadataOutput) Assertions.checkNotNull(output);
        this.outputHandler = outputLooper == null ? null : Util.createHandler(outputLooper, this);
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(decoderFactory);
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return RendererCapabilities.create(format.drmInitData == null ? 4 : 2);
        }
        return RendererCapabilities.create(0);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formats, long offsetUs) {
        this.decoder = this.decoderFactory.createDecoder(formats[0]);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long positionUs, long elapsedRealtimeUs) {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            FormatHolder formatHolder = getFormatHolder();
            int source = readSource(formatHolder, this.buffer, false);
            if (source == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.isDecodeOnly()) {
                    MetadataInputBuffer metadataInputBuffer = this.buffer;
                    metadataInputBuffer.subsampleOffsetUs = this.subsampleOffsetUs;
                    metadataInputBuffer.flip();
                    Metadata metadataDecode = ((MetadataDecoder) Util.castNonNull(this.decoder)).decode(this.buffer);
                    if (metadataDecode != null) {
                        ArrayList arrayList = new ArrayList(metadataDecode.length());
                        decodeWrappedMetadata(metadataDecode, arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            int i = this.pendingMetadataIndex;
                            int i2 = this.pendingMetadataCount;
                            int i3 = (i + i2) % 5;
                            this.pendingMetadata[i3] = metadata;
                            this.pendingMetadataTimestamps[i3] = this.buffer.timeUs;
                            this.pendingMetadataCount = i2 + 1;
                        }
                    }
                }
            } else if (source == -5) {
                this.subsampleOffsetUs = ((Format) Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
            }
        }
        if (this.pendingMetadataCount > 0) {
            long[] jArr = this.pendingMetadataTimestamps;
            int i4 = this.pendingMetadataIndex;
            if (jArr[i4] <= positionUs) {
                invokeRenderer((Metadata) Util.castNonNull(this.pendingMetadata[i4]));
                Metadata[] metadataArr = this.pendingMetadata;
                int i5 = this.pendingMetadataIndex;
                metadataArr[i5] = null;
                this.pendingMetadataIndex = (i5 + 1) % 5;
                this.pendingMetadataCount--;
            }
        }
    }

    private void decodeWrappedMetadata(Metadata metadata, List<Metadata.Entry> decodedEntries) {
        for (int i = 0; i < metadata.length(); i++) {
            Format wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat != null && this.decoderFactory.supportsFormat(wrappedMetadataFormat)) {
                MetadataDecoder metadataDecoderCreateDecoder = this.decoderFactory.createDecoder(wrappedMetadataFormat);
                byte[] bArr = (byte[]) Assertions.checkNotNull(metadata.get(i).getWrappedMetadataBytes());
                this.buffer.clear();
                this.buffer.ensureSpaceForWrite(bArr.length);
                ((ByteBuffer) Util.castNonNull(this.buffer.data)).put(bArr);
                this.buffer.flip();
                Metadata metadataDecode = metadataDecoderCreateDecoder.decode(this.buffer);
                if (metadataDecode != null) {
                    decodeWrappedMetadata(metadataDecode, decodedEntries);
                }
            } else {
                decodedEntries.add(metadata.get(i));
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, (Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what == 0) {
            invokeRendererInternal((Metadata) msg.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }
}
