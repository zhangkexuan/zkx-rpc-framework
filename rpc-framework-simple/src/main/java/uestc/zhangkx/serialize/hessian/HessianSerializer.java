package uestc.zhangkx.serialize.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import uestc.zhangkx.exception.SerializeException;
import uestc.zhangkx.serialize.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Hessian的序列化需要pojo实现{@code java.io.Serializable}
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 19:30
 */
public class HessianSerializer implements Serializer {
    @Override
    public byte[] serialize(Object obj) {
        if(obj==null){
            throw new NullPointerException();
        }
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        HessianOutput output=new HessianOutput(os);
        try {
            output.writeObject(obj);
        } catch (IOException e) {
            throw new SerializeException("Serialization failed");
        }
        return os.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        if(bytes==null){
            return null;
        }
        Object result = null;
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            HessianInput input = new HessianInput(is);
            result = input.readObject();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed");
        }
        return (T)result;
    }
}
