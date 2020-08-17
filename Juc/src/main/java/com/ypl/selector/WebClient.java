package com.ypl.selector;
/*
作者：yangp
创建时间：2020/8/17-14:52-2020
*/



import cn.hutool.core.util.RandomUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: WebClient
 * @Package com.ypl.selector
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 14:52
 */


public class WebClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9098));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);



            while (true) {
                writeBuffer.clear();
                writeBuffer.put((RandomUtil.randomInt(0,100)+"").getBytes());
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
                readBuffer.flip();
                byte[] bytes=new byte[readBuffer.limit()];
                readBuffer.get(bytes,0,bytes.length);
                System.out.println(new String(bytes));
                Thread.sleep(1000);
            }
        } catch (IOException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
