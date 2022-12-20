package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import service.MemberSerivce;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	//memberDao  의존
	private MemberDao memberdao;
	
	@Autowired
	private MemberSerivce memberservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//GET 요청                     
	//join.jsp 화면처리
	@GetMapping("join.htm")
	public String join() {
		
		return "joinus/join";
				
	}
	
	//POST 요청
	@PostMapping("join.htm")
	public String join(Member member) {
		System.out.println(member.toString());
		try {
			
			member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
			memberservice.insertMember(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
    }
	
	//로그인 요청
	@GetMapping(value="login.htm")
	public String login() {
		return "joinus/login";
	}
}