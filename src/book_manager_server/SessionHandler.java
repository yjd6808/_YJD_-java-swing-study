package book_manager_server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteOrder;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import book_manager_stringutil.LibrarySystemStringUtil;
import 어치.JDY_KmsConnectorServer;

public class SessionHandler extends IoHandlerAdapter{
	   @Override
	    public void exceptionCaught(final IoSession session, final Throwable cause) throws Exception {

	    }
	    
	    @Override
	    public void sessionOpened(IoSession session) {
	        
	         InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteAddress();
	        InetAddress inetAddress = socketAddress.getAddress();
	        String ip = inetAddress.getHostAddress();
	        
	        session.setAttribute("Session", new LibrarySystemSession(session, ip));
	        LibrarySystemServer.getInstance().sessionList.add(session);
	        LibrarySystemStringUtil.debugPrint("[알림] [/" + inetAddress.getHostAddress() + "] 에서 도서관리시스템 서버로 연결을 시도했습니다. Count : " + JDY_KmsConnectorServer.getInstance().sessionList.size(), 13);
	    }
	    
	    @Override
	    public void sessionClosed(IoSession session) {
	         InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteAddress();
	        InetAddress inetAddress = socketAddress.getAddress();
	        String ip = "/" + inetAddress.getHostAddress();
	        
	        try {
	        	LibrarySystemServer.getInstance().sessionList.remove(session);
	        	LibrarySystemStringUtil.debugPrint("[알림] [" + ip + "] 가 도서관리시스템 서버로부터 연결이 끊어졌습니다. Count : " + JDY_KmsConnectorServer.getInstance().sessionList.size());
	        }
	         catch (Exception e)
	         {
	        	 LibrarySystemStringUtil.debugPrint("[알림] [" + ip + "] 가 도서관리시스템 서버로부터 연결이 끊어졌습니다. Count : " + JDY_KmsConnectorServer.getInstance().sessionList.size());
	         }
	    
	    }
	    
	    public void messageReceived(IoSession session, Object message) {
	        final ByteBuffer packet = (ByteBuffer) message;
	        packet.order(ByteOrder.LITTLE_ENDIAN);
	        LibrarySystemSession lbSession =  (LibrarySystemSession)session.getAttribute("Session");     
	        int opCode =  packet.getInt();
	        switch (opCode)
	        {
	            case 8580000:
	            {
//	                kms_session.rechable = true;
//	                kms_session.rechableCounter = 0;
//	                
//	                
//	                ByteBuffer buffer = ByteBuffer.allocate(12);
//	                buffer.order(ByteOrder.LITTLE_ENDIAN);
//	                buffer.putInt(JDY_KmsConnectorOpCode.CLIENTINFO.getValue());
//	                buffer.putInt(isBannedSerial);
//	                buffer.putInt(isWzFileSizeEqual);
//	                buffer.flip();
//	                session.write(buffer);
	                break;
	            }
	        }
        }
}

