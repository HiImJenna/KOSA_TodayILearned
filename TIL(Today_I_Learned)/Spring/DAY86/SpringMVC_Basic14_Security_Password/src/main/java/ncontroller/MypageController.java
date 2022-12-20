package ncontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.MemberSerivce;
import vo.Member;

@Controller
@RequestMapping("/customer/")
public class MypageController {	
	
	private MemberSerivce memberservice;
	
	@Autowired
	public void setMemberservice(MemberSerivce memberservice) {
		this.memberservice = memberservice;
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@GetMapping("mypage.htm")
	public String memberConfirm() {
		return "customer/memberConfirm";
	}
	
	@PostMapping("mypage.htm")
	public String memberConfirm(@RequestParam("password") String rawPassword, Principal principal){
		String viewpage="";
		
		//회원정보
		Member member = memberservice.getMember(principal.getName());
		
		
		//DB에서 가져온 암호화된 문자열
		String encodedPassword = member.getPwd();
		
		System.out.println("rawPassword : "+rawPassword );
		System.out.println("encodepassword : " + encodedPassword);
		
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){
			viewpage="redirect:memberupdate.htm";
			
		}else{
			viewpage="redirect:mypage.htm";
		}
		
		return viewpage;
	}
	
	@GetMapping("memberupdate.htm") 
	public String memberUpdate(Model model, Principal principal) {
		Member member = memberservice.getMember(principal.getName());
		model.addAttribute("member", member);
		return "customer/memberUpdate";
	}
	
	@PostMapping("memberupdate.htm")
	public String memberUpdate(Model model, Member member, Principal principal) {
		Member updatemember = memberservice.getMember(principal.getName());
		updatemember.setName(member.getName());
		updatemember.setCphone(member.getCphone());
		updatemember.setEmail(member.getEmail());
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		memberservice.updateMember(updatemember);
		return "redirect:/index.htm";
	}
	
}















