package uestc.zhangkx.remoting.dto;


import lombok.*;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcMessage {

    //rpc message type
    private byte messageType;
    //serialization type
    private byte codec;
    //compress type
    private byte compress;
    //request id
    private int requestId;
    //request data
    private Object data;

}
