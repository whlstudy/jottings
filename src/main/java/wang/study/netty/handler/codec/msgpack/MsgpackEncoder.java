package wang.study.netty.handler.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @author whl
 * @date 2019/10/11 7:37 下午
 *
 * msgpack编码器开发
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        MessagePack msgpack = new MessagePack();
        byte[] raw = msgpack.write(obj); // 将POJO对象编码为byte数组
        byteBuf.writeBytes(raw);
    }
}
