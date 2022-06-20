package br.com.javaweb;

import br.com.javaweb.acoes.Acao;
import br.com.javaweb.acoes.AdicionaDespesa;
import br.com.javaweb.acoes.ListaDespesas;
import br.com.javaweb.acoes.RemoveDespesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controladora")
public class ServletController extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {


        try {
            String acaoNome = request.getParameter("acao");
            String pacote = ("br.com.javaweb.acoes.");
            System.out.println("ação executada foi " +acaoNome);
           Class classe = Class.forName(pacote + acaoNome);
            Acao acao =(Acao) classe.newInstance();

           String resultado = acao.executa((HttpServletRequest) request, (HttpServletResponse) response);

            RequestDispatcher dispatcher = request.getRequestDispatcher(resultado);
            dispatcher.forward(request, response);


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
