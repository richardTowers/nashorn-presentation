package org.nashornExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
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
        baseRequest.setHandled(true);
		
		try
		{
			Object react = this._engine.get("React");
			Object element = this._invocable.invokeMethod(react, "createElement", "h1", null, "Hello World!");
			String result = (String) this._invocable.invokeMethod(react, "renderToString", element);
			
        	response.getWriter().println(result);
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
		FileReader fileReader = new FileReader("react.js");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		engine.eval(fileReader);

        Server server = new Server(1337);
        server.setHandler(new HelloWorld(engine));
 
        server.start();
        server.join();
    }
}
