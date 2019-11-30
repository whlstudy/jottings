package wang.study.netty.protocol.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

/**
 * @author whl
 * @date 2019/11/30 10:27 上午
 */
public class ChannelBufferByteInput implements ByteInput {
    public ChannelBufferByteInput(ByteBuf buf) {
    }
}
