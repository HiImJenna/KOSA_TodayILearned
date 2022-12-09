package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

/*
寃뚯떆�뙋 紐⑸줉 議고쉶 

controller  -> Model�쓽議�  (DAO , DTO) 媛� �븘�슂

NoticeController �뒗   NoticeDao�뿉 �쓽議댄븳�떎
�븘�슂�븯硫� 媛믪쓣 諛쏆븘�빞 �빐�슂 ... (DI , injection (�깮�꽦�옄 , �븿�닔(setter) �넻�빐�꽌 二쇱엯 諛쏅뒗�떎
*/
public class NoticeController  implements Controller {
	public NoticeController() {
		 System.out.println("[NoticeController]");
	}
	
	private NoticeDao noticsdao;
	
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	     //DAO 媛앹껜 �궗�슜
		//public List<Notice> getNotices(int page, String field, String query)
		
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("p");
		  
		//default 媛� �꽕�젙
		int page = 1;
		String field="TITLE";
		String query = "%%";
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_field != null   && ! _field.equals("")) {
			field = _field;
		}
		
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_query != null   && ! _query.equals("")) {
			query = _query;
		}
		
		//DAO �옉�뾽
		List<Notice>  list = noticsdao.getNotices(page, field, query);
		
		
		//Spring  �쟻�슜
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		
		
		return mv;
	}

}
