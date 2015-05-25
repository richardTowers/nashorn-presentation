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
	private Invocable _invocable;

	public HelloWorld (Invocable invocable)
	{
		this._invocable = invocable;
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
			// Invoke the JS and print the result:
			Double result = (Double) this._invocable.invokeFunction("add", 1, 1);
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
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		engine.eval("function add (x, y) { return x + y; }");		

        Server server = new Server(8080);
        server.setHandler(new HelloWorld((Invocable)engine));
 
        server.start();
        server.join();
    }
}
