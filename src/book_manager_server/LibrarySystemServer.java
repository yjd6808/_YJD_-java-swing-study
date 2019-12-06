0package book_manager_server;

import java.io.IOException;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.common.IoSession;
import org.apache.mina.common.SimpleByteBufferAllocator;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;

import book_manager_stringutil.LibrarySystemStringUtil;


public class LibrarySystemServer {
	public static int PORT = 8084;
	private final Lock mutex = new ReentrantLock();
    private static LibrarySystemServer instance = new LibrarySystemServer();
    private InetSocketAddress InetSocketadd;
    private IoAcceptor acceptor;
    private String serverName = "윤정도 도서관리 시스템 서버";
    public List<IoSession> sessionList = new ArrayList<>();
    public boolean Running = false;
    private final Lock locker = new ReentrantLock();
    
    public static LibrarySystemServer getInstance() {
        return instance;
    }
    
    public static void main(String[] args) {
    	LibrarySystemServer.getInstance().run_startup_configurations();
    }
    
    public boolean containIp(String ip)
    {
        for (IoSession se : sessionList)
        {
            
            InetSocketAddress socketAddress = (InetSocketAddress) se.getRemoteAddress();
            InetAddress inetAddress = socketAddress.getAddress();
            String connectedip = "/" + inetAddress.getHostAddress();
            if (ip.equalsIgnoreCase(connectedip))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public void disconnect(String ip)
    {
        locker.lock();
        try {
            for (IoSession se : sessionList)
            {
                InetSocketAddress socketAddress = (InetSocketAddress) se.getRemoteAddress();
                InetAddress inetAddress = socketAddress.getAddress();
                String connectedip = "/" + inetAddress.getHostAddress();
                if (ip.equalsIgnoreCase(connectedip))
                {

                    sessionList.remove(se);
                    se.close();
                    return;
                }
            }
        } finally {
            locker.unlock();
        }
    }
    
    public LibrarySystemSession getSessionFromIp(String ip)
    {
        locker.lock();
        try {
             for (IoSession se : sessionList)
            {
            	 LibrarySystemSession kms_se = (LibrarySystemSession)se.getAttribute("Session");
                
                if (kms_se != null && kms_se.getIp().equalsIgnoreCase(ip))
                    return kms_se;
            }
        }
        finally{
            locker.unlock();   
        }
        return null;
    }
    
    public void run_startup_configurations() {
    	try {
            ByteBuffer.setUseDirectBuffers(false);
            ByteBuffer.setAllocator(new SimpleByteBufferAllocator());
            acceptor = new SocketAcceptor();
            final SocketAcceptorConfig cfg = new SocketAcceptorConfig();
            cfg.getSessionConfig().setTcpNoDelay(true);
            cfg.setDisconnectOnUnbind(true);
            InetSocketadd = new InetSocketAddress(PORT);
            acceptor.bind(InetSocketadd, new SessionHandler(), cfg);
            /* 소켓 설정 종료 */
            //LibrarySystemStringUtil.debugPrint("[알림] " + serverName + "도서관리시스템 서버가 " + PORT + " 포트를 성공적으로 개방하였습니다.", 30);
            System.out.println("서버 오픈");
            }
            catch (IOException e) {
                System.err.println("[오류] " + serverName + "도서관리시스템 서버가 " + PORT + " 포트를 개방하는데 실패했습니다.");
                e.printStackTrace();
            }
    }
    
    
}
