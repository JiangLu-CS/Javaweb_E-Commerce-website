package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
//ksxyeuuldeqhbdee
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;
import dao.impl.*;
import entity.*;

@WebServlet(name = "/UserServlets")
public class UserServlets extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String opr = request.getParameter("opr");


        if(opr.equals("reg")){
            User user = new User();
            UserDaoImpl udi = new UserDaoImpl();
            user.setUsername(request.getParameter("user"));
            user.setPassword(request.getParameter("psw"));
            user.setCellphone(request.getParameter("phone"));
            int result = udi.insert(user);
            if(result == 1){
                out.print("<script>alert('注册成功！');location.href='index.jsp';</script>");
            }
            else{
                out.print("<script>alert('用户名已存在，请重新注册！');location.href='register.jsp';</script>");
            }


        }
        if(opr.equals("login")){
            User user = new User();
            UserDaoImpl udi = new UserDaoImpl();
            user.setUsername(request.getParameter("user"));
            user.setPassword(request.getParameter("psw"));
            User u = udi.findUser(user);
            if(u == null){
                out.println("\"<script>alert('用户名或密码错误');location.href='login.jsp';</script>\"");
            }
            else {
                request.getSession().setAttribute("username",user.getUsername());
                response.sendRedirect("index.jsp");
            }
        }
        else if(opr.equals("exit")) {
            request.getSession().removeAttribute("username");
            response.sendRedirect(request.getHeader("Referer"));
        }
        else if(opr.equals("contrologin")){
            User user=new User();
            UserDaoImpl udi=new UserDaoImpl();
            user.setUsername(request.getParameter("user"));
            user.setPassword(request.getParameter("psw"));
            User u=udi.findUser(user);
            if(u==null){
                out.print("<script>alert('用户名或密码错误');location.href='adminlogin.jsp';</script>");
            }else{
                response.sendRedirect("admin.jsp");
            }
        }
        else if(opr.equals("list")){
            UserDaoImpl udi=new UserDaoImpl();
            List<User> listuser=udi.getAll();
            request.getSession().setAttribute("listuser", listuser);
            response.sendRedirect("control.jsp");
        }else if(opr.equals("fuzzy")){
            request.setCharacterEncoding("utf-8");
            UserDaoImpl udi=new UserDaoImpl();
            String un=request.getParameter("un");
            List<User> listuser=udi.getUserByName(un);
            request.getSession().setAttribute("listuser", listuser);
            response.sendRedirect("control.jsp");

        }
        else if(opr.equals("del")){
            UserDaoImpl udi=new UserDaoImpl();
            String un=request.getParameter("username");
            un=new String(un.getBytes("ISO-8859-1"),"UTF-8");
            User user=new User();
            user.setUsername(un);
            int result=udi.delete(user);
            if(result==1){
                out.print("<script>alert('删除成功！');location.href='UserServlets?opr=list';</script>");
            }else{
                out.print("<script>alert('删除失败！');location.href='UserServlets?opr=list';</script>");
            }
        }else if(opr.equals("mdel")){
            String[] values=request.getParameterValues("chb");
            try{
                for(String un:values){
                    UserDaoImpl udi=new UserDaoImpl();
                    User user=new User();
                    user.setUsername(un);
                    udi.delete(user);
                }

                out.print("<script>alert('删除成功！');location.href='UserServlets?opr=list';</script>");
            }catch(Exception e){
                out.print("<script>alert('删除失败！');location.href='UserServlets?opr=list';</script>");
            }

        }else if(opr.equals("update")){
            String un=request.getParameter("un");
            //un=new String(un.getBytes("ISO-8859-1"),"UTF-8");
            String pwd=request.getParameter("password");
            UserDaoImpl udi=new UserDaoImpl();
            User user=new User();
            user.setUsername(un);
            user.setPassword(pwd);
            int result=udi.update(user);
            if(result==1){
                out.print("<script>alert('修改密码成功！');location.href='UserServlets?opr=list';</script>");
            }else{
                out.print("<script>alert('修改密码失败！');location.href='UserServlets?opr=list';</script>");
            }
        }
        else if(opr.equals("prepay")){
            Cart cart=new Cart();
            String id=(String)request.getSession().getAttribute("username");
            cart.setId(id);
            userbuyDaoImpl record=new userbuyDaoImpl();
            goodCountImpl count = new goodCountImpl();
            goodcount good = new goodcount();


            userbuy buy = new userbuy();
            CartDaoImpl cdi=new CartDaoImpl();
            List<Cart> list2=cdi.getAll(cart);
            double total = 0;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Cart cart2 : list2) {
                total+=cart2.getPrice()*cart2.getNum();
                buy.setName(cart2.getId());
                buy.setGood(cart2.getGid());
                System.out.println(df.format(new Date()));
                buy.setTime(df.format(new Date()));
                int result = record.adduserbuy(buy);
                System.out.println(result);
                good.setName(cart2.getGid());
                goodcount u = count.findGood(good);
                if(u == null){
                    System.out.println("nulllllll");

                }
                else {

                    int price = (int) (cart2.getPrice() + good.getProfit());
                    System.out.println(price);
                    int number = good.getNumber() + 1;
                    System.out.println(number);
                    good.setProfit(price);
                    good.setNumber(number);
                    count.addgood(good);
                }

            }
            request.getSession().setAttribute("total", total);
            request.getSession().setAttribute("list2", list2);
            response.sendRedirect("pay.jsp");
            UserDaoImpl udi=new UserDaoImpl();

        }
        else if(opr.equals("pay")){

            String mail=request.getParameter("mail");
            System.out.println("发送邮件");
            Properties properties = new Properties();

            properties.setProperty("mail.host","smtp.qq.com");

            properties.setProperty("mail.transport.protocol","smtp");

            properties.setProperty("mail.smtp.auth","true");



            //创建一个session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("760858916@qq.com","ksxyeuuldeqhbdee");
                }
            });

            //开启debug模式
            session.setDebug(true);
            try {

                //获取连接对象
                Transport transport = session.getTransport();

                //连接服务器
                transport.connect("smtp.qq.com", "760858916@qq.com", "ksxyeuuldeqhbdee");

                //创建邮件对象
                MimeMessage mimeMessage = new MimeMessage(session);

                //邮件发送人
                mimeMessage.setFrom(new InternetAddress("760858916@qq.com"));

                //邮件接收人
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));

                //邮件标题
                mimeMessage.setSubject("尊敬的顾客");

                //邮件内容
                mimeMessage.setContent("您购买的所有物品都已经发货了！", "text/html;charset=UTF-8");

                //发送邮件
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

                //关闭连接
                transport.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            response.sendRedirect("paysuccess.jsp");
        }
        else if(opr.equals("buyrecord")){
            userbuyDaoImpl udi=new userbuyDaoImpl();
            List<userbuy> listuser=udi.getAll();
            request.getSession().setAttribute("listuser", listuser);
            response.sendRedirect("showuserbuy.jsp");
        }
        else if(opr.equals("lookrecord")){
            userlookDaoImpl udi=new userlookDaoImpl();
            List<userlook> listuser=udi.getAll();
            request.getSession().setAttribute("listuser", listuser);
            response.sendRedirect("showlook.jsp");
        }
        else if(opr.equals("count")){
            goodCountImpl udi=new goodCountImpl();
            List<goodcount> listuser=udi.getAll();
            request.getSession().setAttribute("listuser", listuser);
            response.sendRedirect("goodSta.jsp");
        }
    }





    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
