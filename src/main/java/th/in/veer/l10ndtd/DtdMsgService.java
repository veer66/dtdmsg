package th.in.veer.l10ndtd;

import com.google.gson.Gson;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: vee
 * Date: 9/17/13 AD
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class DtdMsgService extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("@@@ GET");
        out.flush();
    }


        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        L10nDtdReader reader = new L10nDtdReader();
        try {
            response.setContentType("application/json");
            Gson gson = new Gson();
            Translation[] translations = reader.read(new InputSource(request.getInputStream()));
            String s = gson.toJson(translations);
            out.println(s);
        } catch (SAXException e) {
            out.println("Cannot read");
        }
        out.flush();
    }

}
