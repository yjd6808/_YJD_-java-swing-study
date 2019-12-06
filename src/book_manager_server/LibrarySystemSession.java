package book_manager_server;

import org.apache.mina.common.IoSession;

public class LibrarySystemSession {
	public IoSession session;
    private String ip;
    
    public LibrarySystemSession(IoSession se, String ip)
    {
        this.session = se;
        this.ip = ip;
    }
    
    public String getIp()
    {
        return "/" + ip;
    }
}
