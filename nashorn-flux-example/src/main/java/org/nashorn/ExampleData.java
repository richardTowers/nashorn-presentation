package org.nashornExample;

import java.util.Date;
import java.util.HashMap;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class ExampleData
{
	public static Message[] getMessages ()
	{
		return new Message[] {
			new Message("m_1",
				"t_1",
				"Brighton Java",
				"Rich",
				"Everyone enjoying themselves?",
				"2015-05-31T20:12:26.107Z"),
			new Message("m_2",
				"t_2",
				"Nashorn",
				"Rich",
				"Don't you think Nashorn is the coolest thing ever?",
				"2015-05-31T20:12:26.107Z"),
			new Message("m_3",
				"t_2",
				"Nashorn",
				"Brighton Java Attendees",
				"No mate.",
				"2015-05-31T20:12:26.107Z"),
		};
	}
}
