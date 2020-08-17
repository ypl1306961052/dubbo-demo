package com.ypl.selector;
/*
作者：yangp
创建时间：2020/8/17-14:06-2020
*/


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SelectorMain
 * @Package com.ypl.selector
 * @Description: (服务器)
 * @date 2020/8/17 14:06
 */


public class SelectorMain {
    static interface Handle {
        public String handle(String inStr);
    }

    static class Service {
        private Selector selector;
        private List<Handle> handles = new ArrayList<>();
        private int readWriteMaxLen = 1024;

        public Service() throws IOException {
            selector = Selector.open();
        }

        public void addHandle(Handle handle) {
            handles.add(handle);
        }

        public void bind(String ip, int port) throws IOException {
            //绑定接口
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //配置非堵塞
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(ip, port));
            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT, serverSocketChannel);
        }

        public static void main(String[] args) {
            try {
                Service service = new Service();
                service.bind("127.0.0.1", 9098);
                service.addHandle(new Handle() {
                    @Override
                    public String handle(String inStr) {
                        String result = "服务端收到消息:" + inStr;
                        System.out.println(result);
                        return result;
                    }
                });
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            System.out.println("服务已经开始了......");
            while (true) {
                try {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            System.out.println("服务已经可以接受");
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel accept = serverSocketChannel.accept();
                            if (accept != null) {
                                System.out.println("获取");
                                accept.configureBlocking(false);
                                accept.register(selector, SelectionKey.OP_READ);
                            }

                            //可接受
                        } else if (selectionKey.isConnectable()) {
                            SelectableChannel channel = selectionKey.channel();
                            System.out.println("连接上了" + channel);
                            //通道可以链接
                        } else if (selectionKey.isReadable()) {
                            //通道可以链接
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(readWriteMaxLen);
                            try {
                                //写数据
                                channel.read(byteBuffer);
                                //读取数据
                                byteBuffer.flip();
                                byte[] bytes=new byte[byteBuffer.limit()];
                                byteBuffer.get(bytes,0,bytes.length);
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < handles.size(); i++) {
                                    Handle handle = handles.get(i);
                                    String handle1Result = handle.handle(new String(bytes));
                                    stringBuilder.append(handle1Result);
                                }
                                byteBuffer.clear();
                                byte[] wbytes = stringBuilder.toString().getBytes();
                                System.out.println("发送给客户端的信息:" + new String(bytes));
                                int len = Math.min(bytes.length, readWriteMaxLen);
                                byteBuffer.put(wbytes);
                                byteBuffer.flip();
                                channel.write(byteBuffer);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (selectionKey.isWritable()) {

                        } else {
                            selectionKey.isValid();
                        }


                        iterator.remove();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }


}
