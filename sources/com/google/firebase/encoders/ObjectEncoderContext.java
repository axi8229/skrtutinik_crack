package com.google.firebase.encoders;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException;
}
