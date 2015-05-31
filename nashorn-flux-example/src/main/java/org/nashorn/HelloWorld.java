package org.nashornExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
 
import javax.script.*;

import java.io.FileReader;

public class HelloWorld extends AbstractHandler
{
	private ScriptEngine _engine;
	private Invocable _invocable;

	public HelloWorld (ScriptEngine engine)
	{
		this._engine = engine;
		this._invocable = (Invocable)engine;
	}

    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) 
        throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        
        if ("/".equals(target)) {
        	baseRequest.setHandled(true);
        	response.getWriter().println(this.generateHtml());
        }
    }

    private String generateHtml() throws ServletException {
    	try
		{
			String result = (String) this._invocable.invokeFunction("render");
			return result;
		}
		catch (ScriptException ex)
		{
			throw new ServletException(ex);
		}
		catch (NoSuchMethodException ex)
		{
			throw new ServletException(ex);
		}
    }
 
    public static void main(String[] args) throws Exception
    {
		FileReader fileReader = new FileReader("build/server.js");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		engine.eval("var global = this;");
		engine.eval(fileReader);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase(".");
 
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { new HelloWorld(engine), resource_handler, new DefaultHandler() });
 
        Server server = new Server(1337);
        server.setHandler(handlers);
 
        server.start();
        server.join();
    }
}
