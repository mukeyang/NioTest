package utils;

import java.nio.ByteBuffer;

/**
 * Created by CS on 2018/3/21.
 */
public class PacketWrapper {
    private int length;
    private byte[] payload;

    public PacketWrapper(String payload) {
        this.payload = payload.getBytes();
        this.length = this.payload.length;
    }

    public PacketWrapper(byte[] payload) {
        this.payload = payload;
        this.length = this.payload.length;
    }

    public byte[] getBytes() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(this.length + 4);
        byteBuffer.putInt(this.length);
        byteBuffer.put(payload);
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : getBytes()) {
            sb.append(String.format("0x%02X ", b));
        }
        return sb.toString();
    }
}
