package br.com.javaweb.acoes;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Despesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ListaDespesas implements Acao{

    public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao =new DespesaDAO(connection);
        List<Despesa> despesas = dao.findAll();

        request.setAttribute("despesas", despesas);

       return "/WEB-INF/lista-despesas.jsp";
    }
}
