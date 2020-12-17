package uestc.zhangkx.remoting.transport;


import uestc.zhangkx.extension.SPI;
import uestc.zhangkx.remoting.dto.RpcRequest;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@SPI
public interface RpcRequestTransport {
    /**
     * send rpc request to server and get result
     *
     * @param rpcRequest message body
     * @return data from server
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
