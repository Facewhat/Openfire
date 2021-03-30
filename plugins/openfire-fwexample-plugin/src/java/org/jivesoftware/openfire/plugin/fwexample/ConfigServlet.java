/**
 * example-conf.jsp对应的servlet，两者绑定配置在web/WEB-INF/web.xml
 *
 */
package org.jivesoftware.openfire.plugin.fwexample;

import java.io.IOException;

import org.jivesoftware.admin.FlashMessageTag;
import org.jivesoftware.util.ParamUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ConfigServlet extends HttpServlet {

    private ExamplePlugin plugin;

    @Override
    public void init() {
        plugin = ExamplePlugin.getInstance();
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("logToConsole", plugin.isLogToConsole());
        request.setAttribute("logToFile", plugin.isLogToFile());
        request.getRequestDispatcher("example-conf.jsp").forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        final HttpSession session = request.getSession();

        if (request.getParameter("cancel") != null) {
            session.setAttribute(FlashMessageTag.WARNING_MESSAGE_KEY, "No changes were made");
            response.sendRedirect(request.getRequestURI());
            return;
        }

        plugin.setLogToConsole(ParamUtils.getBooleanParameter(request, "logToConsole"));
        plugin.setLogToFile(ParamUtils.getBooleanParameter(request, "logToFile"));

        session.setAttribute(FlashMessageTag.SUCCESS_MESSAGE_KEY, "Logging settings updated");
        response.sendRedirect(request.getRequestURI());
    }
}
