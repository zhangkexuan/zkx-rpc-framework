// 在common中
package uestc.zhangkx.rpc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.*;

/**
 * Java对象序列化和反序列化类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RPCMessage implements Serializable {
    private static final long serialVersionUID = 23875263L;

    private String className; // 使用的序列化类，不包含包名

    /**
     * 发送的消息体
     */
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] paramValues;

    /**
     * 接收的消息体
     */
    private Object value;

    // 序列化
    public void writeMessage(OutputStream out) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(this);
    }

    // 反序列化
    public static RPCMessage getMessage(InputStream input) throws Exception {
        RPCMessage message = (RPCMessage) new ObjectInputStream(input).readObject();
        return message;
    }
}
