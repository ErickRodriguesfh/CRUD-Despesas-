package br.com.javaweb.acoes;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RemoveDespesa implements Acao {


    public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao =  new DespesaDAO(connection);


        String id = request.getParameter("id");
        dao.delete(Long.valueOf(id));

        return "/controladora?acao=ListaDespesas";
    }
}
