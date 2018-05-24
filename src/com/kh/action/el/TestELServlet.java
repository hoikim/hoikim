package com.kh.action.el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.action.model.vo.Person;

/**
 * Servlet implementation class TestELServlet
 */
@WebServlet("/el/test.do")
public class TestELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//속성값 저장 
		request.setAttribute("coffee", "예가체프");
		request.setAttribute("year", 2018);
		request.setAttribute("person", new Person("홍홍",'남',30));
		List<String> items = new ArrayList<>();
	      items.add(new String("프랑켄슈타인"));
	      items.add(new String("노트르담 드 파리"));
	      items.add(new String("드라큘라"));
	      items.add(new String("맨오브라만차"));
	      items.add(new String("지킬앤하이드"));
	      
	      request.setAttribute("items", items);
	      
	      //session/application 스코프에 속성지정
	      HttpSession session = request.getSession();
	      session.setAttribute("book", "나미야잡화점의 기적");
	      session.setAttribute("coffee", "하와이코나");
	      ServletContext application  = request.getServletContext();
	      application.setAttribute("movie", "카모메식당");
	      
	      
	      request.getRequestDispatcher("/el/01_el.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
