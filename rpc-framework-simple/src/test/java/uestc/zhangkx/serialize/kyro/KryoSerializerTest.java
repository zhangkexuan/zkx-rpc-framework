package uestc.zhangkx.serialize.kyro;

import lombok.*;
import org.junit.jupiter.api.Test;
import uestc.zhangkx.serialize.Serializer;
import uestc.zhangkx.serialize.hessian.HessianSerializer;
import uestc.zhangkx.serialize.protostuff.ProtostuffSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 18:46
 */
class KryoSerializerTest {

    @Test
    void testKryo(){
        Student student = Student.builder().name("zhangkx").score(100).build();
        KryoSerializer kryoSerializer = new KryoSerializer();
        final byte[] serialize = kryoSerializer.serialize(student);
        final Student deserialize = kryoSerializer.deserialize(serialize, student.getClass());
        System.out.println(deserialize.toString());
    }

    @Test
    void testProtostuff(){
        Student student = Student.builder().name("zhangkx").score(100).build();
        ProtostuffSerializer protostuffSerializer = new ProtostuffSerializer();
        final byte[] serialize = protostuffSerializer.serialize(student);
        final Student deserialize = protostuffSerializer.deserialize(serialize, student.getClass());
        System.out.println(deserialize.toString());
    }

    @Test
    void testHessian(){
        Student student = Student.builder().name("zhangkx").score(100).build();
        Serializer serializer = new HessianSerializer();
        byte[] serialize = serializer.serialize(student);
        Student deserialize = serializer.deserialize(serialize,student.getClass());
        System.out.println(deserialize.toString());
    }

}

/**
 * 测试序列化
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
class Student implements Serializable {
    private String name;
    private int score;
}